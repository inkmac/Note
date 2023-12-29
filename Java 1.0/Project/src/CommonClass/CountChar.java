package CommonClass;


public class CountChar {
    public static void main(String[] args) {
        String str = "ASF adv 232";
        CountChar.count(str);
    }

    public static void count(String s) {
        int numCount = 0;
        int lowerCount = 0;
        int upperCount = 0;
        int otherCount = 0;

        for (int i = 0; i < s.length(); i++) {      // 用char来判断范围
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numCount++;
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                lowerCount++;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                upperCount++;
            } else {
                otherCount++;
            }
        }

        System.out.println("numCount=" + numCount + "\tlowerCount=" + lowerCount +
                        "\tupperCount=" + upperCount + "\totherCount=" + otherCount);
    }
}
