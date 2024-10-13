
import java.util.Scanner;

class Car {
    String vehicle_id;
    float[] cost = {0f,0f,0f}; // base, exerciseDuty, sales_tax
    float total;
    float grand_total;

    Scanner scanner = new Scanner(System.in);

    // Default Constructor - initialize the array of car objects
    public Car() {
        System.out.println("----------[ Car Details ]----------");

        // 1.) Vehicle id
        System.out.print("\nEnter Vehicle ID: ");
        this.vehicle_id = scanner.nextLine();

        // 2.) Cost
        System.out.print("Enter Base, Exercise Duty and Sales tax: ");
        for (int i=0; i<3;i++) {
            this.cost[i] = scanner.nextFloat();
        }

        System.out.println("Car details added successfully.");
    }

    // Method 1
    public void calc_total() {
        for (Float i : cost) {
            this.total += i;
        }
        System.out.println("\nTotal Cost (Base + Exercise duty + Sales tax): " + this.total);
    }

    // Method 2
    public void calc_grand_total() {
        this.grand_total = (this.total - (this.total * 0.1f));
        System.out.println("\nGrand price after discount: " + this.grand_total);
    }

    public static void display(Car[] car) {
        Car highestCar = car[0];
        for (Car cars : car) {
            if (cars.grand_total > highestCar.grand_total) {
                highestCar = cars;
            }
        }
        System.out.println("\n[ Details of the Car with highest grand price:- ]\n");
        System.out.println("Vehicle ID: " + highestCar.vehicle_id);
        System.out.println("Total: " + highestCar.total);
        System.out.println("Grand Total: " + highestCar.grand_total);
    } 
}

public class Showroom {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-----------[ Showroom ]-----------\n");

        System.out.print("\nEnter the number of Cars to be added to Showroom: ");
        int n = scanner.nextInt();
        Car[] car = new Car[n];
        
        for (int i = 0; i<n; i++) {
            System.out.println("\n[ Car " + (i+1) + " ]");
            car[i] = new Car();
        }

        for (int j = 0; j < n; j++) {
            car[j].calc_total(); 
            car[j].calc_grand_total(); 
        }

        Car.display(car); // array as an argument

        scanner.close();
    }
}