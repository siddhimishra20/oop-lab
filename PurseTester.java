import java.util.Scanner;
class Purse {
    private float dirham;
    private int fills50;
    private int fills25;
    private float total;

    // Constructor - to initialize instance variables
    public Purse() {
        this.dirham = 0f;
        this.fills50 = 0;
        this.fills25 = 0;
        this.total = 0f;
    }

    // Method 2
    public void add_dirham(int amt) {
        this.dirham += amt;
        System.out.println(amt + " Dirhams Added Successfully.");
    }

    // Method 3
    public void remove_dirham(int amt) {
        if (this.dirham >= amt) {
            this.dirham -= amt;
            System.out.println(amt + " Dirhams Removed Successfully.");
        }
        else {
            System.out.println("Insufficient balance. Not enough dirhams to remove.");
        }
        
    }

    // Method 4
    public void add_50fills(int amt) {
        this.fills50 += amt;
        System.out.println(amt + " Fifty fills Added Successfully.");
    }

    // Method 5
    public void remove_50fills(int amt) {
        if (this.fills50 >= amt) {
            this.fills50 -= amt;
            System.out.println(amt + " Fifty fills Removed Successfully.");
        }
        else {
            System.out.println("Insufficient balance. Not enough fifty fills to remove.");
        }
        
    }

    // Method 6
    public void add_25fills(int amt) {
        this.fills25 += amt;
        System.out.println(amt + " Twenty-five fills Added Successfully.");
    }

    // Method 7
    public void remove_25fills(int amt) {
        if (this.fills25 >= amt) {
            this.fills25 -= amt;
            System.out.println(amt + " Twenty-five fills Removed Successfully.");
        }
        else {
            System.out.println("Insufficient balance. Not enough twenty-five fills to remove.");
        }
        
    }

    // Method 8
    public void total_cash() {
        this.total = this.dirham + (this.fills25*0.25f) + (this.fills50*0.5f);
        System.out.println("Total Cash: " + this.total);
    }

}
public class PurseTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Purse purse = new Purse();
        int choice;

        do {
            System.out.println("\n---------[ Purse Menu ]---------");
            System.out.println("1. Add Dirham");
            System.out.println("2. Remove Dirham");
            System.out.println("3. Add 50 Fills");
            System.out.println("4. Remove 50 Fills");
            System.out.println("5. Add 25 Fills");
            System.out.println("6. Remove 25 Fills");
            System.out.println("7. Show Total Cash");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of dirhams to add: ");
                    int dirhamToAdd = scanner.nextInt();
                    purse.add_dirham(dirhamToAdd);
                    break;

                case 2:
                    System.out.print("Enter number of dirhams to remove: ");
                    int dirhamToRemove = scanner.nextInt();
                    purse.remove_dirham(dirhamToRemove);
                    break;

                case 3:
                    System.out.print("Enter number of 50-fills coins to add: ");
                    int fills50ToAdd = scanner.nextInt();
                    purse.add_50fills(fills50ToAdd);
                    break;

                case 4:
                    System.out.print("Enter number of 50-fills coins to remove: ");
                    int fills50ToRemove = scanner.nextInt();
                    purse.remove_50fills(fills50ToRemove);
                    break;

                case 5:
                    System.out.print("Enter number of 25-fills coins to add: ");
                    int fills25ToAdd = scanner.nextInt();
                    purse.add_25fills(fills25ToAdd);
                    break;

                case 6:
                    System.out.print("Enter number of 25-fills coins to remove: ");
                    int fills25ToRemove = scanner.nextInt();
                    purse.remove_25fills(fills25ToRemove);
                    break;

                case 7:
                    purse.total_cash();  
                    break;

                case 8:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    break;
            }

        } while (choice != 8);

        scanner.close();
    }
}
