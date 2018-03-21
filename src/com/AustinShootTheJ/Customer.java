package com.AustinShootTheJ;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;


    // constructor which initializes the list of transactions, sets the customer name, and sets the initialAmount.
    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransactions(initialAmount);

    }

    // method to add to our list of a customer's transactions.
    public void addTransactions(double transaction) {
        this.transactions.add(transaction);
    }

    // returns customer name.
    public String getName() {
        return name;
    }

    // returns the arraylist of customer transactions.
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}


