# Personal Task Manager

A full-stack **Personal Task Manager** application built with **Spring Boot** for the backend and **React** for the frontend.  
This project allows users to manage tasks with features like creating, viewing, and tracking task status.

---

## **Project Structure**

personalTaskManager/
│
├── backend/ ← Spring Boot project
│ ├── src/
│ ├── pom.xml
│ └── ...
│
└── frontend/ ← React project
├── src/
├── package.json
└── ...


---

## **Backend (Spring Boot)**

### **Technologies Used**
- Java 17
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA 
-  MySQL database

### **Running the Backend**
1. Open `backend` in **IntelliJ IDEA**.  
2. Build the project:
   ```bash
   mvn clean install

   Run the Spring Boot application:

From IntelliJ: Click Run on the main application class

Or via terminal:

mvn spring-boot:run


Backend will run at:

http://localhost:8080

Frontend (React)
Technologies Used

React 18

JavaScript (ES6+)

Fetch API for backend communication

Vite for project setup

Running the Frontend

Open frontend in VS Code.

Install dependencies:

npm install


Start the development server:

npm run dev


Frontend will run at:

http://localhost:5173

Connecting Frontend & Backend

Make sure backend is running on port 8080.

Frontend fetches data using:

fetch("http://localhost:8080/api/tasks")


Enable CORS in Spring Boot to allow requests from http://localhost:5173.

API Endpoints
Method	Endpoint	Description
GET	/api/tasks	Get all tasks
POST	/api/tasks	Create a new task
PUT	/api/tasks/{id}	Update a task by ID
DELETE	/api/tasks/{id}	Delete a task by ID
