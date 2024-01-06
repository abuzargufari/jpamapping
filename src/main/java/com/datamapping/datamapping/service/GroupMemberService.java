package com.datamapping.datamapping.service;

import com.datamapping.datamapping.dto.GroupMemberDTO;
import com.datamapping.datamapping.entity.Group;
import com.datamapping.datamapping.entity.GroupJoinRequest;
import com.datamapping.datamapping.entity.GroupMember;
import com.datamapping.datamapping.entity.User;
import com.datamapping.datamapping.repository.GroupJoinRequestRepository;
import com.datamapping.datamapping.repository.GroupMemberRepository;
import com.datamapping.datamapping.repository.GroupRepository;
import com.datamapping.datamapping.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberService {

    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupJoinRequestRepository groupJoinRequestRepository;

    public void sendJoinRequest(GroupMemberDTO groupMemberDTO) {
        User user = userRepository.findById(groupMemberDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Group group = groupRepository.findById(groupMemberDTO.getGroupId())
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));

        if (groupMemberRepository.existsByUserAndGroup(user, group)) {
            throw new IllegalArgumentException("User is already a member of the group");
        }

        GroupJoinRequest joinRequest = new GroupJoinRequest(user, group);
        joinRequest.setPermissionLevel(groupMemberDTO.getPermissionLevel());
        groupJoinRequestRepository.save(joinRequest);
    }

    public void grantJoinRequest(Long requestId) {
        GroupJoinRequest joinRequest = groupJoinRequestRepository.findById(requestId)
                .orElseThrow(() -> new EntityNotFoundException("Join request not found"));

        GroupMember groupMember = new GroupMember();
        groupMember.setUser(joinRequest.getUser());
        groupMember.setGroup(joinRequest.getGroup());
        groupMember.setPermissionLevel(joinRequest.getPermissionLevel());
        groupMemberRepository.save(groupMember);

        groupJoinRequestRepository.delete(joinRequest);
    }
}
