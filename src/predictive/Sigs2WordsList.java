package predictive;
import java.util.Set;

// Time whilst executing on just one value, 4663:
// real	0m1.274s

// Time whilst executing on multiple values, 27753 672643 62646 73224 7327 47273.
// real	0m1.391s

public class Sigs2WordsList {
    public static void main(String[] args){
        DictionaryListImpl test = new DictionaryListImpl();
        for (String curr: args) {
            Set<String> results = test.signatureToWords(curr);
            System.out.println(curr + ": " + results);
        }
    }
}
