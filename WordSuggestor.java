import java.util.*;
import java.io.*;

public class WordSuggestor {

	public static void getWords(String rackWords, String constraint){
Map<Integer, String> bestWords;
		
		ScrabbleWords scrabbleWords = new ScrabbleWords("src/sowpods.txt");
		Map<String, String> anagrams = scrabbleWords.getAnagrams();
		Map<Integer, String> wordScoreMap;
		
		if(rackWords.contains(" ")) {
			BlankHandler blankHandler = new BlankHandler(rackWords, anagrams);
			wordScoreMap = blankHandler.getWordScoreMap();
			bestWords = new TreeMap<Integer, String>(wordScoreMap);
			
		
		}
		else{
			AllWordCombinations allWordCombinations = new AllWordCombinations();
			WordScore wordScore = new WordScore();
			bestWords = new TreeMap<Integer, String>();
			
			ArrayList<String> wordCombinations = allWordCombinations.generateAllCombinationsOfWords(rackWords);
			for(String eachWord : wordCombinations) {
				if(scrabbleWords.validAnagramPresent(eachWord))
				{
					int score = wordScore.getWordScore(eachWord);
					if (bestWords.containsKey(score)) {
						bestWords.put(score, bestWords.get(score) + " " + scrabbleWords.getValidAnagrams(eachWord));
					}
					else {
						bestWords.put(score, scrabbleWords.getValidAnagrams(eachWord));
					}
				}
			}
		}
		if(constraint != null){
			bestWords = PositionalConstraintChecker.ConstraintChecker(new TreeMap<Integer, String>(bestWords), constraint);
		}
		for(Integer i: bestWords.keySet()) {
            System.out.println(i+" --"+ bestWords.get(i));
        }

	}
	 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("GIVE INPUT  \n");
		String rackWords = input.nextLine();
		System.out.print("If any constraint, input in format letter followed by position without space");
		String constraint = input.nextLine();
		
		for(int i=0;i<constraint.length();i+=2){
			rackWords = rackWords + constraint.charAt(i);
		}
		
		getWords(rackWords, constraint);
        input.close();
	}

}
