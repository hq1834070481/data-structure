package com.hq.linked;

/**
 * loopLinkedList
 *
 * @author 胡强
 * @date 2021/3/2
 * @description TODO
 */
public class LoopLinkedList {

    private class Node {

        private int data;

        private Node next;

        private Node() {

        }

        private Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

    }

    public Node head;

    public Node tail;

    private int size;

    public int josephusProblem(int data, int num) {
        Node node = head;
        for (int i = 1; i < size; i++) {
            if (node.data == data) {
                break;
            }
            node = node.next;
        }
        while (1 < size) {
            Node prev = node;
            for (int i = 0; i < num; i++) {
                prev = node;
                node = node.next;
            }
            Node next = node.next;
            if (prev == node) {
                head = node.next;
            } else {
                prev.next = node.next;
            }
            if (next == head) {
                tail = prev;
            }
            node.next = null;
            node = prev;
            size--;
        }
        return node.data;
    }

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            head.next = tail;
        } else {
            tail.next = node;
            tail = node;
        }
        tail.next = head;
        size++;
    }

    public void delete(int data) {
        Node node = head;
        Node prev = head;
        //
        while (node.data != data && node != tail) {
            prev = node;
            node = node.next;
        }

        Node next = node.next;
        if (prev == node) {
            head = node.next;
            prev.next = null;
        } else {
            prev.next = node.next;
        }
        if (next == null) {
            tail = prev;
        }
        node.next = null;
        size--;
    }

}



