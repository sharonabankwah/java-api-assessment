package com.moodcha.service;

import org.springframework.stereotype.Service;
import com.moodcha.model.BaseRecipe;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.model.WaterBasedRecipe;
import com.moodcha.model.JuiceBasedRecipe;
import com.moodcha.repository.JuiceBasedRepository;
import com.moodcha.repository.MilkBasedRepository;
import com.moodcha.repository.WaterBasedRepository;
import com.moodcha.model.enums.Mood;
import java.util.List;
import java.util.ArrayList;

@Service
public class RecipeService {
  private final MilkBasedRepository milkRepo;
  private final WaterBasedRepository waterRepo;
  private final JuiceBasedRepository juiceRepo;

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
      throw new IllegalArgumentException("Unknown recipe.");
    }
  }

  public List<BaseRecipe> getAllMoods(Mood mood) {
    List<BaseRecipe> moodResults = new ArrayList<>();
    moodResults.addAll(milkRepo.findByMood(mood));
    moodResults.addAll(waterRepo.findByMood(mood));
    moodResults.addAll(juiceRepo.findByMood(mood));
    return moodResults;
  } 

}
