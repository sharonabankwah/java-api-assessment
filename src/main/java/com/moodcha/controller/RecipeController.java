package com.moodcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.moodcha.model.BaseRecipe;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.service.RecipeService;
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

  @GetMapping("/{id}")
  public ResponseEntity<BaseRecipe> getRecipeById(@PathVariable UUID id) {
      BaseRecipe recipeFetched = recipeService.getRecipeById(id);
      return ResponseEntity.ok(recipeFetched);
  }
  
  @PostMapping
  public ResponseEntity<BaseRecipe> createRecipe(@RequestBody BaseRecipe recipe) {
      BaseRecipe recipeCreated = recipeService.createRecipe(recipe);
      return ResponseEntity.status(HttpStatus.CREATED).body(recipeCreated);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<BaseRecipe> updateRecipe(@PathVariable UUID id, @RequestBody BaseRecipe updatedRecipe) {
    BaseRecipe recipeUpdated = recipeService.updateRecipe(id, updatedRecipe);
    return ResponseEntity.ok(recipeUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRecipeById(@PathVariable UUID id) {
    recipeService.deleteRecipeById(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/mood")
  public ResponseEntity<List<BaseRecipe>> getRecipeByMood(@RequestParam("mood") Mood mood) {
    return ResponseEntity.ok(recipeService.getAllMoodsRecipes(mood));
  }

  @GetMapping("/flavour")
  public ResponseEntity<List<BaseRecipe>> getRecipeByFlavour(@RequestParam("flavour") Flavour flavour) {
    return ResponseEntity.ok(recipeService.getAllFlavoursRecipes(flavour));
  }

  @GetMapping("/milk")
  public ResponseEntity<List<MilkBasedRecipe>> getRecipeByMilk(@RequestParam("milk") MilkType milk) {
    return ResponseEntity.ok(recipeService.getSpecificMilkRecipes(milk));
  }

  @GetMapping("/temperature")
  public ResponseEntity<List<BaseRecipe>> getRecipeByTemperature(@RequestParam("temperature") Temperature temperature) {
    return ResponseEntity.ok(recipeService.getRecipesByTemperature(temperature));
  }

  @GetMapping("/syrup")
  public ResponseEntity<List<BaseRecipe>> getRecipeBySyrup(@RequestParam("syrup") SyrupType syrup) {
    return ResponseEntity.ok(recipeService.getAllSyrupRecipes(syrup));
  }

  @GetMapping("/random")
  public ResponseEntity<BaseRecipe> getRandomRecipe() {
    return ResponseEntity.ok(recipeService.getRandomRecipe());
  }

}
