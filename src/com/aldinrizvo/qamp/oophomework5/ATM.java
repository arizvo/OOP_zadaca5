package com.aldinrizvo.qamp.oophomework5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ATM {
    private final List<Account> accountList;

    public ATM() {
        this.accountList = new ArrayList<>();
    }

    public void addAccount(final Account account) {
        if (!accountExists(account.getSerialNumber())) {
            this.accountList.add(account);
        } else {
            throw new IllegalStateException("Account serial number must be unique.");
        }
    }

    public void addAccounts(final List<Account> accountList) {
        for (final Account account : accountList) {
            this.addAccount(account);
        }
    }

    public double withdraw(final double amount, final String serialNumber, final int passcode) {
        return findAccount(serialNumber, passcode).withdraw(amount);
    }

    public double deposit(final double amount, final String serialNumber, final int passcode) {
        return findAccount(serialNumber, passcode).deposit(amount);
    }

    public void reset(final String serialNumber, final int passcode) {
        findAccount(serialNumber, passcode).reset();
    }

    public String showAccountState(final String serialNumber, final int passcode) {
        return findAccount(serialNumber, passcode).showAccountState();
    }

    private Account findAccount(final String serialNumber, final int passcode) {
        if (passcode < 1000 || passcode > 9999) {
            throw new IllegalArgumentException("Passcode is out of range.");
        }

        for (final Account account : this.accountList) {
            if (Objects.equals(account.getSerialNumber(), serialNumber)) {
                if (account.verifyPasscode(passcode)) {
                    return account;
                } else {
                    throw new IllegalStateException("Passcode is not correct.");
                }
            }
        }

        throw new IllegalStateException("Account not found.");
    }

    private boolean accountExists(final String serialNumber) {
        for (final Account account : this.accountList) {
            if (Objects.equals(account.getSerialNumber(), serialNumber)) {
                return true;
            }
        }

        return false;
    }
}
