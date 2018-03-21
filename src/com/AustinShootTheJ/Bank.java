package com.AustinShootTheJ;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branches> branches;

    // constructor which sets the bank's name and initialises the branches arraylist.
    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branches>();
    }

    // method to add a new branch. Uses the findBranch method to check if our branchName already exists and creates a branch if it doesnt.
    public boolean addBranch(String branchName){
        if (findBranch(branchName) == null){
            this.branches.add(new Branches(branchName));
            return true;
        }
        return false;
    }

    // method to add a new customer. Checks first to see if the branch requested exists, if it does not we cannot add a customer and thus return false.
    // if a branch is found we call addNewCustomer method from our branches class on the remaining arguments submitted to the method.
    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branches branch = findBranch(branchName);
        if(branch != null){
            return branch.addNewCustomer(customerName,initialAmount);
        }
        return false;
    }


    // method to add a customer transaction. Checks first to see if a branch exists and returns false if it doesnt.
    // if it does we call the addCustomerTransaction method from our branches class on our branches object submit
    // customerName and amount as arguments.
    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branches branch = findBranch(branchName);
        if(branch != null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    // Returns a branches object and accepts a branch argument as a String. Our for loop runs through the branches array list for our current branches object and returns
    // a branches object if our getBranchName method return is equal to the argument branchName.
    private Branches findBranch(String branchName){
        for(int i = 0; i<this.branches.size(); i++){
            Branches checkedBranch = this.branches.get(i);
            if(checkedBranch.getBranchName().equals(branchName)){
                return checkedBranch;

            }

        }

        return null;
    }

    // display customer transactions. the boolean showTransactions gives us the option to only display the name if we want.
    public boolean listCustomers(String branchName, boolean showTransactions){
        // creates a branch if findBranch returns a result
        Branches branch = findBranch(branchName);
        // if a branch is found
        if(branch != null){
            //displays the name of the branch and then begins a for loop to display the customers at that branch.
            System.out.println("Customer details for branch " + branch.getBranchName());
            // Populates an array list from the selected branch's customers list
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            // loops through that list returns the customer names
            for(int i=0; i<branchCustomers.size(); i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "["+(i+1)+"]");
                // checks to see if we wanted to view their transactions and if so loops through our transactions.
                if(showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j=0; j<transactions.size(); j++){
                        System.out.println("["  + (j+1)+"]   Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }else {

            return false;
        }
    }






}
