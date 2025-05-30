package com.leetcode.medium;

import java.util.Arrays;


/*
编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
示例:

现有矩阵 matrix 如下
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

给定 target = 5，返回 true。

给定 target = 20，返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


* */
public class Medium240Search2dArrayII {

    public static void main(String[] args) {
        int[][] array = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println("Input:");
        for(int[] a: array) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("Expect:");
        System.out.println("true");


        System.out.println("Output:");
        System.out.println(searchMatrix(array, 16));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int rowCount = matrix.length;
        if(rowCount == 0) return false;

        int columnCount = matrix[0].length;
        if(columnCount == 0) return false;

        int i = rowCount -1;
        int j = 0;
        while ( i >=0 && j < columnCount) {
            System.out.printf("a[%d][%d] = %d\n", i,j,matrix[i][j]);
            if(target == matrix[i][j]) {
                return true;
            }else if (target > matrix[i][j]) {
                j++;
            }else {
                i--;
            }
        }
        return false;
    }
}

