package Queue;

import java.util.Iterator;

public interface Queue<E> {
    /**
     * 向队尾tail加入元素
     * @return 加入成功返回true, 否则返回false
     */
    boolean offer(E value);

    /**
     * 从队列头获取元素, 并移除
     */
    E poll();

    /**
     * 从队列头获取元素, 不移除
     */
    E peek();

    boolean isEmpty();

    boolean isFull();
}




