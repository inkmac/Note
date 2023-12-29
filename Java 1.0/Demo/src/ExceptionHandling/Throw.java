package ExceptionHandling;


class Throw {
    public static void main(String[] args) throws RuntimeException {
        f1();
    }

    public static void f1() throws RuntimeException {
        int n1 = 10;
        int n2 = 0;
        double res = n1 / n2;
    }

    public static int search() {
        throw new RuntimeException("Cannot find");  //throw了就可以不需要return
    }
}
