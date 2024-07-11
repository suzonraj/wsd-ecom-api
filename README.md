# WSD E-commerce API

This project is an implementation of an E-commerce application exposing several APIs, developed using Spring Boot following the TDD approach.

## Table of Contents

- [Requirements](#requirements)
- [Setup](#setup)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [Docker](#docker)
- [Logging and Monitoring](#logging-and-monitoring)
- [Commit History](#commit-history)

## Requirements

- IntelliJ IDEA IDE
- Spring Boot 3.2.2
- JDK 17
- Latest Docker version
- Prometheus
- Grafana

## Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/suzonraj/wsd-ecom-api.git
   cd wsd-ecom-api
   ```

2. **Configure the database:**
   Create ``wsdecommerce`` database in your PostgreSQL database. Ensure PostgreSQL is installed and running.


3. **Database Migration:**
The database migration is managed by ***Liquibase***. The migration scripts are located in ``src/main/resources/db/changelog``.

   
4. **Install dependencies and build the project::**
   ```sh
   ./mvnw clean install
   ```

## API Endpoints

### Wishlist API
#### Get Customer Wishlist:
- ``GET /api/v1/wishlist/{customerId}``

### Sales API
#### Get Total Sale Amount of Current Day:
- ``GET /api/v1/sales/today``

#### Get Max Sale Day of a Certain Time Range:
- `` GET /api/v1/sales/max-sale-day?startDate=2024-07-01&endDate=2024-07-07``

#### Get Top 5 Selling Items of All Time:
- ``GET /api/v1/sales/top5/all-time``

#### Get Top 5 Selling Items of the Last Month:
- ``GET /api/v1/sales/top5/last-month``


## Running the Application

1. **Start the PostgreSQL container:**
   ```sh
   docker-compose up -d db
   ```
   
2. **Run the Spring Boot application:**
   ```sh
   ./mvnw spring-boot:run
   ```

## Testing
#### Start:

1. **Start the PostgreSQL container:**
   ```sh
   docker-compose up -d db
   ```
   
2. **Run unit tests:**
   ```sh
   ./mvnw test
   ```
   
3. **Run integration tests:**
   ```sh
   ../mvnw verify
   ```

## Docker
1. **Build the Docker image:**
   ```sh
   docker build -t wsd-ecom-api .
   ```
2. **Run the Docker container:**
   ```sh
   docker-compose up -d
   ```

## Logging and Monitoring
- Logging is configured using Sl4j and Logback.
- Monitoring can be implemented using tools such as Prometheus and Grafana. Included in `docker-compose.yml`

## Commit History
For detailed commit history, refer to the repository's [commit logs](https://github.com/suzonraj/wsd-ecom-api.git/commits).