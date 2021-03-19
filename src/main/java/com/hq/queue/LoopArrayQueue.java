package com.hq.queue;

/**
 * LoopQueue
 *
 * @author 胡强
 * @date 2021/3/12
 * @description 循环队列
 */
public class LoopArrayQueue<T> {

    private Object[] array;

    private int head = 0;

    private int tail = 0;

    private int size = 0;

    private int n = 10;

    public LoopArrayQueue(int n) {
        this.n = n;
        array = new Object[n];
    }

    /**
     * 入队
     *
     * @param data
     * @return
     */
    public boolean put(T data) {
        if ((tail + 1) % n == head) {
            return false;
        }
        array[tail] = data;
        tail = (tail + 1) % n;
        size++;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public T pop() {
        if (head == tail) {
            return null;
        }
        T data = (T) array[head];
        array[head] = null;
        head = (head + 1) % n;
        size--;
        return data;

    }

    /**
     * 获取队列长度
     *
     * @return
     */
    public int size() {
        return size;
    }

}
