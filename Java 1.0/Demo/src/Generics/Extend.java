package Generics;

import java.util.ArrayList;
import java.util.List;

public class Extend {
    public static void main(String[] args) {
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<AA> list3 = new ArrayList<>();
        ArrayList<BB> list4 = new ArrayList<>();
        ArrayList<CC> list5 = new ArrayList<>();
    }

    // <?> 表示任意的泛型类型都可以接收
    public static void all(List<?> list) {}

    // <? extends AA> 表示AA及其子类的泛型类型都可以接收
    public static void extend(List<? extends AA> list) {}

    // <? super AA> 表示AA及其父类的泛型类型都可以接收
    public static void super_(List<? super AA> list) {}
}


class AA {}
class BB extends AA {}
class CC extends BB {}


