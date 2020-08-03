package com.dxctraining.entities;

public class Customer {

    private String id,name;

    private Account account;

    public Customer( String name){
        this.name=name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode(){
       int hashcode=id.hashCode();
       return hashcode;
    }



}
