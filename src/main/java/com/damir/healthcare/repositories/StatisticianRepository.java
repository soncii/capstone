package com.damir.healthcare.repositories;

import com.damir.healthcare.entities.Statistician;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticianRepository extends JpaRepository<Statistician, String> {
}
