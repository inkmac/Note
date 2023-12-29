import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray implements Iterable<Integer> {   //实现Iterable接口后, 就可以进行迭代了
    private int size = 0;
    private int capacity = 4;
    private int[] array;

    public void add(int element) {
        sizeCheck();
        array[size] = element;
        size++;
    }

    public void add(int index, int element) {
        sizeCheck();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    public int get(int index) {
        return array[index];
    }

    public void remove(int index) {
        if (index == size - 1) {    //当index是最后一个元素的时候就不移动
            return;
        }
        System.arraycopy(array, index+1, array, index, size - index - 1);
        size--;
    }

    private void sizeCheck() {
        if (size == 0)
            array = new int[capacity];

        if (size == capacity) {
            capacity = capacity << 1;   //直接扩大2倍
            array = Arrays.copyOf(array, capacity);
        }
    }

    @Override
    public Iterator<Integer> iterator() {   //获取迭代器的方法
        return new Iterator<Integer>() {    //return一个实现了Iterator接口的匿名内部类
            int i = 0;
            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];     //指定遍历的就是array, 并且让i指向下一个数据
            }
        };
    }
}


class Test {
    public static void main(String[] args) {
        DynamicArray Array = new DynamicArray();

        Array.add(0);
        Array.add(1);
        Array.add(2);
        Array.add(3);
        Array.add(4);

        for (Integer i : Array) {
            System.out.print(i + " ");
        }
    }
}

