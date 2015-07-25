/**
 * Created by test on 7/25/2015.
 */
public class WordScore {

    public static int getWordScore(String word, String rackAlphabets) {
        char [] presentLetters = rackAlphabets.toCharArray();

        int score = 0;
        for (int i=0; i< presentLetters.length; i++) {
            if (presentLetters[i]!=' ' && word.contains(Character.toString(presentLetters[i])) ) {
                score += AlphabetWeights.getWeight(presentLetters[i]);
            }
        }
        return score;
    }

}
