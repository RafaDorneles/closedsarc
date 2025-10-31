Authors:
- Rafael Dorneles
- João Benevides Lima
- Julio Filho
- Nicolas Docolas

<img width="1280" height="593" alt="image" src="https://github.com/user-attachments/assets/d95c674e-77c0-4fc3-a9a3-c68f24fb5fe0" />

## 📘 Project Overview

Closed SARC is an academic project inspired by the internal OpenSARC platform used at PUCRS.
While OpenSARC allows students to check their classroom schedules and enables professors to rent rooms or equipment, Closed SARC was developed from scratch as a microservices-based replica, with a focus on hands-on learning of distributed and reactive architectures.

The platform is divided into multiple independent services that communicate with each other through HTTP requests. The goal is not only to replicate the original application’s functionality but also to explore modern architectural patterns, reactive programming, and service integration using Spring WebFlux and WebClient.

## 🎯 Learning Objectives

Gain practical experience in designing and building microservice architectures.

Learn and apply Reactive Programming concepts using Spring WebFlux.

Experiment with service communication, API centralization, and inter-service data handling.

Understand containerization and service orchestration using Docker and Docker Compose.

## 🧩 Architecture Overview

The system is composed of several microservices that interact through a shared API gateway layer:

Service	Description
Data Gateway	Central service responsible for communicating with the shared PostgreSQL database. Acts as a simplified database gateway to expose CRUD endpoints for entities such as Professors, Courses, and Rents. While centralization is not the best microservice practice, it was intentionally used here to simplify data access during development.
Professor Service	Manages professor-specific operations such as retrieving their courses and creating or viewing rents for rooms and equipment. Communicates with the Data Gateway via WebClient.
Admin Service	Handles administrative actions and course management, consuming APIs from the Data Gateway.
Common Module	A shared library used across all services, containing common classes such as DTOs, exceptions, and utility components.

Each service runs independently in a container and communicates with others through non-blocking reactive calls, ensuring scalability and resilience.

## ⚙️ Tech Stack

Java 17+

Spring Boot

Spring WebFlux (Reactive programming)

Spring Reactive WebClient

PostgreSQL

Docker & Docker Compose

OpenAPI / Swagger (API documentation)

Maven (build and dependency management)

## 🐳 Running the Project

To run the complete environment locally using Docker Compose:

```shell
docker-compose up --build
```

Once running, you can access the documentations:

Professor Service → http://localhost:8081/professor/swagger-ui/index.htm

Admin Service → http://localhost:8082/admin/swagger-ui/index.html

Data Gateway → http://localhost:8080/data/swagger-ui/index.html

## 📚 Future Improvements

Replace the centralized Data Gateway with direct service-to-service communication.

Add authentication and authorization (JWT).

Implement distributed tracing and observability.

Deploy the full microservices architecture to AWS for real-world scalability testing.

Add unit and integration tests using JUnit and Mockito to strengthen reliability.

Integrate SonarQube for code quality inspection and maintainability analysis.

Deploy to a Kubernetes cluster for scalable orchestration and auto-recovery.

## 🧠 Final Note

Closed SARC was built as an academic exploration of modern backend architecture, blending microservices, reactive programming, and container orchestration.
It reflects the team’s commitment to experimenting beyond traditional monolithic design and gaining real-world insight into distributed systems.