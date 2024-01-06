package com.datamapping.datamapping.dto;

public class GroupMemberDTO {

    private Long groupId;
    private Long userId;
    private String permissionLevel;

    // Constructors, getters, and setters

    public GroupMemberDTO() {
        // Default constructor
    }

    public GroupMemberDTO(Long groupId, Long userId, String permissionLevel) {
        this.groupId = groupId;
        this.userId = userId;
        this.permissionLevel = permissionLevel;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
}

