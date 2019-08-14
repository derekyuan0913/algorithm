package com.leetcode;

import java.util.Arrays;

/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

给定 nums = [0,0,1,1,1,2,2,3,3,4],

函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

你不需要考虑数组中超出新长度后面的元素。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy26RmDupFromSortedArray {

    public static void main(String[] args) {

        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        System.out.println("Input:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Expect:");
        System.out.println(5);
        System.out.println("[0, 1, 2, 3, 4]");

        System.out.println("Output:");
        int len = new Easy26RmDupFromSortedArraySolution().removeDuplicates2(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, len)));
    }
}


class Easy26RmDupFromSortedArraySolution {

    /*
    解法1：双指针，依次判断当前数与后续几个数是否相当，时间效率差

    * */
    public int removeDuplicates(int[] nums) {

        int position = 0;

        for (int i = 0; i < nums.length;) {
            int step = 1;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] != nums[j]) {
                    break;
                }
                step++;
            }
            nums[position] = nums[i];
            position++;
            i+=step;
        }
        return position;
    }

    /*
    解法2 双指针法（leetcode官方解法）
    i为慢指针，j为快指针，只要nums[j] == nums[j], 就增加j以跳过重复项
    * */

    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    /*
    解法3 单层循环，依次判断当前数与前一个数是否相等。
    * */
    public int removeDuplicates3(int[] nums) {
        if (nums.length ==0) {
            return 0;
        }

        int position = 1;
        int prevValue = nums[0];
        for (int i = 1; i < nums.length;i++) {
            if(nums[i] != prevValue) {
                nums[position] = nums[i];
                position++;
            }
            prevValue = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(position);
        return position;
    }
}
