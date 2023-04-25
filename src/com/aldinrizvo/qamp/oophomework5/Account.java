package com.aldinrizvo.qamp.oophomework5;

public abstract class Account {
    private final Owner owner;
    private final String serialNumber;
    private final int passcode;
    private double balance;

    protected Account(final String firstName,
                      final String lastName,
                      final String address,
                      final String serialNumber,
                      final int passcode,
                      final double balance) {
        this(new Owner(firstName, lastName, address), serialNumber, passcode, balance);
    }

    protected Account(final Owner owner,
                      final String serialNumber,
                      final int passcode,
                      final double balance) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalStateException("Passcode must be between 1000 and 9999.");
        }

        this.owner = owner;
        this.serialNumber = serialNumber;
        this.passcode = passcode;
        this.balance = balance;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(final double balance) {
        this.balance = balance;
    }

    public abstract double withdraw(final double amount);

    public abstract double deposit(final double amount);

    public abstract void reset();

    public String showAccountState() {
        return "Owner: " + owner + "\nCurrent balance: " + balance;
    }

    public boolean verifyPasscode(final int passcode) {
        return this.passcode == passcode;
    }
}
