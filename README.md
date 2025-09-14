### 🍵 Moodcha

Moodcha is a Spring Boot–based REST API that manages matcha recipes tailored to a user’s mood, flavour preferences, milk choices, and dietary requirements.

### 📚 Table of Contents

- [Features](###features)  
- [Tech Stack](###tech-stack)  
- [Prerequisites](###prerequisites)  
- [Project Structure](###project-structure)  
- [Installation](####installation)  
- [Database Setup & Sample Data](###database-setup--sample-data)  
- [API Endpoints](###api-endpoints)  
- [Exception Handling](###exception-handling)  
- [Testing](###testing)

### ✨ Features

* Full CRUD (Create, Read, Update, Delete) operations on recipes  
* Query filters on recipes by mood, flavour, milk type, temperature, syrup type  
* Random recipe retrieval  
* Unit test for service class 
* Custom exceptions for recipes not found  
* Structured documentation and unit testing

### 🛠 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* JUnit 5 + Mockito for unit tests

### 💻 Prerequisites

* Java 21
* MySQL
* Maven 3+
* IDE


### 📂 Project Structure
```css
src/
 ┣ main/
 ┃ ┣ java/
 ┃ ┃ ┣ com/
 ┃ ┃ ┃ ┣ moodcha/
 ┃ ┃ ┃ ┃ ┣ controller/
 ┃ ┃ ┃ ┃ ┃ ┗ RecipeController.java
 ┃ ┃ ┃ ┃ ┣ exception/
 ┃ ┃ ┃ ┃ ┃ ┣ GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┗ RecipeNotFoundException.java
 ┃ ┃ ┃ ┃ ┣ model/
 ┃ ┃ ┃ ┃ ┃ ┣ enums/
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ Flavour.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ JuiceType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ MilkType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ Mood.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ SyrupType.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ Temperature.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ WaterType.java
 ┃ ┃ ┃ ┃ ┃ ┣ BaseRecipe.java
 ┃ ┃ ┃ ┃ ┃ ┣ JuiceBasedRecipe.java
 ┃ ┃ ┃ ┃ ┃ ┣ MilkBasedRecipe.java
 ┃ ┃ ┃ ┃ ┃ ┗ WaterBasedRecipe.java
 ┃ ┃ ┃ ┃ ┣ repository/
 ┃ ┃ ┃ ┃ ┃ ┣ JuiceBasedRepository.java
 ┃ ┃ ┃ ┃ ┃ ┣ MilkBasedRepository.java
 ┃ ┃ ┃ ┃ ┃ ┗ WaterBasedRepository.java
 ┃ ┃ ┃ ┃ ┣ service/
 ┃ ┃ ┃ ┃ ┃ ┗ RecipeService.java
 ┃ ┃ ┃ ┃ ┗ RecipeApplication.java
 ┃ ┃ ┣ resources/
 ┃ ┃ ┃ ┣ static/
 ┃ ┃ ┃ ┣ templates/
 ┃ ┃ ┃ ┃ ┗ moodchaDatabaseDump.sql
 ┃ ┣ application.properties
 ┃ ┗ local.properties
```

Note: MySQL database dump can be located at src/main/resources/templates/moodchaDatabaseDump.sql

### 🚀 Getting Started

#### Installation

1. Clone the repository
```bash
git clone https://github.com/sharonabankwah/java-api-assessment.git
```

2. Navigate to the project

```bash
cd java-api-assessment
```

3. Build the project
```bash
./mvnw clean install
```

4. Run the application

```bash
  ./mvnw spring-boot:run
```

### Database Setup

1. Ensure your MySQL server is running. Create the database if not already present:
```sql
CREATE DATABASE moodcha;
USE moodcha;
```

2. Import the sample data:
```bash
mysql -u <username> -p moodcha < src/main/resources/templates/moodchaDatabaseDump.sql
```

3. Verify the sample data exists:
```sql
SELECT * FROM milk_recipes;
SELECT * FROM water_recipes;
SELECT * FROM juice_recipes;
```
### 🌐 API Endpoints

| Method                                                   | Path                        |
| -------------------------------------------------------- | --------------------------- | 
| `GET /api/recipes/{id}`                                  | Get a recipe by its UUID    |         
| `POST /api/recipes`                                      | Create a new recipe         |         
| `PUT /api/recipes/{id}`                                  | Update an existing recipe   |         
| `DELETE /api/recipes/{id}`                               | Delete a recipe by its UUID |         
| `GET /api/recipes/mood?mood={mood}`                      | Filter by mood              |         
| `GET /api/recipes/flavour?flavour={flavour}`             | Filter by flavour           |         
| `GET /api/recipes/milk?milk={milkType}`                  | Filter by milk type         |         
| `GET /api/recipes/temperature?temperature={temperature}` | Filter by temperature       |         
| `GET /api/recipes/syrup?syrup={syrupType}`               | Filter by syrup type        |         
| `GET /api/recipes/random`                                | Get a random recipe         |         

#### Request/Response Examples

* GET by ID:
```bash
GET /api/recipes/b3c7d8a0-55d1-4d0d-9b2e-6f2d5b63c2fa
```

* POST body to create recipe:
```json
{
  "mood": "HAPPY",
  "flavour": "SWEET",
  "temperature": "ICED",
  "syrup": "VANILLA",
  "supplements": "PROTEIN",
  "allergies": NULL,
  "milk": "OAT"
}
```
### 🚨 Exception Handling

* RecipeNotFoundException is thrown when trying to GET, PUT or DELETE by an ID that doesn’t exist.
* The API returns HTTP status 404 Not Found and a message like:

```json
{
  "timestamp": "2025-09-14T12:20:42.189+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Oops... recipe not found with id: <UUID> Try again!"
}
```

### 🔎 Testing

* Unit test added for RecipeService.getRecipeById(UUID id) using JUnit 5 + Mockito.
* To run all tests:

```bash
  ./mvnw test
```
