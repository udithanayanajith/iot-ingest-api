# iot-ingest-api

Spring Boot REST API for IoT device registration and telemetry ingestion.

**What it does**
- Accepts device registration & telemetry over HTTP.
- Validates payloads and publishes telemetry events to Apache Kafka.
- Stateless and horizontally scalable.

## Why this is cool
- Built to be deployed in containers and scaled behind Kubernetes.
- Uses Kafka as the source of truth for high-throughput streaming and decoupling.
- Designed to work with a schema registry (Avro/Protobuf).

## Quickstart (local, dev)

Prereqs:
- Docker & Docker Compose
- Java 11+ (only for local build; not required to run containers)

1. Start stack (Kafka, Zookeeper, Schema Registry, MySQL*(optional)*):
```bash
docker-compose -f docker-compose.dev.yml up --build

./mvnw clean package -DskipTests
docker build -t uditha/iot-ingest-api:dev .
docker run --env SPRING_PROFILES_ACTIVE=dev -p 8080:8080 uditha/iot-ingest-api:dev
