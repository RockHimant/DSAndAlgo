package com.learn.himant.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeTwoLinkedListAlternativelyTest {

    private final MergeTwoLinkedListAlternatively solution = new MergeTwoLinkedListAlternatively();

    @Test
    public void testBothListsNonEmpty() {
        Node head1 = buildList(1, 2, 3, 4);
        Node head2 = buildList(5);

        Node merged = solution.solve(head1, head2);

        assertEquals("1 -> 5 -> 2 -> 3 -> 4", toString(merged));
    }

    @Test
    public void testSecondListShorterThanFirst() {
        Node head1 = buildList(1, 2, 3, 4, 5);
        Node head2 = buildList(10, 20);

        Node merged = solution.solve(head1, head2);

        assertEquals("1 -> 10 -> 2 -> 20 -> 3 -> 4 -> 5", toString(merged));
    }

    @Test
    public void testFirstListShorterThanSecond() {
        Node head1 = buildList(1, 2);
        Node head2 = buildList(10, 20, 30, 40);

        Node merged = solution.solve(head1, head2);

        assertEquals("1 -> 10 -> 2 -> 20 -> 30 -> 40", toString(merged));
    }

    @Test
    public void testFirstListEmpty() {
        Node merged = solution.solve(null, buildList(1, 2, 3));
        assertEquals("1 -> 2 -> 3", toString(merged));
    }

    @Test
    public void testSecondListEmpty() {
        Node merged = solution.solve(buildList(1, 2, 3), null);
        assertEquals("1 -> 2 -> 3", toString(merged));
    }

    @Test
    public void testBothListsEmpty() {
        assertNull(solution.solve(null, null));
    }

    private Node buildList(int... values) {
        if (values == null || values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    private String toString(Node head) {
        if (head == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }
}
