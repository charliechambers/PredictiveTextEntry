package test;

import org.testng.annotations.Test;
import predictive.DictionaryListImpl;

import static org.testng.Assert.assertEquals;


public class DictionaryListImplTest {

    @Test
    public void wordToSignatureTest(){
        assertEquals(DictionaryListImpl.wordToSignature("testing"), "8378464");
        assertEquals(DictionaryListImpl.wordToSignature("test^_@i&n(g"), "8378   4 6 4");
    }

    @Test
    public void signatureToWordsTest(){
        assertEquals(DictionaryListImpl.signatureToWords("8378464").toString(), "[vestini, vesting, testing]");
        assertEquals(DictionaryListImpl.signatureToWords("7839273377").toString(), "[stewardess]");
    }
}
