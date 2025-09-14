### 🍵 Moodcha

Moodcha is a Spring Boot–based REST API that generates matcha recipe recommendations tailored to a user’s mood, flavour preferences, milk choices, and dietary requirements.


### ✨ Features



### 🛠 Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL (via devcontainer in GitHub Codespaces)
* Maven


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
 ┃ ┃ ┗ moodcha_dump.sql
 ┃ ┣ application.properties
 ┃ ┗ local.properties
```

### 🚀 Getting Started

#### Prerequisites 

 * Java 21
 * Maven 3+
 * MySQL

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

5. 
