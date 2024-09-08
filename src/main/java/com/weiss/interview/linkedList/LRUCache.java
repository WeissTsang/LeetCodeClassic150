package com.weiss.interview.linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int value;
        int key;
        Node prev;
        Node next;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }

    int capacity;
    Node dummy = new Node(0, 0);;
    Map<Integer,Node> map = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;

        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);

        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);

        if (node != null) {
            node.value = value;
            return;
        }

        node = new Node(key, value);
        map.put(key, node);
        putFront(node);

        if (map.size() > capacity) {
            Node backNode = dummy.prev;
            map.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key) {
        if (!map.containsKey(key)) {
            return null;
        }

        Node node = map.get(key);
        remove(node);
        putFront(node);

        return node;
    }

    private void putFront(Node node) {
        node.next = dummy.next;
        dummy.next = node;
        node.next.prev = node;
        node.prev = dummy;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
