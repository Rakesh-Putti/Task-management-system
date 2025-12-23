# Task Management System - Java Backend

## Overview
This repository contains the **Java backend** for the Task Management System project.  
It is built using **Java**, **Spring Boot**, and **Maven**, and provides APIs for managing tasks, teams, users, and comments.

---

## Features
- Create, update, delete, and view tasks
- Manage teams and users
- Assign tasks to users
- Add comments to tasks
- Custom exception handling for errors
- API documentation using Swagger

---

## Project Structure

TaskManagementSystem/
├── src/main/java/
│ ├── controller/ # REST controllers
│ ├── service/ # Business logic
│ ├── dao/ # Data access layer
│ ├── dto/ # Data Transfer Objects
│ ├── repo/ # Spring Data Repositories
│ └── exception/ # Custom exceptions
├── src/main/resources/
│ └── application.properties
├── pom.xml


---

## Setup Instructions

1. **Clone the repository:**

```bash
git clone https://github.com/Rakesh-Putti/Task-management-system.git
cd Task-management-system


Open in IDE: Import as a Maven project in Eclipse or IntelliJ.

Configure database: Update application.properties with your DB credentials.
Example:

spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update


Run the application:
Run TaskManagementSystemApplication.java. The server will start on http://localhost:8080/.

Swagger API docs:
Open in browser:

http://localhost:8080/swagger-ui/index.html

Notes

This repository currently includes backend only.

Frontend (React) will be added in a separate update.

Author

Putti Rakesh Varma
Email: rakeshvermaputti@gmail.com

Phone: 8688976276


