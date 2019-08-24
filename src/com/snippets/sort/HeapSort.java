package com.snippets.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        /*保留数组0位置不用，方便通过 2k, 2k+1 的方式找到节点 K 的子节点索引*/
        int[] array = new int[]{9999, 9,4,8,2,7,11,19,1, 6,25,13};
        System.out.println("<1, 2, 3, 4 , 5 , 6 , 7 , 8 , 9 , 10, 11>");
        System.out.printf("%s, length is %d\n", Arrays.toString(Arrays.copyOfRange(array,1,12)), array.length-1);
        heapSort(array);
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,1,12)));
    }


    private static void swap(int[] array, int i, int j) {

        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void sink(int[] array, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && array[j] < array[j+1]) {
                j++;
            }
            if(array[k] > array[j]) break;
            swap(array, k, j);
            k = j;
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length-1;

        //利用下沉，构造有序大根堆
        //从 N/2开始即可，因为可以跳过堆中大小为1的子堆（没有子节点的节点）
        for (int k = n/2; k>=1; k--) {
            sink(array, k, n);
        }
        //依次将最大元素弹出堆（与堆末尾交换位置，再将堆末尾从堆中剔除）
        while (n > 1) {
            swap(array, 1, n--);
            sink(array, 1, n);
        }
    }
}
