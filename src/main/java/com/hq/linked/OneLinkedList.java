package com.hq.linked;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Linked
 *
 * @author 胡强
 * @date 2021/2/22
 * @description 单向链表
 */
public class OneLinkedList<T> {

    private Node head; //头节点

    private Node tail; //尾节点

    private int size = 0; //链表长度

    private class Node {

        private T data;

        private Node next;

        private Node() {

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

    public OneLinkedList() {

    }

    /**
     * 插入头节点
     *
     * @param data
     */
    private void insetHead(T data) {
        Node node = new Node();
        node.setData(data);
        if (head == null) {
            tail = node;
        }
        node.next = head;
        head = node;
        size++;
    }

    /**
     * 插入尾巴节点
     *
     * @param data
     */
    private void insetTail(T data) {
        Node node = new Node();
        node.setData(data);
        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }
        tail = node;
        size++;
    }

    /**
     * 插入,默认插入尾部
     *
     * @param data
     */
    public void insert(T data) {
        Node insertNode = new Node();
        insertNode.setData(data);
        if (head == null) {
            head = insertNode;
        } else {
            tail.next = insertNode;
        }
        tail = insertNode;
        size++;
    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(int position, T data) {
        if (position > size) {
            //不能超过链表长度
            return;
        }
        Node insertNode = new Node();
        Node node = head;
        for (int i = 0; i < position; i++) {
            node = node.next;
        }
        if (node == head) {
            head = insertNode;
        }
        insertNode.next = node.next;
        node.next = insertNode;
        size++;
    }

    public void delete(T data) {
        Node node = head;
        Node prev = head;
        //
        while (node != null && node.data != data) {
            prev = node;
            node = node.next;
        }
        if (node == null) {
            //未找到要删除的数据
            return;
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

    @Override
    public String toString() {
        return "OneWayLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }


}
