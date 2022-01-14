public class Bank extends User {
    private double checkingAcc;
    private double savingAcc;

    /**
     * Bank constructor creates new User object and sets balances to 0
     */
    public Bank(String name, int age) {
        new User(name, age);
        checkingAcc = 0;
        savingAcc = 0;
    }
    /**
     * Getters and setters
     */
    public void setCheckingAcc(double newAmnt) {
        this.checkingAcc = newAmnt;
    }
    public String getCheckingAcc() {
        return String.format("Your checking account balance is $%,.2f", this.checkingAcc);
    }
    public void setSavingAcc(double newAmnt) {
        this.savingAcc = newAmnt;
    }
    public String getSavingAcc() {
        return String.format("Your savings account balance is $%,.2f", this.savingAcc);
    }
    /**
     * View and alter balance of checking account
     */
    public void checkingDeposit(double amount) {
        this.checkingAcc += amount;
        System.out.printf("\nChecking account balance has been updates: $%,.2f", this.checkingAcc);
    }

    public void checkingWithdraw(double amount) {
        // If you try to withdraw more than is the account, give an error
        if (amount > this.checkingAcc)
            System.out.printf("\nInsufficient funds. Checking balance available: $%,.2f", this.checkingAcc);
        else
            this.checkingAcc -= amount;
    }

    /**
     * View and alter balance of savings account
      */
    public void savingsDeposit(double amount) {
        this.savingAcc += amount;
        System.out.printf("\nSavings account balance has been updates: $%,.2f", this.savingAcc);
    }

    public void savingWithdraw(double amount) {
        // If you try to withdraw more than is the account, give an error
        if (amount > this.savingAcc)
            System.out.printf("\nInsufficient funds. Savings account balance available: $%,.2f", this.savingAcc);
        else
            this.savingAcc -= amount;
    }

    /**
     * To move money from one account to another
     */
    public void moveToChecking(double amount) {
        if (amount <= this.savingAcc) {
            this.savingAcc -= amount;
            this.checkingAcc += amount;
        } else { System.out.printf("\nInsufficient funds. Savings account balance available: $%,.2f", this.savingAcc); }
    }

    public void moveToSavings(double amount) {
        if (amount <= this.checkingAcc) {
            this.checkingAcc -= amount;
            this.savingAcc += amount;
        } else { System.out.printf("\nInsufficient funds. Checking account balance available: $%,.2f", this.checkingAcc); }
    }
}
