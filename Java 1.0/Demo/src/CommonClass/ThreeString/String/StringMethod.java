package CommonClass.ThreeString.String;

/*
equals()  判断内容是否相等,区分大小写
equalsIgnoreCase()  判断内容是否相等,不区分大小写
length()  获取字符串长度
indexOf()  获取某一字符/字符串在字符串第一次出现的索引, 如果找不到,返回-1
lastIndexOf()  获取某一字符/字符串在字符串最后一次出现的索引, 如果找不到,返回-1
substring()  截取指定范围的子串,为左闭右开
trim()  只去掉前后空格
charAt()  获取索引处的字符
 */

public class StringMethod {
    public static void main(String[] args) {
        String s1 = "PhysicsOnTop";
        System.out.print(s1.indexOf('s') + "\t");
        System.out.print(s1.lastIndexOf('s') + "\t");
        System.out.println(s1.indexOf("On"));

        String name = "hello,BOB";
        System.out.print(name.substring(6) + "\t");
        System.out.println(name.substring(0,5));

        String a = " shadow assassin ";
        System.out.println(a.trim());
    }
}



/*
toUpperCase()  全部转换成大写
toLowerCase()  全部转换成小写
concat()  拼接字符串, 感觉不如 +
replace()  替换字符串中的全部内容   注意: 需要接收才有用, 单独 s1.replace()没用
split()  根据()内容分割字符串
compareTo()  比较两个字符串的大小 --> 看源码
toCharArray()  转换成字符数组
format()  将字符串格式化
 */

class StringMethod02 {
    public static void main(String[] args) {
        String s1 = "";
        s1 = s1.concat("Physics").concat("On").concat("Top");
        System.out.println(s1);


        String s2 = "Physics Physics Physics On Top";
        s2 = s2.replace("Physics", "Chemistry");
        System.out.println(s2);


        String splitName = "Maxor Storm Goldor Necron";
        String[] splitResult = splitName.split(" ");
        for (String split :  splitResult) {
            System.out.print(split + "\t");
        }


        String a = "abc";
        String b = "ccd";
        System.out.println("\n" + a.compareTo(b));


        // %s: String
        // %d: int
        // %.2f: double, 替换后只会保留小数点两位,并且进行四舍五入
        // %c: char
        // 可以用x$ 进行索引
        String name = "bob";
        int age = 10;
        String info = String.format("姓名是%s 年龄是%d", name, age);
        System.out.println(info);
    }
}



/*  附录: CompareTo 源码

    public int compareTo(String anotherString) {
    int len1 = value.length;
    int len2 = anotherString.value.length;
    int lim = Math.min(len1, len2);
    char v1[] = value;
    char v2[] = anotherString.value;

    int k = 0;
    while (k < lim) {
        char c1 = v1[k];
        char c2 = v2[k];
        if (c1 != c2) {
            return c1 - c2;     //若有不一样的字符直接return结束, 所以后面字符的就不去比较了
        }
        k++;
    }
    return len1 - len2;
    //如果在循环内部没有找到不同的字符,意味着字符串的前部分是相同的,那么会执行 return len1 - len2,
    //这将返回两个字符串的长度差值,用于确定它们的大小关系
}

 */