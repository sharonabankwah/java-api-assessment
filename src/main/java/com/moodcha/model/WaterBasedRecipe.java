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

@Entity
@Table(name = "water_recipes")
public class WaterBasedRecipe extends BaseRecipe {

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private WaterType water;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Temperature temperature = Temperature.HOT;

  public WaterBasedRecipe(Mood mood, Flavour flavour, Temperature temperature, SyrupType syrup, String supplements, 
                         String allergies, WaterType water) {
      super(mood, flavour, temperature, syrup, supplements, allergies);
      this.water = water;
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

}
