package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import predictive.DictionaryTreeImpl;

import static org.testng.AssertJUnit.assertEquals;


public class DictionaryTreeImplTest {
    DictionaryTreeImpl test;

    @BeforeMethod
    public void setUp() {
        test = new DictionaryTreeImpl("/usr/share/dict/words");
    }

    @Test
    public void wordToSignatureTest(){
        //assertEquals(test.wordToSignature("testing"), "8378464");
        //assertEquals(test.wordToSignature("test^_@i&n(g"), "8378   4 6 4");
    }

    @Test
    public void signatureToWordsTest(){
        assertEquals(test.signatureToWords("43").toString(), "[vestini, vesting, testing]");
        //assertEquals(test.signatureToWords("8378464").toString(), "[vestini, vesting, testing]");
        //assertEquals(test.signatureToWords("7839273377").toString(), "[stewardess]");
    }
}