package dev.juanleon.supermarket_inventory.users.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.common.utils.dto.ResponseRequestDto;
import dev.juanleon.supermarket_inventory.common.utils.enums.Roles;
import dev.juanleon.supermarket_inventory.users.application.commands.delete.DeleteByIdUserCommand;
import dev.juanleon.supermarket_inventory.users.application.commands.post.CreateUserCommand;
import dev.juanleon.supermarket_inventory.users.application.commands.update.UpdateByIdUserCommand;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUpdateUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.RequestUserDto;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.queries.getAll.GetAllUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByIdUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByLastNameUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByNameUserQuery;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NoUpdateUserByIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_NOT_FOUND_BY_ID;
import static dev.juanleon.supermarket_inventory.common.utils.enums.MessagesApp.USER_UPDATE_SUCCESSFULLY_BY_ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(UserRestController.class)
class UserRestControllerMockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Mediator mediator;

    protected RestTestClient restTestClient;

    protected static final String BASE_URL = "/api/v1/users";

    protected UUID id1 = UUID.randomUUID();

    protected List<ResponseUserDto> responseUserDtoList = List.of(
            new ResponseUserDto(this.id1, "Juan", "Leon", "juan@mail.com", "123", "ADMIN", true, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0))
    );

    protected ResponseUserDto responseUserDto = new ResponseUserDto(this.id1, "Juan", "Leon", "juan@mail.com", "123", "ADMIN", true, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0));


    protected ResponseRequestDto responseRequestDto = new ResponseRequestDto("User created successfully", LocalDateTime.now().withNano(0));

    @BeforeEach
    void setUp() {
        this.restTestClient = RestTestClient.bindTo(this.mockMvc).build();
    }

    @Test
    void shouldReturnStatusCreatedWhenIsCalledMethodCreate() {

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
    void shouldReturnStatusOkWhenIsCalledMethodUpdateById() {

        RequestUpdateUserDto requestUpdateUserDto = RequestUpdateUserDto.builder()
                .id(this.id1)
                .name("ana")
                .lastName("perez")
                .isActive(true)
                .build();

        ResponseRequestDto responseRequestDto = ResponseRequestDto.builder()
                .message(USER_UPDATE_SUCCESSFULLY_BY_ID.format(this.id1))
                .date(LocalDateTime.now().withNano(0))
                .build();

        when(this.mediator.dispatch(any(UpdateByIdUserCommand.class)))
                .thenReturn(responseRequestDto);

        this.restTestClient
                .put()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestUpdateUserDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResponseRequestDto.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(responseRequestDto, response);
                });

        verify(this.mediator).dispatch(any(UpdateByIdUserCommand.class));
    }

    @Test
    void shouldReturnBadRequestWhenUpdateBodyIsInvalid() {
        RequestUpdateUserDto invalidDto = RequestUpdateUserDto.builder()
                .id(null)
                .name("")
                .lastName("")
                .isActive(null)
                .build();

        this.restTestClient
                .put()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(invalidDto)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(ProblemDetail.class)
                .value(problem -> {
                    assertNotNull(problem);
                    assertNotNull(problem.getProperties());
                    assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), problem.getTitle());
                    assertEquals(MethodArgumentNotValidException.class.getSimpleName(), problem.getProperties().get("typeError"));
                });

        verify(this.mediator, never()).dispatch(any(UpdateByIdUserCommand.class));
    }

    @Test
    void shouldReturnNotFoundWhenUpdateUserDoesNotExist() {
        UUID idNoExistis = UUID.randomUUID();
        String message = USER_NOT_FOUND_BY_ID.format(idNoExistis);

        RequestUpdateUserDto requestUpdateUserDto = RequestUpdateUserDto.builder()
                .id(idNoExistis)
                .name("ana")
                .lastName("perez")
                .isActive(true)
                .build();

        when(this.mediator.dispatch(any(UpdateByIdUserCommand.class)))
                .thenThrow(new NoUpdateUserByIdException(idNoExistis));

        this.restTestClient
                .put()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestUpdateUserDto)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ProblemDetail.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(HttpStatus.NOT_FOUND.getReasonPhrase(), response.getTitle());
                    assertEquals(message, response.getDetail());
                });

        verify(this.mediator).dispatch(any(UpdateByIdUserCommand.class));
    }

    @Test
    void shouldReturnStatusOkWhenIsCalledMethodDeleteById() {
        ResponseRequestDto responseRequestDto = new ResponseRequestDto("User deleted successfully by id: " + this.id1, LocalDateTime.now().withNano(0));

        when(this.mediator.dispatch(any(DeleteByIdUserCommand.class)))
                .thenReturn(responseRequestDto);

        this.restTestClient
                .delete()
                .uri(BASE_URL + "/{id}", this.id1)
                .exchange()
                .expectStatus().isOk()
                .expectBody(ResponseRequestDto.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(responseRequestDto, response);
                });

        verify(this.mediator).dispatch(any(DeleteByIdUserCommand.class));
    }

    @Test
    void shouldReturnNotFoundWhenDeleteUserDoesNotExist() {
        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        when(this.mediator.dispatch(any(DeleteByIdUserCommand.class)))
                .thenThrow(new NotFoundUserException(idNoExistis));

        this.restTestClient
                .delete()
                .uri(BASE_URL + "/{id}", idNoExistis)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ProblemDetail.class)
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(HttpStatus.NOT_FOUND.getReasonPhrase(), response.getTitle());
                    assertEquals(message, response.getDetail());
                });

        verify(this.mediator).dispatch(any(DeleteByIdUserCommand.class));
    }

    @Test
    void shouldReturnBadRequestWhenRequestBodyIsMissing() {
        this.restTestClient
                .post()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isBadRequest();

        verify(this.mediator, never()).dispatch(any(CreateUserCommand.class));
    }

    @Test
    void shouldReturnBadRequestWhenInputIsInvalid() {
        RequestUserDto invalidDto = RequestUserDto.builder()
                .name("")
                .email("no-es-un-email")
                .build();

        this.restTestClient
                .post()
                .uri(BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(invalidDto)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody(ProblemDetail.class)
                .value(problem -> {
                    assertNotNull(problem);
                    assertNotNull(problem.getProperties());
                    assertEquals(HttpStatus.BAD_REQUEST.getReasonPhrase(), problem.getTitle());
                    assertEquals(MethodArgumentNotValidException.class.getSimpleName(), problem.getProperties().get("typeError"));
                });

        verify(this.mediator, never()).dispatch(any(CreateUserCommand.class));
    }

    @Test
    void shouldReturnStatusOkWhenIsCalledMethodGetAll() {

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
    void shouldReturnListOfUsersWhenDataExists() {

        when(this.mediator.dispatch(any(GetAllUserQuery.class))).thenReturn(this.responseUserDtoList);

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
    void shouldReturnStatusOkWithDataWhenIsCalledMethodGetById() {

        when(this.mediator.dispatch(any(GetByIdUserQuery.class)))
                .thenReturn(this.responseUserDto);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/{id}" , this.id1)
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
    void shouldReturnProblemDetailsWhenIsCalledMethodGetByIdWithParamNoExistisOrNull() {

        UUID idNoExistis = UUID.randomUUID();
        String message = "User not found with id: " + idNoExistis;

        when(this.mediator.dispatch(any(GetByIdUserQuery.class)))
                .thenThrow(new NotFoundUserException(idNoExistis));

        this.restTestClient
                .get()
                .uri(BASE_URL + "/{id}" , idNoExistis)
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
    void shouldPassPathVariableWhenIsCalledGetById() {

        when(mediator.dispatch(any(GetByIdUserQuery.class))).thenReturn(this.responseUserDto);

        restTestClient.get()
                .uri(BASE_URL + "/{id}", this.id1)
                .exchange()
                .expectStatus().isOk();

        ArgumentCaptor<GetByIdUserQuery> queryCaptor = ArgumentCaptor
                .forClass(GetByIdUserQuery.class);

        verify(mediator).dispatch(queryCaptor.capture());
        assertEquals(this.id1, queryCaptor.getValue().id());

    }

    @Test
    void shouldReturnStatusOkWhenIsCalledMethodGetByNameWithParamName() {

        when(this.mediator.dispatch(any(GetByNameUserQuery.class)))
                .thenReturn(Collections.emptyList());

        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue(response.isEmpty());
                });

        verify(this.mediator).dispatch(any(GetByNameUserQuery.class));
    }

    @Test
    void shouldReturnListOfUsersWhenIsCalledMethodGetByNameWithParamName() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter((user) -> Objects.equals(user.getName(), this.responseUserDto.getName()))
                .toList();

        when(mediator.dispatch(any(GetByNameUserQuery.class))).thenReturn(userDtoList);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/name/{name}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });

        verify(this.mediator).dispatch(any(GetByNameUserQuery.class));
    }

    @Test
    void shouldPassPathVariableWhenIsCalledGetByName() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter((user) -> Objects.equals(user.getName(), this.responseUserDto.getName()))
                .toList();

        when(mediator.dispatch(any(GetByNameUserQuery.class))).thenReturn(userDtoList);

        restTestClient.get()
                .uri(BASE_URL + "/name/{name}", this.responseUserDto.getName())
                .exchange()
                .expectStatus().isOk();

        ArgumentCaptor<GetByNameUserQuery> queryCaptor = ArgumentCaptor
                .forClass(GetByNameUserQuery.class);

        verify(mediator).dispatch(queryCaptor.capture());
        assertEquals(this.responseUserDto.getName(), queryCaptor.getValue().name());

    }

    @Test
    void shouldReturnStatusOkWhenIsCalledMethodGetByLastNameWithParamLastName() {

        when(this.mediator.dispatch(any(GetByLastNameUserQuery.class)))
                .thenReturn(Collections.emptyList());

        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertTrue(response.isEmpty());
                });

        verify(this.mediator).dispatch(any(GetByLastNameUserQuery.class));
    }

    @Test
    void shouldReturnListOfUsersWhenIsCalledMethodGetByLastNameWithParamLastName() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter((user) -> Objects.equals(user.getLastName(), this.responseUserDto.getLastName()))
                .toList();

        when(mediator.dispatch(any(GetByLastNameUserQuery.class))).thenReturn(userDtoList);

        this.restTestClient
                .get()
                .uri(BASE_URL + "/lastname/{lastName}", "no existe")
                .exchange()
                .expectStatus().isOk()
                .expectBody(new ParameterizedTypeReference<List<ResponseUserDto>>() {})
                .value((response) -> {
                    assertNotNull(response);
                    assertEquals(userDtoList, response);
                });

        verify(this.mediator).dispatch(any(GetByLastNameUserQuery.class));
    }

    @Test
    void shouldPassPathVariableWhenIsCalledGetByLastName() {

        List<ResponseUserDto> userDtoList = this.responseUserDtoList.stream()
                .filter((user) -> Objects.equals(user.getLastName(), this.responseUserDto.getLastName()))
                .toList();

        when(mediator.dispatch(any(GetByLastNameUserQuery.class))).thenReturn(userDtoList);

        restTestClient.get()
                .uri(BASE_URL + "/lastname/{lastName}", this.responseUserDto.getLastName())
                .exchange()
                .expectStatus().isOk();

        ArgumentCaptor<GetByLastNameUserQuery> queryCaptor = ArgumentCaptor
                .forClass(GetByLastNameUserQuery.class);

        verify(mediator).dispatch(queryCaptor.capture());
        assertEquals(this.responseUserDto.getLastName(), queryCaptor.getValue().lastName());

    }

}