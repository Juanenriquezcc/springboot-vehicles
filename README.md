# Vehicle API - Spring Boot 3 + MongoDB

API REST completa para la gestión de vehículos construida con Spring Boot 3 y MongoDB.

## Características

- CRUD completo de vehículos
- Validación de datos con Bean Validation
- Arquitectura limpia con separación de capas
- Documentación automática con Spring Data MongoDB
- Búsquedas personalizadas
- Manejo de errores HTTP apropiado

## Requisitos

- Java 17 o superior
- Maven 3.6+
- MongoDB 4.4+

## Instalación

1. Clonar el repositorio
2. Asegurarse de tener MongoDB ejecutándose en `localhost:27017`
3. Ejecutar: `mvn clean install`
4. Iniciar la aplicación: `mvn spring-boot:run`

## Endpoints de la API

### CRUD Básico

- **POST** `/api/vehicles` - Crear nuevo vehículo
- **GET** `/api/vehicles` - Obtener todos los vehículos
- **GET** `/api/vehicles/{id}` - Obtener vehículo por ID
- **PUT** `/api/vehicles/{id}` - Actualizar vehículo
- **DELETE** `/api/vehicles/{id}` - Eliminar vehículo

### Búsquedas Personalizadas

- **GET** `/api/vehicles/search/brand/{brand}` - Buscar por marca
- **GET** `/api/vehicles/search/model/{model}` - Buscar por modelo
- **GET** `/api/vehicles/search/year/{year}` - Buscar por año
- **GET** `/api/vehicles/search/price/{maxPrice}` - Buscar por precio máximo

## Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/vehicles/
│   │   ├── VehicleApiApplication.java
│   │   ├── model/
│   │   │   └── Vehicle.java
│   │   ├── repository/
│   │   │   └── VehicleRepository.java
│   │   └── controller/
│   │       └── VehicleController.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/vehicles/
```

## Modelo de Datos

### Vehículo (Vehicle)

```json
{
  "id": "string",
  "brand": "string (requerido, 2-50 caracteres)",
  "model": "string (requerido, 1-100 caracteres)",
  "year": "integer (requerido, >= 1900)",
  "price": "double (requerido, >= 0)"
}
```

## Ejemplos de Uso

### Crear un vehículo

```bash
curl -X POST http://localhost:8080/api/vehicles \
  -H "Content-Type: application/json" \
  -d '{
    "brand": "Toyota",
    "model": "Corolla",
    "year": 2023,
    "price": 25000.0
  }'
```

### Obtener todos los vehículos

```bash
curl -X GET http://localhost:8080/api/vehicles
```

### Actualizar un vehículo

```bash
curl -X PUT http://localhost:8080/api/vehicles/{id} \
  -H "Content-Type: application/json" \
  -d '{
    "brand": "Toyota",
    "model": "Camry",
    "year": 2023,
    "price": 28000.0
  }'
```

### Eliminar un vehículo

```bash
curl -X DELETE http://localhost:8080/api/vehicles/{id}
```

### Buscar vehículos por marca

```bash
curl -X GET http://localhost:8080/api/vehicles/search/brand/Toyota
```

## Configuración de MongoDB

La configuración predeterminada espera MongoDB en:
- **Host**: localhost
- **Puerto**: 27017
- **Base de datos**: vehicle_db

Para cambiar la configuración, edite `src/main/resources/application.properties`.

## Compilación y Ejecución

### Compilar el proyecto
```bash
mvn clean install
```

### Ejecutar tests
```bash
mvn test
```

### Ejecutar la aplicación
```bash
mvn spring-boot:run
```

### Crear JAR ejecutable
```bash
mvn clean package
java -jar target/vehicle-api-1.0.0.jar
```

## Tecnologías Utilizadas

- Spring Boot 3.2.0
- Spring Data MongoDB
- Spring Web
- Bean Validation (Jakarta Validation)
- Lombok
- Maven
- Java 17

## Notas de Desarrollo

- La aplicación utiliza Lombok para reducir el código boilerplate
- Se incluye validación en todos los campos del modelo
- Los endpoints devuelven códigos HTTP apropiados
- La API está configurada para permitir CORS desde cualquier origen
- Se incluye Spring DevTools para desarrollo en caliente