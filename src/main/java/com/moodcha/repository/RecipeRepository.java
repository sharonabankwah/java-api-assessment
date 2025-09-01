package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moodcha.model.Recipe;
import com.moodcha.model.enums.Mood;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {



}
