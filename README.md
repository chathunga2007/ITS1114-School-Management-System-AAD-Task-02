# 🏫 School Management System REST API

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Database](https://img.shields.io/badge/Database-MySQL-blue.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

A robust, enterprise-grade backend system for managing school administration and library activities, built using **Spring Boot 3 (v4.1.0)**, **Java 21**, and **Spring Data JPA**.

---

## 🌟 Key Features

### 👮 Admin Panel
* **Save & Update Sections**: Organize the school hierarchy by adding or editing academic sections.
* **Add, Update & Remove Students**: Full student lifecycle management with status tracking (`ACTIVE`/`INACTIVE`).
* **Section Enrollment**: Seamlessly assign students to specific sections.

### 📚 Librarian Panel
* **Save & Update Books**: Maintain the library catalog with comprehensive book information (Name, Author).
* **Borrowing Records Management**: Track and manage records of book borrowings by students (Registering borrowings, updating details, and clearing records).

---

## 🛠️ Technology Stack

* **Framework**: Spring Boot 4.1.0 (with Web and Spring Data JPA starters)
* **Language**: Java 21
* **Database**: MySQL (using MySQL Connector/J)
* **Utility**: Project Lombok (for boilerplate-free model classes)
* **Build Tool**: Maven

---

## 🚀 Getting Started

### 📋 Prerequisites
* **Java Development Kit (JDK) 21** or higher
* **MySQL Server** (default port: `3306`)
* **Maven** (or use the included Maven Wrapper `mvnw.cmd`)

### 🗄️ Database Setup
1. Start your local MySQL server.
2. The application is pre-configured to automatically create the database if it doesn't exist. You do not need to create it manually.
3. Database configuration details (located in `src/main/resources/application.properties`):
   ```properties
   spring.application.name=School-Managment-System
   spring.datasource.url=jdbc:mysql://localhost:3306/school_management_system?createDatabaseIfNotExist=true
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### 🏃 Running the Application
Run the following command from the project root directory:

```bash
# On Windows
.\mvnw.cmd spring-boot:run

# On Linux/macOS
./mvnw spring-boot:run
```

The server will start on **`http://localhost:8080`**.

---

## 🗺️ Project Structure

```text
lk.ijse.School_Managment_System
├── constant                 # Contains API standard response wrappers & codes
│   ├── CommonResponse.java
│   ├── ResponseMessage.java
│   └── ResponseStatusCode.java
├── controller               # Rest Controller endpoints
│   ├── BookController.java
│   ├── RecordController.java
│   ├── SectionController.java
│   └── StudentController.java
├── dto                      # Data Transfer Objects
│   ├── BookDTO.java
│   ├── RecordDTO.java
│   ├── SectionDTO.java
│   └── StudentDTO.java
├── entity                   # JPA/Hibernate Entity definitions
│   ├── Book.java
│   ├── Record.java
│   ├── Section.java
│   └── Student.java
├── enumeration              # System Enums (e.g., StudentStatus)
│   └── StudentStatus.java
├── repository               # Spring Data JPA Repositories
│   ├── BookRepository.java
│   ├── RecordRepository.java
│   ├── SectionRepository.java
│   └── StudentRepository.java
└── service                  # Business Logic Layer
    ├── BookService.java
    ├── RecordService.java
    ├── SectionService.java
    ├── StudentService.java
    └── impl                 # Service Implementations
        ├── BookServiceImpl.java
        ├── RecordServiceImpl.java
        ├── SectionServiceImpl.java
        └── StudentServiceImpl.java
```

---

## 🔌 API Documentation

All request and response bodies are formatted as `application/json`.

### 📂 Sections (`/api/sections`)

#### Save Section
* **Method**: `POST`
* **Request Body**:
  ```json
  {
    "description": "Grade 11 - Class A"
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Update Section
* **Method**: `PUT`
* **Request Body**:
  ```json
  {
    "sectionId": 1,
    "description": "Grade 11 - Class B"
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

---

### 🎓 Students (`/api/students`)

#### Save Student
* **Method**: `POST`
* **Request Body**:
  ```json
  {
    "studentName": "John Doe",
    "dob": "2010-05-15",
    "studentStatus": "ACTIVE",
    "sectionId": 1
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Update Student
* **Method**: `PUT`
* **Request Body**:
  ```json
  {
    "studentId": 1,
    "studentName": "John Smith Doe",
    "dob": "2010-05-15",
    "studentStatus": "ACTIVE",
    "sectionId": 1
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Soft Remove Student
* **Method**: `DELETE`
* **Path Variable**: `studentId` (e.g., `/api/students/1`)
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

---

### 📖 Books (`/api/books`)

#### Save Book
* **Method**: `POST`
* **Request Body**:
  ```json
  {
    "bookName": "Effective Java",
    "bookAuthor": "Joshua Bloch"
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Update Book
* **Method**: `PUT`
* **Request Body**:
  ```json
  {
    "bookId": 1,
    "bookName": "Effective Java (3rd Edition)",
    "bookAuthor": "Joshua Bloch"
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

---

### 📝 Borrowing Records (`/api/records`)

#### Save Record
* **Method**: `POST`
* **Request Body**:
  ```json
  {
    "studentId": 1,
    "bookId": 1
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Update Record
* **Method**: `PUT`
* **Request Body**:
  ```json
  {
    "recordId": 1,
    "studentId": 1,
    "bookId": 2
  }
  ```
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

#### Delete Record
* **Method**: `DELETE`
* **Path Variable**: `recordId` (e.g., `/api/records/1`)
* **Response Body**:
  ```json
  {
    "status": 0,
    "body": null,
    "message": "Operation Successful..."
  }
  ```

---

## 🎓 Academic Profile & Author
* **Developer:** Chathunga Bimsara 
* **Role:** Undergraduate Software Engineering Student
* **Academic Center:** Institute of Java and Software Engineering (IJSE)
* **Curriculum Context:** Advanced Application Development (AAD)

---
<p align="center">Made with ❤️ for School Managemenet System(Backend-AAD) By Chathunga Bimsara</p>
