package com.codingNinjas.Bank.Account.Registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component("currentAccount")
@Scope("prototype")
public class currentAccount implements Account {
    private double balance;

    public currentAccount() {
        this.balance = 0; // Default balance is 0 for a new account
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }

    @Override
    public void addBalance(double balance) {
        this.balance += balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void addAccount(myUser myUser) {
        myUser.addAccount(this);
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Current account initialized.");

    }
}