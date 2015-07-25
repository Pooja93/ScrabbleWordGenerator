/**
 * Created by test on 7/25/2015.
 */
public class AlphabetWeights {

    public static int alphabetWeights[] = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};

    public static int getWeight(char letter) {

        return alphabetWeights[letter -'a'];
    }

    public static int [] getAllAlphabetWeights() {
        return alphabetWeights;
    }

}
