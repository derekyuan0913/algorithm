package com.leetcode.easy;

import com.snippets.ds.tree.BinaryTree;
import com.snippets.ds.tree.TreeNode;

import java.util.Stack;

/*
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明: 叶子节点是指没有子节点的节点。

示例: 
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

* */
public class Easy112PathSum {

    public static final int NULL = BinaryTree.NULL;

    public static void main(String[] args) {


        int[] nodes = {
                5,
                4,                   8,
                11,     NULL,        13,         4,
                7, 2, NULL,NULL,  NULL, NULL,  NULL, 1};

        System.out.println("Expect:");
        System.out.println("true");


        TreeNode root = BinaryTree.createBinaryTree(nodes);
        boolean result = hasPathSum2(root, 22);

        System.out.println("Output:");
        System.out.println(result);
    }

    /*
     * 解法1 递归法
     *
     * 依次判断子树是否满足节点和等于 （sum - 当前根节点 val）
     * */
    public static boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        if(root.left == null && root.right == null) {
            return root.val == sum;
        }
        int target = sum - root.val;
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }

    /*
     * 解法2 迭代法(DFS深度优先)
     *
     * */
    public static boolean hasPathSum2(TreeNode root, int sum) {

        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sum_stack = new Stack<>();

        stack.push(root);
        sum_stack.push(sum - root.val);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentSum = sum_stack.pop();

            if(node.left == null && node.right == null && currentSum == 0) {
                return true;
            }
            if(node.right != null) {
                stack.push(node.right);
                sum_stack.push(currentSum - node.right.val);
            }
            if(node.left != null) {
                stack.push(node.left);
                sum_stack.push(currentSum - node.left.val);
            }
        }
        return false;
    }
}

