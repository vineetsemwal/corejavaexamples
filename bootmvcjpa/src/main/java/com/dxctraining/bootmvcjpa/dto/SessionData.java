package com.dxctraining.bootmvcjpa.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionData {

    private int id=-1;

    public SessionData(int id){
        this.id=id;
    }

    public SessionData(){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void  clear(){
        id=-1;
    }
}
