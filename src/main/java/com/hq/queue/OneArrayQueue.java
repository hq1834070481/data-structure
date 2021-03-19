package com.hq.queue;

/**
 * OneQueue
 *
 * @author 胡强
 * @date 2021/3/11
 * @description 单向队列, 先进先出 FIFO
 */
public class OneArrayQueue<T> {
    private Object[] array;

    private int head = 0; //队列的头部

    private int tail = 0; //队列的尾部

    private int n = 0; //队列大小

    private int size = 0; //队列的容量

    public OneArrayQueue(int size) {
        this.size = size;
        array = new Object[size];
    }

    /**
     * 入队列
     *
     * @param data
     * @return
     */
    public boolean put(T data) {
        if (n >= size) {
            return false;
        }
        if (tail >= size) {
            //移位
            for (int i = 0; i < head; i++) {
                if (head + i < tail) {
                    array[i] = array[head + i];
                }
            }
            tail = tail - head;
            head = 0;
        }
        array[tail++] = data;
        n++;
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public T pop() {
        if (n > 0) {
            T data = (T) array[head];
            array[head] = null;
            head++;
            n--;
            return data;
        }
        return null;
    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int getSize() {
        return n;
    }
}
