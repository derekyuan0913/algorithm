package com.leetcode.easy;


import com.snippets.ds.ListNode;

/*
给定一个链表，判断链表中是否有环。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Easy141LinkedListCycle {

    public static void main(String[] args) {
        System.out.println("Input:");
        System.out.println("");
        System.out.println("Expect:");
        System.out.println("");


        System.out.println("Output:");
        System.out.println();
    }
}

class Easy141LinkedListCycleSolution {


    /*
    未做出

    双指针（快慢指针法）
    思路：快指针一次移动两步，慢指针一次移动一步。若存在环，则快慢指针最终将会重合。若遇到指针为空，则说明不存在环。

    想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。而快跑者最终一定会追上慢跑者。

    * */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }
}
