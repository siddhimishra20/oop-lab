import java.util.Scanner;

class Area {
    private float side1;
    private float side2;
    private float area;

    // Method 1
    public void calc_Area(int side) {
        this.area = side*side;
    }

    // Method 2
    public void calc_Area(float radius) {
        this.area = 3.14f*radius*radius;
    }

    // Method 3
    public void calc_Area(float side1,float side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.area = side1*side2;
    }

    // display()
    public void display() {
        System.out.println("Area calculated is: " + area);
    }

}

public class AreaTester {
    public static void main(String[] args) {
        Area areaObj = new Area();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------[ Area Calculator ]------------");
        System.out.println("Choose which area to calculate: \n1 - Square\n2 - Circle\n3 - Rectangle\n");
        int ch = scanner.nextInt();

        switch(ch) {
            case 1:
                System.out.print("Enter side: ");
                int side = scanner.nextInt();
                areaObj.calc_Area(side);
                areaObj.display();
                break;
            case 2:
                System.out.print("Enter radius: ");
                float radius = scanner.nextFloat();
                areaObj.calc_Area(radius);
                areaObj.display();
                break;
            case 3:
                System.out.print("Enter side 1: ");
                float side1 = scanner.nextFloat();
                System.out.print("Enter side 2: ");
                float side2 = scanner.nextFloat();
                areaObj.calc_Area(side1,side2);
                areaObj.display();
                break;
            default:
                break;
        }
    }
}