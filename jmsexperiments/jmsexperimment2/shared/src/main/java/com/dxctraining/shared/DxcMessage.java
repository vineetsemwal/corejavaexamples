package com.dxctraining.shared;

public class DxcMessage {

    private String receiver, state, message;

    public DxcMessage(){

    }

    public DxcMessage(String receiver, String state, String msg){
        this.receiver=receiver;
        this.state=state;
        this.message=msg;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
