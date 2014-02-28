package predictive;
import java.util.Set;

public class Sigs2WordsProto {

    public static void main(String[] args){
    	for (String curr: args) {
            Set<String> results = PredictivePrototype.signatureToWords(curr);
        	System.out.println(curr + ": " + results.toString());
        }
    }

}
