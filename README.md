# Exam 2B

Proyecto Prueba Técnica para 2B.

## Features

- **Create Empleado**: Agrega nuevo empleado al sistema.
- **View Empleado**: Lista de todos los empleados.
- **Update Empleado**: Modifica Empleado existente.
- **Delete Empleado**: Remueve Empleado.

## Technologies Used

- **Java 17**
- **Spring Boot 3.2.2**
- **Maven**
- **MySQL**
- **Lombok**
- **SpringDoc OpenAPI**
- **JUnit 5**

## Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- MySQL database

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd exam-b2
   ```

2. Configure the database:
   - Update the `application.properties` file with your MySQL database credentials.

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application:
   - API documentation: [http://localhost:8080/exam-documentation](http://localhost:8080/exam-documentation)

## API Endpoints

### Employee Management

- **POST** `/empleados`: Crea empleado.
- **GET** `/empleados`: Obtiene empleados.
- **PUT** `/empleados`: Actualiza empleado.
- **DELETE** `/empleados`: Borra empleado.

## Testing

Run the tests using:
