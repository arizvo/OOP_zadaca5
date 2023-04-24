package com.aldinrizvo.qamp.oophomework5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BonusMain {
    public static void main(String[] args) {
        final Owner dinoMerlin = new Owner("Edin", "Dervishalidovic", "Alifakovac");
        final Owner hariMataHari = new Owner("Hajrudin", "Varesanovic", "Vratnik");
        final Owner halidBeslic = new Owner ("Halid", "Beslic", "Vrapci village");
        final Owner kemalMonteno = new Owner("Kemal", "Monteno", "Staka Skenderova");

        final Account dinosAccount = new CurrentAccount(dinoMerlin, "1", 1111, 1000);
        final Account harisAccount = new CurrentAccount(hariMataHari, "2", 2222, 2000);
        final Account halidsAccount = new SavingsAccount(
                halidBeslic,
                "3",
                3333,
                3000,
                2000
        );
        final Account kemalsAccount = new SavingsAccount(
                kemalMonteno,
                "4",
                4444,
                4000,
                2500
        );
        final Account sejosAccount = new SavingsAccount(
                "Davor",
                "Sucic",
                "Mejtas",
                "5",
                5555,
                5000,
                1000
        );

        final List<Account> accountList = new ArrayList<>();

        accountList.add(dinosAccount);
        accountList.add(harisAccount);
        accountList.add(halidsAccount);
        accountList.add(kemalsAccount);

        final ATM bankomat = new ATM();

        bankomat.addAccounts(accountList);
        bankomat.addAccount(sejosAccount);

        final Scanner scanner = new Scanner(System.in);

        for(;;) {
            System.out.println("Please choose one of the following options: ");
            System.out.println("1 - deposit");
            System.out.println("2 - withdraw");
            System.out.println("3 - reset");
            System.out.println("4 - show account info");
            System.out.println("Selecting a value not defined above will lead to the cancellation of your request.");

            final int option = scanner.nextInt();
            scanner.nextLine(); // Get the redundant newline left in the buffer

            if (option < 1 || option > 4) {
                break;
            }

            final String serialNumber;
            final int passcode;
            System.out.println("Enter the account's serial number: ");
            serialNumber = scanner.nextLine();
            System.out.println("Enter the account's passcode: ");
            passcode = scanner.nextInt();

            double amount = 0;
            if (1 == option || 2 == option) {
                System.out.println("Enter the amount of funds: ");
                amount = scanner.nextDouble();
            }

            try {
                switch (option) {
                    case 1:
                        bankomat.deposit(amount, serialNumber, passcode);
                        break;
                    case 2:
                        bankomat.withdraw(amount, serialNumber, passcode);
                        break;
                    case 3:
                        bankomat.reset(serialNumber, passcode);
                        break;
                    case 4:
                        System.out.println(bankomat.showAccountState(serialNumber, passcode));
                        break;
                    default:
                        // It's not possible to get here due to previous checks.
                }

                System.out.println("Option " + option + " successfully completed.\n");
            } catch (final IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
