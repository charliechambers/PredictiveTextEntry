package predictive;

public class Words2SigsProto {

    public static void main(String[] args) {
        for (String curr: args) {
        	System.out.println(curr + ": " + PredictivePrototype.wordToSignature(curr));
        }
        
    }
}
