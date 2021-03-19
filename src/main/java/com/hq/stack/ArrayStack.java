package com.hq.stack;

/**
 * ArrayStack
 *
 * @author 胡强
 * @date 2021/3/4
 * @description TODO
 */
public class ArrayStack<Item> implements Stack<Item> {

    private Item[] items;

    private int size;

    public ArrayStack(int size) {
        items = (Item[]) new Object[size];
    }

    @Override
    public boolean put(Item item) {
        resize();
        items[size++] = item;
        return false;
    }

    private void resize() {
        if (size + 1 > items.length) {
            Item[] temp = (Item[]) new Object[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                temp[i] = items[i];
            }
            items = temp;
        }
    }


    @Override
    public Item pop() {
        if (isEmpty()) {
            return null;
        }
        Item item = items[--size];
        items[size] = null;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
