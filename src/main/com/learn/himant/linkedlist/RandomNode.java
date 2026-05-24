package com.learn.himant.linkedlist;

/**
 * Represents a node for a linked list with a random pointer.
 */
public class RandomNode {

    int data;
    RandomNode next;
    RandomNode random;

    public RandomNode(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public RandomNode getNext() {
        return next;
    }

    public void setNext(RandomNode next) {
        this.next = next;
    }

    public RandomNode getRandom() {
        return random;
    }

    public void setRandom(RandomNode random) {
        this.random = random;
    }

}
