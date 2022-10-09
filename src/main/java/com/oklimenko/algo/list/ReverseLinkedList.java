package com.oklimenko.algo.list;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;


//        int arr[] = {1, 2, 3, 4, 5};
//        int arr[] = {};
//    int []listB = {5,6,1,8,4,5};
//    int intersectVal = 8;
        ListNode headA = null;
        for (int i = 0; i < arr.length; i++) {
            headA = addAtTail(headA, arr[i]);
        }

        ListNode newHead = removeElements(headA, val);
//        ListNode newHead = reverseList(headA);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode curr = newHead;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return newHead.next;
    }

    public static List<Integer> listToArr(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = head;
        while (head != null && head.next != null) {
            ListNode itemToMove = head.next;
            head.next = itemToMove.next;
            itemToMove.next = newHead;
            newHead = itemToMove;
        }
        return newHead;
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
