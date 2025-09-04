package com.moodcha.model;

import java.util.UUID;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.SyrupType;
import com.moodcha.model.enums.Temperature;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseRecipe {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(updatable = false, nullable = false)
  private UUID id;

  @Enumerated(EnumType.STRING)
  private Mood mood;

  @Enumerated(EnumType.STRING)
  private Flavour flavour;

  @Column(nullable =  false)
  @Enumerated(EnumType.STRING)
  private Temperature temperature;

  @Enumerated(EnumType.STRING)
  private SyrupType syrup; 

  private String supplements;
  private String allergies;

  public BaseRecipe(Mood mood, Flavour flavour, Temperature temperature, SyrupType syrup, 
                    String supplements, String allergies) {
    this.mood = mood;
    this.flavour = flavour;
    this.temperature = temperature;
    this.syrup = syrup;
    this.supplements = supplements;
    this.allergies = allergies;
  }

  public BaseRecipe() {
    // no-arg constructor
  }

  public UUID getId() {
    return id;
  }

  public Mood getMood() {
    return mood;
  }

  public Flavour getFlavour() {
    return flavour;
  }

  public Temperature getTemperature() {
    return temperature;
  }

  public SyrupType getSyrup() {
    return syrup;
  }

  public String getSupplements() {
    return supplements;
  }

  public String getAllergies() {
    return allergies;
  }

  public void setMood(Mood mood) {
    this.mood = mood;
  }

  public void setFlavour(Flavour flavour) {
    this.flavour = flavour;
  }

  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  }

  public void setSyrup(SyrupType syrup) {
    this.syrup = syrup;
  }

  public void setSupplements(String supplements) {
    this.supplements = supplements;
  }

  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }

}
