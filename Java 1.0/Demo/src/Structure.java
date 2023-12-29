class switch_ {
    public static void main(String[] args) {
        //switch的值的数据类型应与case后常量数据类型一致, 或者是可以相互转换的类型
        //switch的值只能是(byte,short,int,char,enum,String)
        //case句子中的值必须是常量
        //switch语句有穿透性，若符合一个条件则会一直执行, 若想退出需用break
        //default可有可无, 且后面的break可以不用带
        //switch中的break只能用于退出switch, 如想退出循环可以使用一个额外的boolean变量来控制循环的条件
        //case可以接收多种情况
        char c = 20;
        switch(c) {
            case 20, 10, 40:
                System.out.println("ok1");
                break;
            case 30:
                System.out.println("ok2");
                break;
            default:
                System.out.println("ok3");
        }
    }
}


class enhanced_switch {
    public static void main(String[] args) {
        //增强型开关没有穿透性
        //仍然不能用break直接退出外层循环, 需要多加一个boolean变量当做循环条件来控制
        //case可以接收多种情况
        char c = 20;
        switch(c) {
            case 20, 50, 60 -> {
                System.out.println("ok 20");
            }
            case 30 -> {
                System.out.println("ok 30");
            }
            default -> {
                System.out.println("default");
            }
        }
    }
}


class for_ {
    public static void main(String[] args) {
        //初始变量(可以有多条语句) ; 判断 ; 变量迭代 (注意a的作用域范围**)
        for (int a = 0, b = 1; a < 3; a++) {
            System.out.println("a=" + a + " " + "b=" + b);
        }

        //初始化变量和变量迭代可以写在其他地方  (注意a的作用域范围**)
        int C = 1;
        for ( ; C < 5; ) {
            System.out.println("C=" + C);
            C++;
        }

        //无限循环: 即中间的判断不写或写上true
        for ( ; ; ) {
            System.out.println("ok");
        }
    }
}


class enhanced_for {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        //适用于遍历 数组,集合
        //快捷键: iter
        for (int number : numbers) {
            System.out.print(number + "\t");
        }

    }
}



//特点: 无论条件是否成立, 都会先执行一遍
class do_while{
    public static void main(String[] args) {
        int i = 1;               //初始变量
        do {
            System.out.println("hello");      //需要循环的语句
            i++;                 //变量迭代
        }while (i <= 3);         //条件判断
    }
}


@SuppressWarnings({"ALL"})
class TernaryOperator {
    public static void main(String[] args) {
        //condition ? value1 : value2
        //如果 condition 为真, 表达式的结果是 value1, 否则结果是 value2
        int x = 5;
        int y = 10;
        int max = (x > y) ? x : y;
        System.out.println("max = " + max);

    }
}



class break_ {
    public static void main(String[] args) {
        //可以用标签来指明某一层的循环, break指定哪个就退出哪个 (尽量不要用)
        //若没有指定的标签, 默认退出最近的循环体
        label1 :
        for (int j = 0; j < 3; j++) {
            label2 :
            for(int i = 0; i < 10; i++) {
                if (i == 2) {
                    break;              //等价于break label2
//                    break label1;
                }
                System.out.print("i=" + i + " ");
            }
            System.out.println("   " + (j + 1));
        }
    }
}




class continue_ {
    public static void main(String[] args) {
        //用于结束本次循环, 不执行剩下的命令, 直接进入下一次循环
        //可用标签来指定跳过的是哪一层循环
        for (int i = 1; i <= 4; i++) {
            if (i == 2) {
                System.out.println("Detect i = 2  " + "Going to leave");
                continue ;
            }System.out.println("ok" + i*100);
        }
        System.out.println("ok,over~");
    }
}



class return_{
    public static void main(String[] args) {
        //若使用在方法中, 表示跳出所在方法
        //若在main方法中, 直接退出程序
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                System.out.println("Detect i = 2  " + "Going to return");
                return;                         //return后面不允许再有代码
            }
            System.out.println("ok" + i*100);
        }
        System.out.println("ok,over~");
    }
}

