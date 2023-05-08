// Meghan Flaherty & Adam Curtin
// CS145
// Letter Inventory [lab 3]
// this program can be used to keep track of an inventory of letters
// and returns specific contents and stats of the input string
import java.util.*;



public class LetterInventory extends LetterInventoryTest{
    private static final int ALPHABET_SIZE = 26;
    private int[] counts;
    private int size; 

    // constructor for the class
    public LetterInventory(String data) {
        counts = new int[ALPHABET_SIZE];
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                counts[Character.toLowerCase(ch) - 'a']++;
                size++;
            }
        }
    }

    public static void prompt() {
        Scanner input = new Scanner(System.in);
            
          //  LetterInventory inventory = new LetterInventory(input);
            System.out.println("Would you like to enter a word in our inventory?");
            System.out.println("please type:");
            System.out.println("Yes - enter a word || No - quit this program");
            String choice = input.next();
            choice = choice.toLowerCase();
            // LetterInventory inventory = new LetterInventory(input);
            if (choice.equals("yes")) {
               Execute(); 
               
            }
            else if (choice.equals("no")) {
                System.exit(0);
            }
    }

    // method that sends the input string to other methods + prints output
    public static void Execute() {
        System.out.print("Enter a word or sentence: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();
        LetterInventory inventory = new LetterInventory(word);
        System.out.println("Original string: " + word);
        System.out.println("Sorted string: " + inventory.toString());
        System.out.println("Letter count: " + inventory.size());
        System.out.println("Empty? " + inventory.isEmpty());
           promptAgain();
    }

    // second prompt menu for fluid program use
    public static void promptAgain() {
        Scanner inputTwo = new Scanner(System.in);
        System.out.println("Would you like to enter another word?");
        System.out.println("Yes / No");
        String choiceTwo = inputTwo.next();
        choiceTwo = choiceTwo.toLowerCase();
        // LetterInventory inventory = new LetterInventory(input);
        if (choiceTwo.equals("yes")) {
           Execute(); 
           
        }
        else if (choiceTwo.equals("no")) {
            System.exit(0);
        }
}
    

    // get method for letter
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Not a letter: " + letter);
        }
        return counts[Character.toLowerCase(letter) - 'a'];
    }

    // set method for letter and value
    public void set(char letter, int value) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Not a letter: " + letter);
        }
        int index = Character.toLowerCase(letter) - 'a';
        if (value < 0) {
            throw new IllegalArgumentException("Negative value: " + value);
        }
        size += value - counts[index];
        counts[index] = value;
    }

    // returns size
    public int size() {
        return size;
    }
    
    // returns true if empty + false if not 
    public boolean isEmpty() {
        return size == 0;
    }

    // to string method to build the string + format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    // adding a letter inventory 
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            sum.counts[i] = counts[i] + other.counts[i];
            sum.size += sum.counts[i];
        }
        return sum;
    }

    // taking out a letter inventory 
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory diff = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            diff.counts[i] = counts[i] - other.counts[i];
            if (diff.counts[i] < 0) {
                return null;
            }
            diff.size += diff.counts[i];
        }
        return diff;
    }

}