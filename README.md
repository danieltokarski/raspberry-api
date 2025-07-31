# 🍇 raspberry-api

This project provides an API that analyzes historical data from the **Golden Raspberry Awards** (commonly called the Razzies).  
Its main objective is to **identify and expose the producers who have received the "Worst Picture" award** with the **shortest and longest time spans** between their consecutive wins.

---

## 📦 Technologies used

- Java 21
- Spring Boot 3
- Maven
- H2 Database (in-memory)
- Swagger / OpenAPI 3
- JUnit (integration tests)
- Clean Architecture

---

## 🔧 Requirements 

Before running the project, make sure you have the following tools installed on your machine:

### ✅ Environment

- **Java JDK 21**  
  Check the version with:
  ```bash
  java -version
  ```
  
- **Maven 3.8+ (if you are not using the mvnw wrapper)**
  Check the version with:
  ```bash
  mvn -v
  ```
- ** Git
  To clone the repository:
  ```bash
  git --version
  ```
  
---

## 🚀 How to run the project

### 1. Clone the repository

```bash
git clone https://github.com/danieltokarski/raspberry-api.git
cd raspberry-api
```

### 2. Build and run the application
bash
```bash
./mvnw spring-boot:run
```
Requires Java 21+

### 3. Access the endpoints

**Swagger UI**  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

**H2 Console**  
[http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
**JDBC URL:** `jdbc:h2:mem:testdb`  
**User:** `sa`  
**Password:** (leave blank)

---

## 📂 Main Endpoint

### `GET /api/awards/producers/intervals`
Returns a JSON with:

* The producer(s) with the minimum interval between two consecutive wins.
* The producer(s) with the maximum interval between two consecutive wins.

Example response:
 ```
json
{
	"min": [
		{
			"producer": "Joel Silver",
			"interval": 1,
			"previousWin": 1990,
			"followingWin": 1991
		}
	],
	"max": [
		{
			"producer": "Matthew Vaughn",
			"interval": 13,
			"previousWin": 2002,
			"followingWin": 2015
		}
	]
}
```

---

### 🧪 Running integration tests
```bash
./mvnw test
```

The integration tests validate that the endpoint returns the correct JSON output based on the provided CSV file.

---

### 🧱 Clean Architecture Folder Structure
```bash

src/
├── domain/              # Business entities and rules
├── application/         # Use cases
├── infrastructure/      # CSV reading, database setup, external adapters
├── interfaces/          # Controllers (REST API)
```

---

### 📄 License

This project is licensed under the MIT License.
See the LICENSE file for details.

---

### 👨‍💻 Author
Daniel Tokarski
GitHub: @danieltokarski
