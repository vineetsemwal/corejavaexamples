package com.dxctraining.onlinevideo.videomgt.dto;

public class VideoDto {
    private Integer id;

    private String description, interest;


    private Integer uploaderUserId;

    public VideoDto(){

    }

    public VideoDto(Integer id,int uploaderUserId, String interest, String desc){
        this.id=id;
        this.interest=interest;
        this.description=desc;
        this.uploaderUserId=uploaderUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUploaderUserId() {
        return uploaderUserId;
    }

    public void setUploaderUserId(Integer uploaderUserId) {
        this.uploaderUserId = uploaderUserId;
    }
}
