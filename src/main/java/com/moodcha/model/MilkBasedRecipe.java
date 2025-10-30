package com.moodcha.model;

import com.moodcha.model.enums.Mood;

import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.MilkType;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.SyrupType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "milk_recipes")
public class MilkBasedRecipe extends BaseRecipe {

  
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private MilkType milk;


  public MilkBasedRecipe(Mood mood, Flavour flavour, Temperature temperature, SyrupType syrup, String supplements, 
                         String allergies, MilkType milk) {
      super(mood, flavour, temperature, syrup, supplements, allergies);
      this.milk = milk;
  }

  public MilkBasedRecipe() {
    // no-arg constructor
    super();
  }

  public MilkType getMilk() {
    return milk;
  }

  public void setMilk(MilkType milk) {
    this.milk = milk;
  }

}