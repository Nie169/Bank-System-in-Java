package BankAccountSystem;

public class Validation extends BankAccount implements Methods{

//	public Validation() {
//		//empty constructor
//	}

	//check if a string contains any numeric characters
    public boolean containsNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false; 
    }
    
    public boolean isValidNumber(long accountNumber) {
        String accountNumberString = String.valueOf(accountNumber);
        return accountNumberString.length() == 10;
    }
    
    //source code chatGPT hehe
    public void animateMessage(String message) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                // Adjust the sleep duration based on your preference
                Thread.sleep(15); // 50 milliseconds pause between characters
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void menu() {
    	System.out.println("----------------------------");
		System.out.println("  ➡️  [1] New Accout");
		System.out.println("  ➡️  [2] Deposit");
		System.out.println("  ➡️  [3] Withdraw");
		System.out.println("  ➡️  [4] Balance Inquiry");
		System.out.println("  ➡️  [5] Account Summary");
		System.out.println("  ➡️  [6] Exit");
		System.out.println("----------------------------");
		System.out.println("Choice Options:[1/2/3/4/5/6]");
		System.out.println("----------------------------");
    }
    
}
