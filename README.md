# Supermarket Inventory — API Backend

Backend en **Java** para un sistema de inventario de supermercado. En el estado actual implementa el **módulo de usuarios** con operaciones de consulta (lectura), siguiendo una arquitectura en capas alineada con **Clean Architecture** y un patrón de **mediador** inspirado en **CQRS** para el desacoplamiento entre la capa web y la lógica de aplicación.

---

## Tabla de contenidos

1. [Stack tecnológico](#stack-tecnológico)
2. [Arquitectura y capas](#arquitectura-y-capas)
3. [Patrones de diseño](#patrones-de-diseño)
4. [Estructura de paquetes](#estructura-de-paquetes)
5. [Modelo de datos](#modelo-de-datos)
6. [API REST](#api-rest)
7. [Excepciones y respuestas de error](#excepciones-y-respuestas-de-error)
8. [Configuración y perfiles](#configuración-y-perfiles)
9. [Dependencias (Gradle)](#dependencias-gradle)
10. [Ejecución y pruebas](#ejecución-y-pruebas)
11. [Estado del proyecto y próximos pasos lógicos](#estado-del-proyecto-y-próximos-pasos-lógicos)

---

## Stack tecnológico

| Área | Tecnología |
|------|------------|
| Lenguaje | Java **25** (toolchain Gradle) |
| Framework | **Spring Boot 4.0.4** |
| Build | **Gradle** (`build.gradle`, `settings.gradle`) |
| API web | Spring Web MVC (`spring-boot-starter-webmvc`) |
| Persistencia | Spring Data JPA + **Hibernate** |
| Bases de datos | **H2** (memoria, perfil desarrollo) / **PostgreSQL** (runtime, perfil producción) |
| Mapeo objeto-objeto | **MapStruct 1.6.3** |
| Reducción de boilerplate | **Lombok** |
| Validación | `jakarta.validation` (`spring-boot-starter-validation`) |
| Observabilidad | **Spring Boot Actuator** |
| Desarrollo | Spring Boot DevTools, consola H2 (`spring-boot-h2console`) |

**Nota sobre el nombre del paquete:** el identificador original con guion no es válido en Java; el proyecto usa `dev.juanleon.supermarket_inventory`.

---

## Arquitectura y capas

El código se organiza en **cuatro capas conceptuales** por bounded context (actualmente `users`), con dependencias que apuntan hacia el dominio:

1. **Infrastructure — inputs**  
   Controladores REST (`UserRestController`). Solo reciben peticiones HTTP, construyen **queries** (objetos de petición) y delegan en el **Mediator**.

2. **Application**  
   - **Queries** y **Query handlers**: implementan `IRequestHandler` y orquestan llamadas al **application handler** (`GetUserHandler`).  
   - **DTOs** de entrada/salida (`RequestUserDto`, `ResponseUserDto`).  
   - **Mappers** de aplicación (`IMapperUserApplication`): traducen entre `UserModel` (dominio) y DTOs.

3. **Domain**  
   - **Modelos** puros (`UserModel` como `record`).  
   - **Contratos** (`IGetUserService`, `IGetUserPersistence`) que definen el caso de uso y el acceso a datos sin conocer Spring ni JPA.  
   - **Casos de uso** (`GetUserUseCase`): implementan la regla de negocio delegando en persistencia.

4. **Infrastructure — outputs**  
   - **Adaptadores** (`GetUserAdapter`): implementan `IGetUserPersistence` usando `IUserRepository` y mappers de infraestructura.  
   - **Entidades JPA** (`UserEntity`), **repositorios** Spring Data, **excepciones** de infraestructura (`NotFoundUserException`).

El **Mediator** (`common.mediator.Mediator`) recibe en tiempo de arranque la lista de todos los `IRequestHandler` registrados como beans Spring y resuelve el handler por tipo de la clase de la query (`dispatch`). Esto mantiene los controladores finos y evita inyectar muchos servicios distintos.

---

## Patrones de diseño

| Patrón | Dónde se aplica |
|--------|------------------|
| **Mediator** | `Mediator` + `IRequest` / `IRequestHandler`: enrutamiento de comandos/consultas a un único manejador por tipo. |
| **CQRS (enfoque ligero)** | Separación de **queries** (`GetAllUserQuery`, `GetByIdUserQuery`, etc.) y sus **handlers** dedicados; no hay comandos de escritura expuestos aún en la API. |
| **Hexagonal / Puertos y adaptadores** | Puertos: `IGetUserService`, `IGetUserPersistence`. Adaptador de salida: `GetUserAdapter` + `IUserRepository`. |
| **Repository** | `IUserRepository` extiende `JpaRepository<UserEntity, UUID>`. |
| **DTO** | `RequestUserDto` / `ResponseUserDto` para la frontera HTTP; el dominio usa `UserModel`. |
| **Mapper (MapStruct)** | Interfaces `@Mapper` en aplicación e infraestructura para conversiones tipadas y generadas en compilación. |
| **Dependency Injection** | Spring (`@Component`, `@Service`, `@Repository`, `@Configuration` + `@Bean` en `BeanUserConfiguration` para cablear `GetUserUseCase`). |
| **Problem Details (RFC 7807)** | `GlobalExceptionsHandler` y `GlobalUserExceptionHandler` devuelven `ProblemDetail` en errores. |

---

## Estructura de paquetes

```
dev.juanleon.supermarket_inventory
├── SupermarketInventoryApplication.java
├── common
│   ├── exception          # Manejo global (mediador, validación, integridad, JSON)
│   ├── mediator           # IRequest, IRequestHandler, Mediator
│   └── utils              # DTOs genéricos, enums (Roles), mappers comunes, ResponseModel
└── users
    ├── application        # queries, handlers, dto, mappers de aplicación
    ├── domain             # models, services, persistence (interfaces), useCases
    └── infrastructure
        ├── inputs         # controllers
        └── outputs        # configuration, database (entities, repos, adapters, mappers), exceptions
```

---

## Modelo de datos

### Dominio — `UserModel` (record)

Campos: `id`, `name`, `lastName`, `email`, `password`, `rol`, `isActive`, `createdAt`, `updatedAt`.

### Persistencia — `UserEntity`

Tabla `users`, clave primaria **UUID** generada por JPA. Campos alineados con el modelo; `email` único; `rol` almacenado como `String` (en el DTO de entrada se usa el enum `Roles`).

### Enum `Roles`

Valores: `USER`, `ADMIN` (definidos en `common.utils.enums.Roles`).

### Repositorio

`IUserRepository` expone:

- `findAll()` (heredado)
- `findById(UUID)` (heredado)
- `findByName(String)`
- `findByLastName(String)`

Las búsquedas por nombre/apellido devuelven listas (coincidencia exacta según métodos derivados de Spring Data).

---

## API REST

**Base path:** `/api/v1/users`

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/v1/users` | Lista todos los usuarios. |
| `GET` | `/api/v1/users/{id}` | Usuario por UUID. |
| `GET` | `/api/v1/users/name/{name}` | Usuarios cuyo `name` coincide con el parámetro. |
| `GET` | `/api/v1/users/lastname/{lastName}` | Usuarios cuyo `lastName` coincide con el parámetro. |

**Respuesta exitosa:** cuerpo JSON con `ResponseUserDto` (uno o lista). Fechas `createdAt` / `updatedAt` con formato `yyyy-MM-dd HH:mm:ss`.

**Nota:** `RequestUserDto` incluye validaciones (Bean Validation) pensadas para futuras operaciones de creación/actualización; los endpoints actuales son solo **GET**.

---

## Excepciones y respuestas de error

| Excepción | Handler | HTTP típico |
|-----------|---------|-------------|
| `NotFoundUserException` | `GlobalUserExceptionHandler` | **404** Not Found |
| `NotFoundTypeRequestHandlerMediator` | `GlobalExceptionsHandler` | **500** (sin handler para el tipo de query) |
| `MethodArgumentNotValidException` | `GlobalExceptionsHandler` | **400** |
| `DataIntegrityViolationException` | `GlobalExceptionsHandler` | **400** |
| `HttpMessageNotReadableException` | `GlobalExceptionsHandler` | **400** |

Los cuerpos usan `ProblemDetail` con propiedades adicionales como `date` y `typeError`.

---

## Configuración y perfiles

| Archivo | Rol |
|---------|-----|
| `application.yml` | Nombre de la aplicación, perfil activo por defecto (`dev`), puerto (`APP_PORT_DEV`, por defecto **2000**), logging, **Actuator** (endpoints expuestos `*`), rutas documentadas para Swagger UI en comentarios de configuración. |
| `application-dev.yml` | H2 en memoria, `ddl-auto: update`, SQL formateado, ruta de subida de imágenes de productos (`app.path-upload-images-products`). |
| `application-prod.yml` | PostgreSQL vía variables `DB_URL`, `DB_USERNAME`, `DB_PASSWORD`, `ddl-auto: validate`, SQL sin mostrar en consola. |

**Actuator:** bajo la configuración actual, los endpoints de gestión quedan expuestos; en producción conviene restringir `management.endpoints.web.exposure`.

**Swagger / OpenAPI:** `application.yml` define rutas tipo `springdoc` (`/swagger-ui.html`, `/api-docs`). Para que la UI funcione hace falta la dependencia **springdoc-openapi** (u otra alternativa) en el build; si no está añadida, revisa el `build.gradle` antes de asumir que la documentación interactiva está disponible.

**Spring Security:** la dependencia está **comentada** en `build.gradle`; la API no aplica autenticación/autorización en este estado.

---

## Dependencias (Gradle)

Principales bloques en `build.gradle`:

- **Spring Boot Starters:** Web MVC, Data JPA, Validation, Actuator, H2 Console.
- **Runtime:** H2, PostgreSQL.
- **MapStruct** (implementation + annotation processor).
- **Lombok** (compileOnly + annotation processor).
- **DevTools** (solo desarrollo).
- **Tests:** starters de test alineados con los módulos usados; JUnit Platform launcher.

---

## Ejecución y pruebas

### Requisitos

- JDK compatible con **Java 25** (según toolchain del proyecto).
- Para perfil **prod:** instancia de PostgreSQL y base configurada en `DB_URL`.

### Comandos habituales

```bash
# Compilar y ejecutar tests
./gradlew test

# Arrancar la aplicación (perfil por defecto: dev)
./gradlew bootRun
```

La API queda disponible en el puerto configurado (por defecto **2000**). La consola H2 puede usarse en desarrollo según la configuración del starter H2.

### Pruebas automatizadas

- **Pruebas de integración** (`UserItTest`): `@SpringBootTest` con puerto aleatorio, `RestTestClient`, datos sembrados en `@BeforeEach` vía `IUserRepository`; cubren los cuatro endpoints GET y el caso 404 por id inexistente.
- **Pruebas unitarias y de capa** adicionales bajo `src/test/java` (handlers, use cases, adaptadores, controladores con MockMvc, etc.).

---

## Estado del proyecto y próximos pasos lógicos

Lo implementado hasta ahora es un **vertical slice** sólido de **consulta de usuarios** con arquitectura clara y tests. Elementos ya preparados en código pero no expuestos aún en REST incluyen:

- `RequestUserDto` con validaciones estrictas (contraseña, email, roles) — coherente con futuros **POST/PUT**.
- Mappers y modelo de dominio listos para **comandos** (crear/editar usuario) siguiendo el mismo patrón Mediator + handlers.
- **Seguridad** desactivada a propósito en dependencias; integrar Spring Security cuando se definan flujos de autenticación.
- **Respuesta de usuario:** `ResponseUserDto` incluye `password` en la serialización JSON; en un entorno real conviene excluir u ofuscar ese campo en las respuestas.

El módulo **inventario / productos** (nombre de la app y propiedad `path-upload-images-products`) está anticipado en configuración pero no descrito aquí como código de dominio adicional en el repositorio actual.

---

## Licencia y autor

Proyecto personal / académico — **dev.juanleon**. Ajusta la licencia si publicas el repositorio.
