package predictive;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Charles Chambers on 06/03/2014.
 */
public class DictionaryListImpl {

    private FileInputStream textFile;
    private BufferedReader readWords;
    private ArrayList<WordSig> arrayWordList = new ArrayList<WordSig>();


    public DictionaryListImpl() {
        try {
            textFile = new FileInputStream("/usr/share/dict/words");
            readWords = new BufferedReader(new InputStreamReader(textFile));
            String line = readWords.readLine();
            while (line != null) {
                arrayWordList.add(new WordSig(line));
                line = readWords.readLine();
            }
            textFile.close();
        } catch (Exception e) {
            System.out.println("SHIT!");
        }
    }

    public static void main(String[] args) {
        DictionaryListImpl test = new DictionaryListImpl();
        Collections.sort(test.arrayWordList);
        for (WordSig trial : test.arrayWordList) {
            System.out.println(trial.toString());
        }
    }
}
