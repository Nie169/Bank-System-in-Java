package BankAccountSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		 ArrayList<BankAccount> accounts = new ArrayList<>();

	     while (true) {
	        Validation displayMenu = new Validation();
	        displayMenu.menu();
	        
			int choice;
		    System.out.print("Select your choice: ");
		    while (!scan.hasNextInt()) {
		        System.err.println("\n----------------------------");
		        System.err.println("Error!! Please try again. ");
		        System.err.println("Please Enter a valid number. ");
			    System.err.println("----------------------------");
			    System.out.print("\nSelect your choice: ");
		        scan.next();
		   }
		    choice = scan.nextInt();
		    
		    switch (choice) {
	        case 1:
	        	Validation validate = new Validation();
	        	Validation message = new Validation();
	            System.out.println("\n\t--------------------------");
	            message.animateMessage("\t  Creating an Account....\n\t  It's quick and easy.\n");
	    		System.out.println("\t--------------------------");
	    				
	            try {
	                long accountNumber;
	                while(true) {  
	                	System.out.print("\nEnter account number: ");  
	                	accountNumber = scan.nextLong();
	                    if (!validate.isValidNumber(accountNumber)) {
	                    	System.err.println("\nError: Account Number should be a unique 10-digit number.");
	                    } 
	                    else {
	                    	break;
	                    }
	                }
	                
	                String firstName;
                    while(true) {
                    	System.out.print("Enter first name: ");
                    	firstName = scan.next();
                    	if(validate.containsNumbers(firstName)) {
                    		System.err.println("\nError: Please Enter valid first name.\n");
                    	} else {
                    		break;
                    	}
                    }
                    scan.nextLine();		       
	                       
                    String middleName;
                    while(true) {
                    	System.out.print("Enter middle name: ");
                    	middleName = scan.next();
                    	if(validate.containsNumbers(middleName)) {
                    		System.err.println("\nError: Please Enter valid middle name.\n");
                    	} else {
                    		break;
                    	}
                    }	
            		scan.nextLine();
	                        
            		String lastName;
                    while(true) {
                    	System.out.print("Enter last name: ");
                    	lastName = scan.next();
                    	if(validate.containsNumbers(lastName)) {
                    		System.err.println("\nError: Please Enter valid last name.\n");
                    	} else {
                    		break;
                    	}
                    }		
	                		
                    System.out.print("Enter address: "); //accept string, number and symbol
            		String address = scan.next();
            		
            		String emailAddress;
            		while(true) {
            			System.out.print("Enter email address: ");
            			emailAddress = scan.next();
            			if(!emailAddress.contains("@")) {
            				System.err.print("\nError: Please include @ for email.\n");
            			} else {
            				break;
            			}
            		}    
            		
            		BankAccount newAccount = new BankAccount(accountNumber, firstName, middleName, lastName, address, emailAddress);
            		accounts.add(newAccount);
            		System.out.println("\n\t-----------------------------");
            		System.out.println("\tAccount created successfully.");
            		System.out.println("\tAccount number: " + newAccount.getAccountNumber());
            		System.out.println("\t-----------------------------\n");
            		
            		Validation saveAccount = new Validation();
            		saveAccount.saveAccountToFile(newAccount);

	            } 
	            catch (Exception InputMismatchException) {
	            	System.err.println("\nError: Please enter valid number.\n");
	            }
	                	
	            break;
	            	
	        case 2:
            	try {
            		System.out.print("\nEnter account number to search: ");
                    long depositAccountNumber = scan.nextLong();	            

                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == depositAccountNumber) {
                        	System.out.print("Enter deposit amount: ");
		                    double depositAmount = scan.nextDouble();
                            account.deposit(depositAmount);
                            break;
                        }
                        else {
                        	System.err.println("\nError: Bank Number does not march.\n");
                        }
                    }
            	} catch(Exception InputMismatchException) {
            		System.out.println("\nError: Please Enter valid account number.\n");
            	} 
            	break;

	        case 3:
            	try {
            		System.out.print("\nEnter account number to search: ");
            		long withdrawAccountNumber = scan.nextLong();

            		for (BankAccount account : accounts) {
            			if (account.getAccountNumber() == withdrawAccountNumber) {
            				System.out.print("Enter withdrawal amount: ");
	                		double withdrawAmount = scan.nextDouble();
            				account.withdraw(withdrawAmount);
            				break;
            			}
            			else {
                        	System.err.println("\nError: Bank Number does not march.\n");
                        }
            		}
            	} catch(Exception InputMismatchException) {
            		System.out.println("\nError: Please Enter valid account number.\n");
            	} 
                break;        
	        		
	        case 4:
            	try {
            		System.out.print("\nEnter account number to search: ");
                    long balanceInquiryAccountNumber = scan.nextLong();

                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == balanceInquiryAccountNumber) {
                            account.balanceInquiry();
                            break;
                        }
                        else {
                        	System.err.println("\nError: Bank Number does not march.\n");
                        }
                    }
            	} catch(Exception InputMismatchException) {
            		System.out.println("\nError: Please Enter valid account number.\n");
            	} 
                break;
	                
	        case 5:
            	try {
            		System.out.print("\nEnter account number to search: ");
                    long accountSummaryAccountNumber = scan.nextLong();

                    for (BankAccount account : accounts) {
                        if (account.getAccountNumber() == accountSummaryAccountNumber) {
                            account.accountSummary();
                            break;
                        }
                        else {
                        	System.err.println("\nError: Bank Number does not march.\n");
                        }
                    }
            	} catch(Exception InputMismatchException) {
            		System.out.println("\nError: Please Enter valid account number.\n");
            	} 
                break;
	                
	        case 6:
	        	System.out.print("\nDo you want to exit? (y/n): ");
	            String exit = scan.next();

	            if (exit.equalsIgnoreCase("y")) {
	                System.out.println("\n\tExit successfully. Thank you!");
	                scan.close();
	                System.exit(0);
	            } else if (exit.equalsIgnoreCase("n")) {
	            	Validation exitMessage = new Validation();
	            	exitMessage.animateMessage("\nReturning to the main menu...\n");
	            } else {
	                System.err.println("\nInvalid choice. Please enter 'y' to exit or 'n' to continue.\n");
	            }
	            break;

	        default:
                System.err.println("\nInvalid choice. Please enter a valid option.\n");
	        }
	     }
	}
}