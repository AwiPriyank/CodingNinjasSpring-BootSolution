package com.codingNinjas.Bank.Account.Registration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.ArrayList;
import java.util.List;

@Component("myUser")
@Scope("singleton")
public class myUser implements User {
    private String username;
    private String password;
    List<Account> accounts;

    public myUser() {
        accounts = new ArrayList<>();
    }

    // Getter and Setter methods for username and password

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Method to initialize user properties or perform any necessary setup
    @PostConstruct
    public void init() {
        // Add initialization logic here if needed
    }

    @Override
    public void setUserDetails(String name) {
        this.username = name;
    }

    @Override
    public void addAccount(Account account) {
       accounts.add(account);
}

    @Override
    public List<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public String getName() {
        return username;
    }

    @PreDestroy
    public void cleanUp() {
        // Add clean up logic here if needed
    }
}
