package com.oklimenko.algo.list;

public class LinkedListCycle {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode head = null;
    private static ListNode tail = null;


    public static void main(String[] args) {
//        int [] arr = {3, 2, 0, -4};
        int [] arr = {1, 2};
        int pos = 0;

        for (int i = 0; i < arr.length; i++) {
            addAtTail(arr[i]);
        }
        if (pos > -1) {
            ListNode curr = head;
            int i = 0;
            for (; i < pos; i++) {
                curr = curr.next;
            }
            tail.next = curr;
        }
    }

    public static void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
//            head.next = null;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
        tail = curr.next;
//        head.next = null;
    }

    /**
     * This is the solution: find if the linked list as a cycle.
     * @param head - linked list head.
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        if (head == null) {
            return false;
        }
        while (true) {
            fastRunner = fastRunner.next;
            if (slowRunner == fastRunner) {
                return true;
            }
            if (fastRunner == null) {
                return false;
            }
            fastRunner = fastRunner.next;
            if (slowRunner == fastRunner) {
                return true;
            }
            if (fastRunner == null) {
                return false;
            }
            slowRunner = slowRunner.next;
            if (slowRunner == null) {
                return false;
            }
        }
    }
}
