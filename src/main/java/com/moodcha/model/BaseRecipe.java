package com.moodcha.model;

import java.util.UUID;
import com.moodcha.model.enums.Flavour;
import com.moodcha.model.enums.Mood;
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
  private UUID id;

  @Enumerated(EnumType.STRING)
  private Mood mood;

  @Enumerated(EnumType.STRING)
  private Flavour flavour;

  @Column(nullable =  false)
  @Enumerated(EnumType.STRING)
  private Temperature temperature;

  private String supplements;
  private String allergies;

}
