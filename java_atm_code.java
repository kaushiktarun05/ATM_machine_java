import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
class Details {
    private int accountno;
    private int pin;
    public int setAccountNo(int accountno) {
        this.accountno = accountno;
        return accountno;
    }
    public int getAccountNo() {
        return accountno;
    }
    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }
    public int getPin() {
        return pin;
    }
}
class OptionMenu extends Details {                           // inherit Details class
    Scanner sc = new Scanner(System.in);
    HashMap < Integer, Integer > data = new HashMap < Integer, Integer > ();
    public void getlogin() throws IOException {
        int balance = 100000;      
        int x = 1;
                     //do while loop
        do {                         
            try                             // exception handling try and catch block
            {
                data.put(78945, 1010);                        //correct account no. and pin respectively
                //data.put(989947, 71976);                    //correct account no. and pin respectively
                System.out.println("Welcome to the ATM ");
                System.out.println("Enter your customer Number");
                setAccountNo(sc.nextInt());

                System.out.print("Enter your PIN Number: ");
                setPin(sc.nextInt());
            } catch (Exception e) {

                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                x = 2;

            }
            int cn = getAccountNo();   // calling method to get account no.

            int pn = getPin();        //calling method  to get pin no.


            if (data.containsKey(cn) && data.get(cn) == pn) {
                while (true) {
                    System.out.println("Automated Teller Machine");
                    System.out.println("Choose 1 for Withdraw");
                    System.out.println("Choose 2 for Deposit");
                    System.out.println("Choose 3 for Check Balance");
                    System.out.println("Choose 4 for EXIT");
                    System.out.print("Choose the operation you want to perform:");
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:                                 // to withdraw money from account/ATM
                            System.out.print("Enter money to be withdrawn:");
                            int withdraw = sc.nextInt();
                            if (balance >= withdraw) {
                                balance = balance - withdraw;          // Current balance present in account
                                System.out.println("");
                                System.out.println("total balance:" + balance);
                                System.out.println("Please collect your money");
                            } else {
                                System.out.println("Insufficient Balance");

                                System.out.println("");
                            }

                            break;
                        case 2:                                               // to deposit money 
                            System.out.print("Enter money to be deposited:");
                            int deposit = sc.nextInt();
                            System.out.println("Your Money has been successfully depsited");
                            balance = balance + deposit;                     // total money in account
                            System.out.println("total balance in your account :-" + balance);
                            System.out.println("");

                            break;
                        case 3:                                          //to check balance 
                            System.out.println("Balance : " + balance);
                            System.out.println("");
                            break;
                        case 4:                                 //to exit ATM
                            System.exit(0);
                    }
                }
            } 
            else {
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
            }
        }
        while (x == 1);
    }
}
class ATM extends OptionMenu {
    public static void main(String[] args) throws IOException {
        OptionMenu op = new OptionMenu();                           //creating object of OptionMenu class
        op.getlogin();                                              //call function
    }
}