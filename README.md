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
src/main/java/com/moodcha
 ┣ model/
 ┃ ┣ Recipe.java
 ┃ ┗ enums/
 ┃    ┣ Mood.java
 ┃    ┣ Flavour.java
 ┃    ┗ Milk.java
 ┣ repository/
 ┃ ┗ RecipeRepository.java
 ┣ service/
 ┃ ┗ RecipeService.java
 ┣ controller/
 ┃ ┗ RecipeController.java
```

### 🚀 Getting Started

#### Prerequisites 

 * Java 21
 * Maven 3+
 * MySQL

#### Installation

1. Clone the repository

2. Navigate to the project

3. Build the project

```bash
  ./mvnw spring-boot:run
```

5. Run the application
