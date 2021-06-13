// Savings Account child class
// has an interest rate
// a method to apply interest - profit 

public class SavingsAccount extends Account {
    private String accountName;
        private double interestedRate;
        public static final String TYPE = "Lokata";

    // interest rate
    private double interestRate;

    // default constructor
    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to intialize Savings account with a customer account
     * number and interest rate
     */
    public InvestmentAccount(String firstName, String lastName, String pesel, String accountNumber,
                             double saveMoney, String accountName, double interestedRate) {
        super(firstName, lastName, pesel, accountNumber, saveMoney);
        this.accountName = accountName;
        this.interestedRate = interestedRate;

    // getter function
    public String getAccountName() {
        return accountName;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calcInterest();
        System.out.printf("Oprocentowanie", interest);
        deposit(interest);
    }

    /**
     * Function to deposit funds into the account as long as the amount parameter is
     * > 0
     * 
     * Apply Transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public void deposit(double amount) {

        // First Check amount
        if (amount > 0) {
            balance += amount;
            System.out.printf("wpłacono %.2f", amount);
            System.out.printf("Stan konta: %.2f%n", balance);

        } else {
            System.out.println("Ujemna Kwota");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as 1. Amount to withdraw
     * must be > 0 2. Amount to withdraw must be <= balance
     * 
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount) {

        // Same check
        if (amount > 0) {
            // Check sufficient balance
            if ((amount) <= balance) {
                System.out.printf("Wyplacoono %.2f", amount);
                balance -= amount;
                System.out.printf("Stan konta: %.2f%n", balance);
            }
        } else {
            System.out.println("Ujemna Kwota");
        }
    }
}