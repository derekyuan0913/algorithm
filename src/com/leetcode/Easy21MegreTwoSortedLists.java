package com.leetcode;


/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

https://leetcode-cn.com/problems/merge-two-sorted-lists/
* */


public class Easy21MegreTwoSortedLists {

    public static void main(String[] args) {
        System.out.println("Input:");
        System.out.println("");
        System.out.println("Expect:");
        System.out.println("");


        System.out.println("Output:");
        System.out.println();
    }
}

class Easy21MegreTwoSortedListsSolution {


    /*
    * 遍历法，依次比较两个链表当前节点大小，维护一个前一个节点的指针，将指针指向当前较小的节点
    *
    * 未做出
    * 做题过程中，思路想出来，但没想到用prev指针维护前一个节点的操作
    * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


}
