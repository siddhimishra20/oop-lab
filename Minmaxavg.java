import java.util.Scanner;
public class Minmaxavg {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------[ Min Max Avg ]-----------");

        float[] arr = new float[10]; // n = 10 given in the question
        System.out.print("\nEnter input for 10 floating point number array: ");

        for (int j =0; j<10; j++) {
            arr[j] = scanner.nextFloat();
        }

        System.out.print("Array Successfully Created: ");
        System.out.print("[");
        for (int k =0; k<10; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.print("]");

        int ch;
        
        do { 
            System.out.println("\nChoose which option to be performed: ");
            System.out.println("\n1 - Max\n2 - Min\n3 - Avg\n4 - Exit");
            ch = scanner.nextInt();

            float max = arr[0];
            float min = arr[0];
            float sum = 0;
            float avg = 0;
            
            
            switch(ch) {
                case 1:
                    for (int i=0; i<10; i++) { // element access directly -> 
                        if (arr[i]>max) {
                            max = arr[i];
                        }
                    }
                    System.out.println("Max of the array is: " + max);
                    break;

                case 2:
                    for (int i=0; i<10; i++) { 
                        if (arr[i]<min) {
                            min = arr[i];
                        }
                    }
                    System.out.println("Min of the array is: " + min);
                    break;

                case 3:
                    for (int i=0; i<10; i++) {
                        sum += arr[i];
                        avg = (sum/10);
                    }
                    System.out.println("Avg of the array is: " + avg);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    break;
                
                default: 
                    System.out.println("ERROR: Please enter a valid option.");
            }
        } while (ch!=4);

        scanner.close();
        
    }
}
