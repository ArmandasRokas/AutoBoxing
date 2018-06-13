package com.rokas;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactionValues;

    public Customer(String name, double initialTransaction){
        this.name = name;
        transactionValues = new ArrayList<Double>();
        createTransactions(initialTransaction);
    }
    public String getName(){
        return name;
    }

    public boolean createTransactions(double amount){
        if (amount != 0.00){
            transactionValues.add(amount);
            return true;
        } else {
            System.out.println("Error. Amount. Zero");
            return false;
        }

    }

    public ArrayList<Double> getTransactionValues(){
        return transactionValues;
    }
}
