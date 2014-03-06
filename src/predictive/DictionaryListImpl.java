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
    private FileInputStream textFile;
    private BufferedReader readWords;
    private ArrayList<WordSig> dictionary = new ArrayList<WordSig>();

    static {
        // Creates a hashtable containing the word
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

    public DictionaryListImpl() {
        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String word;
            while((word = readWords.readLine()) != null) {
                dictionary.add(new WordSig(word, wordToSignature(word)));
                word = readWords.readLine();
            }
            textFile.close();
        } catch (Exception e) {
            System.out.println("Dictionary file could not be found");
        }
        Collections.sort(dictionary);
    }

    public ArrayList<WordSig> getDictionary() {
        return dictionary;
    }

    public static String wordToSignature(String word) {
        // Using StringBuffer rather than String is a more efficient solution as it allows a single variable to be appended.
        // This therefore means it performs the concatenations much more effectively.

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


    public static Set<String> signatureToWords(String signature) {
        // Creates a new hash set to store the results.
        Set<String> results = new HashSet<String>();

        DictionaryListImpl dictionaryList = new DictionaryListImpl();
        ArrayList<WordSig> dictionary = dictionaryList.getDictionary();

        int result = Collections.binarySearch(dictionary, new WordSig("", signature));
        results.add(dictionary.get(result).getWord());

        return results;
    }
}
