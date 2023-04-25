package com.aldinrizvo.qamp.oophomework5;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final Owner aldin = new Owner("Aldin", "Rizvo", "Trg Heroja");
        final Owner hana = new Owner("Hana", "Bezdrob", "Paromlinska");

        try {
            final Account hanasAccount = new CurrentAccount(hana, "1", 1111, 5000);
            final Account aldinsAccount = new SavingsAccount(
                    aldin,
                    "2",
                    2222,
                    10000,
                    3000
            );

            final List<Account> listOfAccounts = new LinkedList<>();

            listOfAccounts.add(hanasAccount);
            listOfAccounts.add(aldinsAccount);

            final ATM bankomat = new ATM();
            bankomat.addAccounts(listOfAccounts);

            System.out.println("Initial account state: ");
            System.out.println(bankomat.showAccountState("1", 1111));
            System.out.println();
            System.out.println(bankomat.showAccountState("2", 2222));
            System.out.println();

            bankomat.deposit(200, "2", 2222);
            System.out.println("State of savings account after deposit: ");
            System.out.println(bankomat.showAccountState("2", 2222));
            System.out.println();

            bankomat.withdraw(1000, "1", 1111);
            bankomat.withdraw(1200, "2", 2222);
            System.out.println("State of both accounts after withdrawal: ");
            System.out.println(bankomat.showAccountState("2", 2222));
            System.out.println(bankomat.showAccountState("1", 1111));
            System.out.println();

            bankomat.reset("1", 1111);
            bankomat.reset("2", 2222);
            System.out.println("State of current account after reset: ");
            System.out.println(bankomat.showAccountState("1", 1111));
            System.out.println();
            System.out.println(bankomat.showAccountState("2", 2222));
            System.out.println();

            final Account hanasNewAccount = new CurrentAccount(hana, "1", 1111, 100);
            bankomat.addAccount(hanasNewAccount); // Should throw an exception due to non-unique serial number.
            System.out.println(hanasNewAccount); // Should not get here.
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
