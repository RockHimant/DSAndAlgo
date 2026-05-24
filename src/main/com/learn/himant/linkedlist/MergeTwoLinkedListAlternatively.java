package com.learn.himant.linkedlist;

/**
 * Provides multiple approaches to merge two linked lists alternately.
 *
 * <p><strong>Problem Statement:</strong></p>
 * <p>Given two singly linked lists, merge them alternately such that nodes from both lists
 * are interleaved in the resulting list. If one list is longer than the other, append the
 * remaining nodes from the longer list at the end.</p>
 *
 * <p><strong>Input:</strong></p>
 * <ul>
 *   <li>Two linked list heads: {@code head1} and {@code head2}</li>
 *   <li>Lists may be of different lengths or empty</li>
 * </ul>
 *
 * <p><strong>Expected Output:</strong></p>
 * <ul>
 *   <li>A single merged linked list with nodes alternating from both input lists</li>
 *   <li>If one list is exhausted, the remaining nodes from the other list are appended</li>
 * </ul>
 *
 * <p><strong>Examples:</strong></p>
 * <ul>
 *   <li>Input: head1 = [1, 2, 3], head2 = [a, b, c]<br>
 *       Output: [1, a, 2, b, 3, c]</li>
 *   <li>Input: head1 = [1, 2, 3, 4], head2 = [a, b]<br>
 *       Output: [1, a, 2, b, 3, 4]</li>
 *   <li>Input: head1 = [1], head2 = [a, b, c]<br>
 *       Output: [1, a, b, c]</li>
 *   <li>Input: head1 = null, head2 = [a, b]<br>
 *       Output: [a, b]</li>
 * </ul>
 *
 * <p><strong>Time Complexity:</strong></p>
 * <p>All methods: O(n + m), where n and m are the lengths of the two lists.</p>
 *
 * <p><strong>Space Complexity:</strong></p>
 * <ul>
 *   <li>In-place methods: O(1) - modifies existing nodes</li>
 *   <li>Recursive method: O(n + m) - due to recursion stack</li>
 * </ul>
 *
 * <p>This class provides three different implementations for educational purposes:</p>
 * <ul>
 *   <li>In-place modification</li>
 *   <li>Iterative with dummy node</li>
 *   <li>Recursive approach</li>
 * </ul>
 */
public class MergeTwoLinkedListAlternatively {

    /**
     * In-place alternating merge using the first list as the base.
     *
     * <p>This method modifies the pointers of the original lists without creating new nodes.
     * It starts with the first list and alternates by linking nodes from the second list.</p>
     *
     * <p><strong>Algorithm:</strong></p>
     * <ol>
     *   <li>Traverse both lists simultaneously</li>
     *   <li>Link current1.next to current2</li>
     *   <li>Link current2.next to next1</li>
     *   <li>Move pointers forward</li>
     *   <li>Stop when either list is exhausted</li>
     * </ol>
     *
     * @param head1 the head of the first linked list (may be null)
     * @param head2 the head of the second linked list (may be null)
     * @return the head of the merged linked list
     *
     * <p><strong>Time Complexity:</strong> O(n + m)</p>
     * <p><strong>Space Complexity:</strong> O(1)</p>
     *
     * <p><strong>Example:</strong></p>
     * <pre>
     * Input: head1 = [1, 2, 3], head2 = [a, b]
     * Output: [1, a, 2, b, 3]
     * </pre>
     */
    public Node solveInPlace(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null && current2 != null) {
            Node next1 = current1.next;
            Node next2 = current2.next;

            current1.next = current2;

            if (next1 == null) {
                break;
            }

            current2.next = next1;
            current1 = next1;
            current2 = next2;
        }

        return head1;
    }

    /**
     * Iterative merge using a dummy head and a tail pointer.
     *
     * <p>This method builds the merged list by reusing existing nodes and appending them
     * in alternating order through a tail pointer. It preserves the original lists.</p>
     *
     * <p><strong>Algorithm:</strong></p>
     * <ol>
     *   <li>Create a dummy node and tail pointer</li>
     *   <li>Alternate appending nodes from both lists to tail</li>
     *   <li>Append remaining nodes from the non-empty list</li>
     *   <li>Return dummy.next</li>
     * </ol>
     *
     * @param head1 the head of the first linked list (may be null)
     * @param head2 the head of the second linked list (may be null)
     * @return the head of the merged linked list
     *
     * <p><strong>Time Complexity:</strong> O(n + m)</p>
     * <p><strong>Space Complexity:</strong> O(1)</p>
     *
     * <p><strong>Example:</strong></p>
     * <pre>
     * Input: head1 = [1, 2], head2 = [a, b, c]
     * Output: [1, a, 2, b, c]
     * </pre>
     */
    public Node solveWithDummy(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node dummy = new Node(0);
        Node tail = dummy;
        Node current1 = head1;
        Node current2 = head2;

        while (current1 != null && current2 != null) {
            tail.next = current1;
            current1 = current1.next;
            tail = tail.next;

            tail.next = current2;
            current2 = current2.next;
            tail = tail.next;
        }

        tail.next = current1 != null ? current1 : current2;
        return dummy.next;
    }

    /**
     * Recursive alternating merge.
     *
     * <p>This method alternates nodes recursively by connecting head1 to head2 and then
     * recurring on the remaining sublists. It modifies the original lists.</p>
     *
     * <p><strong>Algorithm:</strong></p>
     * <ol>
     *   <li>Base cases: if either list is null, return the other</li>
     *   <li>Save next pointers</li>
     *   <li>Connect head1.next to head2</li>
     *   <li>Recurse on remaining lists and connect to head2.next</li>
     *   <li>Return head1</li>
     * </ol>
     *
     * @param head1 the head of the first linked list (may be null)
     * @param head2 the head of the second linked list (may be null)
     * @return the head of the merged linked list
     *
     * <p><strong>Time Complexity:</strong> O(n + m)</p>
     * <p><strong>Space Complexity:</strong> O(n + m) due to recursion stack</p>
     *
     * <p><strong>Example:</strong></p>
     * <pre>
     * Input: head1 = [1, 2], head2 = [a, b]
     * Output: [1, a, 2, b]
     * </pre>
     */
    public Node solveRecursive(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node next1 = head1.next;
        Node next2 = head2.next;

        head1.next = head2;
        head2.next = solveRecursive(next1, next2);

        return head1;
    }

    /**
     * Default merge method preserving the original in-place behavior.
     *
     * <p>This is an alias for {@link #solveInPlace(Node, Node)} to maintain backward compatibility.</p>
     *
     * @param head1 the head of the first linked list (may be null)
     * @param head2 the head of the second linked list (may be null)
     * @return the head of the merged linked list
     *
     * <p><strong>Time Complexity:</strong> O(n + m)</p>
     * <p><strong>Space Complexity:</strong> O(1)</p>
     */
    public Node solve(Node head1, Node head2) {
        return solveInPlace(head1, head2);
    }
}
