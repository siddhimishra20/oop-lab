import java.util.Scanner;

public class Mult_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to print its multiplication table: ");
        int n = scanner.nextInt();

        int[][] table = new int[n][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }

        scanner.close();
    }
}
