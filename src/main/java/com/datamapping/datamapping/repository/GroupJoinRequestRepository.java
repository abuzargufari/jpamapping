package com.datamapping.datamapping.repository;

import com.datamapping.datamapping.entity.GroupJoinRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJoinRequestRepository extends JpaRepository<GroupJoinRequest, Long> {
    // Custom queries if needed
}
