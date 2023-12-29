package CommonClass;
import java.math.BigDecimal;
import java.math.BigInteger;


class BigInteger_ {
    public static void main(String[] args) {

        //用""将数据引起来
        BigInteger bigInteger = new BigInteger("1999999999999999999999999");
        System.out.println(bigInteger);
        BigInteger bigInteger2 = new BigInteger("10000000");

        BigInteger add = bigInteger.add(bigInteger2);
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        BigInteger divide = bigInteger.divide(bigInteger2);
    }
}



class BigDecimal_ {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("10.99999");
        BigDecimal bigDecimal2 = new BigDecimal("0.3");


        //其他都与BigInteger一样,只有除法要注意 -> 可能会抛出ArithmeticException
        //指定精度即可 BigDecimal.ROUND_CEILING
        //如果有无限循环小数就会保留到 分子 的精度
        BigDecimal divide = bigDecimal.divide(bigDecimal2, BigDecimal.ROUND_CEILING);
    }
}
