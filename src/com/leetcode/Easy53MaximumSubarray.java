package com.leetcode;

import java.util.Arrays;

/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy53MaximumSubarray {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Expect:");
        System.out.println("6");


        System.out.println("Output:");
        System.out.println(new Easy53MaximumSubarraySolution().maxSubArray(nums));
    }
}

class Easy53MaximumSubarraySolution {

    /*
    未做出
    动态规划
    如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
    如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
    * */
    public int maxSubArray(int[] nums) {

        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum = sum > 0 ? sum+num : num;
            result = result > sum ? result : sum;
        }
        return result;
    }
}
