import java.io.*;
import java.util.*;

public class ScrabbleWords {

	private Map<String, String> map = new HashMap<String, String>();
	
	public ScrabbleWords(String file) {
		constructMapFromFile(file);
	}
	
	public boolean validAnagramPresent(String sortedWord) {
		return map.containsKey(sortedWord);
	}
	
	public String getValidAnagrams(String sortedWord) {
		if ( validAnagramPresent(sortedWord))
		{
			return map.get(sortedWord);
		}	
		else {
			return null;
		}
	} 
	
	private void constructMapFromFile(String path){
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(path));
            while ((sCurrentLine = br.readLine()) != null) {
                this.addToHash(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
	
	private void addToHash(String word){
        String sortedWord = sortString(word);
        if (map.containsKey(sortedWord)) {
            map.put(sortedWord, map.get(sortedWord) + " " + word);
        } else {
            map.put(sortedWord, word);
        }
    }
	
	private String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return  new String(chars);
        
    }
	
	public static void main(String[] args)
	{
		ScrabbleWords s = new ScrabbleWords("input5.txt");
		System.out.println(s.getValidAnagrams("dorsw"));
	}
}