package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodcha.model.WaterBasedRecipe;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.WaterType;
import java.util.UUID;
import java.util.List;

public interface WaterBasedRepository extends JpaRepository<WaterBasedRepository, UUID> {

  List<WaterBasedRecipe> findByMood(Mood mood);

  List<WaterBasedRecipe> findByFlavour(Flavour flavour);

  List<WaterBasedRecipe> findByWaterType(WaterType water);

}
