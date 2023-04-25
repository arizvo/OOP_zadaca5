package com.aldinrizvo.qamp.oophomework5;

public class CurrentAccount extends Account {
    public CurrentAccount(final Owner owner,
                          final String serialNumber,
                          final int passcode,
                          final double balance) {
        super(owner, serialNumber, passcode, balance);
    }

    public CurrentAccount(final String firstName,
                          final String lastName,
                          final String address,
                          final String serialNumber,
                          final int passcode,
                          final double balance) {
        this(new Owner(firstName, lastName, address), serialNumber, passcode, balance);
    }

    @Override
    public double withdraw(final double amount) {
        setBalance(getBalance() - amount);

        return amount;
    }

    @Override
    public double deposit(final double amount) {
        setBalance(getBalance() + amount);

        return amount;
    }

    @Override
    public void reset() {
        // Nothing to reset for a current account.
    }
}
