package com.datamapping.datamapping.service;

import com.datamapping.datamapping.dto.GroupDTO;
import com.datamapping.datamapping.entity.Group;
import com.datamapping.datamapping.entity.User;
import com.datamapping.datamapping.repository.GroupRepository;
import com.datamapping.datamapping.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
   private UserRepository userRepository;

    public void createGroup(GroupDTO groupDTO) {
        User creator = userRepository.findById(groupDTO.getCreatorId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Group group = new Group();
        group.setGroupName(groupDTO.getGroupName());
        group.setCreator(creator);
        groupRepository.save(group);
    }
}