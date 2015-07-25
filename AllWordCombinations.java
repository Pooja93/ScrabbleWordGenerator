import java.util.*;

class AllWordCombinations{
	
	public ArrayList<String> generateAllCombinationsOfWords(String input) {
		char[] inputArray = input.toCharArray();
		Arrays.sort(inputArray);
		ArrayList<String> output = new ArrayList<String>();

		for(int i = 2; i <= inputArray.length; i++) {
			char[] data = new char[i];
			combinationUtil(inputArray, data, 0, inputArray.length - 1, 0, i, output);
		}
		return output;
	}
	
	private void combinationUtil(char[] arr, char[] data, int start, int end, int index, int r, ArrayList<String> listOfWords) {
		if (index == r) {
			listOfWords.add(new String(data));
			return;
		}

		for (int i=start; i<=end && end-i+1 >= r-index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i+1, end, index+1, r, listOfWords);
		}
	}

}