package com.dxctraining.entities;

public class RegularCustomer extends Customer{

    private String houseAddress;

    public RegularCustomer(String name,String houseAddress){
        super(name);
        this.houseAddress=houseAddress;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj==null|| !(obj instanceof RegularCustomer)){
            return false;
        }
        RegularCustomer that=(RegularCustomer)obj;
        boolean result= this.getId().equals(that.getId());
        return result;
    }
}
