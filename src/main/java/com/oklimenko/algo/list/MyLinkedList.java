package com.oklimenko.algo.list;

import java.util.List;

public class MyLinkedList {

    static public MyLinkedList compose(Integer[] arr, int idx) {
        MyLinkedList myLinkedList1 = new MyLinkedList();

        while (idx < arr.length && arr[idx] != null) {
            myLinkedList1.addAtTail(arr[idx]);
            idx++;
        }
        int count = 0;
        while (idx < arr.length && arr[idx] == null) {
            count++;
//            myLinkedList1.addAtTail(arr[idx]);
            idx++;
        }
        if (idx < arr.length) {
            MyLinkedList sublist = compose(arr, idx);
            ListNode item = myLinkedList1.getItem(count-1);
            if (item!=null) {
                item.child = sublist.head;
            }
        }
        return myLinkedList1;
    }

    static public ListNode insert(ListNode head, int insertVal) {
        if (head == null) {
            head = new ListNode(insertVal);
            head.next = head;
            return head;
        }
        ListNode curr = head;
        int count = 0;
        do {
            if (insertVal >= curr.val|| count>1 && curr.val>=curr.next.val && (insertVal <= curr.val)) {
                ListNode inserting = new ListNode(insertVal);
                inserting.next = curr.next;
                curr.next = inserting;
                return head;
            }
            curr = curr.next;
            if (curr == head) {
                count++;
            }
        } while (count<3);
        return head;
    }

