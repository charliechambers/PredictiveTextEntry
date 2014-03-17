package predictive;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Charles Chambers on 16/03/2014.
 */
public class DictionaryTreeImpl {

    private Set<String> possibleWords = new HashSet<String>();
    private String signature;
    private Set<String> words;

    public DictionaryTreeImpl(String signature) {
        FileInputStream textFile;
        BufferedReader readWords;
        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String word;
            while ((word = readWords.readLine()) != null) {
                words.add(word);
            }
            textFile.close();
        } catch (Exception e) {
            System.out.println("Dictionary file could not be found");
        }
        new DictionaryTreeImpl(signature, words);
    }

    public DictionaryTreeImpl(String signature, Set<String> words) {
        this.signature = signature;
        this.words = words;
    }


    public Set<String> signatureToWordsHelper() {
        if (signature.substring(0).equals("2")) {
            for (String word : words) {
                if (word.substring(0, 1).matches("[a-c]")) {
                    possibleWords.add(word);
                }
            }
            if (signature.length() == 1) {
                return possibleWords;
            } else {
                DictionaryTreeImpl two = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                two.signatureToWordsHelper();
            }


            if (signature.substring(0).equals("3")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[d-f]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl three = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    three.signatureToWordsHelper();
                }
            }


            if (signature.substring(0).equals("4")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[g-i]")) {
                        possibleWords.add(word);
                    }
                }
                DictionaryTreeImpl four = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                four.signatureToWordsHelper();
            }


            if (signature.substring(0).equals("5")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[j-l]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl five = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    five.signatureToWordsHelper();
                }
            }


            if (signature.substring(0).equals("6")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[m-o]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl six = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    six.signatureToWordsHelper();
                }
            }


            if (signature.substring(0).equals("7")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[p-s]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl seven = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    seven.signatureToWordsHelper();
                }
            }


            if (signature.substring(0).equals("8")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[t-v]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl eight = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    eight.signatureToWordsHelper();
                }
            }


            if (signature.substring(0).equals("9")) {
                for (String word : words) {
                    if (word.substring(0, 1).matches("[w-z]")) {
                        possibleWords.add(word);
                    }
                }
                if (signature.length() == 1) {
                    return possibleWords;
                } else {
                    DictionaryTreeImpl nine = new DictionaryTreeImpl(signature.substring(1, signature.length()), possibleWords);
                    nine.signatureToWordsHelper();
                }
            }
        }
        return new HashSet<String>();
    }
}
