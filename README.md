Spring Commerce - Fullstack E-commerce Application
📌 Project Overview
This is a fullstack E-commerce application built as a deep-dive into the Spring Boot ecosystem, inspired by the comprehensive curriculum from Telusko. The project demonstrates the separation of concerns by utilizing a decoupled architecture: a robust Spring Boot REST API for the backend logic and a modern React.js frontend.

The backend is custom-built to handle business logic, database persistence, and file management, while the frontend is integrated from the ecom-frontend-1 repository.

🚀 Tech Stack
Backend
Java 21

Spring Boot 3.x

Spring Web (RESTful APIs)

Spring Data JPA (ORM)

Spring MVC (Multipart for Image Uploads)

H2 Database (In-memory for development/testing)

Lombok (Boilerplate reduction)

SLF4J/Logback (Professional Logging)

Frontend
React.js

Axios (API Communication)

CSS3/Bootstrap

🛠 Architecture & Key Features
RESTful API Design: Follows standard HTTP methods and status codes for seamless frontend communication.

CRUD Operations: Full product management (Create, Read, Update, Delete).

Image Management: Custom logic to handle multipart file uploads, storing and retrieving product images as byte arrays.

Search Functionality: Dynamic filtering of products based on keywords, brand, or category.

Exception Handling: Global exception handling to ensure consistent error responses.

Validation: Server-side validation for data integrity.

📋 Prerequisites
Before running the application, ensure you have:

JDK 21 or higher.

Maven 3.6+.

Node.js & npm (for frontend).

⚙️ Installation & Setup
1. Backend Setup
Clone your backend repository.

Open src/main/resources/application.properties and ensure the H2 configuration is set:

Properties
spring.application.name=spring-ecom
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
# Allow large file uploads for images
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=5MB
Run the application:

Bash
mvn spring-boot:run
2. Frontend Setup
Clone the frontend: git clone https://github.com/navinreddy20/ecom-frontend-1

Install dependencies:

Bash
cd ecom-frontend-1
npm install
Update the API base URL in the frontend code (usually in a conf.js or service file) to point to http://localhost:8080/api.

Start the frontend:

Bash
npm start
🧪 Testing
The project includes unit and integration tests using JUnit 5 and Mockito.
To run tests:

Bash
mvn test
💡 Lessons Learned (via Telusko)
Mastering Constructor Injection for better testability and cleaner code.

Understanding the lifecycle of Spring Beans and the power of Auto-configuration.

Managing complex data types (Images/BLOBs) in a relational database.

Handling CORS (Cross-Origin Resource Sharing) to allow React and Spring Boot to communicate.

👤 Author
Thành Đạt - [thanhdattt2006]

Inspired by the Telusko Java/Spring Boot Series.
