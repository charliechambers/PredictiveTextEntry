package predictive;

import java.util.*;

/**
 * Created by Charles Chambers on 06/03/2014.
 */

public interface Dictionary {


    /**
     * Returns the array list containing the dictionary.
     *
     * @return
     */
    ArrayList<WordSig> getDictionary();

    /**
     * Takes in a word and returns the numerical signature for that word.
     *
     * @param word
     * @return
     */
    String wordToSignature(String word);


    /**
     * Takes in a numerical signature and returns all possible words matching the numbers.
     *
     * @param signature
     * @return
     */
    Set<String> signatureToWords(String signature);
}
