package com.moodcha.model;

import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.WaterType;
import com.moodcha.model.enums.SyrupType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "water_recipes")
public class WaterBasedRecipe extends BaseRecipe {

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @NotNull(message = "Water type is required")
  private WaterType water;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @NotNull(message = "Temperature is required")
  private Temperature temperature;

  public WaterBasedRecipe(Mood mood, Flavour flavour, Temperature temperature, SyrupType syrup, String supplements, 
                         String allergies, WaterType water) {
      super(mood, flavour, temperature, syrup, supplements, allergies);
      this.water = water;
      this.temperature = temperature;
  }

  public WaterBasedRecipe() {
    // no-arg constructor
    super();
  }

  public WaterType getWater() {
    return water;
  }

  public void setWater(WaterType water) {
    this.water = water;
  }

  public Temperature getTemperature() {
    return temperature;
  }

  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  } 

}
