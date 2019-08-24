package com.snippets.sort;

import java.util.Arrays;

public class SimpleSort {


    public static void main(String[] args) {

        int[] array = new int[]{9,4,8,2,7,11};
        System.out.println(Arrays.toString(array));
        InsertionSort(array);
        System.out.println(Arrays.toString(array));

    }

    /*
    * 冒泡排序， 稳定
    * */
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    /*
    * 选择排序，不稳定
    * 找到最小元素，与第一个元素交换位置。在剩下元素中找到最小元素，与第二个元素交换位置
    * */
    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] <= array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }

    /*
    * 插入排序，稳定
    *
    * 从当前元素开始，后往前查找，找到该元素合适的插入位置
    * */
    public static void InsertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j-1] ; j--) {
                int tmp = array[j];
                array[j] = array[j-1];
                array[j-1] = tmp;
            }
        }
    }
}

