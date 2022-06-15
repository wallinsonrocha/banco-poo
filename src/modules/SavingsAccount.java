package modules;

public class SavingsAccount extends Account{
    public SavingsAccount(Client client){
        super(client);
    }

    @Override
    public void printExtract() {
        System.out.println("=== Saving Account Statements ===");
        super.printInfos();
    }
}
