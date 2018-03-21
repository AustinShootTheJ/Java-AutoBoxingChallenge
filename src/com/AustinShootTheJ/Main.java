package com.AustinShootTheJ;

public class Main {

    public static void main(String[] args) {

    Bank bank = new Bank("VACU");

    bank.addBranch("Virginia Center Commons");

    bank.addCustomer("Virginia Center Commons","AJ",200.00);
    bank.addCustomer("Virginia Center Commons","Travis",100.00);

    bank.addBranch("South Side");

    bank.addCustomer("South Side","David",50.00);
    bank.addCustomer("South Side", "Tyler",300.00);



    bank.addCustomerTransaction("Virginia Center Commons","AJ", 22.5);
    bank.addCustomerTransaction("Virginia Center Commons","Travis", 33);
    bank.addCustomerTransaction("South Side","Tyler", 22.5);


    bank.listCustomers("Virginia Center Commons",true);



    }
}
