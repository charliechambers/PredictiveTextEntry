package predictive;
import java.util.Set;

// Time whilst executing on just one value, 4663:
// real	0m1.316s

// Time whilst executing on multiple values, 27753 672643 62646 73224 7327 47273.
// real	0m5.866s

public class Sigs2WordsProto {
    public static void main(String[] args){
    	for (String curr: args) {
            Set<String> results = PredictivePrototype.signatureToWords(curr);
        	System.out.println(curr + ": " + results);
        }
    }

}
