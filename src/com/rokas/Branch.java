package com.rokas;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customerArrayList;

    public Branch(String name){
        this.name = name;
        customerArrayList = new ArrayList<Customer>();
    }

    public String getName(){
        return this.name;
    }

    public boolean createCustomer(String name, double initialTransaction){

        if(this.getCustomer(name) == null){
            Customer customer = new Customer(name, initialTransaction );
            customerArrayList.add(customer);
            return true;
        }
        System.out.println("Customer with name " + name + " already exists.");
        return false;

    }



    public boolean makeTransaction(String nameCustomer, double amount){

        Customer customer = getCustomer(nameCustomer);
        if (customer != null){
            return customer.createTransactions(amount);
        }

        return false;

    }

    public Customer getCustomer(String name) {

        for (int i = 0; i < customerArrayList.size(); i++) {
            Customer customer = customerArrayList.get(i);
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }


    public ArrayList<Customer> getCustomerArrayList(){
        return customerArrayList;
    }


}
