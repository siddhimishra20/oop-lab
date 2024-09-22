import java.util.Scanner;
class Employee {
    String id;
    String name;
    int dept;
    float basic;
    float allowance;
    float totalSalary;
    float hra; 
    
    // A.) Employee Constructor
    public Employee(String id, String name, int dept, float basic, float allowance, float totalSalary, float hra) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.basic = basic;
        this.allowance = allowance;
        this.totalSalary = totalSalary;
        this.hra = hra;
    }

    // B.) Calculate Salary Method 
    public void calculateSalary() {
        totalSalary = (hra + basic + allowance);
        System.out.print("\nEmployee Total Salary: " + totalSalary);
    }

    // C.) Display Method
    public void displayDetails() {
        System.out.println("\nEmployee Details are as below: \n");
        System.out.print("ID: " + id);
        System.out.print("\nName: " + name);
        System.out.print("\nDepartment: " + (dept==1 ? "Staff" : dept==2 ? "Accounts" : "Admin")); // Ternary operator 
        System.out.print("\nBasic Salary: " + basic);
        System.out.print("\nHRA: " + hra);
        System.out.print("\nAllowance: " + allowance);
    }
}

public class EmployeeTester {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n----------------------[ EMPLOYEE] ----------------------\n");

        System.out.print("Enter number of employees to be added: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Employee[] employee = new Employee[n]; // Array of n employee objects

        for (int i=0; i<n; i++) {
            System.out.println("\n[ EMPLOYEE " + (i+1) + " DETAILS ]");

            // 1.) Employee ID
            System.out.print("\nEnter Employee ID: ");
            String id = scanner.nextLine();

            // 2.) Employee Name 
            System.out.print("\nEnter Employee Name: ");
            String name = scanner.nextLine();

            //3.) Employee Department
            System.out.print("\nEnter Employee Department: ");
            System.out.print("\n1 - Staff \n2 - Accounts \n3 - Admin \n");
            int dept = scanner.nextInt(); 
            scanner.nextLine(); // consume leftover newline character 

            //4.) Employee Basic Salary
            System.out.print("\nEnter Employee Basic Salary: ");
            float basic = scanner.nextFloat();
            scanner.nextLine();

            //5.) Employee Allowance
            System.out.println("\nEmployee Allowance: ");
            float allowance = 0f;
            switch(dept) {
                case 1:
                    System.out.println("Allowance for Staff Employee is: Dhs 1500");
                    allowance = 1500f;
                    break;
                case 2:
                    System.out.println("Allowance for Accounts Employee is: Dhs 2500");
                    allowance = 2500f;
                    break;
                case 3:
                    System.out.println("Allowance for Admin Employee is: Dhs 3500");
                    allowance = 3500f;
                    break;
            }

            //6.) Employee HRA
            float hra = (0.4f*basic);
            System.out.print("\nEmployee HRA is: " + hra);

            // FINISH
            System.out.println("\n\nEmployee Details have been successfully added.");

            employee[i] = new Employee(id, name, dept, basic, allowance, allowance, hra);
        }

        int ch;

        do {
            System.out.println("\n MENU: ");
            System.out.println("\n1 - Calculate Salaray");
            System.out.println("2 - Display Details");
            System.out.println("3 - Exit");
            System.out.print("Enter choice: ");
            ch = scanner.nextInt();
            scanner.nextLine();

            switch (ch) {
                case 1:
                for (int i = 0; i < n; i++) {
                    System.out.println("\nEmployee " + (i + 1) + ":");
                    employee[i].calculateSalary();
                    System.out.println();
                }
                break;
                case 2:
                for (int i = 0; i < n; i++) {
                    System.out.println("\nEmployee " + (i + 1) + ":");
                    employee[i].displayDetails();
                    System.out.println();
                }
                break;
                case 3:
                    break;
            }
        } while (ch!=3);
            
    }

}
