package com.oklimenko.algo.list;

public class FindNthElementInSingleLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {1, 2};
        int n = 2;
//    int []listB = {5,6,1,8,4,5};
//    int intersectVal = 8;

        ListNode headA = null;
        for (int i = 0; i < arr.length; i++) {
            headA = addAtTail(headA, arr[i]);
        }

        System.out.println(removeNthFromEnd(headA, n).val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int len = 0;
        while (p2 != null) {
            p2 = p2.next;
            len++;
        }
        if (len ==1 && n==1) {
            return null;
        }
        if (len == n) {
            return head.next;
        }
        for (int i = 0; i < len - n - 1; i++) {
            p1 = p1.next;
        }
        if (p1.next != null) {
            p1.next = p1.next.next;
        }
        return head;
    }

    public static ListNode addAtTail(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
//            tail = head;
//            head.next = null;
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new ListNode(val);
//        tail = curr.next;
//        head.next = null;
        return head;
    }
}
