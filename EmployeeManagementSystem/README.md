Employee Management System 
--------------------------

This is a simple Employee Management System API built with Spring Boot Security and JWT (JSON Web Token) authentication.

🔧 Technologies Used
Java 21

Spring Boot

Spring Security

JWT (io.jsonwebtoken)

Maven

Postman (for API testing)

🏗️ Project Structure
bash
Copy
Edit
src/main/java/com/example/employeemanagementsystem
├── config           # Security Configuration
├── controller       # Controllers for Auth & Employee APIs
├── dto              # DTOs for Login Request and JWT Response
├── entity           # Employee Entity
├── filter           # JWT Authentication Filter
├── service          # Employee Service Layer
├── util             # JWT Utility Class
🛡️ Security
Login Endpoint: POST /api/login

Token: JWT Token is returned on successful login

Authorization:

ADMIN Role: Full Access (GET, POST, DELETE Employees)

USER Role: Can only access /api/profile

Authentication Type: Bearer Token (JWT)

🔑 Default Credentials
Username	Password	Role
admin	admin123	ADMIN
user	user123	USER

📫 API Endpoints
🔐 Authentication
Method	Endpoint	Body Example	Description
POST	/login	{ "username": "admin", "password": "admin123" }	Get JWT Token
GET	/profile	None	Profile for logged-in user

👨‍💼 Employee Management (ADMIN Only)
Method	Endpoint	Description
GET	/employees	List all employees
POST	/employees	Create employee
DELETE	/employees/{id}	Delete employee

🔥 How to Run
1️⃣ Clone Repository
bash
Copy
Edit
git clone <your-repo-url>
cd EmployeeManagementSystem
2️⃣ Build
bash
Copy
Edit
mvn clean install
3️⃣ Run
bash
Copy
Edit
mvn spring-boot:run
4️⃣ Test with Postman
POST /api/login to get JWT

Set Authorization > Bearer Token in Postman with the JWT

Call GET /api/employees, POST /api/employees, or DELETE /api/employees/{id}