package com.leetcode.medium;

import java.util.Arrays;


/*
编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

输入:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Medium74Search2dArray {

    public static void main(String[] args) {

        int[][] array = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 16;
        System.out.println("Input:");
        for(int[] a: array) {
            System.out.println(Arrays.toString(a));
        }

        System.out.println("Expect:");
        System.out.println("true");


        System.out.println("Output:");
        System.out.println(searchMatrix2(array, target));
    }

    /*
     * 解法1 缩小范围递归法
     *
     * 目标数与二位数组左下角数相比，大于则遍历最后一行逐个比较，小于则裁剪掉最后一行，用裁剪后的新数组重复此操作。
     * */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        if(rowCount == 0) return false;

        int columnCount = matrix[0].length;
        if(columnCount == 0) return false;

        if(rowCount == 1) {
            if(target < matrix[0][0]) return false;
            for (int i = 0; i < columnCount; i++) {
                if(matrix[0][i] == target) {
                    return true;
                }
            }
            return false;
        }
        int bottomLeftCorner = matrix[rowCount-1][0];
        if( target == bottomLeftCorner) {
            return true;
        }else if( target > bottomLeftCorner) {
            for (int i = 0; i < columnCount; i++) {
                if(matrix[rowCount-1][i] == target) {
                    return true;
                }
            }
            return false;
        }else {
            return searchMatrix(Arrays.copyOfRange(matrix,0, rowCount-1), target);
        }
    }


    /*
     * 二分搜索法（将数组降维）
     * */
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int rowCount = matrix.length;
        if(rowCount == 0) return false;

        int columnCount = matrix[0].length;
        if(columnCount == 0) return false;

        int left = 0;
        int right = rowCount * columnCount -1;
        int middle, middleValue;

        while (left <= right) {
            middle = (left + right) /2;
            middleValue = matrix[middle / columnCount][middle % columnCount];
            if(target == middleValue) {
                return true;
            }else if(target > middleValue) {
                left = middle +1;
            }else {
                right = middle -1;
            }
        }
        return false;
    }
}

