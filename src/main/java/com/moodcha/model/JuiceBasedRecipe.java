package com.moodcha.model;

import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.JuiceType;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Temperature;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "juice_recipes")
public class JuiceBasedRecipe extends BaseRecipe {

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private JuiceType juice;

  public JuiceBasedRecipe(Mood mood, Flavour flavour, Temperature temperature, String supplements, 
                         String allergies, JuiceType juice) {
      super(mood, flavour, temperature, supplements, allergies);
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
