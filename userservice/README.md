UserService
-----------

This is a Spring Boot application of microservice responsible for managing User Registration and Authentication.
It provides JWT-based security for other services.

📂 Project Structure
css
Copy
Edit
src/main/java/com/example/userservice
🚀 Technologies Used
Java 17+

Spring Boot 3+

Spring Security

JWT (JSON Web Token)

Spring Data JPA

MySQL

Lombok

Maven

🛠️ How to Run
1️⃣ Configure Database (H2 or MySQL)
Set your application.properties / application.yml with DB details.

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/userdb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
2️⃣ Run Application
bash
Copy
Edit
./mvnw spring-boot:run
🎯 Endpoints (Examples)
Method	Endpoint	Description
POST	/api/users/register	Register new user
POST	/api/users/login	Login & get JWT

🔑 JWT Secured Endpoints
You must include Authorization: Bearer <token> for secured routes in other services.