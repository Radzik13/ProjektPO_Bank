// Checking Account
public class CheckingAccount extends Account {


    // default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to intialize CheckingAccount
     * with a custom Account Number and a Customer Transaction
     * Fee. 
     */
    public CheckingAccount(int accountNumber) {
        super(accountNumber);

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
        if( amount > 0) {
            balance += amount;
            System.out.printf("Kwota wplaty", amount);


            System.out.printf("Stan Konta", balance);
            
        } else {
            System.out.println("Ujemny stan konta ");
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
        if(amount > 0) {
            // Check sufficient balance
            if((amount) <= balance) {

                System.out.printf("Kwota Wypłaty", amount);
                balance -= amount;
    
                System.out.printf("Stan konta: ", balance);
            }
        } else {
            System.out.println("Ujemny stan konta");
        }
    }
}