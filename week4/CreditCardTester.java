import java.util.Scanner;
class CreditCard {
    private String name;
    private long cardNo;
    private boolean enabled;
    private int pin;
    private String expiryMonth;
    private int cardType; // 3 - plat, 2 - gold, 1 - silver
    private int currentCredit;
    private int creditLimit;

    Scanner scanner = new Scanner(System.in); // Scanner object

    // A.) CreditCard() constructor
    public CreditCard() {
        System.out.println(" \n[ NEW CREDIT CARD ]\n ");
        // 1.) Name input
        System.out.print("Enter Card Holder's name: ");   
        this.name = scanner.nextLine();

        // 2.) Cardno.
        this.cardNo = (long)(Math.random() * 10000000000000000L);
        System.out.println("\nCard Number assigned is: " + cardNo);
        
        // 3.) Enable
        System.out.print("\nDo you want to enable the credit card? (y/n): ");
        String in = scanner.nextLine(); 
        if (in.equals("y")) {
            this.enabled = true;
        }
        else {
            this.enabled = false;
        }

        // 4.) Pin
        System.out.print("\nEnter your desired pin: ");
        this.pin = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        // 5.) Expiry Month
        System.out.print("\nEnter the Expiry Month: ");
        this.expiryMonth = scanner.nextLine();

        // 6.) Card Type
        System.out.println("\nEnter you card type according to the following options: ");
        System.out.println("1 - Silver (1% Discount) \n2 - Gold (2% Discount) \n3 - Platinum (3% Discount) \n: ");
        this.cardType = scanner.nextInt();
        scanner.nextLine();

        // 7.) Current Credit 
        System.out.print("\nEnter current credit: ");
        this.currentCredit = scanner.nextInt();
        scanner.nextLine();

        // 8.) Credit Limit
        System.out.println("\nCredit Card Limit: ");
        if (cardType==3) {
            System.out.println("PLAT: Your Card Limit is Dhs 250,000");
            this.creditLimit = 250000;
        }
        else if (cardType==2) {
            System.out.println("GOLD: Your Card Limit is Dhs 100,000");
            this.creditLimit = 100000;
        }
        else if (cardType==1) {
            System.out.println("SILV: Your Card Limit is Dhs 50,000");
            this.creditLimit = 50000;
        }

        System.out.println("\nCongratulations! A new Credit Card has been created.");
    }

    // B.) Change Pin
    public void changePin() {            
        System.out.println("Enter pin number: ");
        int pinNum = scanner.nextInt();
        scanner.nextLine();

        if (pinNum==pin) {
            System.out.print("Enter new pin number: ");
            int newpin = scanner.nextInt();
            scanner.nextLine();
            this.pin = newpin;
            System.out.println("\nNew pin has been set successfully.");
        }
        else {
            System.out.println("ERROR: The entered pin does not match the original pin.");
        }
    }

    // C.) Transaction
    public void transact(int amt) { 

        System.out.print("Enter Credit Card pin: ");
        int ccpin = scanner.nextInt();
        scanner.nextLine();
        
        if (cardType==3) {
            if (ccpin==pin && enabled==true && amt<250000 ) {
                double discamt = amt - (0.03*amt);
                currentCredit -= discamt; 
                System.out.println("\nAmount Deducted: " + discamt);
                System.out.println("\nCurrent Credit: " + currentCredit);
            }
            else {
                System.out.println("\nERROR: Transcation not valid. Please check your PIN, STATUS and LIMIT.");
            }
        }
        else if (cardType==2) {
            if (ccpin==pin && enabled==true && amt<100000 ) {
                double discamt = amt - (0.02*amt);
                currentCredit -= discamt; 
                System.out.println("\nAmount Deducted: " + discamt);
                System.out.println("\nCurrent Credit: " + currentCredit);
            }
            else {
                System.out.println("\nERROR: Transcation not valid. Please check your PIN, STATUS and LIMIT.");
            }
        }
        else if (cardType==1) {
            if (ccpin==pin && enabled==true && amt<50000 ) {
                double discamt = amt - (0.01*amt);
                currentCredit -= discamt; 
                System.out.println("\nAmount Deducted: " + discamt);
                System.out.println("\nCurrent Credit: " + currentCredit);
            }
            else {
                System.out.println("\nERROR: Transcation not valid. Please check your PIN, STATUS and LIMIT.");
            }
        }
    }

    // D.) Change Credit Card Status
    public void changeCardStatus(boolean status) { // change it to: status (passed in the method)
        System.out.print("Credit Card Status: ");
        if (status == true) {
            enabled = true;
            System.out.print(" Enabled");
        }
        else {
            enabled = false;
            System.out.println(" Disabled");
        }
    }

    // E.) Display
    public void display() {
        System.out.println("\nCredit Card details are as below: ");
        System.out.println("Card Holder: " + name);
        System.out.println("Card Number: " + cardNo);
        System.out.println("Card Status: " + enabled);
        System.out.println("Card Pin: " + pin);
        System.out.println("Card Expiry Month: " + expiryMonth);
        if (cardType==3) {
            System.out.println("Card Type: Platinum");
        }
        else if (cardType==2) {
            System.out.println("Card Type: Gold");
        }
        else if (cardType==1) {
            System.out.println("Card Type: Silver");
        }
        System.out.println("Card Current Credit: " + currentCredit);
        System.out.println("Card Credit Limit: " + creditLimit);
    }
}

public class CreditCardTester {
    public static void main(String[] args) {

        CreditCard card = new CreditCard(); // object of creditcard
        Scanner scanner2 = new Scanner(System.in);

        int ch;

        do {
            System.out.println("\n-------------CREDIT CARD-------------\n");
            System.out.println("Choose from the menu below: ");
            System.out.println("\n1.) Display\n2.) Change pin\n3.) Transaction\n4.) Change Card status\n5.) Exit\n");

            ch = scanner2.nextInt();
        
            switch(ch) {
                
                case 1: // 1.) Display
                    card.display();
                    break;
                
                case 2: //2.) Change pin
                    card.changePin();
                    break;

                case 3:  //3.) Transaction
                    System.out.print("\nEnter Amount to be deducted: ");
                    int amount = scanner2.nextInt();
                    scanner2.nextLine();
                    card.transact(amount);
                    break;

                case 4:  //4.) Change card status
                    System.out.print("\nEnter new Card Status (true/false): ");
                    boolean status = scanner2.nextBoolean();
                    scanner2.nextLine();
                    card.changeCardStatus(status);
                    break;

                case 5:
                    System.out.println("\nThank you for using Credit Card System. Exiting.");
                    break;

                default:
                    System.out.println("ERROR: Print a valid response.");
            }
        } while (ch!=5);    
    }
}
