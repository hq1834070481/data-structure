package com.hq.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * DoubleLinkedList
 *
 * @author 胡强
 * @date 2021/2/25
 * @description TODO
 */
public class DoubleLinkedList<T> {

    private Node head;

    private Node tail;

    private int size;

    class Node {

        private T data; //数据

        private Node prev; //上一个节点

        private Node next; //下一个节点

        private Node() {

        }

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void insert(int position, T data) {
        if (position > size) {
            //不能超过链表长度
            return;
        }

        Node node = head;
        for (int i = 0; i < position; i++) {
            node = node.next;
        }
        Node insertNode = new Node(data);
        Node prev = node.prev;
        insertNode.prev = prev;
        insertNode.next = node;
        node.prev = insertNode;
        if (prev == null) {
            tail = insertNode;
        } else {
            prev.next = insertNode;
        }
        size++;
    }

    public void insertHead(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public void insertTail(T data) {
        Node node = new Node(data);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        size++;
    }

    public void delete(T data) {
        Node node = head;
        for (; node != null; node = node.next) {
            if (node.data == data) {
                Node prev = node.prev;
                Node next = node.next;
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                    node.prev = null;
                }

                if (next == null) {
                    tail = node;
                } else {
                    next.prev = prev;
                    node.next = null;
                }
                size--;
                return;
            }
        }
    }
}
