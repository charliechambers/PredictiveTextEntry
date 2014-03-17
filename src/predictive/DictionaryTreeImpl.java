package predictive;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Charles Chambers on 16/03/2014.
 */
public class DictionaryTreeImpl {

    private Set<String> possibleWords = new HashSet<String>();

    public DictionaryTreeImpl(String signature, Set<String> words) {
        if (signature.substring(0).equals("2")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[a-c]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl two = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("3")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[d-f]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl three = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("4")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[g-i]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl four = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("5")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[j-l]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl five = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("6")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[m-o]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl six = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("7")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[p-s]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl seven = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("8")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[t-v]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl eight = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

        if (signature.substring(0).equals("9")){
            for (String word : words) {
                if (word.substring(0, 1).matches("[w-z]")) {
                    possibleWords.add(word);
                }
            }
            DictionaryTreeImpl nine = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
        }

    }

}
