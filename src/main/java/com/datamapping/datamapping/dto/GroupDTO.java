package com.datamapping.datamapping.dto;

public class GroupDTO {

    private String groupName;
    private Long creatorId;

    // Constructors, getters, and setters

    public GroupDTO() {
        // Default constructor
    }

    public GroupDTO(String groupName, Long creatorId) {
        this.groupName = groupName;
        this.creatorId = creatorId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }
}
