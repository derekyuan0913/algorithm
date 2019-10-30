package com.leetcode;

import com.snippets.ds.ListNode;

/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

https://leetcode-cn.com/problems/reverse-linked-list/


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }

* */
public class Easy206ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println("Input:");
        System.out.println("");
        System.out.println("Expect:");
        System.out.println("");


        System.out.println("Output:");
        System.out.println();
    }
}

class Easy206ReverseLinkedListSolution {

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode next = null;

        while (head!=null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return head;
    }
}
