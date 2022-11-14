package com.damir.healthcare.repositories;

import com.damir.healthcare.entities.Discover;
import com.damir.healthcare.entities.DiscoverID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DiscoveryRepository extends JpaRepository<Discover, DiscoverID> {
}
