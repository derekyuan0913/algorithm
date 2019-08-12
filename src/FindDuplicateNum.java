



/* 在一个长度为N的数组里所有数字都在 0到n-1范围内，其中某些数字是重复的，重复次数未知。
*  请找出数组中任意一个重复的数字。
*  如输入长度为 7的 数组 {2,3,1,0,2,5,3}, 那么对应输出为2或者3.
* */

import java.util.Arrays;
import java.util.HashMap;

public class FindDuplicateNum {

    public static void main(String[] args) {

        int[] inputArray = {2,3,1,0,2,5,3};

        int result = Solution.findDuplicateNum2(inputArray);
        System.out.println(result);
    }
}


class Solution {

    /* 利用哈希表特性， 依次添加数字到哈希表， 若存在重复键，则能立即找到重复数字*/
    public static int findDuplicateNum(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i= 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                return array[i];
            }else {
                map.put(array[i], i);
            }
        }
        return -1;
    }


    /* 对数组排序，再遍历找到重复数组，时间复杂度为排序的复杂度(若为二分排序，则为O(nlogn) )*/
    public static int findDuplicateNum2(int[] array) {

        Arrays.sort(array);
        int tmp = -1;
        for(int i= 0; i < array.length; i++) {
            if (array[i] == tmp) {
                return array[i];
            }else {
                tmp = array[i];
            }

        }
        return -1;
    }

}