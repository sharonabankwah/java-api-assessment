package com.moodcha.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moodcha.exception.RecipeNotFoundException;
import com.moodcha.model.BaseRecipe;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.model.WaterBasedRecipe;
import com.moodcha.model.JuiceBasedRecipe;
import com.moodcha.repository.JuiceBasedRepository;
import com.moodcha.repository.MilkBasedRepository;
import com.moodcha.repository.WaterBasedRepository;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.SyrupType;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.WaterType;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.MilkType;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
public class RecipeService {
  private final MilkBasedRepository milkRepo;
  private final WaterBasedRepository waterRepo;
  private final JuiceBasedRepository juiceRepo;
  private final Random random = new Random();

  public RecipeService(MilkBasedRepository milkRepo, WaterBasedRepository waterRepo, JuiceBasedRepository juiceRepo) {
    this.milkRepo = milkRepo;
    this.waterRepo = waterRepo;
    this.juiceRepo = juiceRepo;
  }

    // ------------------- CREATE -------------------
    /**
     * Saves a recipe to the corresponding repository based on type.
     * Supports MilkBasedRecipe, WaterBasedRecipe, JuiceBasedRecipe.
     */
  @SuppressWarnings("unchecked")
  public <T extends BaseRecipe> T createRecipe(BaseRecipe recipe) {

    if (recipe.getId() == null) {
      recipe.setId(UUID.randomUUID());
    }

    if (recipe instanceof MilkBasedRecipe) {
      MilkBasedRecipe saved = milkRepo.save((MilkBasedRecipe) recipe);
      System.out.println("Saved milk recipe: " + saved.getId());
        return (T) saved;
    } else if (recipe instanceof WaterBasedRecipe) {
        return (T) waterRepo.save((WaterBasedRecipe) recipe);
    } else if (recipe instanceof JuiceBasedRecipe) {
        return (T) juiceRepo.save((JuiceBasedRecipe) recipe);
    } else {
      throw new IllegalArgumentException("Unknown recipe type. Try again!");
    }
  }

  // ------------------- READ -------------------
    /**
     * Fetch a recipe by its UUID from any repository.
     */
  public BaseRecipe getRecipeById(UUID id) {
    List<JpaRepository<? extends BaseRecipe, UUID>> repos = List.of(milkRepo, waterRepo, juiceRepo);

    for (JpaRepository<? extends BaseRecipe, UUID> repo : repos) {
        Optional<? extends BaseRecipe> recipeFound = repo.findById(id);
        if (recipeFound.isPresent()) {
            return recipeFound.get();
        }
    }
    throw new RecipeNotFoundException("Recipe not found with id: " + id);
  }

  /**
     * Fetch all recipes from all repositories.
     */
  public List<BaseRecipe> getAllRecipes() {
    List<BaseRecipe> allRecipes = new ArrayList<>();
    allRecipes.addAll(milkRepo.findAll());
    allRecipes.addAll(waterRepo.findAll());
    allRecipes.addAll(juiceRepo.findAll());
    return allRecipes;
  }

  /**
  * Fetch all recipes with a specific mood.
  */
  public List<BaseRecipe> getAllMoodsRecipes(Mood mood) {
    List<BaseRecipe> moodResults = new ArrayList<>();
    moodResults.addAll(milkRepo.findByMood(mood));
    moodResults.addAll(waterRepo.findByMood(mood));
    moodResults.addAll(juiceRepo.findByMood(mood));
    return moodResults;
  } 

  /**
  * Fetch all recipes with a specific flavour.
  */
  public List<BaseRecipe> getAllFlavoursRecipes(Flavour flavour) {
    List<BaseRecipe> flavourResults = new ArrayList<>();
    flavourResults.addAll(milkRepo.findByFlavour(flavour));
    flavourResults.addAll(waterRepo.findByFlavour(flavour));
    flavourResults.addAll(juiceRepo.findByFlavour(flavour));
    return flavourResults;
  }

  /**
  * Fetch all milk-based recipes of a specific milk type.
  */
  public List<MilkBasedRecipe> getSpecificMilkRecipes(MilkType milk) {
    return milkRepo.findByMilk(milk);
  }

  /**
  * Fetch recipes by temperature.
  * - Milk: HOT or ICED depending on field
  * - Water: STILL can only be HOT, all others can be ICED
  * - Juice: only ICED
  */
  public List<BaseRecipe> getRecipesByTemperature(Temperature temperature) {
  
    List<BaseRecipe> temperatureResults = new ArrayList<>();

    // Milk can be hot or iced
    temperatureResults.addAll(milkRepo.findByTemperature(temperature));

    // Water can only be hot if still and iced if not still
    List<WaterBasedRecipe> allWater = waterRepo.findAll();
    for (WaterBasedRecipe water : allWater) {
      if ((water.getWater() == WaterType.STILL && temperature == Temperature.HOT) ||
          (water.getWater() != WaterType.STILL && temperature == Temperature.ICED)) {
        temperatureResults.add(water);
      }
    }

    // Juice can only be iced
    if (temperature == Temperature.ICED) {
      temperatureResults.addAll(juiceRepo.findAll());
    }
    return temperatureResults; 
  }

