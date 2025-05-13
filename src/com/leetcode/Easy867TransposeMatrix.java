package com.leetcode;

import java.util.Arrays;

/*
* 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

示例:
输入：matrix = [
[1,2,3],
[4,5,6],
[7,8,9],
[10,11,12]
]
输出：[
[1,4,7,10],
[2,5,8,11],
[3,6,9,12]
]

* */
public class Easy867TransposeMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int[][] transposeMatrix = transpose(matrix);

        System.out.println("transpose is");
        System.out.printf(Arrays.deepToString(transposeMatrix));
    }

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
