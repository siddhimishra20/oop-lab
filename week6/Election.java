import java.util.Scanner;

public class Election {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] voteCount = new int[5]; // {1,2,3,4,5}
        int spoiltCount = 0;

        System.out.println("-------------[ Elections ]-------------");

        int choice;

        do { 
            System.out.println("\n[ Ballot paper ]\n");
            System.out.println("Choose: \n1 - Voting\n2 - Exit the ballot");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("\nChoose the candidate you wish to vote for (1,2,3,4,5): ");
                    int ch = scanner.nextInt();
                    if (ch>=1 && ch<=5) {
                        int index = (ch - 1);
                        voteCount[index]++;
                    }
                    else {
                        spoiltCount++;
                    }
                    break;
                case 2:
                    break;
            }
        } while (choice!=2);

        System.out.println("\n[ Final Review ]\n");
        for (int i = 0; i<5; i++) {
            System.out.println("Number of votes for candidate " + (i+1) + ": " + voteCount[i]);
        }
        System.out.println("Number of spoilt votes: " + spoiltCount);
        scanner.close();
    }
 }