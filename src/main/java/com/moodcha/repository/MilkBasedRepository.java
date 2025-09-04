package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.moodcha.model.MilkBasedRecipe;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.MilkType;
import com.moodcha.model.enums.SyrupType;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import com.moodcha.model.enums.Temperature;


public interface MilkBasedRepository extends JpaRepository<MilkBasedRecipe, UUID> {

  List<MilkBasedRecipe> findByMood(Mood mood);

  List<MilkBasedRecipe> findByFlavour(Flavour flavour);

  List<MilkBasedRecipe> findByMilkType(MilkType milk);

  List<MilkBasedRecipe> findByTemperature(Temperature temperature);

  List<MilkBasedRecipe> findBySyrup(SyrupType syrup);

  List<MilkBasedRecipe> findByMoodAndFlavourAndMilkType(Mood mood, Flavour flavour, MilkType milk);

  @Query("SELECT r FROM MilkBasedRecipe WHERE r.mood = :mood AND r.supplements IS NOT NULL")
  List<MilkBasedRecipe> findByMoodWithSupplements(@Param("mood")Mood mood);

  @Query("SELECT r FROM MilkBasedRecipe WHERE :allergy NOT MEMBER OF r.allergies")
  List<MilkBasedRecipe> findRecipesWithoutAllergy(@Param("allergy")String allergy);

  @Query(value = "SELECT * FROM MilkBasedRecipe" +
                 "WHERE mood IS NOT NULL AND flavour IS NOT NULL AND milk IS NOT NULL" +
                 "ORDER BY RAND() LIMIT 1", nativeQuery = true)
  Optional<MilkBasedRecipe> findRandomRecipe();

}
