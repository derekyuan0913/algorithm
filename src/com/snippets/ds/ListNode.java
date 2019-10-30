package com.snippets.ds;


/*
 * Definition for singly-linked list.
 * */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int[] array) {
        this(array[0]);
        ListNode pre = this;
        for (int i = 1; i < array.length; i++) {
            pre.next = new ListNode(array[i]);
            pre = pre.next;
        }
    }
}
