package bankAccount;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount tester1 = new BankAccount();
        BankAccount tester2 = new BankAccount();
        System.out.println(tester1.totalMoney());
        System.out.println("tester1's checking balance is "+tester1.getCheckBalance());
        System.out.println("tester1's savings balance is "+tester1.getSavingsBalance());
        System.out.println("Activies about tester1");
        tester1.deposit(200, "savings");
        tester1.deposit(123, "checking");
        tester1.withdraw(50, "savings");
        System.out.println("Activies about tester2");
        tester2.deposit(100, "checking");
        tester2.deposit(152, "savings");
        tester2.withdraw(101, "checking");
        System.out.println("tester1's checking balance is "+tester1.getCheckBalance());
        System.out.println("tester1's savings balance is "+tester1.getSavingsBalance());
        System.out.println("tester2's checking balance is "+tester2.getCheckBalance());
        System.out.println("tester2's savings balance is "+tester2.getSavingsBalance());


        System.out.println(tester1.totalMoney());
        System.out.println(tester2.totalMoney());
        System.out.println("There are "+BankAccount.numOfAccount+" bank accounts that have been generated.");

    }
}
