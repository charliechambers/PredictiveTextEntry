package predictive;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Charles Chambers on 15/03/2014.
 */
public class DictionaryMapImpl implements Dictionary {

    private static final Hashtable<Character, Integer> signatures = new Hashtable<Character, Integer>();
    private Map<BigInteger, Set<String>> dictionary = new HashMap<BigInteger, Set<String>>();

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

    public DictionaryMapImpl() {
        FileInputStream textFile;
        BufferedReader readWords;
        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String word;
            Set<String> current;
            while ((word = readWords.readLine()) != null) {
                word = word.toLowerCase();
                if(word.matches("[a-z]+")){
                    BigInteger signature = new BigInteger(wordToSignature(word));
                    if(dictionary.get(signature) == null) {
                        current = new HashSet<String>();
                    } else {
                        current = dictionary.get(signature);
                    }
                    current.add(word.toLowerCase());
                    dictionary.put(signature, current);
                }
            }
            textFile.close();
        } catch (Exception e) {
            e.printStackTrace();
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
    @Override
    public Set<String> signatureToWords(String signature) {
        BigInteger sig = new BigInteger(signature);
        return dictionary.get(sig);
    }
}
