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

  // Get recipe by ID
  @GetMapping("/{id}")
  public ResponseEntity<BaseRecipe> getRecipeById(@PathVariable UUID id) {
      BaseRecipe recipeFetched = recipeService.getRecipeById(id);
      return ResponseEntity.ok(recipeFetched);
  }

  // Create water-based recipe
  @PostMapping("/water")
  public ResponseEntity<WaterBasedRecipe> createWaterRecipe(@RequestBody WaterBasedRecipe recipe) {
      WaterBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }

  // Create milk-based recipe
  @PostMapping("/milk")
  public ResponseEntity<MilkBasedRecipe> createMilkRecipe(@Valid @RequestBody MilkBasedRecipe recipe) {
        MilkBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
    }

  // Create juice-based recipe
  @PostMapping("/juice")
  public ResponseEntity<JuiceBasedRecipe> createJuiceRecipe(@RequestBody JuiceBasedRecipe recipe) {
      JuiceBasedRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }

  // Update milk-based recipe by ID
  @PutMapping("/milk/{id}")
  public ResponseEntity<MilkBasedRecipe> updateMilkRecipe(
      @PathVariable UUID id,
      @RequestBody MilkBasedRecipe updatedRecipe) {
      MilkBasedRecipe recipeUpdated = recipeService.updateMilkRecipe(id, updatedRecipe);
      return ResponseEntity.ok(recipeUpdated);
  }

  // Delete recipe by ID
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRecipeById(@PathVariable UUID id) {
    recipeService.deleteRecipeById(id);
    return ResponseEntity.noContent().build();
  }

  // Get recipes by mood
  @GetMapping("/mood")
  public ResponseEntity<List<BaseRecipe>> getRecipeByMood(@RequestParam("mood") Mood mood) {
    return ResponseEntity.ok(recipeService.getAllMoodsRecipes(mood));
  }

  // Get recipes by flavour
  @GetMapping("/flavour")
  public ResponseEntity<List<BaseRecipe>> getRecipeByFlavour(@RequestParam("flavour") Flavour flavour) {
    return ResponseEntity.ok(recipeService.getAllFlavoursRecipes(flavour));
  }

  // Get recipes by milk type
  @GetMapping("/milk")
  public ResponseEntity<List<MilkBasedRecipe>> getRecipeByMilk(@RequestParam("milk") MilkType milk) {
    return ResponseEntity.ok(recipeService.getSpecificMilkRecipes(milk));
  }

  // Get recipes by temperature
  @GetMapping("/temperature")
  public ResponseEntity<List<BaseRecipe>> getRecipeByTemperature(@RequestParam("temperature") Temperature temperature) {
    return ResponseEntity.ok(recipeService.getRecipesByTemperature(temperature));
  }

  // Get recipes by syrup type
  @GetMapping("/syrup")
  public ResponseEntity<List<BaseRecipe>> getRecipeBySyrup(@RequestParam("syrup") SyrupType syrup) {
    return ResponseEntity.ok(recipeService.getAllSyrupRecipes(syrup));
  }

  // Get a random recipe
  @GetMapping("/random")
  public ResponseEntity<BaseRecipe> getRandomRecipe() {
    return ResponseEntity.ok(recipeService.getRandomRecipe());
  }

}
