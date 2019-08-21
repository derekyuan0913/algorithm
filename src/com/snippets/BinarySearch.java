package com.snippets;

import java.util.Arrays;

public class BinarySearch {


    public static void main(String[] args) {

        int[] array = {1,4,7,8,11,13,19,26,33,39,50};

        System.out.println("<0, 1, 2, 3, 4 , 5 , 6 , 7 , 8 , 9 , 10>");
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int target = array[i];
            System.out.printf("target: %d\nexpect: a[%d]\n", target, i);
            System.out.printf("result: a[%d]\n\n",binarySearch(array, target));
        }
    }


    /*
    * 二分搜索，返回数组中目标数的位置下标
    * */
    public static int binarySearch(int[] array, int target) {

        int left = 0;
        int right = array.length -1;
        int middle;
        while (left <= right ) {

            middle = (left + right)/2;
            if(target == array[middle]) {
                return middle;
            }else if (target < array[middle]) {
                right = middle -1;
            }else {
                left = middle +1;
            }
        }
        return -1;
    }
}
