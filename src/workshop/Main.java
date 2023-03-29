package workshop;

import java.util.Scanner;

public class Main {

    // TO-DO TASK 3
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); 

        System.out.print("What is your name: ");
        BankAccount bankAccount = new BankAccount(input.next()); 

        do {
            System.out.println("");
            System.out.println("Hello " + bankAccount.getAccountName() + ", what would you like to do?");
            System.out.println("1. View account balance");
            System.out.println("2. View account history");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit bank");
            System.out.print("> ");

            switch (input.nextInt()) { 
                case 1: 
                    System.out.println(bankAccount.getAccountBalance());
                    break;
                case 2:
                    if (bankAccount.getTransactions().isEmpty()) {
                        System.out.println("You have no past transactions");
                    } else {
                        for (String transaction : bankAccount.getTransactions()) {
                            System.out.println(transaction);
                        }
                    }
                    break; 
                case 3:
                    bankAccount.deposit();
                    break;
                case 4:
                    bankAccount.withdraw();
                    break; 
                case 5:
                    input.close();
                    System.out.println("Adios, see you next time"); 
                    return; 
                default:
                    System.out.println("You have entered an invalid number");
            }  
        } while (true);
    }
}
