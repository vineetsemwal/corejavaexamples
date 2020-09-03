package com.dxctraining.onlinevideo.videomgt.exceptions;

public class VideoNotFoundException extends RuntimeException{

    public VideoNotFoundException(String msg){
        super(msg);
    }
}
