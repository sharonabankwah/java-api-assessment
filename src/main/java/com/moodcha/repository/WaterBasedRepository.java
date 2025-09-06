package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodcha.model.WaterBasedRecipe;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.SyrupType;
import com.moodcha.model.enums.WaterType;
import java.util.UUID;
import java.util.List;

public interface WaterBasedRepository extends JpaRepository<WaterBasedRecipe, UUID> {

  List<WaterBasedRecipe> findByMood(Mood mood);

  List<WaterBasedRecipe> findByFlavour(Flavour flavour);

  List<WaterBasedRecipe> findBySyrup(SyrupType syrup);

  List<WaterBasedRecipe> findByWaterType(WaterType water);

}
