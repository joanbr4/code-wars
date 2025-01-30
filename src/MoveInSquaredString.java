import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
LEVEL: 6Kuy

You are given a string of n lines, each substring being n characters long:

String s = "abcd\nefgh\nijkl\nmnop"

Symmetry with respect to the main diagonal:
diag_1_sym(s) => "aeim\nbfjn\ncgko\ndhlp"

Clockwise rotation 90 degrees:
rot_90_clock(s) => "miea\nnjfb\nokgc\nplhd"

Selfie and diag1: It is initial string + string obtained by symmetry with respect to the main diagonal.
selfie_and_diag1(s) => "abcd|aeim\nefgh|bfjn\nijkl|cgko\nmnop|dhlp"

* */
public class MoveInSquaredString {
        public static String diag1Sym(String strng) {
            List<String> finalArray = new ArrayList<>();
            String[] splitArray = strng.split("\\n");//
            for(String word: splitArray){
                for(int j = 0; j < word.length(); j++){
                    if (j >= finalArray.size()) {
                        finalArray.add("");
                    }
                finalArray.set(j, finalArray.get(j) + word.charAt(j));
            }}
            return String.join("\n", finalArray);
        }
        public static String rot90Clock(String strng) {
            String[] splitArray = strng.split("\\n");
            String[] finalArray = new String[splitArray.length];
            Arrays.fill(finalArray, "");
            for(int i = splitArray.length -1; i >= 0; i--){
                for(int j = splitArray[i].length() -1; j >= 0; j--){
                    finalArray[j] = finalArray[j]+ splitArray[i].charAt(j);
                }}
            return String.join("\n", finalArray);
        }
        public static String selfieAndDiag1(String strng) {
            String[] splitArray = strng.split("\\n");
            String[] finalArray = new String[splitArray.length];
            Arrays.fill(finalArray, "");
            for (String string : splitArray) {
                for (int j = 0; j < string.length(); j++) {
                    finalArray[j] = finalArray[j] + string.charAt(j);
                }
            }
            for(int i = 0; i< finalArray.length;i++){
                finalArray[i] = splitArray[i] + "|"+finalArray[i];
            }
           return String.join("\n", finalArray);
        }
        public static String oper(Function<String, String> operator, String s) {
            return operator.apply(s);
        }

    public static void main(String[] args) {
        String strdiag = MoveInSquaredString.oper(MoveInSquaredString::diag1Sym, "rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb") ;
        String strRot = MoveInSquaredString.oper(MoveInSquaredString::rot90Clock, "rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb") ;
        String strSelf = MoveInSquaredString.oper(MoveInSquaredString::selfieAndDiag1, "rgavce\nvGcEKl\ndChZVW\nxNWgXR\niJBYDO\nSdmEKb") ;
        System.out.println(strdiag);
        System.out.println("-------");
        System.out.println(strRot);
        System.out.println("-------");
        System.out.println(strSelf);
    }
}
