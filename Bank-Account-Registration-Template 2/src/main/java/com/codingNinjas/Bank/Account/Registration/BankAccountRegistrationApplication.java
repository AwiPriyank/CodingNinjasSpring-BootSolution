package com.codingNinjas.Bank.Account.Registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class BankAccountRegistrationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.codingNinjas.Bank.Account.Registration");
        SpringApplication.run(BankAccountRegistrationApplication.class, args);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name:");
        String userName = scanner.nextLine();

        User user = context.getBean(User.class);
        user.setUserDetails(userName);

        while (true) {
            System.out.println("Enter account type (savings/current) or 'exit' to finish:");
            String accountType = scanner.nextLine();
            if (accountType.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter initial balance:");
            double initialBalance = Double.parseDouble(scanner.nextLine());

            Account account;
            if (accountType.equalsIgnoreCase("savings")) {
                account = context.getBean("savingsAccount", savingsAccount.class);
            } else if (accountType.equalsIgnoreCase("current")) {
                account = context.getBean("currentAccount", currentAccount.class);
            } else {
                System.out.println("Invalid account type. Please enter 'savings' or 'current'.");
                continue;
            }

            account.addBalance(initialBalance);
            user.addAccount(account);
        }

        displayAccountList(user);
    }

    private static void displayAccountList(User user) {
        System.out.println("List of accounts for " + user.getName() + ":");
        int count = 1;
        for (Account account : user.getAllAccounts()) {
            System.out.println("Account " + count++ + ": " + account.getAccountType() +
                    " - Balance: " + account.getBalance());
        }
    }

}
