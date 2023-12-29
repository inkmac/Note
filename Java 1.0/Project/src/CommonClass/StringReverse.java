package CommonClass;
import java.util.Arrays;
// 编程思想:
// (1) 用if语句一一排除不符合的条件
// (2) 将正确的条件写下来, 然后再取反, 就得到了要排除的条件


public class StringReverse {
    public static void main(String[] args) {
        String str = "afedcbg";
        String reverse = StringReverse.reverse(str, 1, 5);
        System.out.println(reverse);
    }


    public static String reverse(String str, int start, int end) {

        if (str == null || start >= end || start <= 0 || end >= str.length()) {
            System.out.println("StringCannotBeSwitchException");
            return null;
        }

        char[] charArray = str.toCharArray();
        for (int i = start, j = end, m = 0; m < (Math.floor(end - start)/2); i++, j--, m++) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return Arrays.toString(charArray);
    }
}
