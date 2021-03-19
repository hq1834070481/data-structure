package com.hq.array;

import java.util.Arrays;

/**
 * ArrayTest
 *
 * @author 胡强
 * @date 2021/2/19
 * @description 数组
 */
public class Array {

    /**
     * 数组大小
     */
    private int size;

    /**
     * 数组
     */
    private int[] array;

    /**
     * 当前数组插入下标的数量
     */
    private int index;

    public Array(int size) {
        this.size = size;
        this.array = new int[size];
    }

    /**
     * 数组插入
     *
     * @param loc
     * @param n
     */
    public void insert(int loc, int n) {
        if (index++ < size) {
            for (int i = size - 1; i > loc; i--) {
                array[i] = array[i - 1];
            }
            array[loc] = n;
        }
    }

    /**
     * 数组删除
     *
     * @param loc
     */
    public void delete(int loc) {
        for (int i = loc; i < size; i++) {
            if (i != size - 1) {
                array[i] = array[i + 1];
            } else {
                array[i] = 0;
            }

        }
    }

    public void update(int loc, int n) {
        array[loc] = n;
    }

    public int get(int loc) {
        return array[loc];
    }

    @Override
    public String toString() {
        return "ArrayTest{" +
                "size=" + size +
                ", array=" + Arrays.toString(array) +
                ", index=" + index +
                '}';
    }
}
