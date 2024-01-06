package com.datamapping.datamapping.repository;

import com.datamapping.datamapping.entity.Group;
import com.datamapping.datamapping.entity.GroupMember;
import com.datamapping.datamapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {
    boolean existsByUserAndGroup(User user, Group group);
    // Custom queries if needed
}
