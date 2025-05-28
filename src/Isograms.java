//import java.util.Arrays;

/*
LEVEL: 7kyu

An isogram is a word that has no repeating letters, consecutive or non-consecutive. Implement a function that determines whether a string that contains only letters is an isogram. Assume the empty string is an isogram. Ignore letter case.

String isogram1 = "Dermatoglyphics"; // true
String isogram2 = "moose"; // false
String isogram3 = "moOse"; // false
String isogram4 = ""; // true

 */
public class Isograms {
    public static boolean isIsogram(String str) {
//        return Arrays.stream(str.split("")).map(String::toLowerCase).distinct().count() == str.length() || str.isEmpty();
        return str.chars().map(Character::toLowerCase).distinct().count() == str.length();
    }
    public static void main(String[] args) {
        String isogram1 = "Dermatoglyphics";
        System.out.println(Isograms.isIsogram(isogram1));
    }
}
