import java.util.Scanner;

public class AccountDriver {
    
    // Entry point of program
    public static void main(String [] args) {

        Scanner keyboard = new Scanner(System.in);
        
        // Create array of Accounts
        Account accounts [] = new Account[10];
        int numAccounts = 0; 

        int choice;

        do {
            choice = menu(keyboard);
            System.out.println();
            
            if(choice == 1) {
                accounts[numAccounts++] = createAccount(keyboard);
            } else if(choice == 2) {
                doDeposit(accounts, numAccounts, keyboard);
            } else if(choice == 3) {
                doWithdraw(accounts, numAccounts, keyboard);
            } else if(choice == 4) {
                applyInterest(accounts, numAccounts, keyboard);
            } else {
                System.out.println("Zegnam");
            }
            System.out.println();
        } while(choice != 5);
    }

    /**
     * Account choice
     * 
     * @param keyboard 
     * @return choice
     */
    public static int accountMenu(Scanner keyboard) {
        System.out.println("Wybierz Konto");
        System.out.println("1. Sprawdz Konto");
        System.out.println("2. Konto Oszczednosciowe");

        int choice;
        do {
            System.out.print("Twoj Wybór: ");
            choice = keyboard.nextInt();
        }while(choice < 1 || choice > 2);
        
        return choice;
    } 

    public static int searchAccount(Account accounts [], int count, int accountNumber) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getAccountNumber() == accountNumber) {
                return i;
            }
        }

        return -1; 
    }

    /**
     * Function to perform Deposit on a selected account
     */
    public static void doDeposit(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nWpisz numer konta: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Kwota do wpłaty: ");
            double amount = keyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("Brak konta: " + accountNumber);
        }
    }

    public static void doWithdraw(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nWpisz numer Konta: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Kwota wyplaty: ");
            double amount = keyboard.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("Brak konta: " + accountNumber);
        }
    }

    public static void applyInterest(Account accounts [], int count, Scanner keyboard) {
        // Get the account number
        System.out.print("\nWpisz numer konta: ");
        int accountNumber = keyboard.nextInt();

        // search for account
        int index = searchAccount(accounts, count, accountNumber);

        if(index >= 0) {
            
            // must be instance of savings account
            if(accounts[index] instanceof SavingsAccount) {
                ((SavingsAccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("Brak konta: " + accountNumber);
        }
    }

    /**
     * Function to create a new Account
     */
    public static Account createAccount(Scanner keyboard) {

        Account account = null; 
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Wpisz numer konta: ");
        accountNumber = keyboard.nextInt();

        if(choice == 1)  { // chekcing account;
 
        } else { // Savings account
            
            System.out.print("Please enter Interest Rate: ");
            double ir = keyboard.nextDouble();
            account = new SavingsAccount(accountNumber, ir);
        }
        return account;
    }

    /**
     * Menu to display options and get the user's selection
     * 
     * @param keyboard
     * @return choice
     */
    public static int menu(Scanner keyboard) {
        System.out.println("Bank Menu");
        System.out.println("1. Stworz nowe konto ");
        System.out.println("2. Wplata");
        System.out.println("3. Wyplata");
        System.out.println("4. Apply Interest");
        System.out.println("5. EXIT");

        int choice;

        do {
            System.out.print("Wybierz cyfre: ");
            choice = keyboard.nextInt();
        } while(choice < 1 || choice > 5);

        return choice;
    }    
}
