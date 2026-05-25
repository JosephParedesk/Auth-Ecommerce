# Auth — Microservicio de Autenticación y Usuarios

Microservicio REST encargado del registro, autenticación, consulta y eliminación de usuarios dentro de un sistema de e-commerce.  
Las contraseñas se almacenan cifradas utilizando BCrypt para garantizar seguridad en el manejo de credenciales.

---

## Tecnologías utilizadas

- Java 21
- Spring Boot 4.0.3
- Spring Data JPA
- Spring Security Crypto (BCrypt)
- MySQL
- Lombok
- Gradle

---

## Arquitectura

El proyecto implementa una arquitectura limpia por capas, separando responsabilidades para facilitar mantenimiento, escalabilidad y pruebas.

```txt
domain/
  model/           → Entidad Usuario y gateways (puertos)
  usecase/         → Lógica de negocio (UsuarioUseCase)

infrastructure/
  entry_points/    → Controladores REST
  driver_adapters/ → Implementación JPA del gateway de usuario
  encrypter/       → Implementación BCrypt
  mapper/          → Conversión entre entidades y modelos
  exception/       → Manejo global de excepciones

application/
  config/          → Configuración e inyección de dependencias
```

---

## Funcionalidades principales

- Registro de usuarios
- Inicio de sesión
- Consulta de usuarios por cédula
- Eliminación de usuarios
- Cifrado seguro de contraseñas con BCrypt
- Validaciones básicas de datos
- Persistencia con MySQL

---

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| `POST` | `/api/ecommerce/usuario/save` | Registrar usuario |
| `POST` | `/api/ecommerce/usuario/login` | Iniciar sesión |
| `GET` | `/api/ecommerce/usuario/buscar/{cedula}` | Buscar usuario |
| `DELETE` | `/api/ecommerce/usuario/eliminar/{cedula}` | Eliminar usuario |

---

## Ejemplo — Registro de usuario

```json
{
  "cedula": "1234567890",
  "nombre": "Ana García",
  "correo": "ana@correo.com",
  "contrasena": "miPassword123",
  "telefono": "3001234567",
  "edad": 28,
  "rol": "ADMIN"
}
```

---

## Ejemplo — Login

```json
{
  "correo": "ana@correo.com",
  "contrasena": "miPassword123"
}
```

---

## Reglas de negocio

- `cedula`, `nombre`, `correo` y `contrasena` son obligatorios.
- El correo debe contener `@`.
- La contraseña nunca se almacena en texto plano.
- Las credenciales se validan utilizando comparación de hashes BCrypt.
- No se permite registrar usuarios con datos vacíos.

---

## Configuración

En `src/main/resources/application.properties`:

```properties
spring.application.name=auth
server.port=${PORT:8080}

spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USER}
spring.datasource.password=${DATABASE_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
```

> ⚠️ Se recomienda utilizar variables de entorno para evitar exponer credenciales sensibles.

---

## Cómo ejecutar el proyecto

```bash
# Clonar repositorio
git clone https://github.com/JosephParedesk/Auth-Ecommerce

cd Auth-Ecommerce

# Ejecutar aplicación
./gradlew bootRun
```

La API estará disponible en:

```txt
http://localhost:8080
```

---

## Frontend del proyecto

Interfaz web del sistema de e-commerce:

🔗 https://hilarious-gingersnap-98ab5b.netlify.app/

---

## Repositorios relacionados

- Auth-Ecommerce  
  https://github.com/JosephParedesk/Auth-Ecommerce

- Catalogo-Ecommerce  
  https://github.com/JosephParedesk/Catalogo-Ecommerce

---

## Ecosistema del proyecto

Este microservicio hace parte de una arquitectura basada en microservicios para un sistema de e-commerce, donde cada servicio tiene responsabilidades independientes:

- Auth → Gestión de usuarios y autenticación
- Catálogo → Gestión de productos
- Frontend → Interfaz administrativa y visual del sistema

El objetivo es construir una plataforma modular, escalable y fácil de mantener.