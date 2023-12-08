package BankAccountSystem;

public interface Methods {
	
	public void deposit(double amount);
	public void withdraw(double amount);
	public void balanceInquiry();
	public void accountSummary();
	public void saveTransaction(String transactionType, double amount);
	public void saveAccountToFile(BankAccount account);
	public boolean containsNumbers(String input);
	public boolean isValidNumber(long accountNumber);
	public void animateMessage(String message);
}
