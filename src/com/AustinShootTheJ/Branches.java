package com.AustinShootTheJ;

import java.util.ArrayList;

public class Branches {

    private ArrayList<Customer> customers;
    private String branchName;

    // constructor which sets the branch name and initializes the customers list.
    public Branches(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<Customer>();
    }

    // method for adding a customer to our customers list. calls the findCustomer method to check if a customer already exists
    // if that customer does not exist it is created, if it does exist false is returned.
    public boolean addNewCustomer(String customerName, double initialTransaction){
        if(findCustomer(customerName) == null){
            this.customers.add(new Customer(customerName,initialTransaction));
            return true;
        }

        return false;

    }

    // method for adding a transaction to an existing customer. takes the arguments of customerName and amount, creates a customer object and initializes it to the result of findCustomer.
    // checks that created object and if it is equal to null returns false. If it is not equal to null then our findCustomer method returned a customer object and we call our
    // addTransactions method from the Customers class on our customer object with the argument amount and return true.
    public boolean addCustomerTransaction(String customerName, double amount){
        Customer existingCustomer = findCustomer(customerName);

        if(existingCustomer != null){
            existingCustomer.addTransactions(amount);
            return true;
        }
        return false;
    }


    // returns the branch name.
    public String getBranchName() {
        return branchName;
    }


    // Returns a customer object and accepts a customerName argument as a String. Our for loop runs through the customers array list for our current branches object and returns
    // a customer object if our getName method return is equal to the argument customerName.
    private Customer findCustomer(String customerName){
        for(int i = 0; i<this.customers.size(); i++){
            Customer checkedCustomer = this.customers.get(i);
            if(checkedCustomer.getName().equals(customerName)){
                return checkedCustomer;

            }

        }

        return null;
    }

    // returns the arraylist customers for our branches object.
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
