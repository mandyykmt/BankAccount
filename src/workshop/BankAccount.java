package workshop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class BankAccount {

    Scanner input = new Scanner(System.in); 

    private final String accountName;
    private final String accountNumber = UUID.randomUUID().toString().substring(0, 8);
    private float accountBalance;
    private List<String> transactions = new ArrayList<>();
    private boolean isClosed = false;
    private LocalDateTime dateCreated;
    private LocalDateTime dateClosed;

    // used "name" instead of "accountName" to show link between parameters and variables, see also "initialAccountBalance"
    public BankAccount(String name) { 
        this.accountName = name; 
        this.accountBalance = 0;
    }

    public BankAccount(String name, float initialAccountBalance) { 
        this.accountName = name; 
        this.accountBalance = initialAccountBalance;
    }

    public String getAccountName() {
        return accountName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public float getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }
    public LocalDateTime getDateClosed() {
        return dateClosed;
    }
    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }

    public void deposit() {
        
        try {
            System.out.print("How much would you like to deposit: ");
            float depositAmount = input.nextFloat(); 
            if (depositAmount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be more than 0"); 
            } 

            LocalDateTime depositTime = LocalDateTime.now(); 
            String transaction = "Deposit $" + depositAmount + " on " + depositTime; 
            
            transactions.add(transaction); 
            accountBalance += depositAmount; 
            System.out.println("You have deposited $" + depositAmount + " at " + depositTime);
            
        } catch(IllegalArgumentException e) {
            System.out.println("Error, please enter a value more than 0");
        }
    }

    public void withdraw() {

        try {
            System.out.print("How much would you like to withdraw: ");
            float withdrawAmount = input.nextFloat(); 
            if (withdrawAmount <= 0) {
                throw new IllegalArgumentException("Withdraw amount must be more than 0");
            }

            if (accountBalance < withdrawAmount) {
                throw new IllegalArgumentException("Bank account has insufficient funds");
            }

            LocalDateTime withdrawTime = LocalDateTime.now(); 
            String transaction = "Withdraw $" + withdrawAmount + " on " + withdrawTime; 
            
            transactions.add(transaction); 
            accountBalance -= withdrawAmount; 
            System.out.println("You have withdrawn $" + withdrawAmount + " at " + withdrawTime);

        } catch(IllegalArgumentException e) {
            System.out.println("Error, invalid withdrawal amount");
            System.out.println(""); // how to print different messages since it cannot reach the variables inside the method
        }
    }
}