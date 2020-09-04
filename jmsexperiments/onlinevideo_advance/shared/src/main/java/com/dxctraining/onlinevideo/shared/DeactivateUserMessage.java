package com.dxctraining.onlinevideo.shared;

public class DeactivateUserMessage {
    private Integer userId;

    public DeactivateUserMessage(){

    }

    public DeactivateUserMessage(Integer userId){
        this.userId=userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
