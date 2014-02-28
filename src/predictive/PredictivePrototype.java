package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PredictivePrototype {

    public static String wordToSignature(String word) {
        // Using StringBuffer rather than String is a more efficient solution as it allows a single variable to be appended.
        // This therefore means it performs the concatenations much more effectively.

        // Creates new string buffer to hold the signature.
        StringBuffer buffer = new StringBuffer();

        // Converts the word to lower case.
        word = word.toLowerCase();

        // Loops through each letter in the word.
        for (int count = 0; count < word.length(); count++) {
            char letter = word.charAt(count);

            // Compares the char with each case and appends corresponding number to buffer.
            switch (letter) {
                case 'a':case 'b':case 'c':
                    buffer.append(2);
                    break;
                case 'd':case 'e':case 'f':
                    buffer.append(3);
                    break;
                case 'g':case 'h':case 'i':
                    buffer.append(4);
                    break;
                case 'j':case 'k':case 'l':
                    buffer.append(5);
                    break;
                case 'm':case 'n':case 'o':
                    buffer.append(6);
                    break;
                case 'p':case 'q':case 'r':case 's':
                    buffer.append(7);
                    break;
                case 't':case 'u':case 'v':
                    buffer.append(8);
                    break;
                case 'w':case 'x':case 'y':case 'z':
                    buffer.append(9);
                    break;
                // If the char is not in the alphabet, simply append a blank space.
                default:
                    buffer.append(" ");
                    break;
            }
        }
        // Return the string version of the buffer.
        return buffer.toString();
    }

    public static Set<String> signatureToWords(String signature) {
        // Each time a word is being input, the system has to read through the dictionary line by line.
        // This is obviously hugely inefficient, especially using a Scanner to read the data.
        // A better solution would be to initially store the dictionary in a hash set then continuously refer to the set.

        // Initialises a new Scanner.
        Scanner filescan = null;

        // Tries to scan in the dictionary, else catches the exception.
        try {
            filescan = new Scanner(new File("/Users/charliechambers/Documents/University First Year/Software Workshop/Programming/PredictiveTextEntry/src/predictive/dictionary.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Creates a new hash set to store the results.
        Set<String> results = new HashSet<String>();

        // While the scanner has an input.
        while (filescan.hasNext()) {
            // The scanners input is saved as a string and converted to lower case.
            String current = (filescan.nextLine().toLowerCase());
            // If current signature is equal to the signature being passed in and set containing the results does not already contain the word.
            if (wordToSignature(current).equals(signature) && !(results.contains(current))) {
                // Add the word to the results set.
                results.add(current);
            }
        }
        return results;
    }

}



