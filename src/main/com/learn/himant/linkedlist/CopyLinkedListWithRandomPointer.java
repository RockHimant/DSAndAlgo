package com.learn.himant.linkedlist;

/**
 * Copies a linked list where each node contains an additional random pointer.
 *
 * <p>The list contains nodes of type {@link RandomNode}, each with a {@code next}
 * pointer and a {@code random} pointer that may reference any node in the list or be null.</p>
 *
 * <p>The {@code solve} method creates a deep copy of the original list such that:
 * <ul>
 *   <li>Each copied node has the same {@code data} value as its original counterpart.</li>
 *   <li>The {@code next} and {@code random} relationships are preserved.</li>
 *   <li>The original list is restored to its original structure.</li>
 * </ul>
 * </p>
 *
 * <p>Example:</p>
 * <pre>
 * Input: head = [1 -> 2 -> 3], random pointers: 1.random = 3, 2.random = 1, 3.random = null
 * Output: copied list with same values and random connections, original list unchanged.
 * </pre>
 *
 * <p><strong>Time Complexity:</strong> O(n), where n is the number of nodes in the list.</p>
 * <p><strong>Space Complexity:</strong> O(1) additional space, not counting the output list.
 * The algorithm interleaves copied nodes into the original list and restores it in place.</p>
 */
public class CopyLinkedListWithRandomPointer {

    /**
     * Creates a deep copy of the input list containing random pointers.
     *
     * <p>The algorithm works in three phases:</p>
     * <ol>
     *   <li>Interleave copied nodes between original nodes.</li>
     *   <li>Assign random pointers for copied nodes using the interleaved structure.</li>
     *   <li>Separate the copied list from the original list and restore original pointers.</li>
     * </ol>
     *
     * @param head the head of the original list containing random pointers
     * @return the head of the copied list, or null if the input is null
     */
    public RandomNode solve(RandomNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and interleave them with original nodes
        RandomNode current = head;
        while (current != null) {
            RandomNode newNode = new RandomNode(current.data);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // Step 2: Set random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and copied nodes
        RandomNode dummyHead = new RandomNode(0);
        RandomNode copyCurrent = dummyHead;
        current = head;

        while (current != null) {
            copyCurrent.next = current.next; // Link the copied node
            copyCurrent = copyCurrent.next; // Move the copy pointer

            // Restore the original list
            current.next = current.next.next;
            current = current.next; // Move to the next original node
        }

        return dummyHead.next; // Return the head of the copied list
    }

}
