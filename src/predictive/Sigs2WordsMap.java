package predictive;
import java.util.Set;

// Time whilst executing on just one value, 4663:
// real	0m0.822s

// Time whilst executing on multiple values, 27753 672643 62646 73224 7327 47273.
// real	0m0.816s

/**
 * Created by Charles Chambers on 18/03/2014.
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        Dictionary test = new DictionaryMapImpl();
        for (String curr : args) {
            Set<String> results = test.signatureToWords(curr);
            System.out.println(curr + ": " + results);
        }
    }
}