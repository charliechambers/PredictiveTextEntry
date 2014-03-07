package predictive;
import java.util.Set;

public class Sigs2WordsList {
    public static void main(String[] args){
        DictionaryListImpl test = new DictionaryListImpl();
        for (String curr: args) {
            Set<String> results = test.signatureToWords(curr);
            System.out.println(curr + ": " + results);
        }
    }
}
