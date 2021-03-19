package com.hq.stack;

import com.hq.linked.DoubleLinkedList;

/**
 * LinkedStack
 *
 * @author 胡强
 * @date 2021/3/16
 * @description TODO
 */
public class LinkedStack<Item> implements Stack<Item> {


    private Node head;

    private int size;

    @Override
    public boolean put(Item item) {
        Node node = new Node(item);
        if (head != null) {
            node.next = head;
        }
        head = node;
        size++;
        return false;
    }

    @Override
    public Item pop() {
        Node node = null;
        if (head != null) {
            node = head;
            head = node.next;
            node.next = null;
            return node.data;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    class Node {

        private Item data; //数据

        private Node prev; //上一个节点

        private Node next; //下一个节点

        private Node() {

        }

        public Node(Item data) {
            this.data = data;
        }

        public Item getData() {
            return data;
        }

        public void setData(Item data) {
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
}
