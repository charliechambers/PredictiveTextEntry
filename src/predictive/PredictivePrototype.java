package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

    public static String wordToSignature(String word) {
        // Using StringBuffer rather than String is a more efficient solution as it allows a single variable to be appended.
        // This therefore means it performs the concatenations much more effectively.

        // Creates new string buffer to hold the signature.
        StringBuffer buffer = new StringBuffer();

        // Converts the word to lower case.
        word = word.toLowerCase();

        // Creates a hashtable containing the word
        Hashtable<Character, Integer> signatures = new Hashtable<Character, Integer>();
        signatures.put('a', 2);
        signatures.put('b', 2);
        signatures.put('c', 2);
        signatures.put('d', 3);
        signatures.put('e', 3);
        signatures.put('f', 3);
        signatures.put('g', 4);
        signatures.put('h', 4);
        signatures.put('i', 4);
        signatures.put('j', 5);
        signatures.put('k', 5);
        signatures.put('l', 5);
        signatures.put('m', 6);
        signatures.put('n', 6);
        signatures.put('o', 6);
        signatures.put('p', 7);
        signatures.put('q', 7);
        signatures.put('r', 7);
        signatures.put('s', 7);
        signatures.put('t', 8);
        signatures.put('u', 8);
        signatures.put('v', 8);
        signatures.put('w', 9);
        signatures.put('x', 9);
        signatures.put('y', 9);
        signatures.put('z', 9);

        // Loops through each letter in the word.
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            // Compares the letter with each case and appends corresponding number to buffer.
            if (signatures.containsKey(letter))
                buffer.append(signatures.get(letter));
            else
                buffer.append(" ");
        }
        // Return the string version of the buffer.
        return buffer.toString();
    }

    public static Set<String> signatureToWords(String signature) {
        // Each time a word is being input, the system has to read through the dictionary line by line.
        // This is obviously hugely inefficient, especially using a Scanner to read the data.
        // A better solution would be to initially store the dictionary in a hash set then continuously refer to the set.

        // Creates a new hash set to store the results.
        Set<String> results = new HashSet<String>();

        // Initialises a new Scanner.
        Scanner filescan = null;

        try {
            filescan = new Scanner(new File("/usr/share/dict/words"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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



