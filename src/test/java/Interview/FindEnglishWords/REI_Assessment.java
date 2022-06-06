package Interview.FindEnglishWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class REI_Assessment {

    public static void main(String[] args) throws IOException {

        // 2. I used Scanner method to have input from a user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter letters");
        String letters = scanner.nextLine().toLowerCase();
        // the user will put letters and it will be stored in "letters" variable.
        // toLowerCase() -> because the words in text are in lower case, so whatever the user puts, it shows lower case



        /*
        count how many letters in "aabrt"?
        a -> 2, b -> 1, r -> 1, t -> 1

        and compare "aabrt" to "aardvark"
        a -> 3, r -> 2, d -> 1, v -> 1, k -> 1
         */


        // 4. I created "lettersCountMap" which is equals to
        //  getCharacterCountMap of letters from private access-modifier.
        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        // 1. I added BufferedReader method
        BufferedReader reader = new BufferedReader(new FileReader("/Applications/IntelliJ IDEA CE.app/REI_Interview_Test/src/test/java/Interview/FindEnglishWords/utilities/EnglishWordList"));
        // use BufferReader to read the file of English word list
        // I added "IOException" to avoid error

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            // it reads the very first line of code and put it into "currentWord" variable.
            // currentWord is not equal to null -> if a line in currentWord turns out to null, then it is not a line anymore.
            //  keep reads it while currentWord is not equal to null.
            // Iterate the next line, currentWord equals to reader.readLine.

            // 5. I created currentWordMap and stored "getCharacterCountMap of currentWord" in it
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);

            // added boolean to check if it breaks the loop or not.
            boolean canMakeCurrentWord = true;
            // this for loop will loop the key set of words, the key set will get the key (character) and
            //   value (the counted loop number)
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ?
                                       lettersCountMap.get(character) : 0;
                // lettersCharCount equals to lettersCountMap. If lettersCountMap contains key of current character,
                // then you will get current value (character). If it doesn't have the key, the value is 0.

                // compare the 2 ints:
                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                    // if current words need more letters than available letters now, then you have to break the loop.
                }
            }

            // 6. if you can make the current word (if the boolean is true), print current word:
            if (canMakeCurrentWord) {
                System.out.println(currentWord);
            }
        }


        /*
        Map<Character, Integer> lettersCountMap = new HashMap<Character, Integer>();
        // map a Character to an Integer

        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);
            // currentChar will get the character at 0 position in String, i. (i can be "M"" like "ME" for example)

            // count for the current letter
            int count = lettersCountMap.containsKey(currentChar) ?
                    lettersCountMap.get(currentChar) : 0;
            // if lettersCountMap contains the key of the currentChar, then lettersCountMap will get currentChar,
            // and it will count the character. Otherwise, it will be 0. Ex: aabbe -> on the first loop, it counts first
            // a -> 0 because a is the first one. Second a -> count it because there is first a.

            // Then add the character to Map:
            lettersCountMap.put(currentChar, count + 1);
            // the first a of "aabbe" is counted as 1 -> (a,0 + 1) -> (a, 1)
            // second a is counted as 2 -> (a,1 + 1) -> (a, 2)

        }
         */

        }


        // 3. I created private access-modifier to store for loop which loops letters and count. (alt + command + m)
    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<Character, Integer>();
        // map a Character to an Integer

        for (int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);
            // currentChar will get the character at 0 position in String, i. (i can be "M"" like "ME" for example)

            // count for the current letter
            int count = lettersCountMap.containsKey(currentChar) ?
                    lettersCountMap.get(currentChar) : 0;
            // if lettersCountMap contains the key of the currentChar, then lettersCountMap will get currentChar,
            // and it will count the character. Otherwise, it will be 0. Ex: aabbe -> on the first loop, it counts first
            // a -> 0 because a is the first one. Second a -> count it because there is first a.

            // Then add the character to Map:
            lettersCountMap.put(currentChar, count + 1);
            // the first a of "aabbe" is counted as 1 -> (a,0 + 1) -> (a, 1)
            // second a is counted as 2 -> (a,1 + 1) -> (a, 2)

        }
        return lettersCountMap;
    }



    }

