### 🍵 Moodcha

Moodcha is a Spring Boot–based REST API that manages matcha recipes tailored to a user’s mood, flavour preferences, milk choices, and dietary requirements.

### 📚 Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Prerequisites](#prerequisites)  
- [Project Structure](#project-structure)  
- [Installation](#installation)  
- [Database Setup & Sample Data](#database-setup--sample-data)  
- [API Endpoints](#api-endpoints)  
- [Exception Handling](#exception-handling)  
- [Testing](#testing)  
- [Usage Example](#usage-example)

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

## 💻 Prerequisites

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
 ┣ resources/
 ┃ ┣ static/
 ┃ ┣ templates/
 ┃ ┃ ┗ moodchaDatabaseDump.sql
 ┃ ┣ application.properties
 ┃ ┗ local.properties
```

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
2. 
```bash
CREATE DATABASE moodcha;
USE moodcha;
```

2. Import the sample data:
```bash
mysql -u <username> -p moodcha < src/main/resources/templates/moodchaDatabaseDump.sql
```


3. 
4. 
