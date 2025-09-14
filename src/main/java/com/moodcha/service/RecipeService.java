package com.moodcha.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
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

  public BaseRecipe createRecipe(BaseRecipe recipe) {
    if (recipe instanceof MilkBasedRecipe) {
        return milkRepo.save((MilkBasedRecipe) recipe);
    } else if (recipe instanceof WaterBasedRecipe) {
        return waterRepo.save((WaterBasedRecipe) recipe);
    } else if (recipe instanceof JuiceBasedRecipe) {
        return juiceRepo.save((JuiceBasedRecipe) recipe);
    } else {
      throw new IllegalArgumentException("Oops... unknown recipe. Try again!");
    }
  }

  public BaseRecipe getRecipeById(UUID id) {
    List<JpaRepository<? extends BaseRecipe, UUID>> repos = List.of(milkRepo, waterRepo, juiceRepo);

    for (JpaRepository<? extends BaseRecipe, UUID> repo : repos) {
        Optional<? extends BaseRecipe> recipeFound = repo.findById(id);
        if (recipeFound.isPresent()) {
            return recipeFound.get();
        }
    }
    throw new RecipeNotFoundException("Oops... recipe not found with id: " + id + " Try again!");
  }

  public List<BaseRecipe> getAllRecipes() {
    List<BaseRecipe> allRecipes = new ArrayList<>();
    allRecipes.addAll(milkRepo.findAll());
    allRecipes.addAll(waterRepo.findAll());
    allRecipes.addAll(juiceRepo.findAll());
    return allRecipes;
  }

  public BaseRecipe updateRecipe(UUID id, BaseRecipe updatedRecipe) {
    BaseRecipe existingRecipe = getRecipeById(id);

    existingRecipe.setMood(updatedRecipe.getMood());
    existingRecipe.setFlavour(updatedRecipe.getFlavour());
    existingRecipe.setTemperature(updatedRecipe.getTemperature());
    existingRecipe.setSyrup(updatedRecipe.getSyrup());
    existingRecipe.setAllergies(updatedRecipe.getAllergies());
    existingRecipe.setSupplements(updatedRecipe.getSupplements());

    // Child-specific fields
    if (existingRecipe instanceof MilkBasedRecipe && updatedRecipe instanceof MilkBasedRecipe) {
      ((MilkBasedRecipe) existingRecipe).setMilk(((MilkBasedRecipe) updatedRecipe).getMilk());
    } else if (existingRecipe instanceof WaterBasedRecipe && updatedRecipe instanceof WaterBasedRecipe) {
      ((WaterBasedRecipe) existingRecipe).setWater(((WaterBasedRecipe) updatedRecipe).getWater());
    } else if (existingRecipe instanceof JuiceBasedRecipe && updatedRecipe instanceof JuiceBasedRecipe) {
      ((JuiceBasedRecipe) existingRecipe).setJuice(((JuiceBasedRecipe) updatedRecipe).getJuice());
    }

    if (existingRecipe instanceof MilkBasedRecipe) {
      return milkRepo.save((MilkBasedRecipe) existingRecipe);
    } else if (existingRecipe instanceof WaterBasedRecipe) {
      return waterRepo.save((WaterBasedRecipe) existingRecipe);
    } else if (existingRecipe instanceof JuiceBasedRecipe) {
      return juiceRepo.save((JuiceBasedRecipe) existingRecipe);
    } else {
      throw new IllegalArgumentException("Oops... unknown recipe. Try again!");
    }
  }

  public void deleteRecipeById(UUID id) {
    if (milkRepo.existsById(id)) {
      milkRepo.deleteById(id);
    } else if (waterRepo.existsById(id)) {
      waterRepo.deleteById(id);
    } else if (juiceRepo.existsById(id)) {
      juiceRepo.deleteById(id);
    } else {
      throw new RecipeNotFoundException("Oops... recipe not found with id: " + id + " Try again!");
    }
  }

  public List<BaseRecipe> getAllMoodsRecipes(Mood mood) {
    List<BaseRecipe> moodResults = new ArrayList<>();
    moodResults.addAll(milkRepo.findByMood(mood));
    moodResults.addAll(waterRepo.findByMood(mood));
    moodResults.addAll(juiceRepo.findByMood(mood));
    return moodResults;
  } 

  public List<BaseRecipe> getAllFlavoursRecipes(Flavour flavour) {
    List<BaseRecipe> flavourResults = new ArrayList<>();
    flavourResults.addAll(milkRepo.findByFlavour(flavour));
    flavourResults.addAll(waterRepo.findByFlavour(flavour));
    flavourResults.addAll(juiceRepo.findByFlavour(flavour));
    return flavourResults;
  }

  public List<MilkBasedRecipe> getSpecificMilkRecipes(MilkType milk) {
    return milkRepo.findByMilk(milk);
  }

  public List<BaseRecipe> getRecipesByTemperature(Temperature temperature) {
    List<BaseRecipe> temperatureResults = new ArrayList<>();
    // Milk can be hot or iced
    temperatureResults.addAll(milkRepo.findByTemperature(temperature));
    // Water can only be hot
    if (temperature == Temperature.HOT) {
      temperatureResults.addAll(waterRepo.findAll());
    // Juice can only be iced
    } else if (temperature == Temperature.ICED) {
      temperatureResults.addAll(juiceRepo.findAll());
    }
    return temperatureResults; 
  }

  public List<BaseRecipe> getAllSyrupRecipes(SyrupType syrup) {
    List<BaseRecipe> syrupResults = new ArrayList<>();
    syrupResults.addAll(milkRepo.findBySyrup(syrup));
    syrupResults.addAll(waterRepo.findBySyrup(syrup));
    syrupResults.addAll(juiceRepo.findBySyrup(syrup));
    return syrupResults;
  }

  public BaseRecipe getRandomRecipe() {
    List<BaseRecipe> randomResults = getAllRecipes();
    if (randomResults.isEmpty()) {
      throw new RecipeNotFoundException("Oops... no recipes found. Try again!");
    }
    return randomResults.get(random.nextInt(randomResults.size()));
  }
}
