package com.damir.healthcare.repositories;

import com.damir.healthcare.entities.RecordID;
import com.damir.healthcare.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, RecordID> {
}
