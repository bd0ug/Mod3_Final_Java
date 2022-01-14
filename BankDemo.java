import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        String name, yesOrNo;
        int age = 0, withdrawOrDeposit = 0, checkOrSave;
        double amount, checkingBalance = 0, savingsBalance = 0;

        // New menu object to access menu methods
        Menu menu = new Menu();


        // Collect information from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
       name = in.nextLine();
        System.out.print("Enter age: ");
        try { age = in.nextInt(); } // If user doesn't enter an integer, then the program will end
        catch (Exception e) { menu.invalid(); }

        // Creation of new Bank object
        Bank acc = new Bank(name, age);

        // Collect amount of money user has, must enter valid number equal to or greater than 0
        System.out.print("How much is in your checking account? ");
        while (checkingBalance == 0) {
            checkingBalance = menu.validNumber();
        }
        System.out.print("How much is in your savings account? ");
        while (savingsBalance == 0) {
            savingsBalance = menu.validNumber();
        }


        // Set balance and savings values
        acc.setCheckingAcc(checkingBalance);
        acc.setSavingAcc(savingsBalance);

        do {
            menu.Menu1();
            checkOrSave = menu.checkInput();

            if (checkOrSave == 1 || checkOrSave == 2) {         // if user enters number that corresponds to menu
                menu.Menu2();
                withdrawOrDeposit = menu.checkInput();
            }
            else if (checkOrSave == 3 ) {                       // user wants to see balances
                System.out.println();
                System.out.println(acc.getCheckingAcc());
                System.out.println(acc.getSavingAcc());
            }
            else { menu.invalid(); }                             // Program will end due to incorrect input

            // If user chooses 1 for the checking account...
            if (checkOrSave == 1) {          // User wants to withdraw
                if (withdrawOrDeposit == 1) {
                    System.out.println(acc.getCheckingAcc());
                    System.out.print("How much would you like to withdraw? ");
                    amount = menu.validNumber();
                    acc.checkingWithdraw(amount);
                }
                else if (withdrawOrDeposit == 2) {      // User wants to deposit
                    System.out.println(acc.getCheckingAcc());
                    System.out.print("How much would you like to deposit? ");
                    amount = menu.validNumber();
                    acc.checkingDeposit(amount);
                }
                else if (withdrawOrDeposit == 3){      // User wants to move from checking to savings
                    System.out.println(acc.getCheckingAcc());
                    System.out.print("How much would you like to move to savings? ");
                    amount = menu.validNumber();
                    acc.moveToSavings(amount);
                }
                else { menu.invalid(); }
            }
            // If user chooses 2 for the savings account...
            if (checkOrSave == 2) {
                if (withdrawOrDeposit == 1) {           // User wants to withdraw
                    System.out.println(acc.getSavingAcc());
                    System.out.print("How much would you like to withdraw? ");
                    amount = menu.validNumber();
                    acc.savingWithdraw(amount);
                }
                else if (withdrawOrDeposit == 2) {      // User wants to deposit
                    System.out.println(acc.getSavingAcc());
                    System.out.print("How much would you like to deposit? ");
                    amount = menu.validNumber();
                    acc.savingsDeposit(amount);
                }
                else if (withdrawOrDeposit == 3){      // User wants to move from checking to savings
                    System.out.println(acc.getSavingAcc());
                    System.out.print("How much would you like to move to checking? ");
                    amount = menu.validNumber();
                    acc.moveToChecking(amount);
                }
                else { menu.invalid(); }
            }

            System.out.print("\nWould you like to make more changes to your account? (y/n) ");
            yesOrNo = in.next();

        } while (yesOrNo.equals("y") || yesOrNo.equals("Y"));   // Better to use .equals() with string since not pointing to same address in memory

        System.out.println("\nThank you for using Daniel & Douglas Bank.");
    }

}
