public class Elements {
    int atnum;
    String atname;
    String atsymbol;
    String atclass;
    double atweight;
    
    Elements(int atnum, String atname, String atsymbol, String atclass, double atweight) {
        this.atnum = atnum;
        this.atname = atname;
        this.atsymbol = atsymbol;
        this.atclass = atclass;
        this.atweight = atweight; 
    }

    public void Display() {
        System.out.println("Atomic Number: " + atnum + " Atomic Name: " + atname + " Symbol: " + atsymbol + " Class: " + atclass + " Weight: " + atweight);
    }
    
    public static void DisplayAbove15(Elements[] elements) { 
        for (Elements element : elements) {
            if (element.atweight > 15) {
                element.Display();
            }
        }
    }

    public static void main(String[] args) {
        // Array of objects <class/data type> <object name> = {};
        Elements[] elements = { new Elements(1, "Hydrogen", "H", "Non-metal", 1.00784),
                               new Elements(36, "Krypton", "Kr", "Noble-gas", 83.798),
                               new Elements(33, "Arsenic", "As", "Metalloids", 74.922)};
        System.out.println("The elements are as listed below: \n");
        for (Elements element : elements) { // Display method is for single object so you cant call it directly. Traverse through the array for each object and then call display method
            element.Display();
        }

        System.out.println("\nThe elements with atomic weight > 15 are as listed below: \n");
        DisplayAbove15(elements); // elements was not accessible, so we passed elements array to the method
        
    }
}
