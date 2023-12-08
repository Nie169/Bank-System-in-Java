package BankAccountSystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class BankAccount implements Methods{
	  
    private long accountNumber;
    private String firstName, middleName, lastName, address, emailAddress;
    private double balance;

    // Constructor
    public BankAccount(long accountNumber, String firstName, String middleName, String lastName, String address, String emailAddress) {
    	this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.balance = 0;
    }
    
    //Overloading Constructor
    public BankAccount() {
    	this.accountNumber = 0;
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.address = "N/A";
        this.emailAddress = "N/A";
        this.balance = 0;
    }
    
    // Encapsulation
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public double getBalance() {
        return balance;
    }

    @Override // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            saveTransaction("Deposit", amount);
            System.out.println("\n------------------------------------------");
            System.out.println("Deposit successful. New balance: Php" + balance);
            System.out.println("------------------------------------------\n");
        } else {
            System.out.println("\nInvalid deposit amount.\n");
        }
    }

    @Override // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {
            balance -= amount;
            saveTransaction("Withdraw", amount);
            System.out.println("\n--------------------------------------------");
            System.out.println("Withdrawal successful. New balance: Php" + balance);
            System.out.println("--------------------------------------------\n");
        } else {
            System.out.println("\nInvalid withdrawal amount or insufficient balance.");
            System.out.println("Your Balance is " + balance + "Php " + ", Maintaining Balance of 500Php.\n");
        }
    }

    @Override // Balance Inquiry method
    public void balanceInquiry() {
    	System.out.println("\n--------------------------");
        System.out.println("Account balance: Pph" + balance);
        System.out.println("--------------------------\n");
        
    }

    @Override // Account Summary method
    public void accountSummary() {
        System.out.println("\n#----------ACCOUNT SUMMARY----------#");
        System.out.println("ACCOUNT NUMBER: " + accountNumber);
        System.out.println("NAME: " + getFullName());
        System.out.println("ADDRESS: " + address);
        System.out.println("EMAIL ADDRESS: " + emailAddress);
        System.out.println("ACCOUNT BALANCE: Php" + balance);
        System.out.println("#----------ACCOUNT SUMMARY----------#\n");
    }

    @Override // Save transaction details to file
    public void saveTransaction(String transactionType, double amount) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Niel\\Desktop\\CSC104 Final Project\\BankClientDetails.txt", true))) {
        	writer.println("\n#------------ACCOUNT SUMMARY------------#");
        	writer.println("TRANSACTION TYPE  : " + transactionType);
        	writer.println("AMOUNT            : " + amount);
            writer.println("ACCOUNT NUMBER    : " + accountNumber);
            writer.println("FULL NAME         : " + getFullName());
            writer.println("ADDRESS           : " + address);
            writer.println("EMAIL ADDRESS     : " + emailAddress);
            writer.println("ACCOUNT BALANCE   : Php" + balance);
            writer.println("#------------ACCOUNT SUMMARY------------#\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
	public void saveAccountToFile(BankAccount account) {
        try (PrintWriter writer = new PrintWriter(new FileWriter
        		("C:\\Users\\Niel\\Desktop\\CSC104 Final Project\\BankClientDetails.txt", true))) {
            writer.println("\n#------------ACCOUNT SUMMARY------------#");
            writer.println("ACCOUNT NUMBER    : " + account.getAccountNumber());
            writer.println("FULL NAME         : " + account.getFullName());
            writer.println("ADDRESS           : " + account.getAddress());
            writer.println("EMAIL ADDRESS     : " + account.getEmailAddress());
            writer.println("ACCOUNT BALANCE   : PHP " + account.getBalance());
            writer.println("#------------ACCOUNT SUMMARY------------#\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean containsNumbers(String input) {
		return false;
	}

	@Override
	public boolean isValidNumber(long accountNumber) {
		return false;
	}

	@Override
	public void animateMessage(String message) {
		
	}
}