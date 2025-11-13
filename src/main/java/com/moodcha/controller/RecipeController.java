package com.moodcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moodcha.model.BaseRecipe;
import com.moodcha.model.JuiceBasedRecipe;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.model.WaterBasedRecipe;
import com.moodcha.service.RecipeService;

import jakarta.validation.Valid;

import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.MilkType;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.SyrupType;
import java.util.UUID;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  // ------------------- CRUD -------------------

  // Get a recipe by its ID
  // URL: GET /api/recipes/{id}
  @GetMapping("/{id}")
  public ResponseEntity<BaseRecipe> getRecipeById(@PathVariable UUID id) {
      BaseRecipe recipeFetched = recipeService.getRecipeById(id);
      return ResponseEntity.ok(recipeFetched);
  }

  // Create a milk-based recipe
  // URL: POST /api/recipes/milk
  // Body: MilkBasedRecipe JSON
  @PostMapping("/milk")
  public ResponseEntity<MilkBasedRecipe> createMilkRecipe(@Valid @RequestBody MilkBasedRecipe recipe) {
      MilkBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }

  // Create a water-based recipe
  // URL: POST /api/recipes/water
  @PostMapping("/water")
  public ResponseEntity<WaterBasedRecipe> createWaterRecipe(@Valid @RequestBody WaterBasedRecipe recipe) {
      WaterBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }


  // Create a juice-based recipe
  // URL: POST /api/recipes/juice
  @PostMapping("/juice")
  public ResponseEntity<JuiceBasedRecipe> createJuiceRecipe(@Valid @RequestBody JuiceBasedRecipe recipe) {
      JuiceBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }

  // Update a milk-based recipe by ID
  // URL: PUT /api/recipes/milk/{id}
  @PutMapping("/milk/{id}")
  public ResponseEntity<MilkBasedRecipe> updateMilkRecipe(
      @PathVariable UUID id,
      @Valid @RequestBody MilkBasedRecipe updatedRecipe) {
      MilkBasedRecipe recipeUpdated = recipeService.updateMilkRecipe(id, updatedRecipe);
      return ResponseEntity.ok(recipeUpdated);
  }

  // Delete a recipe by ID (works for milk, water, or juice)
  // URL: DELETE /api/recipes/{id}
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRecipeById(@PathVariable UUID id) {
    recipeService.deleteRecipeById(id);
    return ResponseEntity.noContent().build();
  }

  // ------------------- Filters / Queries -------------------

  // Get recipes by mood
  // URL: GET /api/recipes/mood?mood=ENERGETIC
  @GetMapping("/mood")
  public ResponseEntity<List<BaseRecipe>> getRecipeByMood(@RequestParam("mood") Mood mood) {
    return ResponseEntity.ok(recipeService.getAllMoodsRecipes(mood));
  }

  // Get recipes by flavour
  // URL: GET /api/recipes/flavour?flavour=SWEET
  @GetMapping("/flavour")
  public ResponseEntity<List<BaseRecipe>> getRecipeByFlavour(@RequestParam("flavour") Flavour flavour) {
    return ResponseEntity.ok(recipeService.getAllFlavoursRecipes(flavour));
  }

  // Get milk-based recipes by milk type
  // URL: GET /api/recipes/milk?milk=ALMOND
  @GetMapping("/milk")
  public ResponseEntity<List<MilkBasedRecipe>> getRecipeByMilk(@RequestParam("milk") MilkType milk) {
    return ResponseEntity.ok(recipeService.getSpecificMilkRecipes(milk));
  }

  // Get recipes by temperature
  // URL: GET /api/recipes/temperature?temperature=HOT
  @GetMapping("/temperature")
  public ResponseEntity<List<BaseRecipe>> getRecipeByTemperature(@RequestParam("temperature") Temperature temperature) {
    return ResponseEntity.ok(recipeService.getRecipesByTemperature(temperature));
  }

  // Get recipes by syrup type
  // URL: GET /api/recipes/syrup?syrup=VANILLA
  @GetMapping("/syrup")
  public ResponseEntity<List<BaseRecipe>> getRecipeBySyrup(@RequestParam("syrup") SyrupType syrup) {
    return ResponseEntity.ok(recipeService.getAllSyrupRecipes(syrup));
  }

  // ------------------- Misc -------------------

  // Get a random recipe
  // URL: GET /api/recipes/random
  @GetMapping("/random")
  public ResponseEntity<BaseRecipe> getRandomRecipe() {
    return ResponseEntity.ok(recipeService.getRandomRecipe());
  }

}
