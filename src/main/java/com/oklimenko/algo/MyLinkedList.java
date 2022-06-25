package com.oklimenko.algo;

import com.oklimenko.util.StringUtils;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class MyLinkedList {

    /*MyLinkedList() Initializes the MyLinkedList object.
    int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
    void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    void addAtTail(int val) Append a node of value val as the last element of the linked list.
    void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
    void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.*/

    public static class Node {
        int val;
        public Node next;

        public Node() {
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static String m1(int monthNumber) {
        return Month   // Enum class, predefining names for each month of the year.
                .of(monthNumber)
                .getDisplayName(
                        TextStyle.SHORT_STANDALONE, Locale.US
                );
    }

    public static void main(String[] args) {
        System.out.println(m1(1));
        System.out.println(StringUtils.month(1));
        System.out.println(StringUtils.monthCorrected(1));
    }

    private Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        head = new Node(val, head);
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val, null);
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(val, null);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node curr = head;
        Node prev = curr;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (prev != null) {
            prev.next = new Node(val, prev.next == null ? null : prev.next);
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
            }
            return;
        }
        int i = 0;
        Node curr = head;
        Node prev = head;
        while (curr != null) {
            if (i == index) {
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
        if (curr != null) {
            prev.next = curr.next;
        }
    }

//    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//
//        myLinkedList.addAtIndex(1, 0);
//        System.out.println(myLinkedList.get(0));


//        ["MyLinkedList","addAtIndex","get"]
//[[],[1,0],[0]]

        /*myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(7);
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);


//        myLinkedList.get(1);
//        myLinkedList.addAtHead(5);
//        myLinkedList.addAtHead();


//,"addAtHead","deleteAtIndex"]
//,[1],[4]]

      /*  myLinkedList.addAtHead(0);
        myLinkedList.addAtIndex(1, 4);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(4, 3);
        myLinkedList.addAtTail(0);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtIndex(6, 3);
        myLinkedList.deleteAtIndex(7);
        myLinkedList.deleteAtIndex(5);
        myLinkedList.addAtTail(4);


*/

       /* [,"","deleteAtIndex","addAtTail"]
[,[,[5],[4]] */

        /*myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
        myLinkedList.addAtIndex(2, 33);

        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);*/


       /* myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(3);

        myLinkedList.addAtIndex(1, 5);
        myLinkedList.addAtIndex(3, 7);

        myLinkedList.deleteAtIndex(11);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.deleteAtIndex(0);*/
//        myLinkedList.deleteAtIndex(2);

/*
//        myLinkedList.addAtTail(55);
        myLinkedList.addAtObjectStreamConstantHead(1);
//        myLinkedList.addAtHead(2);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        System.out.println(myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(myLinkedList.get(1));              // return 3*/
//    }

}
