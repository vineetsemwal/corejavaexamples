package com.dxctraining.service;

import com.dxctraining.dao.CustomerDaoImpl;
import com.dxctraining.dao.ICustomerDao;
import com.dxctraining.entities.Account;
import com.dxctraining.entities.BusinessCustomer;
import com.dxctraining.entities.Customer;
import com.dxctraining.entities.RegularCustomer;
import com.dxctraining.exceptions.InSufficientAmountException;
import com.dxctraining.exceptions.InvalidAmountException;
import com.dxctraining.exceptions.InvalidArgumentException;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerDao dao = new CustomerDaoImpl();

    @Override
    public Customer findById(String id) {
        validateId(id);
        Customer customer = dao.findById(id);
        return customer;
    }

    @Override
    public void add(Customer customer) {
        dao.add(customer);
    }

    @Override
    public RegularCustomer createRegularCustomer(String customerName, String houseAddress, String pancard) {
        RegularCustomer customer = new RegularCustomer(customerName, houseAddress);
        Account account = new Account();
        account.setPancard(pancard);
        customer.setAccount(account);
        dao.add(customer);
        return customer;
    }

    @Override
    public BusinessCustomer createBusinessCustomer(String customerName, String office, String pancard) {
        BusinessCustomer customer = new BusinessCustomer(customerName, office);
        Account account = new Account();
        account.setPancard(pancard);
        customer.setAccount(account);
        dao.add(customer);
        return customer;
    }

    @Override
    public void delete(String id) {
        validateId(id);
        dao.delete(id);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = dao.findAll();
        return list;
    }

    @Override
    public Customer updateName(String id, String name) {
        validateId(id);
        validateName(name);
        return null;
    }

    @Override
    public Customer addAmount(String id, double amount) {
        validateId(id);
        validateAmount(amount);
        Customer customer = dao.findById(id);
        Account account = customer.getAccount();
        double balance = account.getBalance();
        balance = balance + amount;
        account.setBalance(balance);
        return customer;
    }

    @Override
    public Customer deductAmount(String id, double amount) {
        validateId(id);
        validateAmount(amount);
        Customer customer=dao.findById(id);
        Account account=customer.getAccount();
        double balance=account.getBalance();
        if(balance<amount){
          throw new InSufficientAmountException("amount you want to deduct is more than balance");
        }
        balance=balance-amount;
        account.setBalance(balance);
        return customer;
    }

    public void validateAmount(double amount) {
        if (amount < 0) {
            throw new InvalidAmountException("amount can't be less than zero");
        }
    }

    public void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidArgumentException("name can't be null or empty");
        }
    }

    public void validateId(String id) {
        if (id == null || id.isEmpty()) {
            throw new InvalidArgumentException("id can't be null or empty");
        }
    }

    public void validateCustomer(Customer customer) {
        if (customer == null) {
            throw new InvalidArgumentException("customer can't be null");
        }
    }

}
