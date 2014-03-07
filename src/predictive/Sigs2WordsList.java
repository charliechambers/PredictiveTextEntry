package predictive;
import java.util.Set;

public class Sigs2WordsList {
    private static DictionaryListImpl test = new DictionaryListImpl();
    public static void main(String[] args){
        for (String curr: args) {
            Set<String> results = test.signatureToWords(curr);
            System.out.println(curr + ": " + results.toString());
        }
    }
}
