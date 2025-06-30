package org.test1;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        // 1000 Deposit
        account.deposit(1000);

        // 2000 deposit
        account.deposit(2000);

        // 500 withdraw
        account.withdraw(500);

        // Print the transactions
        account.printStatement();
    }
}