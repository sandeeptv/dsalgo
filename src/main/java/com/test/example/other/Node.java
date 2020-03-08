package com.test.example.other;

public class Node {

    private int value;
    private Node next;

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int data) {
        this.value = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
