package bankAccount;

public class BankAccount {
   
    public static int numOfAccount = 0;
    public static double totalAmountOfMoney =  0;
    private double checkingBalance=0;
    private double savingsBalance=0;
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        numOfAccount++;
    }

    //getter
    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public double getCheckBalance() {
        return this.checkingBalance;
    }
    //deposit
    public void deposit(double moneyToDeposit, String accountType) {
        if (accountType.equals("savings")) {
            System.out.println("deposit "+ moneyToDeposit + "  to savings account");
            savingsBalance += moneyToDeposit;
        }
        if (accountType.equals("checking")) {
            System.out.println("deposit "+ moneyToDeposit + "  to checking account");
            checkingBalance += moneyToDeposit;
        }
        totalAmountOfMoney += moneyToDeposit;

    }

    //withdraw
    public void withdraw(double moneyToWithdraw, String accountType) {
        //this boolean setting I learned from the solution on platform.
        boolean successful = false;
        if (accountType.equals("savings")) {
            if (moneyToWithdraw <= savingsBalance) {
            System.out.println("Withdraw money "+moneyToWithdraw+ " from savings account");
            successful = true;
            savingsBalance -= moneyToWithdraw;
        } else {
            System.out.println("Savings balance is not enough to finish this withdrawal.");
        }
    }
        
        if (accountType.equals("checking")) { 
            if (moneyToWithdraw <= checkingBalance) {
            System.out.println("Withdraw money "+moneyToWithdraw+ " from checking account");
            successful = true;
            checkingBalance -= moneyToWithdraw;
        } else {
            System.out.println("Checking balance is not enough to finish this withdrawal.");
        }
    }   if (successful){
        totalAmountOfMoney -= moneyToWithdraw;
    }
    }

    // public double totalMoney() {
    //     System.out.println("Total money from both checking and savings account is ");
    //     return totalAmountOfMoney;
    // }
}
