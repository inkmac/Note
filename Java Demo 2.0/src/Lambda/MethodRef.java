package Lambda;

import java.util.stream.Stream;

public class MethodRef {
    public static void main(String[] args) {
        Stream.of(
            new String("AAA"),
            new String("BBB"),
            new String("CCC")
        ).forEach(System.out::println);


    }
}
