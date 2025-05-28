import java.util.HashSet;
import java.util.Set;


/*
LEVEL: 6kyu

A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation

Examples:

String pangram1 = "The quick brown fox jumps over the lazy dog." // true
String pangram2 = ""You shall not pass!"" // false

*/

public class DetectPangram {
    public boolean check(String sentence) {
        Set<Character> setwords = new HashSet<>();
        for(char c : sentence.toCharArray()){
            if(Character.isLetter(c)){
                setwords.add(Character.toLowerCase(c));
            }
        }
        return setwords.size() == 26; // 27 in spanish
    }
    public static void main(String[] args) {
        String pangram1 = "The quick brown fox jumps over the lazy dog.";
        String pangram2 = "You shall not pass!";
        DetectPangram dp = new DetectPangram();
        System.out.println(dp.check(pangram1));
        boolean result2 = dp.check(pangram2);
        System.out.println(result2);
    }
}
