package com.moodcha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.moodcha.model.BaseRecipe;
import com.moodcha.service.RecipeService;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/recipes")
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

}
