package com.hq.queue;

/**
 * LinkQueue
 *
 * @author 胡强
 * @date 2021/3/15
 * @description 队列, 先进先出
 */
public class OneLinkQueue<T> {

    private Node head;

    private Node tail;

    private int size;

    private int n;

    public OneLinkQueue(int n) {
        this.n = n;
    }

    /**
     * 入队,插入在尾部
     *
     * @param data
     * @return
     */
    public boolean put(T data) {//O(1)
        if (size >= n) {
            return false;
        }
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }

    /**
     * 出队，弹出头部
     *
     * @return
     */
    public T pop() { //O(1)
        if (isEmpty()) {
            return null;
        }
        Node node = head;
        head = node.next;
        size--;
        return node.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private class Node {

        private T data;

        private Node next;

        private Node() {

        }

        private Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
