package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moodcha.model.Recipe;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Milk;
import java.util.List;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

List<Recipe> findByMood(Mood mood);

List<Recipe> findByFlavour(Flavour flavour);

List<Recipe> findByMilk(Milk milk);

List<Recipe> findByMoodAndFlavourAndMilk(Mood mood, Flavour flavour, Milk milk);

}
