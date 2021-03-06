package test;

import org.testng.annotations.Test;
import predictive.DictionaryTreeImpl;

import static org.testng.Assert.assertEquals;


public class DictionaryTreeImplTest {
    DictionaryTreeImpl test = new DictionaryTreeImpl("/usr/share/dict/words");

    @Test
    public void wordToSignatureTest(){
        assertEquals(test.wordToSignature("testing"), "8378464");
        assertEquals(test.wordToSignature("test^_@i&n(g"), "8378   4 6 4");
    }

    @Test
    public void signatureToWordsTest(){
        assertEquals(test.signatureToWords("8378464").toString(), "[vestini, vesting, testing]");
        assertEquals(test.signatureToWords("7839273377").toString(), "[stewardess]");
        assertEquals(test.signatureToWords("43556").toString(), "[hello, helln, gekko]");
        assertEquals(test.signatureToWords("435").toString(), "[hek, hel, hej, gel, gek, idl]");
    }
}