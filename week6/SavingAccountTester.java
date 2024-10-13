class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    // constructor to initialize savingsBalance
    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    // method 1
    public void calculateMonthlyInterest() {
        double monthlyInterest = ((savingsBalance * annualInterestRate)/12);
        System.out.println("Monthly Interest is: " + monthlyInterest);
        savingsBalance+=monthlyInterest;
    }

    // method 2
    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }

    // method 3
    public double getSavingsBalance() {
        return savingsBalance;
    }
    
}

public class SavingAccountTester {
    public static void main(String[] args) {
        // array of three objects
        SavingsAccount[] accounts = { new SavingsAccount(4000.0),
                                      new SavingsAccount(1500.0),
                                      new SavingsAccount(2300.0)};
        
        SavingsAccount.modifyInterestRate(0.04); // Always use ClassName.method() to call a static method
        for (SavingsAccount account : accounts) {
            account.calculateMonthlyInterest();
            System.out.println("New Balance for 4% is: " + account.getSavingsBalance());
        }
        System.out.println(" ");
        SavingsAccount.modifyInterestRate(0.05);
        for (SavingsAccount account : accounts) {
            account.calculateMonthlyInterest();
            System.out.println("New Balance for 5% is: " + account.getSavingsBalance());
        }


    }
}

/*
 * Static methods (e.g., modifyInterestRate) are called using the class name: SavingsAccount.modifyInterestRate().
 * Instance methods (e.g., calculateMonthlyInterest) are called using an object (instance) of the class: accounts[0].calculateMonthlyInterest().
 */
