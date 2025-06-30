package org.test1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account implements AccountService{
    private final ArrayList<Integer> balanceArray = new ArrayList<>();
    private final ArrayList<Integer> amountArray = new ArrayList<>();
    private final ArrayList<LocalDate> dateArray = new ArrayList<>();

    private int getCurrentBalance() {
        int currentBalance;
        if (this.balanceArray.isEmpty()) {
            currentBalance = 0;
        }
        else {
            currentBalance = this.balanceArray.get(this.balanceArray.size() - 1);
        }
        return currentBalance;
    }

    @Override
    public void deposit(int amount) {
        int currentBalance = getCurrentBalance();
        this.balanceArray.add(currentBalance + amount);
        this.amountArray.add(amount);
        this.dateArray.add(LocalDate.now());
    }

    @Override
    public void withdraw(int amount) {
        int currentBalance = getCurrentBalance();
        if (currentBalance - amount < 0) {
            throw new RuntimeException("Insufficient balance!");
        }
        this.balanceArray.add(currentBalance - amount);
        this.amountArray.add(-amount);
        this.dateArray.add(LocalDate.now());
    }

    @Override
    public void printStatement() {
        System.out.println("Date || Amount || Balance");
        for (int i = this.balanceArray.size() - 1; i >= 0 ; i--) {
            System.out.println(this.dateArray.get(i) + " || " + this.amountArray.get(i) + " || " + this.balanceArray.get(i));
        }
    }
}