    static public ListNode flatten(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                ListNode flatHead = flatten( curr.child );
                ListNode lastTail = flatHead;
                while (lastTail.next != null) {
                    lastTail.child = null;
                    lastTail = lastTail.next;
                }
                if (curr.next != null) {
                    curr.next.prev = lastTail;
                }
                lastTail.next = curr.next;
                curr.child.prev = curr;
                ListNode next = curr.next;
                curr.next = curr.child;
                curr = next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {

        MyLinkedList myLinkedList1 = new MyLinkedList();
        myLinkedList1.addAtTail(1);
        myLinkedList1.head.next = myLinkedList1.head;
        ListNode result = insert(myLinkedList1.head, 0);
        while (result.next!=null) {
            System.out.println(result.val);
            result = result.next;
        }

        /*

//        Integer arr[] = {1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12};
        Integer arr[] = {1,2,null,3};
//        Output: [1,2,3,7,8,11,12,9,10,4,5,6];

//        MyLinkedList myLinkedList1 = new MyLinkedList();
        MyLinkedList myLinkedList1 = compose(arr, 0);

        ListNode result = flatten(myLinkedList1.head);

        while (result.next!=null) {
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);

        System.out.println("!!!");
        while (result!=null) {
            System.out.println(result.val);
            result = result.prev;
        }*/

//        for (int i = 0; i < l1.length; i++) {
//            myLinkedList1.addAtTail(l1[i]);
//        }

//        whil

//        int l1[] = {0};//{2,4,3};
//        int l2[] = {0};//{5,6,4};

       /* int l1[] = {9,9,9,9,9,9,9};
        int l2[] = {9,9,9,9};
//        [8,9,9,9,0,0,0,1]
//        Output: [7,0,8]
        MyLinkedList myLinkedList1 = new MyLinkedList();
        for (int i = 0; i < l1.length; i++) {
            myLinkedList1.addAtTail(l1[i]);
        }

        MyLinkedList myLinkedList2 = new MyLinkedList();
        for (int i = 0; i < l2.length; i++) {
            myLinkedList2.addAtTail(l2[i]);
        }

        ListNode result = addTwoNumbers(myLinkedList1.head, myLinkedList2.head);
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
        System.out.println();*/

//        [null,null,null,null,-1,2,null,null,null,null,null,null,null,null,84,null,null,null,null,null,null,null,null,null,null,null,16,null,null,null,null,null,null,null,null,37,null,null,null,null,null,23,null,null,null,null,null,null,null,null,null,null,null,null,null,null,19,null,17,null,null,56,null,null,31,null,17,null,12,null,null,null,null,null,null,null,40,null,null,null,37,null,76,null,-1,null,null,null,null,null,null,80,null,null,null,null,43,null,null,null,-1,null]
//        [null,null,null,null,-1,2,null,null,null,null,null,null,null,null,84,null,null,null,null,null,null,null,null,null,null,null,16,null,null,null,null,null,null,null,null,37,null,null,null,null,null,23,null,null,null,null,null,null,null,null,null,null,null,null,null,null,19,null,17,null,null,56,null,null,31,null,17,null,12,null,null,null,null,null,null,null,40,null,null,null,37,null,76,null,42,null,null,null,null,null,null,80,null,null,null,null,43,null,null,null,40,null]

//    ["MyLinkedList","addAtHead","addAtTail","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"]
//    [[],[84],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]]

       /* MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(84);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtTail(39);
        myLinkedList.get(3);
        myLinkedList.get(1);
        myLinkedList.addAtTail(42);
        myLinkedList.addAtIndex(1,80);
        myLinkedList.addAtHead(14);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(53);
        myLinkedList.addAtTail(98);
        myLinkedList.addAtTail(19);
        myLinkedList.addAtTail(12);
        myLinkedList.get(2);
        myLinkedList.addAtHead(16);
        myLinkedList.addAtHead(33);
        myLinkedList.addAtIndex(4,17);
        myLinkedList.addAtIndex(6,8);
        myLinkedList.addAtHead(37);
        myLinkedList.addAtTail(43);
        myLinkedList.deleteAtIndex(11);
        myLinkedList.addAtHead(80);
        myLinkedList.addAtHead(31);
        myLinkedList.addAtIndex(13,23);
        myLinkedList.addAtTail(17);
        myLinkedList.get(4);
        myLinkedList.addAtIndex(10,0);
        myLinkedList.addAtTail(21);
        myLinkedList.addAtHead(73);
        myLinkedList.addAtHead(22);
        myLinkedList.addAtIndex(24,37);
        myLinkedList.addAtTail(14);
        myLinkedList.addAtHead(97);
        myLinkedList.addAtHead(8);
        myLinkedList.get(6);
        myLinkedList.deleteAtIndex(17);
        myLinkedList.addAtTail(50);
        myLinkedList.addAtTail(28);
        myLinkedList.addAtHead(76);
        myLinkedList.addAtTail(79);
        myLinkedList.get(18);
        myLinkedList.deleteAtIndex(30);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(83);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtTail(40);
        myLinkedList.deleteAtIndex(26);
        myLinkedList.addAtIndex(20,90);
        myLinkedList.deleteAtIndex(30);
        myLinkedList.addAtTail(40);
        myLinkedList.addAtHead(56);
        myLinkedList.addAtIndex(15,23);
        myLinkedList.addAtHead(51);
        myLinkedList.addAtHead(21);
        myLinkedList.get(26);
        myLinkedList.addAtHead(83);
        myLinkedList.get(30);
        myLinkedList.addAtHead(12);
        myLinkedList.deleteAtIndex(8);
        myLinkedList.get(4);
        myLinkedList.addAtHead(20);
        myLinkedList.addAtTail(45);
        myLinkedList.get(10);
        myLinkedList.addAtHead(56);
        myLinkedList.get(18);
        myLinkedList.addAtTail(33);
        myLinkedList.get(2);
        myLinkedList.addAtTail(70);
        myLinkedList.addAtHead(57);
        myLinkedList.addAtIndex(31,24);
        myLinkedList.addAtIndex(16,92);
        myLinkedList.addAtHead(40);
        myLinkedList.addAtHead(23);
        myLinkedList.deleteAtIndex(26);
        myLinkedList.get(1);
        myLinkedList.addAtHead(92);
        myLinkedList.addAtIndex(3,78);
        myLinkedList.addAtTail(42);
        myLinkedList.get(18);
        myLinkedList.addAtIndex(39,9);
        myLinkedList.get(13);
        myLinkedList.addAtIndex(33,17);
        myLinkedList.get(51);
        myLinkedList.addAtIndex(18,95);
        myLinkedList.addAtIndex(18,33);
        myLinkedList.addAtHead(80);
        myLinkedList.addAtHead(21);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtIndex(17,46);
        myLinkedList.get(33);
        myLinkedList.addAtHead(60);
        myLinkedList.addAtTail(26);
        myLinkedList.addAtTail(4);
        myLinkedList.addAtHead(9);
        myLinkedList.get(45);
        myLinkedList.addAtTail(38);
        myLinkedList.addAtHead(95);
        myLinkedList.addAtTail(78);
        myLinkedList.get(54);
        myLinkedList.addAtIndex(42,86);*/


       /* String s1 = "[\"MyLinkedList\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"get\",\"get\",\"addAtTail\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"addAtTail\",\"addAtTail\",\"get\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtTail\",\"deleteAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"get\",\"addAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtHead\",\"get\",\"deleteAtIndex\",\"addAtTail\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"get\",\"deleteAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"deleteAtIndex\",\"addAtTail\",\"deleteAtIndex\",\"addAtIndex\",\"deleteAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"get\",\"addAtHead\",\"get\",\"addAtHead\",\"deleteAtIndex\",\"get\",\"addAtHead\",\"addAtTail\",\"get\",\"addAtHead\",\"get\",\"addAtTail\",\"get\",\"addAtTail\",\"addAtHead\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"deleteAtIndex\",\"get\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"get\",\"addAtIndex\",\"get\",\"addAtIndex\",\"get\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtTail\",\"addAtIndex\",\"get\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"addAtHead\",\"get\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"get\",\"addAtIndex\"]";
        String s2 = "[[],[84],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]]";

        List<String> s1List = new LinkedList<>();
        List<String> s2List = new LinkedList<>();

        String[] result1 = s1.split("\",\"");
        String[] result2 = s2.split("],\\[");
        for (String s : result1) {
            s1List.add(s.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("]", ""));
//            System.out.println(">" + s.replaceAll("\"", "")
//                    .replaceAll("\\[", "")
//                    .replaceAll("]", "")+ "<");
        }
        for (String s: result2) {
            s2List.add(s.replaceAll("\"", "").replaceAll("\\[", "").replaceAll("]", ""));
//            System.out.println(">" + s.replaceAll("\"", "")
//                    .replaceAll("\\[", "")
//                    .replaceAll("]", "")+ "<");
        }

        for (int i = 0; i < s1List.size(); i++) {
            System.out.println("myLinkedList." + s1List.get(i) + "(" + s2List.get(i) + ");");
        }*/

        /*int arr[] = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            myLinkedList.addAtTail(arr[i]);
        }

        myLinkedList.addAtIndex(2, 11);

        for (int i = 0; i < arr.length+1; i++) {
            System.out.println(myLinkedList.get(i));
        }
        */
//        addAtHead 84
//        addAtTail 2
//
//        ["","","","addAtTail","get","get","addAtTail","addAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","addAtHead","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","deleteAtIndex","addAtHead","addAtHead","addAtIndex","addAtTail","get","addAtIndex","addAtTail","addAtHead","addAtHead","addAtIndex","addAtTail","addAtHead","addAtHead","get","deleteAtIndex","addAtTail","addAtTail","addAtHead","addAtTail","get","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","deleteAtIndex","addAtIndex","deleteAtIndex","addAtTail","addAtHead","addAtIndex","addAtHead","addAtHead","get","addAtHead","get","addAtHead","deleteAtIndex","get","addAtHead","addAtTail","get","addAtHead","get","addAtTail","get","addAtTail","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtHead","deleteAtIndex","get","addAtHead","addAtIndex","addAtTail","get","addAtIndex","get","addAtIndex","get","addAtIndex","addAtIndex","addAtHead","addAtHead","addAtTail","addAtIndex","get","addAtHead","addAtTail","addAtTail","addAtHead","get","addAtTail","addAtHead","addAtTail","get","addAtIndex"]
//[[],[],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]]


//[null,null,null,null,-1,2,null,null,null,null,null,null,null,null,84,null,null,null,null,null,null,null,null,null,null,null,16,null,null,null,null,null,null,null,null,37,null,null,null,null,null,23,null,null,null,null,null,null,null,null,null,null,null,null,null,null,19,null,17,null,null,56,null,null,31,null,17,null,12,null,null,null,null,null,null,null,40,null,null,null,37,null,76,null,-1,null,null,null,null,null,null,80,null,null,null,null,43,null,null,null,-1,null]
//[null,null,null,null,-1,2,null,null,null,null,null,null,null,null,84,null,null,null,null,null,null,null,null,null,null,null,16,null,null,null,null,null,null,null,null,37,null,null,null,null,null,23,null,null,null,null,null,null,null,null,null,null,null,null,null,null,19,null,17,null,null,56,null,null,31,null,17,null,12,null,null,null,null,null,null,null,40,null,null,null,37,null,76,null,42,null,null,null,null,null,null,80,null,null,null,null,43,null,null,null,40,null]

        /*MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtTail(3);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.print();
        myLinkedList.printBk();
        System.out.println("GET " + myLinkedList.get(1));
        myLinkedList.print();
        myLinkedList.printBk();
        System.out.println("DELETE @ INDEX");
        myLinkedList.deleteAtIndex(0);
        myLinkedList.print();
        myLinkedList.printBk();
        System.out.println("GET " + myLinkedList.get(0));
        myLinkedList.print();
        myLinkedList.printBk();*/

//["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//[[],[1],[3],[1,2],[1],[0],[0]]
        // 1
        // 1 3
        // 1 2 3
        // -> 2
        // 2 3
        // -> 2




//        Kozko, Marco

//        ["","","","","get","","get"]
//[[],[],[],[],[],[0],[0]]




//["","","","","","deleteAtIndex","get"]
//[[],[],[],[],[],[],[]]
/*
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtHead(7);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtHead(2);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtHead(1);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.deleteAtIndex(2);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtHead(6);
        myLinkedList.print();
        myLinkedList.printBk();
        myLinkedList.addAtTail(4);
        myLinkedList.print();
        myLinkedList.printBk();

        System.out.println(myLinkedList.get(4));*/


//        ["","","","","","","","","get","addAtHead","addAtIndex","addAtHead"]
//[[],[],[],[],[],[],[],[],[4],[4],[5,0],[6]]
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        9,9,9,9,9,9,9
//        9,9,9,9
        ListNode result = new ListNode(0);
        ListNode headRes = result;
        int nextVal = 0;
        while (l1!=null || l2!=null || nextVal!=0) {
            int sum = nextVal;
            int val1;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
//            int sum = val1 + val2 + nextVal;
            int val = sum % 10;
            nextVal = sum / 10;
            ListNode nextResult = new ListNode(val);
            result.next = nextResult;
            result = nextResult;
        }
//        if ( nextVal!=0 ) {
//            ListNode nextResult = new ListNode(nextVal);
//            result.next = nextResult;
//            result = nextResult;
//        }
        return headRes.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newHead = new ListNode(0);
        ListNode newCurr = newHead;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while (curr1!=null || curr2!=null) {
            if (curr2==null) {
                newCurr.next = curr1;
                newCurr = curr1;
                curr1 = curr1.next;
                continue;
            }
            if (curr1==null) {
                newCurr.next = curr2;
                newCurr = curr2;
                curr2 = curr2.next;
                continue;
            }
            if (curr1.val < curr2.val) {
                newCurr.next = curr1;
                newCurr = curr1;
                curr1 = curr1.next;
            } else {
                newCurr.next = curr2;
                newCurr = curr2;
                curr2 = curr2.next;
            }
        }
        return newHead.next;
    }

    boolean isPrint = false;

    static class ListNode {
        int val;
        ListNode next, prev, child;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;

    public MyLinkedList() {
    }

    public int get(int index) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            if (n == index) {
                if (isPrint) {
                    System.out.println("GET!!! " + index + ": " + curr.val);
                }
                return curr.val;
            }
            curr = curr.next;
            n++;
        }
        if (isPrint) {
            System.out.println("GET!!! " + index + ": " + -1);
        }
        return -1;
    }

