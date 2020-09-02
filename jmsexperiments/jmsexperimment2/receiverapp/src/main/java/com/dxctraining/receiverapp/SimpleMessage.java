package com.dxctraining.receiverapp;

import java.io.Serializable;

public class SimpleMessage implements Serializable {

    private String receiverName;

    private String messageText;

    private String state;

    public SimpleMessage(){

    }

    public SimpleMessage(String receiver,String state, String messageText){
        this.receiverName=receiver;
        this.messageText=messageText;
        this.state=state;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
