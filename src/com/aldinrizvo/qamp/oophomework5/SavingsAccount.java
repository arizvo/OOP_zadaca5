package com.aldinrizvo.qamp.oophomework5;

public class SavingsAccount extends Account {
    private final double initialTransactionLimit;
    private double currentTransactionLimit;
    private int numberOfTransactionsLeft;

    public SavingsAccount(final Owner owner,
                          final String serialNumber,
                          final int passcode,
                          final double balance,
                          final double initialTransactionLimit) {
        super(owner, serialNumber, passcode, balance);
        this.initialTransactionLimit = initialTransactionLimit;
        this.currentTransactionLimit = initialTransactionLimit;
        this.numberOfTransactionsLeft = 3;
    }

    public SavingsAccount(final String firstName,
                          final String lastName,
                          final String address,
                          final String serialNumber,
                          final int passcode,
                          final double balance,
                          final double initialTransactionLimit) {
        this(new Owner(firstName, lastName, address), serialNumber, passcode, balance, initialTransactionLimit);
    }

    public SavingsAccount(final String firstName,
                          final String lastName,
                          final String address,
                          final String serialNumber,
                          final int passcode,
                          final double balance) {
        this(firstName, lastName, address, serialNumber, passcode, balance, 1000);
    }

    public SavingsAccount(final Owner owner,
                          final String serialNumber,
                          final int passcode,
                          final double balance) {
        this(owner, serialNumber, passcode, balance, 1000);
    }

    @Override
    public double withdraw(final double amount) {
        if (numberOfTransactionsLeft == 0) {
            throw new IllegalStateException("Daily maximum od transactions reached.");
        }

        if (amount > this.currentTransactionLimit) {
            throw new IllegalStateException("Daily limit exceeded.");
        }

        if (super.getBalance() - amount < 0) {
            throw new IllegalStateException("Insufficient funds.");
        }

        currentTransactionLimit -= amount;
        numberOfTransactionsLeft--;
        setBalance(getBalance() - amount);

        return amount;
    }

    @Override
    public double deposit(final double amount) {
        if (numberOfTransactionsLeft == 0) {
            throw new IllegalStateException("Daily maximum od transactions reached.");
        }

        numberOfTransactionsLeft--;
        setBalance(getBalance() + amount);

        return amount;
    }

    @Override
    public void reset() {
        numberOfTransactionsLeft = 3;
        currentTransactionLimit = initialTransactionLimit;
    }

    @Override
    public String showAccountState() {
        return super.showAccountState() +
                "\nCurrent daily limit: " + currentTransactionLimit +
                ", number of available transactions: " + numberOfTransactionsLeft;
    }
}
