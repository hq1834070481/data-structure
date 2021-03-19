package com.hq.linked;

import java.util.Date;
import java.util.HashMap;

/**
 * LRU
 *
 * @author 胡强
 * @date 2021/3/8
 * @description LRU淘汰算法, 最近最少使用
 */
public class LruCache<K, V> {

    private Node head;

    private Node tail;

    private int n;

    private int size = 10;

    private HashMap<K, Node> table;

    public LruCache() {

    }

    public LruCache(int size) {
        this.size = size;
    }

    /**
     * 添加数据
     *
     * @param value
     */
    public void insert(K key, V value) { //O(n)
        Node insertNode = new Node(key, value);
        if (head == null) {
            head = insertNode;
            tail = insertNode;
            table = new HashMap<>(size);
            n++;
        } else {
            if (isCache(key)) {
                Node oldNode = table.get(key);
                remove(oldNode);
            }
            //判断是否达到链表最大长度,达到最大长度淘汰最后一个节点
            if (n >= size) {
                table.remove(tail.k);
                tail.perv.next = null;
                tail = tail.perv;
            }
            insertNode.next = head;
            head.perv = insertNode;
            head = insertNode;
            if (!isCache(key) && !(n >= size)) {
                n++;
            }
        }
        table.put(key, insertNode);

    }

    /**
     * 判断缓存是否存在
     *
     * @param key
     * @return
     */
    public boolean isCache(K key) {//O(n)
        return table.containsKey(key);
    }

    /**
     * 判断缓存是否存在
     *
     * @param key
     * @return
     */
    public V get(K key) {//O(n)
        Node node = table.get(key);
        if (node != null) {
            remove(node);
            node.next = head;
            head = node;
            return node.data;
        }
        return null;
    }

    private void remove(Node node) {
        Node next = node.next;
        Node prev = node.perv;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.perv = null;
        }
        if (next == null) {
            tail = prev;
        } else {
            next.perv = prev;
            node.next = null;
        }
    }


    private class Node {

        private K k;

        private V data;

        private Node next;

        private Node perv;

        private Node() {

        }

        private Node(K k, V data) {
            this.k = k;
            this.data = data;
        }

        public V getData() {
            return data;
        }

        public void setData(V data) {
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

    @Override
    public String toString() {
        return "LruCache{" +
                "head=" + head +
                ", tail=" + tail +
                ", n=" + n +
                ", size=" + size +
                ", table=" + table +
                '}';
    }
}
