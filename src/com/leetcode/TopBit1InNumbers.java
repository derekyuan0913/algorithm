package com.leetcode;

import java.util.Arrays;

/*
 给定一个特定的数组 int list, 返回其按照每个元素二进制形式中 1 的个数从大到小排序的前 M 个元素。
 */
public class TopBit1InNumbers {

    public static int[] topMNumbers(int[] list, int M) {
        if (list == null || list.length == 0 || M <= 0) {
            return new int[0];
        }

        M = Math.min(M, list.length);

        // 转换为Integer数组
        Integer[] numbers = Arrays.stream(list).boxed().toArray(Integer[]::new);

        // 使用Lambda表达式作为匿名比较器
        Arrays.sort(numbers, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            return countA != countB ? Integer.compare(countB, countA) : Integer.compare(b, a);
        });

        return Arrays.stream(numbers).limit(M).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(topMNumbers(test1, 3))); // [7, 6, 5]

        int[] test2 = {1024, 512, 256, 128, 64};
        System.out.println(Arrays.toString(topMNumbers(test2, 2))); // [64, 128]

        int[] test3 = {15, 7, 3, 31, 63};
        System.out.println(Arrays.toString(topMNumbers(test3, 4))); // [63, 31, 15, 7]

        System.out.println(Math.max(3,5));
    }
}
