package Object_Low;

//递归: 先递后归; 只递不归,内存炮灰
//相当于许多层嵌套, 一直嵌套到能够执行的语句(递), 在一层一层往回走(归)
class recursion {
    public void test(int n) {
        if (n > 2) {
            test(n-1);
        }
        System.out.println("n=" + n);
    }
}

class recursionObject {
    public static void main(String[] args) {
        recursion t1 = new recursion();
        t1.test(4);
    }
}



class factorial {
    public int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) * n;
    }
}

class factorialObject {
    public static void main(String[] args) {
        factorial A = new factorial();
//        int summary = A.sum(5);
        System.out.println("sum=" + A.sum(5));
    }
}


