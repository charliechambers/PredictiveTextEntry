package test;

import org.testng.annotations.Test;
import predictive.DictionaryListImpl;

import static org.testng.Assert.assertEquals;


public class DictionaryListImplTest {
    DictionaryListImpl test = new DictionaryListImpl();

    @Test
    public void wordToSignatureTest(){
        assertEquals(test.wordToSignature("testing"), "8378464");
        assertEquals(test.wordToSignature("test^_@i&n(g"), "8378   4 6 4");
    }

    @Test
    public void signatureToWordsTest(){
        assertEquals(test.signatureToWords("8378464").toString(), "[vestini, vesting, testing]");
        assertEquals(test.signatureToWords("7839273377").toString(), "[stewardess]");
    }
}
