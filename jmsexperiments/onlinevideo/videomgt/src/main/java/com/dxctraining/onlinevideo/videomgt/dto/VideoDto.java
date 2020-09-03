package com.dxctraining.onlinevideo.videomgt.dto;

public class VideoDto {
    private Integer id;

    private String description, interest;


    public VideoDto(){

    }

    public VideoDto(Integer id, String interest, String desc){
        this.id=id;
        this.interest=interest;
        this.description=desc;
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

}
