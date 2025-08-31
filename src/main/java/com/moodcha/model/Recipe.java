package com.moodcha.model;

import com.moodcha.model.enums.Mood;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Milk;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.util.UUID;
import jakarta.persistence.Column;

@Entity
@Table(name = "recipes")
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Enumerated(EnumType.STRING)
  private Mood mood;

  @Enumerated(EnumType.STRING)
  private Flavour flavour;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Milk milk;

  private String supplements;
  private String allergies;

  public Recipe(Mood mood, Flavour flavour, Milk milk, String supplements, String allergies) {
    this.mood = mood;
    this.flavour = flavour;
    this.milk = milk;
    this.supplements = supplements;
    this.allergies = allergies;
  }

  public Recipe() {
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

  public Milk getMilk() {
    return milk;
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

  public void setMilk(Milk milk) {
    this.milk = milk;
  }

  public void setSupplements(String supplements) {
    this.supplements = supplements;
  }

  public void setAllergies(String allergies) {
    this.allergies = allergies;
  }

}