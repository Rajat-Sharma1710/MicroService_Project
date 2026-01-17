# 🚀 Microservices Architecture Demo Project

This project demonstrates a **Spring Boot–based microservices architecture** using **Spring Cloud components** such as Eureka Server, API Gateway, Feign Clients, and Circuit Breaker (Resilience4j).  
It is built to understand how independent services communicate, register, route requests, and handle failures gracefully.

---

## 🧩 Microservices in This Project

| Service        | Description |
|----------------|------------|
| Eureka Server  | Service registry and discovery |
| API Gateway    | Central entry point, routing & authentication filter |
| Auth Service   | User authentication and JWT token generation |
| Employee Service | Manages employee data |
| Address Service | Manages address data and calls Employee service |

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Cloud
- Eureka Server
- Spring Cloud Gateway
- OpenFeign
- Resilience4j (Circuit Breaker)
- REST APIs
- JWT Authentication

---

## ⚙ Service Ports

| Service        | Port |
|----------------|------|
| Eureka Server  | 8761 |
| API Gateway    | 9090 |
| Auth Service   | 8083 |
| Employee       | 8081 |
| Address        | 8082 |

---

## 🏗 Architecture Overview

Client → API Gateway → Microservices  
          ↓  
      Eureka Server (Service Discovery)

- All services register with Eureka Server.
- API Gateway routes requests using service names.
- Address service calls Employee service using Feign client.
- Circuit Breaker protects Address service if Employee service is down.

---

## ▶ How to Run the Project

Start services in the following order:

1. Eureka Server
2. API Gateway
3. Auth Service
4. Employee Service
5. Address Service

Eureka Dashboard:
http://localhost:8761

---
