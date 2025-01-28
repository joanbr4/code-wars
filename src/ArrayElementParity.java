import java.util.*;
/*
LEVEL: 7kyu
In this Kata, you will be given an array of integers whose elements have both a negative and a positive value, except for one integer that is either only negative or only positive. Your task will be to find that integer.

example
input: int[]
output: int
Examples:

int[] intArray = {1,-1, -4, -3, 5, -5, 3}; //-4
int[] intArray = {-110,110,-38,-38,-62,62,-38,-38,-38}; //-38
int[] intArray = {-9,-105,-9,-9,-9,-9,105}; //-9

* * */

public class ArrayElementParity {
    private int FindNumber(int[] arr){
        int numberOnlyPosNeg = 0;
        Map<Integer, Integer> resultaArray = new HashMap<>();

        Arrays.stream(arr).forEach(item-> {
            int absolutNumber = Math.abs(item);
            if(resultaArray.containsKey(absolutNumber)) {
                int intialNumber= resultaArray.get(absolutNumber);
                resultaArray.put(absolutNumber, item + intialNumber);
            }else{
                resultaArray.put(absolutNumber, item);
            }
        });
        for(Map.Entry<Integer, Integer> itemMap: resultaArray.entrySet()) {
            if(itemMap.getValue() != 0) {
                int finalValueNumber = itemMap.getValue();
                int finalNumber = itemMap.getKey();
                numberOnlyPosNeg = finalValueNumber > 0 ? finalNumber : -finalNumber;
            }
        }
        return numberOnlyPosNeg;
    }
    public static void main(String[] args) {
        int[] intArray = {};
        int result = new ArrayElementParity().FindNumber(intArray);
        System.out.println("Special number  is " + result);
    }
}
