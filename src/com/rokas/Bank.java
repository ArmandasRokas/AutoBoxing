package com.rokas;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branchArrayList;

    public Bank(){
        branchArrayList = new ArrayList<Branch>();
    }

    public boolean addBranch(String name){

        if (getBranch(name) == null){
            Branch branch = new Branch(name);
            branchArrayList.add(branch);
            return true;
        }
        return false;
    }

    private Branch getBranch(String branchName){
        for(int i=0; i<branchArrayList.size(); i++){
            Branch branch = branchArrayList.get(i);
            if(branch.getName().equals(branchName)){
                return branch;
            }
        }
        return null;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){

        Branch branch = getBranch(branchName);

        if (branch == null){
            System.out.println("Branch with " + branchName + " not found.");
            return false;
        } else {
            return branch.createCustomer(customerName, initialTransaction);
        }
    }

    public boolean addTransaction(String branchNameIN, String customerNameIN, String branchNameOUT, String customerNameOUT, double amount) {
        Branch branchIN = this.getBranch(branchNameIN);
        Branch branchOUT = this.getBranch(branchNameOUT);

        if (branchIN == null) {
            System.out.println("Wrong incoming branch name");
            return false;
        } else if (branchOUT == null) {
            System.out.println("Wrong outcoming branch name");
            return false;
        }

        if (branchOUT.makeTransaction(customerNameOUT, -amount) && branchIN.makeTransaction(customerNameIN, amount)) {
            System.out.println("Transaction is made successful from " + customerNameOUT + " to " + customerNameIN +
                    " with amount " + amount);
            return true;
        } else {
            return false;
    }


    }

    public boolean printTransactions(String branchName, String customerName) {
        Branch branch = this.getBranch(branchName);
        ArrayList<Double> customerTransactions;

        if (branch != null){
            customerTransactions = branch.getCustomer(customerName).getTransactionValues();

            if (customerTransactions != null){
                System.out.println(customerName + " made this transactions:");
                for (int i = 0; i < customerTransactions.size(); i++) {
                    System.out.println(i+1 + " transaction: " + customerTransactions.get(i));
                }
                return true;
            }
        }
        return false;



    }

    public boolean printCustomersOfBranch(String branchName, boolean showTransactions){
        Branch branch = this.getBranch(branchName);
        ArrayList<Customer> customers;

        if (branch != null){
            customers = branch.getCustomerArrayList();

            if (customers != null){

                for (int i = 0; i < customers.size(); i++){
                    Customer customer = customers.get(i);
                    System.out.println(" ");
                    System.out.print(customer.getName() + ". ");

                    if (showTransactions){
                        System.out.print("His transactions is: ");
                        ArrayList<Double> transactions = customer.getTransactionValues();
                        for (int a = 0; a<transactions.size(); a++) {
                            System.out.print(" " + transactions.get(a) + ";");
                        }
                    }
                }
                return true;
            }
        }


        return false;
    }


}

