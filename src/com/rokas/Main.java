package com.rokas;

public class Main {

    public static void main(String[] args) {

            Bank bank1 = new Bank();
            bank1.addBranch("Copenhagen");
            bank1.addCustomer("Copenhagen", "Jim", 10.00);
            bank1.addCustomer("Copenhagen", "John", 10.00);

            bank1.addTransaction("Copenhagen", "Jim", "Copenhagen", "John", 1.00);
      //      bank1.addTransaction("Copenhagen", "Jim", "Copenhagen", "John", 9.00);
            bank1.printTransactions("Copenhagen", "John");

            bank1.printCustomersOfBranch("Copenhagen", false);
    }
}
