# OOP_zadaca5

Write the class ATM.

The ATM contains an account register, represented with a list of Accounts.

ATM has mandatory methods:
- withdraw(double amount, String serialNumber, int passcode) - returns the withdrawn value

- deposit money(double amount, String serialNumber, int passcode) - returns the deposited value

- reset (String serialNumber, int passcode)

- showAccountState(String serialNumber, int passcode)

If an account with the provided serialNumber is not found throw an IllegalStateException, with the
respective message

If the provided passcode is outside the legal range of numbers (1000-9999) - throw an
IllegalArgumentException

If an account is found, but the passcode is not correct throw an IllegalStateException indicating
this in the message

Withdraw, deposit, reset and showAccountState - will interact with the accounts, explained below

Every account has following attributes:
owner - representing a class containing personal information of the account

serialNumber - String

passcode - int (1000-9999)

balance double - current balance of the account

There are two types of accounts: 
CurrentAccount:
- Does not have a transaction limit

- Has can have an unlimited number of transactions per day

- Can have a negative balance

Withdraw - withdraws the provided value from the balance, balance can be negative

Deposit - deposits the provided value to the balance

Reset - does nothing

Savings account:
- Has a transaction limit - provided by the constructor (or 1000 default) - maximum withdraw value

- Has a maximum of 3 transactions per day

- Can not have a negative balance

Withdraw - withdraws the provided value from the balance, if the balance would be negative or
the daily limit exceeded or the daily number of transactions exceeded an IllegalStateException will
be thrown having the proper message

Deposit - deposits the provided value to the balance - if the daily number of transactions is
exceeded it will throw an exception instead

Reset - resets the the daily limit to the constructor provided value (or 1000) and number of
transactions to 3

showAccountState() - returns a String containing:

- Owner information in the format: {firstName}, lastName, address 
- current balance:  
- current daily limit: {dailyLimit}, numberOfAvailableTransactions {transactionsLeft} (for
                                                                                     SavingAccounts only)

Owner:
First name String

Last name String

Address String

Has a constructor with all 3 attributes.

Main Class:
Write a main class to demonstrate the behaviour of ATM. The main method should handle
all the exceptions. Handling of exceptions should be done by simply printing the Exception
message.
——BONUS——:
Rewrite the Main class, such that it contains a fixed number of accounts.

Create a Scanner object which will receive user input.

Create an infinite loop which will repeatedly print the following: 
 
1 deposit

2 withdraw

3 reset

4 show account info

anythingElse = quit
You can assume that the input will always be an integer.
After 1-4 are chosen, the user will be prompted to insert SerialNumber, passcode and amount (in
case withdraw or deposit is chosen).

Assume the user input is always correct i.e. never a String for balance etc...
Implement proper Exception Handling for all the methods, and print the error messages returned
by the ATM.

The invoking of the respective methods based on user choice can be done either from the
Main.class or ATM.class, your choice. 
