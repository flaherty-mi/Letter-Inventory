// Meghan Flaherty & Adam Curtin
// CS145
// Letter Inventory [lab 3]
// this program can be used to keep track of an inventory of letters

public class LetterInventory {
    private char letter;
    private int value;
    private String data;

    // constructor -> computes how many of each letter are in a string
    public LetterInventory() {

    }

    //returns a count of how many of this letter are in the inventory
    // can be lower or uppercase
    // if non alphabetic -> throw illegalArgumentException
    public int get(char letter) {
        return letter;
    }

    // sets the count for the letter to the value
    public void set(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    // returns sum of all of the counts in this inventory
    // should store the size rather than having to compute
    // each time method is called
    public int size() {

        return 0;
        // ^ 0 is just to keep errors quiet
    }

    // returns true if inventory is empty
    public Object isEmpty() {

        return null;
    }

    // returns a string representation of the inventory
    // with letters all lowercase + in sorted order w/ square brackets
    // num of occurences should match count in inventory
    public String toString() {

        return null;
    }

    // constructs and returns a new LetterInventory object that
    // represents the sum of this letter inventory +
    // the other given LetterInventory
    public LetterInventory add(LetterInventory other) {

        return other;
    }

    // constructs and returns a new LetterInventory object that
    // represents the result of subtracting the other inventory from this one
    public LetterInventory subtract(LetterInventory other) {

        return other;
    }

}