package dev.juanleon.supermarket_inventory.users;

import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.entities.UserEntity;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.database.repositories.IUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureRestTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserItTest {

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private IUserRepository iUserRepository;

    protected String BASE_URL = "/api/v1/users";

    protected List<ResponseUserDto> responseUserDtoList = new ArrayList<ResponseUserDto>();

    protected ResponseUserDto responseUserDto1;
    protected ResponseUserDto responseUserDto2;

    protected UserEntity userEntitySave1;
    protected UserEntity userEntitySave2;

    @BeforeEach
    void setUp() {

            this.userEntitySave1 = UserEntity.builder()
                .name("juan")
                .lastName("leon")
                .email("papo123@gmail.com")
                .password("123456789")
                .rol("ADMIN")
                .isActive(true)
                .createdAt(LocalDateTime.now().withNano(0))
                .updatedAt(LocalDateTime.now().withNano(0))
                .build();

        this.userEntitySave1 = this.iUserRepository.save(this.userEntitySave1);

        this.responseUserDto1 = ResponseUserDto.builder()
                .id(this.userEntitySave1.getId())
                .name(this.userEntitySave1.getName())
                .lastName(this.userEntitySave1.getLastName())
                .email(this.userEntitySave1.getEmail())
                .password(this.userEntitySave1.getPassword())
                .rol(this.userEntitySave1.getRol())
                .isActive(this.userEntitySave1.getIsActive())
                .createdAt(this.userEntitySave1.getCreatedAt())
                .updatedAt(this.userEntitySave1.getUpdatedAt())
                .build();

        this.userEntitySave2 = UserEntity.builder()
                .name("camilo")
                .lastName("leon")
                .email("cami123@gmail.com")
                .password("123456789")
                .rol("USER")
                .isActive(false)
                .createdAt(LocalDateTime.now().withNano(0))
                .updatedAt(LocalDateTime.now().withNano(0))
                .build();

        this.userEntitySave2 = this.iUserRepository.save(this.userEntitySave2);

        this.responseUserDto2 = ResponseUserDto.builder()
                .id(this.userEntitySave2.getId())
                .name(this.userEntitySave2.getName())
                .lastName(this.userEntitySave2.getLastName())
                .email(this.userEntitySave2.getEmail())
                .password(this.userEntitySave2.getPassword())
                .rol(this.userEntitySave2.getRol())
                .isActive(this.userEntitySave2.getIsActive())
                .createdAt(this.userEntitySave2.getCreatedAt())
                .updatedAt(this.userEntitySave2.getUpdatedAt())
                .build();

        this.responseUserDtoList.add(responseUserDto1);
        this.responseUserDtoList.add(responseUserDto2);
    }

    @AfterEach
    void tearDown() {
        this.iUserRepository.deleteAll();
    }

    @Test
    void shouldReturnResponseUserDtoWhenIsCalledMethodCreate() {

        RequestUserDto requestUserDto = RequestUserDto.builder()
                .name("nuevo")
                .lastName("usuario")
                .email("nuevo.usuario@correo.com")
                .password("Abcd1234@")
                .rol(Roles.USER)
                .isActive(true)
                .build();

        this.restTestClient
                .post()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestUserDto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ResponseRequestDto.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals("User created successfully", response.getMessage());
                    assertNotNull(response.getDate());
                });

        assertTrue(this.iUserRepository.findAll().stream()
                .anyMatch((u) -> "nuevo.usuario@correo.com".equals(u.getEmail())));
    }

    @Test
    void shouldReturnListOfResponseUserDtoWhenIsCalledMethodGetAll() {
        this.restTestClient
                .get()
                .uri(BASE_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(this.responseUserDtoList, response);
                });
    }

    @Test
    void shouldReturnResponseUserDtoWhenIsCalledMethodGetByIdWithParam() {
        this.restTestClient
                .get()
                .uri(BASE_URL + "/{id}", this.responseUserDto1.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResponseUserDto.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(this.responseUserDto1, response);
                });
    }

    @Test
    void shouldReturnResponseUserDtoWhenIsCalledMethodGetByIdWithParamNoExistis() {

        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        this.restTestClient
                .get()
                .uri(BASE_URL + "/{id}", idNoExistis)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ProblemDetail.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(HttpStatus.NOT_FOUND.getReasonPhrase(), response.getTitle());
                    assertEquals(message, response.getDetail());
                });
    }

    @Test
    void shouldReturnListResponseUserDtoWhenIsCalledMethodGetByNameWithParam() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getName(), this.responseUserDto1.getName()))
                .toList();

        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", this.responseUserDto1.getName())
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByNameWithParamNoExistis() {
        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue((response.isEmpty()));
                });
    }

    @Test
    void shouldReturnListResponseUserDtoWhenIsCalledMethodGetByLastNameWithParam() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getLastName(), this.responseUserDto1.getLastName()))
                .toList();

        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", this.responseUserDto1.getLastName())
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistis() {
        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue((response.isEmpty()));
                });
    }
}
