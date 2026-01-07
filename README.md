# CAF SoftSol Recruitment Technical Assessment (Jan 2026)

## 👤 Candidate Information
* **Author:** Mohammad
* **College:** College of Engineering and Management, Kolaghat
* **Date:** January 7, 2026

---

## 🚀 Overview
This repository contains a Spring Boot application developed for the CAF technical recruitment drive. The project solves two key backend challenges:

1.  **Assignment 1 (Config Parser):** A service that reads a `.txt` file, parses specific sections (e.g., "Order Service"), and serves the data as a RESTful JSON response.
2.  **Assignment 2 (Price Retrieval):** A robust pricing engine that handles time-based logic. It retrieves the correct SKU price by filtering through overlapping time windows and returning the most recent valid record.

---

## 🛠 Tech Stack
- **Language:** Java 8 (OpenJDK 1.8.0_392)
- **Framework:** Spring Boot 2.7.18
- **Build Tool:** Maven
- **Architecture:** Layered (Controller -> Service -> Model)

---

## 🧪 TDD & Quality Assurance
Following a **Test-Driven Development (TDD)** approach, I have implemented automated unit tests to verify the business logic.
- **Unit Tests:** Located in `src/test/java/com/itsmdsh/assignment/`
- **Verification:** To run the automated tests, use the following command:
  ```powershell
  .\mvnw.cmd test

```

---

## 🖥️ How to Run Locally

1. Clone the repository.
2. Ensure you have **Java 8** installed.
3. Open a terminal in the project root and run:
```powershell
.\mvnw.cmd spring-boot:run

```



---

## 🔗 API Endpoints & Testing

Once the server is running on `localhost:8080`, you can test the following endpoints:

### 1. Configuration API

* **URL:** `http://localhost:8080/api/config?sectionName=Order Service`
* **Expected Output:** ```json
{
"topic": ["test_os_topic_1", "test_os_topic_2"],
"broker": "[https://orbroker.in](https://orbroker.in)"
}




### 2. Price Retrieval API

* **URL:** `http://localhost:8080/api/price?skuid=u00006541&time=10:05`
* **Expected Output:** `99` (Correctly handles overlapping time windows)


## 📂 Project Structure

* `com.itsmdsh.assignment.service`: Contains `ConfigService` (File I/O) and `PriceService` (Business Logic).
* `com.itsmdsh.assignment.controller`: REST Controllers for exposing endpoints.
* `src/main/resources`: Contains `config.txt` and `prices.tsv` data files.


