package com.moodcha.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.SyrupType;
import com.moodcha.model.enums.Temperature;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public abstract class BaseRecipe {

  @Id
  @JdbcTypeCode(SqlTypes.CHAR)
  @Column(columnDefinition = "CHAR(36)", updatable = false, nullable = false)
  private UUID id;

  @NotNull(message = "Mood is required")
  @Enumerated(EnumType.STRING)
  private Mood mood;

  @NotNull(message = "Flavour is required")
  @Enumerated(EnumType.STRING)
  private Flavour flavour;

  @NotNull(message = "Temperature is required")
  @Column(nullable =  false)
  @Enumerated(EnumType.STRING)
  private Temperature temperature;

  @Enumerated(EnumType.STRING)
  private SyrupType syrup; 

  @Size(max = 255, message = "Supplements text too long")
  private String supplements;
  @Size(max = 255, message = "Allergies text too long")
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

  public void setId(UUID id) {
    this.id = id;
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
