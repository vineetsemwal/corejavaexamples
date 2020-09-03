package com.dxctraining.onlinevideo.shared;

public class InterestMessage {

    private String interest;

    private Integer videoId;

    public InterestMessage(){

    }

    public InterestMessage(int videoId, String interest){
        this.videoId=videoId;
        this.interest=interest;
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
}
