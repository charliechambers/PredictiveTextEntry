package predictive;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Charles Chambers on 15/03/2014.
 */
public class DictionaryMapImpl implements Dictionary {

    private static final Hashtable<Character, Integer> charsigs = new Hashtable<Character, Integer>();
    private Map<String, Set<String>> dictionary = new HashMap<String, Set<String>>();

    // TESTING SVN
    static {
        charsigs.put('a', 2);
        charsigs.put('b', 2);
        charsigs.put('c', 2);
        charsigs.put('d', 3);
        charsigs.put('e', 3);
        charsigs.put('f', 3);
        charsigs.put('g', 4);
        charsigs.put('h', 4);
        charsigs.put('i', 4);
        charsigs.put('j', 5);
        charsigs.put('k', 5);
        charsigs.put('l', 5);
        charsigs.put('m', 6);
        charsigs.put('n', 6);
        charsigs.put('o', 6);
        charsigs.put('p', 7);
        charsigs.put('q', 7);
        charsigs.put('r', 7);
        charsigs.put('s', 7);
        charsigs.put('t', 8);
        charsigs.put('u', 8);
        charsigs.put('v', 8);
        charsigs.put('w', 9);
        charsigs.put('x', 9);
        charsigs.put('y', 9);
        charsigs.put('z', 9);
    }

    public DictionaryMapImpl() {
        FileInputStream textFile;
        BufferedReader readWords;
        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String word;
            String prev = null;
            Set<String> current = new HashSet<String>();
            while ((word = readWords.readLine()) != null) {
                if (wordToSignature(word).equals(prev)){
                    current.add(word);
                }
                else{
                    dictionary.put(wordToSignature(word), current);
                    current.clear();
                }
            }
            textFile.close();


        } catch (Exception e) {
            System.out.println("Dictionary file could not be found");
        }
    }

    /**
     * Takes in a word and returns the numerical signature for that word.
     *
     * @param word
     * @return
     */
    @Override
    public String wordToSignature(String word) {
        // Creates new string buffer to hold the signature.
        StringBuffer buffer = new StringBuffer();

        // Converts the word to lower case.
        word = word.toLowerCase();

        // Loops through each letter in the word.
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            // Compares the letter with each case and appends corresponding number to buffer.
            if (charsigs.containsKey(letter))
                buffer.append(charsigs.get(letter));
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
    @Override
    public Set<String> signatureToWords(String signature) {
        return dictionary.get(signature);
    }
}
