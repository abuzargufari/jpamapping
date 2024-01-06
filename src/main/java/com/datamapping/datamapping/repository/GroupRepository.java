package com.datamapping.datamapping.repository;

import com.datamapping.datamapping.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    // Custom queries if needed
}
