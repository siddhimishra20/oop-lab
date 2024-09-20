import java.util.Scanner;
public class guessgame {

    public static class player {
        String name;
        int num;
        player(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void startGame() {
    Scanner scanner = new Scanner(System.in);
    player[] playerarr = new player[3]; // player array 

    System.out.println("\n-------------Welcome to Guess Game Launcher!-------------\n");

    for (int i=0; i<3; i++) {
        System.out.print("Enter name of Player" + (i+1) + ": ");
        String pname = scanner.nextLine();

        System.out.print("Enter guess of Player" + (i+1) + ": ");
        int pnum = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        playerarr[i] = new player(pname, pnum); // creating objects in array 
        
    }
    scanner.close();

    int targetno = (int)(Math.random() * 10); // Generating random number

    boolean flag = false; 

    for (player i : playerarr) {
        if (i.num==targetno) {
            System.out.println(i.name + " has guessed it correctly!");
            System.out.println("The number was: " + targetno);
            flag = true;
            break;
        }
    }
    if (!flag) {
        System.out.println("No one guessed correctly :( Try again.");
        System.out.println("The number was: " + targetno);
    }
    }

    public static void main(String[] args) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Do you wish to start game? (y/n): ");
        String ch = scanner2.nextLine();
        if (ch.equals("y")) {
            startGame();
        }
        else {
            System.out.println("Not started.");
        }
        scanner2.close();
    }
}
