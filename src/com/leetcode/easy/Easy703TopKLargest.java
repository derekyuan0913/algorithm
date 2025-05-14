package com.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。

你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy703TopKLargest {

    public static void main(String[] args) {

        int[] nums = {11,4,7,8,6,13,2};
        int k = 5;

        System.out.println("Input:");
        System.out.println(Arrays.toString(nums));

        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(54));
        System.out.println(kthLargest.add(55));
        System.out.println(kthLargest.add(56));
    }
}


/*
* 解法：求第 K 大的数，则利用数据流中前 K 个元素构造小根堆，堆顶始终为第 K 大的元素。
*
* 后续数据流中的元素若大于堆顶，则将堆顶删除，将新元素加入堆中（堆重新调整为有序）。堆顶
* 始终为 第 K 大的元素。
*
* 可直接利用 JAVA 内置的优先队列（小根堆实现）
*
*
*
* */
class KthLargest {

    private PriorityQueue<Integer> queue;
    private int maxHeapSize;

    public KthLargest(int k, int[] nums) {

        maxHeapSize = k;
        queue = new PriorityQueue<>(k);

        if (k < nums.length) {
            for (int i = 0; i < k; i++) {
                queue.add(nums[i]);
            }

            for (int j = k; j < nums.length; j++) {
                if (nums[j] > queue.peek()) {
                    queue.poll();
                    queue.offer(nums[j]);
                }
            }
        }else {
            for(int val : nums) {
                queue.add(val);
            }
        }
    }

    public int add(int val) {

        if(queue.size() < maxHeapSize) {
            queue.offer(val);
            return queue.peek();
        }

        if(val > queue.peek()) {
            queue.poll();
            queue.offer(val);
            return queue.peek();
        }
        return queue.peek();
    }
}
