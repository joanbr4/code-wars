import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortGiftCode {
    public String sortGiftCode(String long_string) {
        System.out.println(long_string);
        String finalString = Arrays.stream(long_string.split("")).sorted().collect(Collectors.joining());
        System.out.println(finalString);
        return finalString;
    }

    public static void main(String[] args) {
        String gs = new SortGiftCode().sortGiftCode("zyxwvutsrqponmlkjihgfedcba");
        System.out.println(gs);
    }
}
