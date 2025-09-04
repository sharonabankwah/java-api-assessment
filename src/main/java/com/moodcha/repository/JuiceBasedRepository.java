package com.moodcha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JuiceBasedRepository extends JpaRepository<JuiceBasedRepository, UUID> {

}