  /**
  * Fetch all recipes with a specific syrup type.
  */
  public List<BaseRecipe> getAllSyrupRecipes(SyrupType syrup) {
    List<BaseRecipe> syrupResults = new ArrayList<>();
    syrupResults.addAll(milkRepo.findBySyrup(syrup));
    syrupResults.addAll(waterRepo.findBySyrup(syrup));
    syrupResults.addAll(juiceRepo.findBySyrup(syrup));
    return syrupResults;
  }

  /**
  * Returns a single random recipe.
  */
  public BaseRecipe getRandomRecipe() {
    List<BaseRecipe> randomResults = getAllRecipes();
    if (randomResults.isEmpty()) {
      throw new RecipeNotFoundException("No recipes found.");
    }
    return randomResults.get(random.nextInt(randomResults.size()));
  }

   // ------------------- UPDATE -------------------
    /**
     * Updates a milk-based recipe by ID.
     */
  @Transactional
  public MilkBasedRecipe updateMilkRecipe(UUID id, MilkBasedRecipe updatedRecipe) {
    MilkBasedRecipe existing = milkRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Milk recipe not found: " + id));
    existing.setMood(updatedRecipe.getMood());
    existing.setFlavour(updatedRecipe.getFlavour());
    existing.setTemperature(updatedRecipe.getTemperature());
    existing.setMilk(updatedRecipe.getMilk());
    System.out.println("Updated milk recipe: " + existing.getId());
    return milkRepo.save(existing);
  }

  // ------------------- DELETE -------------------
    /**
     * Deletes a recipe by ID from any repository.
     */
  public void deleteRecipeById(UUID id) {
    if (milkRepo.existsById(id)) {
      milkRepo.deleteById(id);
    } else if (waterRepo.existsById(id)) {
      waterRepo.deleteById(id);
    } else if (juiceRepo.existsById(id)) {
      juiceRepo.deleteById(id);
    } else {
      throw new RecipeNotFoundException("Recipe not found with id: " + id);
    }
  }

}

// ------------------- COMMENTED -------------------
  /**
   * Generic update method for any recipe type.
   * Currently not in use due to complexity with child-specific fields.
   */
// public BaseRecipe updateRecipe(UUID id, BaseRecipe updatedRecipe) {
  //   BaseRecipe existingRecipe = getRecipeById(id);

  //   existingRecipe.setMood(updatedRecipe.getMood());
  //   existingRecipe.setFlavour(updatedRecipe.getFlavour());
  //   existingRecipe.setTemperature(updatedRecipe.getTemperature());
  //   existingRecipe.setSyrup(updatedRecipe.getSyrup());
  //   existingRecipe.setAllergies(updatedRecipe.getAllergies());
  //   existingRecipe.setSupplements(updatedRecipe.getSupplements());

  //   // Child-specific fields
  //   if (existingRecipe instanceof MilkBasedRecipe && updatedRecipe instanceof MilkBasedRecipe) {
  //     ((MilkBasedRecipe) existingRecipe).setMilk(((MilkBasedRecipe) updatedRecipe).getMilk());
  //   } else if (existingRecipe instanceof WaterBasedRecipe && updatedRecipe instanceof WaterBasedRecipe) {
  //     ((WaterBasedRecipe) existingRecipe).setWater(((WaterBasedRecipe) updatedRecipe).getWater());
  //   } else if (existingRecipe instanceof JuiceBasedRecipe && updatedRecipe instanceof JuiceBasedRecipe) {
  //     ((JuiceBasedRecipe) existingRecipe).setJuice(((JuiceBasedRecipe) updatedRecipe).getJuice());
  //   }

  //   if (existingRecipe instanceof MilkBasedRecipe) {
  //     return milkRepo.save((MilkBasedRecipe) existingRecipe);
  //   } else if (existingRecipe instanceof WaterBasedRecipe) {
  //     return waterRepo.save((WaterBasedRecipe) existingRecipe);
  //   } else if (existingRecipe instanceof JuiceBasedRecipe) {
  //     return juiceRepo.save((JuiceBasedRecipe) existingRecipe);
  //   } else {
  //     throw new IllegalArgumentException("Oops... unknown recipe. Try again!");
  //   }
  // }
