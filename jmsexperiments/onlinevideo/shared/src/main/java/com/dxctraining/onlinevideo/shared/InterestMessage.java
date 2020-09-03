package com.dxctraining.onlinevideo.shared;

public class InterestMessage {

    private String interest;

    private Integer videoId;

    private String operation;

    public InterestMessage(){

    }

    public InterestMessage(int videoId, String interest ,String operation){
        this.videoId=videoId;
        this.interest=interest;
        this.operation=operation;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }


    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
