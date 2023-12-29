package CommonClass.ThreeString.StringBuffer;

// StringBuffer: 可以直接更新内容, 不用每次都更新地址, 效率较高

/*
1.StringBuffer是char[] value的,所以可以直接更改,效率更高
2.StringBuffer默认是16位的, 如果不够会自动追加
 */


class String_Buffer {
    public static void main(String[] args) {

        //通过 Constructor 创建指定大小/字符串的 StringBuffer
        StringBuffer hello = new StringBuffer("hello");
        StringBuffer stringBuffer = new StringBuffer(100);



        //String --> StringBuffer
        String str = "bob";
        StringBuffer strBuffer = new StringBuffer(str);

        StringBuffer strBuffer1 = new StringBuffer();
        strBuffer1.append(str);

        //StringBuffer --> String
        String s = new String(strBuffer);
        String s1 = strBuffer.toString();
    }
}


