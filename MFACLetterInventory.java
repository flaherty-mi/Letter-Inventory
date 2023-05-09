// Meghan Flaherty & Adam Curtin
// CS145
// Letter Inventory [lab 3]
// this program can be used to keep track of an inventory of letters
// and returns specific contents and stats of the input string

import java.util.*;

public class MFACLetterInventory extends MFACLetterInventoryTest{
    private static final int ALPHABET_SIZE = 26;
    private int[] counts;
    private int size; 

    // constructor for the class
    public MFACLetterInventory(String data) {
        // initialize counts array with alphabet size
        counts = new int[ALPHABET_SIZE];
        // loop through each char in the data String
        for (char ch : data.toCharArray()) {
            // if the char is a letter, add to its count in count array
            if (Character.isLetter(ch)) {
                counts[Character.toLowerCase(ch) - 'a']++;
                size++;
            } // end if char is letter
        } // end for each char
    } // end LetterInventory

    // Prompt user to enter a word
    // If yes, call runLetterInventory method
    // If no, exit (System.exit)
    public static void prompt() {
        Scanner input = new Scanner(System.in);
            
           // Prompt user
            System.out.println("Would you like to enter a word in our inventory?");
            System.out.println("please type:");
            System.out.println("Yes - enter a word || No - quit this program");
            
            // Get user response, convert to lowercase
            String choice = input.next();
            choice = choice.toLowerCase();

            // If yes, runLetterInventory method, if no, exit.
            switch (choice) {
                case "yes":
                    runLetterInventory();
                    break;
                case "no":
                    System.exit(0);
                    break;
                default: 
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                    prompt(); // call prompt method until they say yes or no
            } // end switch case
    } // end prompt method

    // method that sends the input string to other methods + prints output
    public static void runLetterInventory() {
        // Prompt for word or sentence
        System.out.print("Enter a word or sentence: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        // Create Letter Inventory object from user input
        MFACLetterInventory inventory = new MFACLetterInventory(word);

        // Print info about Inventory
        System.out.println("Original string: " + word);
        System.out.println("Sorted string: " + inventory.toString());
        System.out.println("Letter count: " + inventory.size());
        System.out.println("Empty? " + inventory.isEmpty());

        // prompt user again
        promptAgain(); 
    } // end runLetterInventory method

    // second prompt menu for fluid program use
    public static void promptAgain() {
        // prompt user if they want to use program again
        Scanner inputTwo = new Scanner(System.in);
        System.out.println("Would you like to enter another word?");
        System.out.println("Yes / No");

        // Convert input to lowercase
        String choiceTwo = inputTwo.next();
        choiceTwo = choiceTwo.toLowerCase();
        
        // If yes, runLetterInventory method, if no, exit.
        switch (choiceTwo) {
            case "yes":
                runLetterInventory();
                break;
            case "no":
                System.exit(0);
                break;
            default: 
                System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                promptAgain(); // call prompt method until they say yes or no
        } // end switch case
    } // end 2nd prompt menu method

    // get method for letter 
    // returns count of spefified letter in iventory
    public int get(char letter) {
        // if char isn't a-z throw illegal arg exception
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Not a letter: " + letter);
        } // end if not letter
        return counts[Character.toLowerCase(letter) - 'a'];
    } // end get letter method

    // set method for letter and value
    public void set(char letter, int value) {
        // if char isn't a-z throw illegal arg exception
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Not a letter: " + letter);
        } // end if letter

        // find index of letter in counts array
        int index = Character.toLowerCase(letter) - 'a';

        // if value is negative, throw illegal arg exception
        if (value < 0) {
            throw new IllegalArgumentException("Negative value: " + value);
        } // end if negative

        // update size and value in counts array
        size += value - counts[index];
        counts[index] = value;
    } // end set letter and value method

    // returns size
    public int size() {
        return size;
    } // end return size
    
    // returns true if empty + false if not 
    public boolean isEmpty() {
        return size == 0;
    } // end empty check

    // to string method to build the string + format
    // The string will contain all letter in the inventory,
    // sorted in alphabetical order
    @Override
    public String toString() {
        // create string builder
        StringBuilder stringBuilder = new StringBuilder("[");

        // loop through the array to add each letter to string builder
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            for (int j = 0; j < counts[i]; j++) {
                // add the current letter
                stringBuilder.append((char) (i + 'a'));
            } // end inner for
        } // end outer for

        // add closing bracket to string builder and return string
        stringBuilder.append("]");
        return stringBuilder.toString();
    } // end toString
    
    // adds another letter inventory to this one. 
    // returns resulting letter inventory 
    public MFACLetterInventory add(MFACLetterInventory other) {
        // create a new inventory to hold sum of two inventories
        MFACLetterInventory sum = new MFACLetterInventory("");

        // for each letter in the alphabet
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            // set counts for current letter to sum of this inventory and other
            sum.counts[i] = counts[i] + other.counts[i];
            // add counts for current letter to size of sum letter inventory
            sum.size += sum.counts[i];
        } // end for each letter

        return sum; // return resulting sum letter inventory
    } // end add inventory method

    // Subtracts another letter inventory from this one
    // returns resulting letter inventory 
    public MFACLetterInventory subtract(MFACLetterInventory other) {
        // create a new inventory to hold difference in this inventory and other
        MFACLetterInventory diff = new MFACLetterInventory("");

        // for each letter in alphabet
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            // set counts for current letter to difference of this inventory and other
            diff.counts[i] = counts[i] - other.counts[i];

            // if difference is negative, return null
            if (diff.counts[i] < 0) {
                return null;
            } // end if count is less than 0
            // add counts for current letter to size of difference letter inventory
            diff.size += diff.counts[i];
        } // end for each letter

        return diff; // return resulting difference letter inventory
    } // end subtract inventory method

} // end LetterInventory Class