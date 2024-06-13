package CommonClass;
import java.util.Random;


public class Random_ {
    public static void main(String[] args) {
        //随机获取字符串
        String[] randomArr = {"Up", "Down", "Left", "Right"};
        Random random = new Random();
        int randomIndex = random.nextInt(randomArr.length);
        String randomGet = randomArr[randomIndex];


    }
}
