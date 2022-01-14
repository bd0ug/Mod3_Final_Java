import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class menu options and catches errors
 */
public class Menu {
    public void Menu1() {
        System.out.println("\nAccounts:\n1. Checking\n2. Savings\n3. See balances");
    }

    public void Menu2() {
        System.out.println("\nWould you like to...\n1. Withdraw\n2. Deposit\n3. Move");
    }

    // If an input is invalid, end the program
    public void invalid() {
        System.out.println("Invalid option. Please try again later.");
        System.out.println("Thank you for using Daniel & Douglas Bank.");
        System.exit(0);
    }

    // Will check user input, if it's not an integer then end the program
    public int checkInput() {
        int answer = 0;
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter choice: ");
            answer = in.nextInt();
        }
        catch (Exception e) {
            invalid();
        }
        return answer;
    }

    // Will check user input, to make sure its a double
    public double validNumber() {
        double amount = 0;
        Scanner in = new Scanner(System.in);
        try {
            amount = in.nextDouble();

            if (amount < 0) {  // if user enters a negative number
                System.out.print("Please enter a number greater than 0. ");
                amount = 0;     // don't want to withdraw or deposit anything
            }
        }
        catch (InputMismatchException e) {
            System.out.print("Please enter a valid number. ");
        }
        return amount;
    }
}
