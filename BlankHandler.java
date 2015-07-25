import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 7/24/2015.
 */
public class BlankHandler {
    Map<Integer, String> wordWeights = new HashMap<Integer, String>();
    String rackAlphabets;
    Map<String, String> scrabbleWords = new HashMap<String, String>();

    BlankHandler(String rackAlphabets, Map<String, String> scrabbleWords) {
        this.rackAlphabets = rackAlphabets;
        this.scrabbleWords = scrabbleWords;
    }

    BlankHandler(){};

    public Map<Integer, String> getWordScoreMap() {

        ArrayList<String> blankReplacedWords = ReplaceBlanks.getBlankReplacedWords(rackAlphabets);
        AllWordCombinations allCombinations = new AllWordCombinations();

        for(String blankReplacedWord: blankReplacedWords) {
            ArrayList<String> allPossibeWords = allCombinations.generateAllCombinationsOfWords(blankReplacedWord);

            for (String word: allPossibeWords) {
                String sortedWord = sortString(word);
                int score = WordScore.getWordScore(sortedWord, rackAlphabets);

                if(scrabbleWords.containsKey(sortedWord)) {
                    String [] anagramOfWord = scrabbleWords.get(sortedWord).split(" ");

                    for(String anagram: anagramOfWord) {
                        if(wordWeights.containsKey(score)) {
                            if(!containsWord(wordWeights.get(score),anagram))
                                wordWeights.put(score, (wordWeights.get(score))+ " " +anagram);
                        } else {
                            wordWeights.put(score, anagram);
                        }
                    }

                }
            }

        }

        return wordWeights;
    }

    private String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return  new String(chars);

    }

    private static boolean containsWord(String sameWeightWords, String comparionWord){

        boolean result=false;

        if(sameWeightWords!=null)
        {
            String [] words = sameWeightWords.split(" ");

            for(String word: words) {
                if (comparionWord.trim().equals(word.trim())) {
                    return true;
                }
            }
        }
        return result;

    }

    //For Testing
    public static void main(String args[]) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("ad", "a d ad");
        map.put("abd", "adb");
        map.put("ads", "sad das");
        map.put("ade", "aed");
        map.put("adm", "random");
        BlankHandler bl = new BlankHandler("a dm", map);
        Map<Integer, String> output = bl.getWordScoreMap();

        for(Integer i: output.keySet()) {
            System.out.println(i+" ------ "+ output.get(i));
        }
    }
}
