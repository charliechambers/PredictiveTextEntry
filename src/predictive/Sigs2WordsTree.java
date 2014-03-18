package predictive;

import java.util.Set;

/**
 * Created by Charles Chambers on 18/03/2014.
 */
public class Sigs2WordsTree {
    public static void main(String[] args) {
        Dictionary test = new DictionaryTreeImpl("/usr/share/dict/words");
        for (String curr : args) {
            Set<String> results = test.signatureToWords(curr);
            System.out.println(curr + ": " + results);
        }
    }
}