package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

@Query("SELECT r FROM Recipe WHERE r.mood = :mood AND r.supplements IS NOT NULL")
List<Recipe> findByMoodWithSupplements(@Param("mood")Mood mood);

@Query("SELECT r FROM Recipe WHERE :allergy NOT MEMBER OF r.allergies")
List<Recipe> findRecipesWithoutAllergy(@Param("allergy")String allergy);

}
