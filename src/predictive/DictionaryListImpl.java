package predictive;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Charles Chambers on 06/03/2014.
 */

public class DictionaryListImpl {

    private static final Hashtable<Character, Integer> signatures = new Hashtable<Character, Integer>();
    private ArrayList<WordSig> dictionary = new ArrayList<WordSig>();

    /**
     * Hash table for signatures initialised in a static initialiser.
     */
    static {
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
    }

    /**
     * Constructor reads words file into an Array List, then is sorted.
     * If words file cannot be found, exception is caught and error message is output.
     */
    public DictionaryListImpl() {
        FileInputStream textFile;
        BufferedReader readWords;

        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String word;
            while ((word = readWords.readLine()) != null) {
                dictionary.add(new WordSig(word, wordToSignature(word)));
            }
            textFile.close();
        } catch (Exception e) {
            System.out.println("Dictionary file could not be found");
        }
        Collections.sort(dictionary);
    }

    /**
     * Returns the array list containing the dictionary.
     *
     * @return
     */
    public ArrayList<WordSig> getDictionary() {
        return dictionary;
    }

    /**
     * Takes in a word and returns the numerical signature for that word.
     *
     * @param word
     * @return
     */
    public String wordToSignature(String word) {
        // Creates new string buffer to hold the signature.
        StringBuffer buffer = new StringBuffer();

        // Converts the word to lower case.
        word = word.toLowerCase();

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


    /**
     * Takes in a numerical signature and returns all possible words matching the numbers.
     *
     * @param signature
     * @return
     */
    public Set<String> signatureToWords(String signature) {
        // Creates a new hash set to store the results.
        Set<String> results = new HashSet<String>();

        int result = Collections.binarySearch(dictionary, new WordSig("", signature));
        //results.add(dictionary.get(result).getWord().toLowerCase());

        results.add(dictionary.get(result).getWord().toLowerCase());

        int x = result;
        int y = result;

        while (dictionary.get(x - 1).getSignature().equals(signature)) {
            results.add(dictionary.get(x - 1).getWord().toLowerCase());
            x--;
        }

        while (dictionary.get(y + 1).getSignature().equals(signature)) {
            results.add(dictionary.get(y + 1).getWord().toLowerCase());
            y++;
        }

        return results;
    }
}
