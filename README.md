# BarberLab API

BarberLab is a RESTful API built with **Java 21** and **Spring Boot** to manage a barber shop. 
It handles clients, appointments, services, and barbers in a simple and efficient way.

## Features

- Manage clients: add, update, delete, list.
- Manage appointments with clients and barbers.
- Manage services offered by the barber shop.
- Automatic database migrations using Flyway.
- Clean architecture with Spring Boot best practices.

## Technologies

- Java 21
- Spring Boot
- PostgreSQL (database)
- Flyway (database migrations)
- Maven (build tool)

## Getting Started

1. Clone the repository:

```
git clone https://github.com/Valadaresxx/BarberLab.git
```
2. Configure your PostgreSQL database in application.yml
3. Run the project:
```
./mvnw spring-boot:run
```
4. Flyway will automatically apply the database migrations.

## Project Structure 
```
src/
 ├─ main/
 │  ├─ java/com/barberlab/
 │  │  ├─ controller/
 │  │  ├─ dto/
 │  │  ├─ model/
 │  │  ├─ repository/
 │  │  └─ service/
 │  └─ resources/
 │     └─ db/migration/
 └─ test/
```

## Future Plans
- Add authentication and authorization (JWT or OAuth2)
- Implement a frontend (React or Angular)
- Advanced reports and analytics

## License 
Mit License
