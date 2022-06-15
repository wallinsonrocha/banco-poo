import modules.Account;
import modules.Client;
import modules.CurrentAccount;
import modules.SavingsAccount;

import java.io.IOError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        // Scan
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        boolean c = true;
        Account someone = null;

        // Clientes
        Client carlos = new Client("Carlos");
        Client maria = new Client("Maria");
        Client pedro = new Client("Pedro");
        Client sarah = new Client("Sarah");

        // Contas
        Account carlosCA = new CurrentAccount(carlos);
        Account mariaCA = new CurrentAccount(maria);
        Account pedroSA = new SavingsAccount(pedro);
        Account sarahSA = new SavingsAccount(sarah);

        // Lista
        List<Account> accounts = new ArrayList<>();
        accounts.add(carlosCA);
        accounts.add(mariaCA);
        accounts.add(pedroSA);
        accounts.add(sarahSA);

        System.out.println("=== Choose a number ===");
        System.out.println("1 - Carlos");
        System.out.println("2 - Maria");
        System.out.println("3 - Pedro");
        System.out.println("4 - Sarah");

        n = sc.nextInt();

        switch (n){
            case 1:
                someone = carlosCA;
                break;
            case 2:
                someone = mariaCA;
                break;
            case 3:
                someone = pedroSA;
                break;
            case 4:
                someone = sarahSA;
                break;
            default:
                System.out.println("Choose a valid opition!");
                return;
        }

        do{
            System.out.println("=== Choose a option: ===");
            System.out.println("1 - Account extract");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Transfer");
            System.out.println("5 - End");

            n = sc.nextInt();

            switch (n){
                case 1:
                    someone.printExtract();
                    break;

                case 2:
                    System.out.print("Digit the value: ");
                    double dValue = sc.nextDouble();
                    someone.deposit(dValue);
                    break;

                case 3:
                    System.out.print("Digit the value: ");
                    double wValue = sc.nextDouble();
                    someone.withdraw(wValue);
                    break;

                case 4:
                    Account tAcc = null;
                    List<Account> lTransAcc = new ArrayList<>();

                    System.out.print("Digit the value: ");
                    double tValue = sc.nextDouble();

                    System.out.println("=== Choose to who want to transfer ===");

                    for(int i = 0; i < accounts.size(); i++){
                        if(!(someone.equals(accounts.get(i)))){
                            lTransAcc.add(accounts.get(i));
                            System.out.println(lTransAcc.indexOf(lTransAcc.get(i)) +
                                    " - " + lTransAcc.get(i).getClient());
                        }
                    }

                    m = sc.nextInt();

                    switch (m){
                        case 0:
                            someone.transfer(tValue, lTransAcc.get(0));
                            break;
                        case 1:
                            someone.transfer(tValue, lTransAcc.get(1));
                            break;
                        case 2:
                            someone.transfer(tValue, lTransAcc.get(2));
                            break;
                    }
                    break;

                case 5:
                    c = false;
                    break;

                default:
                    System.out.println("Choose a valid opition!");
                    return;
            }
        } while (c == true);
    }
}
