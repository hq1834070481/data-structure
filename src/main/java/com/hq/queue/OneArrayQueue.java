package com.hq.queue;

/**
 * OneQueue
 *
 * @author 胡强
 * @date 2021/3/11
 * @description 单向队列, 数组实现,数组有边界
 */
public class OneArrayQueue<T> {

    private Object[] array;

    private int head = 0; //队列的头部

    private int tail = 0; //队列的尾部

    private int size = 0; //队列大小

    private int n = 0; //队列的容量

    public OneArrayQueue(int n) {
        this.n = n;
        array = new Object[n];
    }

    /**
     * 入队列
     *
     * @param data 插入的数据
     * @return
     */
    public boolean put(T data) {
        if (size >= n) {
            return false;
        }
        //判断是否需要移动数组
        if (tail >= n) {
            //当前队列已满
            if (tail - head >= n) {
                return false;
            }
            //移动数组位置
            for (int i = 0; i < head; i++) {
                if (head + i < tail) {
                    array[i] = array[head + i];
                }
            }
            tail = tail - head;
            head = 0;

        }
        array[tail++] = data;
        size++;
        return true;
    }

    /**
     * 出队列
     *
     * @return
     */
    public T pop() {
        if (size > 0) {
            T data = (T) array[head];
            array[head] = null;
            head++;
            size--;
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
        return size;
    }
}
