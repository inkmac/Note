package CommonClass.ThreeString.StringBuffer;


/*
增 append()
删 delete(start, end)
改 replace(start, end, string)
查 indexOf()  lastIndexOf()
插 insert(start, string) 在索引为start处插入String
获取长度 length()
 */


class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("Physics");

        //append 追加,在最后面加
        s.append("On").append("Top");
        System.out.println(s);

        //删 左闭右开
        s.delete(7,9);
        System.out.println(s);

        //改 左闭右开
        s.replace(0,7,"Chemistry");
        System.out.println(s);

        //查  找到了返回第一次出现的索引,没找到返回-1
        int s1 = s.indexOf("is");
        System.out.println(s1);

        //插 在索引为9处插入String
        s.insert(9,"On");
        System.out.println(s);

        //查询长度
        int length = s.length();
        System.out.println(length);
    }
}
