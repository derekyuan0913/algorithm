package com.leetcode.easy;


/*
给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy169MajorityElement {

    public static void main(String[] args) {
        System.out.println("Input:");
        System.out.println("");
        System.out.println("Expect:");
        System.out.println("");


        System.out.println("Output:");
        System.out.println();
    }
}

class Easy169MajorityElementSolution {

    /*
    * 此题与《编程之美》中"寻找发帖水王"为为同一题。
    * 解法，思路为对不同的数两两消除，剩下的就为众数。
    *
    *
    * 或等价为 假设当前数为众数， 如果遇到一个我们目前的候选众数，就将计数器加一，否则减一。
    * 只要计数器等于 0 ，我们就将 nums 中之前访问的数字全部 忘记 ，并把下一个数字当做候选的众数。
    * */
    public int majorityElement(int[] nums) {
        int majority = 0;
        int sum = 0;
        for (int num : nums) {
            if(sum == 0) {
                majority = num;
            }
            sum += majority == num ? 1:-1;
        }
        return majority;
    }
}
