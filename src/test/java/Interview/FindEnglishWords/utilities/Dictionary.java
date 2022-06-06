package Interview.FindEnglishWords.utilities;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    private Dictionary_Info EngWordList;

    public void setDictionary_Info(Dictionary_Info EngWordList){
        this.EngWordList = EngWordList;
    }

    public List<String> useDictionary(){
        return EngWordList.useDictionary();
    }

    public boolean isEnglishWord(String word){
        return EngWordList.isEnglishWord(word);
    }


    /*
    Select words that you want to use from dictionary and put it into lower case
     */
    public List<String> selectWords(String select) {
        ArrayList<String> works = new ArrayList<String>();
        List<String> dictionary = useDictionary();
        select = select.toLowerCase();

        // use for loop to compare each character
        for (String character: dictionary){

            // check with boolean
            Boolean doesNotMatch = true;

            for (char EachCharacter : character.toCharArray()){
                String eachOne = Character.toString(EachCharacter);

                if (character.length() - character.replace(eachOne, "").length()
                        != select.length() - select.replace(eachOne, "").length()){
                    doesNotMatch = false;
                    break;
                }
            }
            if (doesNotMatch){
                works.add(character);
            }
        }
        System.out.println(works);
        return works;
    }


}
