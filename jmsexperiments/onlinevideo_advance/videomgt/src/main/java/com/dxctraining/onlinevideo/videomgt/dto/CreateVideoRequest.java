package com.dxctraining.onlinevideo.videomgt.dto;

public class CreateVideoRequest {

    private String description, interest;

    private Integer uploaderUserId;

    public Integer getUploaderUserId() {
        return uploaderUserId;
    }

    public void setUploaderUserId(Integer uploaderUserId) {
        this.uploaderUserId = uploaderUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

}
