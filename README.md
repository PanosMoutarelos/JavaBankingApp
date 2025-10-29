Features Implemented So Far

Create new accounts with:

Unique automatically assigned ID

Account holder name (letters only)

Initial balance (non-negative numbers only)

Deposit money into an account

Withdraw money from an account (checks for sufficient balance)

Check balance of a specific account

List all accounts stored in the system

Input validation:

Account holder name must only contain letters and spaces

Balance, deposit, and withdrawal amounts must be numbers and non-negative

Error handling for invalid input and invalid menu options

Classes

BankAccount – Represents a single bank account

Fields: id, accountHolder, balance

Methods: deposit(), withdraw(), displayBalance(), getId(), getAccountHolder(), getBalance()

BankData – Manages a collection of BankAccount objects

Add new accounts, find accounts by name, list all accounts

BankApp – Main program with a menu-driven console interface
