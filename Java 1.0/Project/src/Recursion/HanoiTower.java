package Recursion;

public class HanoiTower {
    public static void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("盘子:" + num + " " + a + " -> " + c);
            return;
        }

        //看成2个盘，最下面的一个和上面的全部
        //(1) 先移动上面的盘到b
        move(num - 1, a, c, b);
        //(2) 把最下面的移动到C
        System.out.println("盘子:" + num + " " + a + " -> " + c);
        //(3) 把b上盘子移动到c
        move(num - 1, b, a, c);

    }
}

class Tower {
    public static void main(String[] args) {

        HanoiTower.move(3,'A','B','C');
    }
}
