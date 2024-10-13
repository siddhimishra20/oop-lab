// Good question -> Use Hashmaps

import java.util.Scanner;

public class DuplicateElement {

    public static int[][] check_duplicate(int[] arr) {
        int[][] newArr = new int[arr.length][2];
        boolean[] visited = new boolean[arr.length]; // check if we visited that element -> flag {0,0,0,...}

        int index = 0; //for newArr

        for (int i = 0; i<arr.length; i++) {

            if (visited[i]) { // PASS if visited
                continue;
            }
            int count = 1; // each element's count is gonna start from 1

            for (int j = i+1; j<arr.length; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                    visited[j] = true; // Visited, so true

                }
            }

            if (count > 1) {
                newArr[index][0] = arr[i];
                newArr[index][1] = count;
                index++;
            }
        }
        return newArr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("------------[ Array ]------------");
        System.out.print("\nEnter size of array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n]; // array declared and memory allocated. [1 2 3 2 5 9]

        System.out.print("Enter elements of array: ");
        for (int i=0;i<n;i++) {
            arr[i] = scanner.nextInt();
        }
        
        int[][] result = check_duplicate(arr);

        System.out.println("\n[ Duplicate Elements and their count ]\n");
        for (int j=0; j<result.length; j++) {
            if (result[j][1]>0) {
                System.out.println("Element: " + result[j][0] + " Count: " + result[j][1]);
            }
        }
    }
}
