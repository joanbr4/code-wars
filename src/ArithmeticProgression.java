import java.util.Arrays;

/*
LEVEL: 6kyu

In this Kata, you are given a serial number with corrupt number, detected and restore its right pattern


*/
public class ArithmeticProgression {
    public static int[] fixPattern(int[] sequence){
        int indexCorrruptNumber = 0;
        int spaceNumber= -99;
        for(int i =0; i< sequence.length; i++){
            if(i > 0 && sequence[i-1]> sequence[i]) {
                if(sequence[i+1] > sequence[i]){
                    int finalDiff = sequence[sequence.length-1] - sequence[sequence.length -2];
                    int initalDiff = sequence[i] - sequence[i-1];
                    spaceNumber = initalDiff == finalDiff? initalDiff : sequence[i+1] -sequence[i];
                    indexCorrruptNumber = i-1;
                    break;
                }
                int initalDiff = sequence[i] - sequence[i-1];
                int finalDiff = sequence[sequence.length-1] - sequence[sequence.length -2];
                if(i == sequence.length -1) break;
                if(spaceNumber == - 99 && sequence[i]+ initalDiff == sequence[i+1]){
                    spaceNumber = initalDiff;
                }
                else if(spaceNumber == - 99 && sequence[i]+ initalDiff != sequence[i+1]){
                    int postNumber = sequence[i+1] - sequence[i];
                    int centerNumber = (sequence[i+1] - sequence[i-1]) /2;
                    spaceNumber = centerNumber == finalDiff ? centerNumber : initalDiff == finalDiff ? initalDiff : postNumber;
                    indexCorrruptNumber = spaceNumber == centerNumber ? i : i+1;
                    break;
                }
                else if(sequence[i] + spaceNumber != sequence[i+1]){
                    indexCorrruptNumber = i+1;
                    break;
                }
            }
            if(i > 0 && sequence[i -1 ] < sequence[i]){
                int initalDiff = sequence[i] - sequence[i-1];
                int finalDiff = sequence[sequence.length-1] - sequence[sequence.length -2];
                if(i == sequence.length -1) break;
                if(spaceNumber == - 99 && sequence[i]+ initalDiff == sequence[i+1]){
                    spaceNumber = initalDiff;
                }
                else if(spaceNumber == - 99 && sequence[i]+ initalDiff != sequence[i+1]){
                    int postNumber = sequence[i+1] - sequence[i];
                    int centerNumber = (sequence[i+1] - sequence[i-1]) /2;
                    spaceNumber = centerNumber == finalDiff ? centerNumber : initalDiff == finalDiff ? initalDiff : postNumber;
                    indexCorrruptNumber = spaceNumber == centerNumber ? i : i+1;
                    break;
                }
                else if(sequence[i] + spaceNumber != sequence[i+1]){
                    indexCorrruptNumber = i+1;
                    break;
                }
            }
        }
        if(indexCorrruptNumber == sequence.length -1 ){
            sequence[indexCorrruptNumber] = sequence[indexCorrruptNumber -1] + spaceNumber;
        } else{
            sequence[indexCorrruptNumber] = sequence[indexCorrruptNumber +1] - spaceNumber;
        }
        return sequence;
    }
    public static void main(String[] args){
//        int[] corruptArray = {-8,-11,-12,-14,-16};
        int[] corruptArray = {5, 4, 6, 8, 10, 12};
        int[] fixArray = ArithmeticProgression.fixPattern(corruptArray);
        System.out.println(Arrays.toString(fixArray));
    }
}
