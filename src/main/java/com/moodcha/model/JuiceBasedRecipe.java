package com.moodcha.model;

import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.JuiceType;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Temperature;
import com.moodcha.model.enums.SyrupType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "juice_recipes")
public class JuiceBasedRecipe extends BaseRecipe {

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @NotNull(message = "Juice type is required")
  private JuiceType juice;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  @NotNull(message = "Temperature is required")
  private Temperature temperature;

  public JuiceBasedRecipe(Mood mood, Flavour flavour, Temperature temperature, SyrupType syrup, String supplements, 
                         String allergies, JuiceType juice) {
      super(mood, flavour, temperature, syrup, supplements, allergies);
      this.juice = juice;
  }

  public JuiceBasedRecipe() {
    // no-arg constructor
    super();
  }

  public JuiceType getJuice() {
    return juice;
  }

  public void setJuice(JuiceType juice) {
    this.juice = juice;
  }

}
