package Interview.FindEnglishWords.runners;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import Interview.FindEnglishWords.utilities.Dictionary;
import Interview.FindEnglishWords.utilities.Dictionary_Info;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DictionaryRunner {
    private Dictionary dictionary;
    private Dictionary_Info EngWordList;
    List<String> wordsInList;

    @Before
    public void setup(){
        dictionary = new Dictionary();
        EngWordList = mock(Dictionary_Info.class);
        // this is mocked dictionary

        when(EngWordList.useDictionary()).thenReturn(DictionaryArray());
        wordsInList = EngWordList.useDictionary();
    }

    /*
    create String list based on the Dictionary file (EnglishWords in this case) to mock the dictionary service
     */
    static List<String> DictionaryArray(){
        List<String> wordList = new ArrayList<String>();
        BufferedReader reader;

        try {
            ClassLoader loader = DictionaryRunner.class.getClassLoader();
            File file = new File(loader.getResource("EnglishWordList").getFile());
            reader = new BufferedReader(new FileReader(file));
            String str = reader.readLine();
            while (str != null){
                wordList.add(str);
                str = reader.readLine();
                // read next line
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    /*
    Validate if given word exists in the dictionary (EnglishWords in this case) to mock the isEnglishWord function
     */
    public boolean English(String word) {
        for (String eachOne : wordsInList) {
            if (eachOne.equals(word.toLowerCase())) {
                System.out.println(word + " is valid");
                return true;
            }
        }
        return false;
    }

    @Test
    public void testWorking(){
        when(EngWordList.isEnglishWord("WORKING")).thenReturn(English("WORKING"));
        Assert.assertTrue(dictionary.isEnglishWord("WORKING"));
    }

    @Test
    public void testMe(){
        when(EngWordList.isEnglishWord("ME")).thenReturn(English("ME"));
        Assert.assertTrue(dictionary.isEnglishWord("ME"));
        Assert.assertEquals(Arrays.asList("m", "me", "e", "em"), (dictionary.selectWords("ME")));
    }

    @Test
    public void testHome(){
        when(EngWordList.isEnglishWord("HOME")).thenReturn(English("HOME"));
        Assert.assertTrue(dictionary.isEnglishWord("HOME"));
    }


}
