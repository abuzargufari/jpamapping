package com.datamapping.datamapping.controller;

import com.datamapping.datamapping.dto.GroupDTO;
import com.datamapping.datamapping.dto.GroupMemberDTO;
import com.datamapping.datamapping.service.GroupMemberService;
import com.datamapping.datamapping.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupMemberService groupMemberService;

    // Endpoint for creating a group
    @PostMapping("/create")
    public ResponseEntity<String> createGroup(@RequestBody GroupDTO groupDTO) {
        groupService.createGroup(groupDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Group created successfully");
    }

    // Endpoint for sending a join request
    @PostMapping("/join-request")
    public ResponseEntity<String> sendJoinRequest(@RequestBody GroupMemberDTO groupMemberDTO) {
        groupMemberService.sendJoinRequest(groupMemberDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Join request sent successfully");
    }

    // Endpoint for granting a join request
    @PutMapping("/grant-join-request/{requestId}")
    public ResponseEntity<String> grantJoinRequest(@PathVariable Long requestId) {
        groupMemberService.grantJoinRequest(requestId);
        return ResponseEntity.status(HttpStatus.OK).body("Join request granted successfully");
    }
}

