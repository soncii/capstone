package com.damir.healthcare.repositories;

import com.damir.healthcare.entities.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, String> {
}
