package com.leetcode;

import com.snippets.ds.tree.BinaryTree;
import com.snippets.ds.tree.TreeNode;

import java.util.Arrays;


/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

* */
public class Easy108SortedArrayToBST {

    public static void main(String[] args) {

        int[] nums = {-10,-3,0,5,9};

        System.out.println("Input:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Output:");

        TreeNode root = new Easy108SortedArrayToBSTSolution().sortedArrayToBST(nums);
        BinaryTree.inOrderTraversal(root);
    }
}

class Easy108SortedArrayToBSTSolution {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if(start > end) return null;

        int middle = start + (end - start) /2 ;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(nums, start, middle-1);
        root.right = sortedArrayToBST(nums, middle+1, end);
        return root;
    }
}
