package com.dxctraining.entities;

public class BusinessCustomer extends Customer{

    private String officeAddress;

    public BusinessCustomer(String name, String office){
        super(name);
        this.officeAddress=office;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this){
            return true;
        }
        if(obj==null|| !(obj instanceof BusinessCustomer)){
            return false;
        }
        BusinessCustomer that=(BusinessCustomer) obj;
        boolean result= this.getId().equals(that.getId());
        return result;
    }
}
