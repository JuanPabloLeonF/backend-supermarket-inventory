package dev.juanleon.supermarket_inventory.users.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.exception.GlobalExceptionsHandler;
import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
import dev.juanleon.supermarket_inventory.users.application.commands.post.CreateUserCommand;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.queries.getAll.GetAllUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByIdUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByLastNameUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByNameUserQuery;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.GlobalUserExceptionHandler;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserRestControllerUnitTest {

    protected Mediator mediator;

    protected RestTestClient restTestClient;

    protected static final String BASE_URL = "/api/v1/users";

    protected UUID id1 = UUID.randomUUID();
    protected UUID id2 = UUID.randomUUID();

    protected List<ResponseUserDto> responseUserDtoList  = List.of(
            new ResponseUserDto(this.id1, "juan", "leon", "juan123@gmail.com", "1234567", "ADMIN", true,LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0)),
            new ResponseUserDto(this.id2, "pipe", "leon", "pipe123@gmail.com", "123456789", "USER", false, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0))
    );

    protected ResponseUserDto responseUserDto = this.responseUserDtoList.getFirst();

    protected ResponseRequestDto responseRequestDto = new ResponseRequestDto("User created successfully", LocalDateTime.now().withNano(0));

    @BeforeEach
    void setUp() {
        this.mediator = mock(Mediator.class);
        UserRestController controller = new UserRestController(this.mediator);
        this.restTestClient = RestTestClient
                .bindToController(
                        controller,
                        new GlobalUserExceptionHandler(),
                        new GlobalExceptionsHandler()
                ).build();
    }

    @Test
    void shouldReturnResponseUserDtoWhenIsCalledMethodCreate() {

        RequestUserDto requestUserDto = RequestUserDto.builder()
                .name("ana")
                .lastName("perez")
                .email("ana@gmail.com")
                .password("Abcd1234@")
                .rol(Roles.USER)
                .isActive(true)
                .build();

        when(this.mediator.dispatch(any(CreateUserCommand.class)))
                .thenReturn(this.responseRequestDto);

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
                    assertEquals(this.responseRequestDto, response);
                });

        verify(this.mediator).dispatch(any(CreateUserCommand.class));
    }

    @Test
    void shouldReturnListOfResponseUserDtoWhenIsCalledMethodGetAll() {

        when(this.mediator.dispatch(any(GetAllUserQuery.class)))
                .thenReturn(this.responseUserDtoList);

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

        verify(this.mediator).dispatch(any(GetAllUserQuery.class));
    }

    @Test
    void shouldReturnListOfEmptyWhenIsCalledMethodGetAll() {

        when(this.mediator.dispatch(any(GetAllUserQuery.class)))
                .thenReturn(Collections.emptyList());

        this.restTestClient
                .get()
                .uri(BASE_URL)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue(response.isEmpty());
                });

        verify(this.mediator).dispatch(any(GetAllUserQuery.class));
    }

    @Test
    void shouldResponseUserDtoWhenIsCalledMethodGetByIdWithParamId() {

        when(this.mediator.dispatch(any(GetByIdUserQuery.class)))
                .thenReturn(this.responseUserDto);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/{id}", this.id1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResponseUserDto.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(this.responseUserDto, response);
                });

        verify(this.mediator).dispatch(any(GetByIdUserQuery.class));
    }

    @Test
    void shouldReturnProblemDetailWhenIsCalledMethodGetByIdWithParamNoExistisOrNull() {

        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        when(this.mediator.dispatch(any(GetByIdUserQuery.class)))
                .thenThrow(new NotFoundUserException(idNoExistis));

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

        verify(this.mediator).dispatch(any(GetByIdUserQuery.class));
    }

    @Test
    void shouldResponseUserDtoWhenIsCalledMethodGetByNameWithParamName() {

        String name = "pipe";

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getName(), name))
                .toList();

        when(this.mediator.dispatch(any(GetByNameUserQuery.class)))
                .thenReturn(userDtoList);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", name)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {
                })
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });

        verify(this.mediator).dispatch(any(GetByNameUserQuery.class));
    }

    @Test
    void shouldReturnProblemDetailWhenIsCalledMethodGetByNameWithParamNoExistisOrNull() {

        String name = "no existe";

        when(this.mediator.dispatch(any(GetByNameUserQuery.class)))
                .thenReturn(Collections.emptyList());

        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", name)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {
                })
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue(response.isEmpty());
                });

        verify(this.mediator).dispatch(any(GetByNameUserQuery.class));
    }

    @Test
    void shouldResponseUserDtoWhenIsCalledMethodGetByLastNameWithParamLastName() {

        String lastName = "leon";

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter(user -> Objects.equals(user.getLastName(), lastName))
                .toList();

        when(this.mediator.dispatch(any(GetByLastNameUserQuery.class)))
                .thenReturn(userDtoList);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", lastName)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {
                })
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });

        verify(this.mediator).dispatch(any(GetByLastNameUserQuery.class));
    }

    @Test
    void shouldReturnListEmptyWhenIsCalledMethodGetByLastNameWithParamNoExistisOrNull() {

        String lastName = "no existe";

        when(this.mediator.dispatch(any(GetByLastNameUserQuery.class)))
                .thenReturn(Collections.emptyList());

        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", lastName)
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {
                })
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue(response.isEmpty());
                });

        verify(this.mediator).dispatch(any(GetByLastNameUserQuery.class));
    }
}