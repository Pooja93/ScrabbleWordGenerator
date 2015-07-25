import java.util.*;

class AllWordCombinations{
	
	public ArrayList<String> generateAllCombinationsOfWords(String word) {
		char[] lettersArray = input.toCharArray();
		Arrays.sort(lettersArray);
		ArrayList<String> possibleCombinations = new ArrayList<String>();

		for(int i = 2; i <= lettersArray.length; i++) {
			char[] letter = new char[i];
			combinationUtil(lettersArray, letter, 0, lettersArray.length - 1, 0, i, possibleCombinations);
		}
		return possibleCombinations;
	}
	
	private void combinationUtil(char[] array, char[] data, int start, int end, int index, int combinationSize, ArrayList<String> listOfWords) {
		if (index == combinationSize) {
			listOfWords.add(new String(data));
			return;
		}

		for (int i=start; i<=end && end-i+1 >= combinationSize-index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, combinationSize, listOfWords);
		}
	}

}