package com.dxctraining.ui;

import com.dxctraining.entities.Account;
import com.dxctraining.entities.BusinessCustomer;
import com.dxctraining.entities.Customer;
import com.dxctraining.entities.RegularCustomer;
import com.dxctraining.service.CustomerServiceImpl;
import com.dxctraining.service.ICustomerService;

import java.util.List;

public class CustomerUi {

    private ICustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {
        CustomerUi ui = new CustomerUi();
        ui.runUi();
    }


    public void runUi() {
        BusinessCustomer customer1 = customerService.createBusinessCustomer("ashok", "hybdoffice", "abcf673");
        BusinessCustomer customer2 = customerService.createBusinessCustomer("vineel", "banglore-office", "abcf673");
        RegularCustomer customer3 = customerService.createRegularCustomer("anuj", "delhi", "6732hbdcba");
        RegularCustomer customer4 = customerService.createRegularCustomer("pradeep", "andhra-home", "98uhjaejaw");

        String id1 = customer1.getId();
        String id2 = customer2.getId();
        customerService.addAmount(id1, 100);
        customerService.addAmount(id2, 200);
        customerService.deductAmount(id2, 50);
        displayAll();

    }

    public void displayAll() {
        List<Customer> list = customerService.findAll();
        for (Customer customer : list) {
            display(customer);
        }
    }

    public void display(Customer customer) {
        System.out.println("*******customer*************");
        System.out.println("custome " +customer.getId() + " " + customer.getName());
        Account account = customer.getAccount();
        System.out.println("pancard " + account.getPancard() + " balance=" + account.getBalance());

        if (customer instanceof RegularCustomer) {
            RegularCustomer regularCustomer = (RegularCustomer) customer;
            System.out.println("House " + regularCustomer.getHouseAddress());
        }

        if (customer instanceof BusinessCustomer) {
            BusinessCustomer businessCustomer = (BusinessCustomer) customer;
            System.out.println("office address " + businessCustomer.getOfficeAddress());
        }

    }


}
