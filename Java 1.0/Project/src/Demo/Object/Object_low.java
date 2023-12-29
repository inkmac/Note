package Demo.Object;

class Person{           //作为示例
    String name;
    int age;
}


//判断一个数是不是偶数
//可以将if语句直接写在return中
class Method01{
    public boolean judge01(int n) {
        return n % 2 == 0;
    }
}
class Object01 {
    public static void main(String[] args) {
        Method01 input = new Method01();
        boolean out = input.judge01(11);
        System.out.println(out);
    }
}


//克隆对象
class Method03{
    public Person copy(Person p) {
        Person p2 = new Person();
        p2.age = p.age;
        p2.name = p.name;
        return p2;
    }
}
class Object03{
    public static void main(String[] args) {
        Person p = new Person();
        p.age = 10;
        p.name = "Bob";
        Method03 copied = new Method03();
        Person p2 = copied.copy(p);
        System.out.print("p2.name=" + p2.name + "  p2.age=" + p2.age);
    }
}


//用迭代解决走迷宫问题
class Map {
    public static boolean findWay(int[][] map, int i, int j) {

        if (i < 0 || j < 0 || i >= map.length || j >= map[0].length ||
            map[i][j] == 1 || map[i][j] == 3 || map[i][j] == 2) {
            return false;
        }

        if (map[i][j] == 4) {
            return true;
        } else {
            if (map[i][j] == 0) {

                map[i][j] = 2;
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
              return false;     // 其实不用带，为了防止编译器报错
            }
        }
    }
}


class MapTest {
    public static void main(String[] args) {
        //建立迷宫
        //0表示可以走, 1表示障碍物, 2表示走过, 3表示不能走, 4表示终点
        int[][] map = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 4},
        };

        System.out.println("====当前地图====");
        for (int[] value : map) {
            for (int i : value) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Map.findWay(map, 0, 0 );
        System.out.println("\n====findWay地图====");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}


//This使用 : 指向当前对象的引用 (谁调用, 指向谁)
//不要忘记&&(逻辑运算符),  if可以直接放在return中 **
//构造器和方法要分清
class This {
    String name;
    int age;

    public This(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean compareWay1(This p1, This p2) {
        System.out.print("Way1 executed: ");
        return (p1.name).equals(p2.name) && p1.age == p2.age;
    }

    public boolean compareWay2(This p) {
        System.out.print("Way2 executed: ");
        return this.name.equals(p.name) && this.age == p.age;
    }
}

class ThisObject {
    public static void main(String[] args) {
        This p1 = new This("jack",20);
        This p2 = new This("Bob",20);
        System.out.println(p2.compareWay1(p1,p2));

        System.out.println(p1.compareWay2(p2));
        //通过p1.compareWay2(p2)调用了p1对象的compareWay2方法, 同时传递了p2对象作为参数。
        //this: 谁调用,指向谁, p1调用了,this就指向p1
    }
}


