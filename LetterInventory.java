public class LetterInventory {
    private static final int ALPHABET_SIZE = 26;
    private int[] counts;
    private int size;

    public LetterInventory(String data) {
        counts = new int[ALPHABET_SIZE];
        for (char ch : data.toCharArray()) {
            if (Character.isLetter(ch)) {
                counts[Character.toLowerCase(ch) - 'a']++;
                size++;
            }
        }
    }

    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("Not a letter: " + letter);
        }
        return counts[Character.toLowerCase(letter) - 'a'];
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

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

    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            sum.counts[i] = counts[i] + other.counts[i];
            sum.size += sum.counts[i];
        }
        return sum;
    }

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
} // end LetterInventory
