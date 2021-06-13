// Base clase
// Abstract
public abstract class Account {
    private String firstName;
    private String lastName;
    private String pesel;
    private String accountNumber;
    private double saveMoney;
    // account number
    private int accountNumber;

    // Balance
    protected double balance; 

    // Default constructor
    public Account() {

    }

    public Account(String firstName, String lastName, String pesel, String accountNumber, double saveMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getter methods
    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    // Abstract
    /**
     * Function to deposit funds into the account as long as
     * the amount parameter is > 0 
     * 
     * Apply Transaction fee for the CheckingAccount
     * 
     * @param amount value to be deposited
     */
    public abstract void deposit(double amount); 

    /**
     * Function to withdraw funds from the Account as long as
     *  1. Amount to withdraw must be > 0
     *  2. Amount to withdraw must be <= balance
     * 
     * @param amount value to be withdrawn
     */    
    public abstract void withdraw(double amount); 
}