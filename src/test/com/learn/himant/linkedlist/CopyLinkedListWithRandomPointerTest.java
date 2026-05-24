package com.learn.himant.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

public class CopyLinkedListWithRandomPointerTest {

    private final CopyLinkedListWithRandomPointer solution = new CopyLinkedListWithRandomPointer();

    @Test
    public void testNullInput() {
        assertNull(solution.solve(null));
    }

    @Test
    public void testSingleNodeWithoutRandom() {
        RandomNode head = new RandomNode(1);

        RandomNode copy = solution.solve(head);

        assertNotNull(copy);
        assertEquals(1, copy.getData());
        assertNull(copy.getNext());
        assertNull(copy.getRandom());
        assertNotSame(head, copy);
        assertNull(head.getNext());
        assertNull(head.getRandom());
    }

    @Test
    public void testSingleNodeRandomToSelf() {
        RandomNode head = new RandomNode(1);
        head.setRandom(head);

        RandomNode copy = solution.solve(head);

        assertNotNull(copy);
        assertEquals(1, copy.getData());
        assertNull(copy.getNext());
        assertNotNull(copy.getRandom());
        assertEquals(copy, copy.getRandom());
        assertNotSame(head, copy);
        assertEquals(head, head.getRandom());
    }

    @Test
    public void testMultipleNodesWithRandomPointers() {
        RandomNode[] nodes = buildList(1, 2, 3, 4);
        nodes[0].setRandom(nodes[2]); // 1.random = 3
        nodes[1].setRandom(nodes[0]); // 2.random = 1
        nodes[2].setRandom(null);     // 3.random = null
        nodes[3].setRandom(nodes[1]); // 4.random = 2

        RandomNode copy = solution.solve(nodes[0]);

        assertCopyStructure(nodes[0], copy);
        assertRandomLinks(copy, new Integer[]{3, 1, null, 2});
        assertOriginalRestored(nodes[0], new Integer[]{1, 2, 3, 4});
    }

    @Test
    public void testRandomPointersSomeNull() {
        RandomNode[] nodes = buildList(1, 2, 3);
        nodes[0].setRandom(null);
        nodes[1].setRandom(nodes[2]);
        nodes[2].setRandom(nodes[1]);

        RandomNode copy = solution.solve(nodes[0]);

        assertCopyStructure(nodes[0], copy);
        assertRandomLinks(copy, new Integer[]{null, 3, 2});
        assertOriginalRestored(nodes[0], new Integer[]{1, 2, 3});
    }

    private RandomNode[] buildList(int... values) {
        RandomNode[] nodes = new RandomNode[values.length];
        RandomNode head = null;
        RandomNode current = null;

        for (int i = 0; i < values.length; i++) {
            nodes[i] = new RandomNode(values[i]);
            if (head == null) {
                head = nodes[i];
                current = head;
            } else {
                current.setNext(nodes[i]);
                current = current.getNext();
            }
        }

        return nodes;
    }

    private void assertCopyStructure(RandomNode original, RandomNode copy) {
        RandomNode currentOriginal = original;
        RandomNode currentCopy = copy;

        while (currentOriginal != null && currentCopy != null) {
            assertNotSame(currentOriginal, currentCopy);
            assertEquals(currentOriginal.getData(), currentCopy.getData());
            currentOriginal = currentOriginal.getNext();
            currentCopy = currentCopy.getNext();
        }

        assertNull(currentOriginal);
        assertNull(currentCopy);
    }

    private void assertRandomLinks(RandomNode copy, Integer[] expectedRandomValues) {
        RandomNode current = copy;
        int index = 0;

        while (current != null) {
            Integer expected = expectedRandomValues[index++];
            if (expected == null) {
                assertNull(current.getRandom());
            } else {
                assertNotNull(current.getRandom());
                assertEquals(expected.intValue(), current.getRandom().getData());
            }
            current = current.getNext();
        }
    }

    private void assertOriginalRestored(RandomNode original, Integer[] expectedValues) {
        RandomNode current = original;
        int index = 0;

        while (current != null) {
            assertEquals(expectedValues[index++].intValue(), current.getData());
            current = current.getNext();
        }

        assertNull(current);
    }
}
