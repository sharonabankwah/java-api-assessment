package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moodcha.model.JuiceBasedRecipe;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.SyrupType;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.JuiceType;
import java.util.List;
import java.util.UUID;

public interface JuiceBasedRepository extends JpaRepository<JuiceBasedRecipe, UUID> {

  List<JuiceBasedRecipe> findByMood(Mood mood);

  List<JuiceBasedRecipe> findByFlavour(Flavour flavour);

  List<JuiceBasedRecipe> findBySyrup(SyrupType syrup);

  List<JuiceBasedRecipe> findByJuice(JuiceType juice);

  List<JuiceBasedRecipe> findByTemperature(Temperature temperature);

}
