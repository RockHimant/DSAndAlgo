package com.learn.himant.linkedlist;

public class RemoveNthNodeFromEnd {

    public Node solve(Node head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;

        // Move first n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (first == null) {
                return head; // n is greater than the length of the list
            }
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the nth node from the end
        second.next = second.next.next;

        return dummy.next;
    }

}
