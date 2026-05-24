package com.learn.himant.linkedlist;

public class MergeKSortedList {

    public Node solve(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }   
    public Node mergeKLists(Node[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        Node l1 = mergeKLists(lists, left, mid);
        Node l2 = mergeKLists(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }
}
