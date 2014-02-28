/**
 * Created by Charles Chambers on 27/02/2014.
 */

package test;

import org.testng.annotations.Test;
import predictive.PredictivePrototype;

import static org.testng.Assert.assertEquals;


public class PredictivePrototypeTest {

    @Test
    public void wordToSignatureTest(){
        assertEquals(PredictivePrototype.wordToSignature("testing"), "8378464");
        assertEquals(PredictivePrototype.wordToSignature("test^_@i&n(g"), "8378   4 6 4");
    }

    @Test
    public void signatureToWordsTest(){
        assertEquals(PredictivePrototype.signatureToWords("8378464").toString(), "[vestini, vesting, testing]");
        assertEquals(PredictivePrototype.signatureToWords("7839273377").toString(), "[stewardess]");
        assertEquals(PredictivePrototype.signatureToWords("123456789").toString(), "[]");
    }
}
