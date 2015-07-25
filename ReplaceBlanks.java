import java.util.ArrayList;

/**
 * Created by test on 7/25/2015.
 */
public class ReplaceBlanks {

    public static ArrayList<String> blankReplacedWords = new ArrayList<String>();

    public static void replaceBlanks(String rackAlphabets) {

        if(rackAlphabets.contains(" ")) {
            for(char i='a'; i<='z'; i++) {
                String modifiedWord = rackAlphabets.replaceFirst(" ", Character.toString(i));
                blankReplacedWords.add(modifiedWord);
                if(modifiedWord.contains(" ")) {
                    blankReplacedWords.remove(modifiedWord);
                    replaceBlanks(modifiedWord);
                }
            }
        }
    }

    public static ArrayList<String> getBlankReplacedWords(String word) {
        replaceBlanks(word);
        return blankReplacedWords;
    }
}
