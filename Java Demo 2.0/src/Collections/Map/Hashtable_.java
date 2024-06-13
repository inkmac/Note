package Collections.Map;
import java.util.*;

/*  与HashMap的区别
线程安全
k,v都不允许为空
 */


/*  Hashtable扩容机制
第一次添加时候table扩容到11, 达到临界值的时候就会扩充两倍再加上1
int newCapacity = (oldCapacity << 1) + 1;
threshold = presentCapacity * loadFactor(0.75)
 */


@SuppressWarnings({"all"})
public class Hashtable_ {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();

    }
}
