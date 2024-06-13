package Useless.A;


public class GGG {
    public static void main(String[] args) {

        String a = "java";
        String b = "java";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        String s = new String("java");
        String m = new String("java");
        System.out.println(s.hashCode());
        System.out.println(m.hashCode());

    }
}



