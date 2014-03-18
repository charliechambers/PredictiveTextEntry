package predictive;

/**
 * Created by Charles Chambers on 06/03/2014.
 */
public class WordSig implements Comparable<WordSig> {

    private String signature;
    private String word;

    public WordSig(String word, String signature) {
        this.word = word;
        this.signature = signature;
    }

    public String getWord() {
        return word;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "WordSig{" + "word ='" + word + '\'' + ", signature ='" + signature + '\'' + '}';
    }

    @Override
    public int compareTo(WordSig wordSig) {
        if (signature.length() < wordSig.getSignature().length()) {
            return -1;
        } else if (signature.length() > wordSig.getSignature().length()) {
            return 1;
        } else {
            for (int i = 0; i < signature.length(); i++) {
                char current = signature.charAt(i);
                char test = wordSig.getSignature().charAt(i);
                if (current < test) {
                    return -1;
                }
                if (current > test) {
                    return 1;
                }
            }
        }
        return 0;
    }
}

