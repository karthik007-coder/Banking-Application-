import java.util.Scanner;

public class banking { 
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            System.out.printf("\n********************\n");
            System.out.printf("Welcome to Bank\n");
            System.out.printf("********************\n");
            System.out.printf("Enter 1 for displaying the balance\n");
            System.out.printf("Enter 2 for withdrawing\n");
            System.out.printf("Enter 3 for depositing\n");
            System.out.printf("Enter 4 for Exiting\n");
            System.out.printf("********************\n");
            System.out.printf("Enter your choice (1-4): ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showBalance(balance);
                    break;
                case 2:
                    double withdrawAmt = withdrawing(balance);
                    if (withdrawAmt > 0) {
                        balance -= withdrawAmt;
                        System.out.printf("Withdrawn successfully\n");
                    }
                    System.out.printf("Your bank balance is $%.2f\n", balance);
                    break;
                case 3:
                    double depositAmt = depositing();
                    if (depositAmt > 0) {
                        balance += depositAmt;
                        System.out.printf("Deposited successfully\n");
                    }
                    System.out.printf("Your bank balance is $%.2f\n", balance);
                    break;
                case 4:
                    System.out.printf("Thank you for choosing our Bank\n");
                    isRunning = false;
                    break;
                default:
                    System.out.printf("Invalid input, please try again\n");
            }
        }
        sc.close();
    }

    static void showBalance(double balance) {
        System.out.printf("********************\n");
        System.out.printf("Your bank balance is $%.2f\n", balance);
    }

    static double depositing() {
        System.out.printf("Enter an amount to deposit: ");
        double amount = sc.nextDouble();
        
        if (amount < 0) { 
            System.out.printf("Amount can't be negative\n");
            return 0;
        } else if (amount == 0) {
            System.out.printf("Amount can't be zero\n");
            return 0;
        } else {
            return amount;
        }
    }

    static double withdrawing(double balance) { 
        System.out.printf("Enter an amount to withdraw: ");
        double amount = sc.nextDouble();
        
        if (amount <= 0) {
            System.out.printf("Amount must be greater than zero\n");
            return 0;
        } else if (amount > balance) { 
            System.out.printf("Insufficient funds! You only have $%.2f\n", balance);
            return 0;
        } else {
            return amount;
        }
    }
}