    public ListNode getItem(int index) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            if (n == index) {
                if (isPrint) {
                    System.out.println("GET!!! " + index + ": " + curr.val);
                }
                return curr;
            }
            curr = curr.next;
            n++;
        }
        if (isPrint) {
            System.out.println("GET!!! " + index + ": " + -1);
        }
        return null;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
        if (isPrint) {
            print();
            printBk();
        }
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        newNode.prev = tail;

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        if (head == null) {
            head = newNode;
        }
        if (isPrint) {
            print();
            printBk();
        }
    }

    public void addAtIndex(int index, int val) {
        if (head == null && index == 0) {
            addAtHead(val);
            if (isPrint) {
                print();
                printBk();
            }
            return;
        }
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            if (n == index) {
                ListNode newNode = new ListNode(val);
                ListNode prev = curr.prev;
                newNode.next = curr;
                newNode.prev = prev;
                if (prev == null) {
                    head = newNode;
                } else {
                    prev.next = newNode;
                }
                curr.prev = newNode;
                if (isPrint) {
                    print();
                    printBk();
                }
                return;
            }
            curr = curr.next;
            n++;
        }
        if (n == index) {
            addAtTail(val);
        }
        if (isPrint) {
            print();
            printBk();
        }
    }

    public void deleteAtIndex(int index) {
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            if (n == index) {
                ListNode prev = curr.prev;
                ListNode next = curr.next;
                curr.prev = curr.next = null;
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }
                if (next == null) {
                    tail = prev;
                } else {
                    next.prev = prev;
                }
                if (isPrint) {
                    print();
                    printBk();
                }
                return;
            }
            curr = curr.next;
            n++;
        }
        if (isPrint) {
            print();
            printBk();
        }
    }

    public void print() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.next;
        }
        System.out.println();
    }

    public void printBk() {
        ListNode curr = tail;
        while (curr != null) {
            System.out.print(curr.val + ",");
            curr = curr.prev;
        }
        System.out.println("---");
    }
}
