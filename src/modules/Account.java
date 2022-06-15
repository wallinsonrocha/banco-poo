package modules;

import interfaces.IntfAccount;

import java.util.Objects;

public class Account implements IntfAccount {

    // Atributos
    private static final int DEFAULT_AGENCY = 1;
    private static int NUMBER = 1;

    protected int accountAgency;
    protected int accountNumber;
    protected double balance;
    protected Client client;

    // Constructor
    public Account(Client client) {
        this.client = client;
        accountAgency = DEFAULT_AGENCY;
        accountNumber = NUMBER;
        NUMBER++;
    }

    // Método
    protected void printInfos() {
        System.out.println(String.format("Name: %s", this.client.getName()));
        System.out.println(String.format("Agency: %d", this.accountAgency));
        System.out.println(String.format("Number: %d", this.accountNumber));
        System.out.println(String.format("Balance: %.2f", this.balance));
        System.out.println();
    }

    public String getClient() {
        return client.getName();
    }

    // Interface
    @Override
    public void withdraw(double value) {
        if(value <= balance){
            balance -= value;
            System.out.println("Success!");
            System.out.println();
        } else{
            System.out.println("Insufficient balance!");
            System.out.println();
        }
    }

    @Override
    public void deposit(double value) {
        balance += value;
        System.out.println("Success!");
        System.out.println();
    }

    @Override
    public void transfer(double value, IntfAccount destiny) {
        if(value <= balance){
            this.withdraw(value);
            destiny.deposit(value);
        } else{
            System.out.println("Insufficient balance!");
            System.out.println();
        }
    }

    @Override
    public void printExtract() {}

    // Equals e HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountAgency == account.accountAgency && accountNumber == account.accountNumber && Double.compare(account.balance, balance) == 0 && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountAgency, accountNumber, balance, client);
    }
}
