
    import java.util.Scanner;
    
    public class LetterInventoryTest {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence: ");
        String input = scanner.nextLine();
        LetterInventory inventory = new LetterInventory(input);
        System.out.println("Original string: " + input);
        System.out.println("Sorted string: " + inventory.toString());
        System.out.println("Letter count: " + inventory.size());
        System.out.println("Empty? " + inventory.isEmpty());
            LetterInventory inventory1 = new LetterInventory("Hello");
            System.out.println("Inventory 1: " + inventory1); // prints [ehllo]
    
            LetterInventory inventory2 = new LetterInventory("World");
            System.out.println("Inventory 2: " + inventory2); // prints [dlorw]
    
            LetterInventory sum = inventory1.add(inventory2);
            System.out.println("Sum: " + sum); // prints [dehllloorw]
    
            LetterInventory diff = inventory2.subtract(inventory1);
            System.out.println("Difference: " + diff); // prints [dorw]
    
            // Test get() method
            System.out.println("Number of 'l's in inventory 1: " + inventory1.get('l')); // prints 2
            System.out.println("Number of 'z's in inventory 2: " + inventory2.get('z')); // throws IllegalArgumentException
    
            // Test set() method
            inventory1.set('l', 3);
            System.out.println("Inventory 1 after setting 'l' count to 3: " + inventory1); // prints [ehlloo]
            inventory1.set('z', 2); // throws IllegalArgumentException
    
            // Test size() and isEmpty() methods
            System.out.println("Size of inventory 2: " + inventory2.size()); // prints 5
            System.out.println("Is inventory 1 empty? " + inventory1.isEmpty()); // prints false
    
        } // end main method
    } // end test class
    
