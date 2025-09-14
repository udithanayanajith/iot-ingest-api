IoT Ingest API Service
======================

A Spring Boot microservice for registering IoT devices and ingesting telemetry data.

Overview
--------

This service provides REST APIs for device management and telemetry ingestion. It receives telemetry data from IoT devices, validates device registration, and publishes the data to Kafka for further processing.

Features
--------

*   Device registration and management
*   Bulk telemetry ingestion
*   Kafka integration for asynchronous processing
*   Swagger/OpenAPI documentation
*   Prometheus metrics integration
*   Input validation

Technology Stack
----------------

*   Java 17+
*   Spring Boot 3.x
*   Spring Data JPA
*   Spring Kafka
*   MySQL Database
*   OpenAPI 3 (Swagger)
*   Micrometer (Prometheus metrics)
*   Maven

Project Structure
-----------------

src/main/java/com/iot\_ingest\_api/uditha97/

├── business/           # Business logic layer

├── config/             # Configuration classes

├── controller/         # REST controllers

├── dto/               # Data Transfer Objects

├── model/             # Entity models

├── repository/        # Data access layer

├── service/           # Service layer

└── IotIngestApiApplication.java  # Main application class


API Endpoints
-------------

### Device Registration

**POST** /api/v1/devices

Registers a new IoT device in the system.

**Request Body:** Device object (JSON)

### Get Device by ID

**GET** /api/v1/devices/{deviceId}

Retrieves device information by its unique identifier.

### Ingest Telemetry (Bulk)

**POST** /api/v1/telemetry

Accepts bulk telemetry payloads and publishes to Kafka asynchronously.

**Request Body:** TelemetryBulkDTO (JSON)

Configuration
-------------

Update the `application.yml` file with your environment-specific settings:

spring:
datasource:
url: jdbc:mysql://localhost:3306/iotdatabase
username: root
password: your\_password
kafka:
bootstrap-servers: localhost:9092


Build and Run
-------------

### Prerequisites

*   Java 17 or higher
*   Maven 3.6+
*   MySQL 8.0+
*   Kafka 2.8+

### Build the Application

mvn clean package

### Run the Application

java -jar target/iot-ingest-api-0.1.0.jar

### Run with Docker

\# Build the Docker image
docker build -t iot-ingest-api .

# Run the container
docker run -p 8080:8080 --name iot-ingest-api iot-ingest-api


Access Points
-------------

*   Application: [http://localhost:8080](http://localhost:8080)
*   Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
*   API Docs: [http://localhost:8080/v1/api-docs](http://localhost:8080/v1/api-docs)
*   Actuator Endpoints: [http://localhost:8080/actuator](http://localhost:8080/actuator)
*   Prometheus Metrics: [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

Monitoring
----------

The service exposes metrics via Micrometer that can be scraped by Prometheus:

*   `iot.telemetry.sent`: Counter for telemetry messages sent to Kafka
*   Standard Spring Boot metrics (JVM, HTTP requests, etc.)

**Note:** Ensure that Kafka and MySQL are running before starting the application.

[Demo.pdf](Extra%20Things/Demo.pdf)