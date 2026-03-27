package dev.juanleon.supermarket_inventory.users.infrastructure.inputs.controllers;

import dev.juanleon.supermarket_inventory.common.mediator.Mediator;
import dev.juanleon.supermarket_inventory.users.application.dto.ResponseUserDto;
import dev.juanleon.supermarket_inventory.users.application.queries.getAll.GetAllUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByIdUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByLastNameUserQuery;
import dev.juanleon.supermarket_inventory.users.application.queries.getBy.GetByNameUserQuery;
import dev.juanleon.supermarket_inventory.users.infrastructure.outputs.exceptions.NotFoundUserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @BeforeEach
    void setUp() {
        this.restTestClient = RestTestClient.bindTo(this.mockMvc).build();
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
                .thenThrow(new NotFoundUserException(message));

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