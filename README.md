# CAF SoftSol Recruitment Assignment - Jan 2026

## Overview
This repository contains the solution for the CAF recruitment technical assessment.
- **Assignment 1:** Configuration file parser and REST API.
- **Assignment 2:** Time-based SKU price retrieval service.

## Tech Stack
- **Java:** 8 (OpenJDK 1.8.0_392)
- **Framework:** Spring Boot 2.7.18
- **Build Tool:** Maven

 * Author: Mohammad
 * College: College Of Engineering And Management,Kolaghat
 * Date: Jan 7, 2026
 

## Project Structure
- `ConfigService`: Parses `config.txt` using BufferedReader.
- `PriceService`: Implements logic to find the active price for a SKU at a specific time, handling overlapping windows.
- `Controllers`: Provide REST endpoints for data retrieval.

## How to Run
1. Navigate to the root folder.
2. Run: `.\mvnw.cmd spring-boot:run`

## Test URLs
- Config API: `http://localhost:8080/api/config?sectionName=Order Service`
- Price API: `http://localhost:8080/api/price?skuid=u00006541&time=10:05`