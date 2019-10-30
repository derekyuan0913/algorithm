package com.leetcode;


/*
编写一个程序，找到两个单链表相交的起始节点。

 - 如果两个链表没有交点，返回 null.
 - 在返回结果后，两个链表仍须保持原有的结构。
 - 可假定整个链表结构中没有循环。
 - 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */

import com.snippets.ds.ListNode;

public class Easy160IntersectionNodeOfLinkedLists {

    public static void main(String[] args) {

        ListNode headA = new ListNode(new int[]{1,2,4,5,9,6,3});
        ListNode headB = new ListNode(new int[]{8,7,9,6,3});

        System.out.println("Expect:");
        System.out.println("9");

        System.out.println("Output:");
        System.out.println(new Easy160IntersectionNodeOfLinkedListsSolution()
                .getIntersectionNode2(headA,headB).val);
    }
}



class Easy160IntersectionNodeOfLinkedListsSolution {

    /*
    方法1，长链表指针先走的方式消除长度差，最终两链表即可同时走到相交点

    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int listALength = 0;
        int listBLength = 0;

        if(headA == null || headB == null) {
            return null;
        }

        //计算链表长度
        ListNode iterNode = headA;
        while (iterNode!= null) {
            listALength++;
            iterNode = iterNode.next;
        }
        iterNode = headB;
        while (iterNode != null) {
            listBLength++;
            iterNode = iterNode.next;
        }

        //较长链表跳过长度差skip的节点
        if(listALength > listBLength) {
            int skip = listALength-listBLength;
            while (skip > 0 && headA !=null) {
                headA = headA.next;
                skip--;
            }
        }else {
            int skip = listBLength-listALength;
            while (skip > 0 && headB !=null) {
                headB = headB.next;
                skip--;
            }
        }

        //两链表同步前进，找到相交节点
        while (headA!=null && headB !=null) {
            //if(headA == headB) {
            if(headA .val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    /*
    长度差补齐法，详情见 leetcode高赞同题解。

    长链表补齐法，同时遍历两链表，任意一个链表遍历到尾部时，将指针指向另一个链表头部继续同时遍历，
    即可在遍历过程中找到相交节点。

    假设长链表 长度为M, 短链表长度为N, 当长链表遍历完时，即 将长度差加在短链表后继续遍历，

    M = N+(M-N)，此时，两链表长度差消除，同时遍历即可找到相同节点
    * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        //while (pA != pB) {
        while (pA.val != pB.val) {
            pA = pA.next == null ? headB : pA.next;
            pB = pB.next == null ? headA : pB.next;
        }
        return pA;
    }
}
