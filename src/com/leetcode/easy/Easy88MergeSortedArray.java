package com.leetcode.easy;

/*
给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import java.util.Arrays;

public class Easy88MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3, 7, 9, 0, 0, 0};
        int[] nums2 = {3,6,8};
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        System.out.println("Output:");
        new Easy88MergeSortedArraySolution().merge(nums1, 5, nums2,nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}

class Easy88MergeSortedArraySolution {

    /*
    * 双指针法（未做出）
    * p1, p2 分别指向两数组尾部，将较大的值放入数组最终位置
    * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n  -1;

        while (p1 >=0 && p2 >=0) {
            nums1[p--] = nums1[p1] >= nums2[p2]? nums1[p1--]:nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2+1);
    }
}
