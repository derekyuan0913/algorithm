package com.leetcode.easy;

import com.snippets.ds.tree.BinaryTree;
import com.snippets.ds.tree.TreeNode;

import java.util.Stack;

/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class Easy104MaximumDepthOfBinaryTree {

    private static final int NULL = BinaryTree.NULL;
    public static void main(String[] args) {

        int[] nodes = {3,9,20,NULL,NULL,15,7};

        TreeNode tree = BinaryTree.createBinaryTree(nodes);

        System.out.println("Expect:");
        System.out.println("3");


        System.out.println("Output:");
        System.out.println(new Easy104MaximumDepthSolution().maxDepth2(tree));
    }
}

class Easy104MaximumDepthSolution {


    /*
    * 解法1 递归
    * */
    public int maxDepth(TreeNode root) {

        if (root == null) return 0;

        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);

        return leftMax > rightMax ? leftMax : rightMax;
    }



    /*
    * 解法2 迭代（DFS 深度优先）
    * */
    public int maxDepth2(TreeNode root) {


        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);
        int maxDepth = 1;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depthStack.pop();
            if(node.left == null && node.right == null) {
                maxDepth = maxDepth > currentDepth ? maxDepth:currentDepth;
            }
            if(node.right != null) {
                stack.push(node.right);
                depthStack.push(currentDepth +1);
            }
            if(node.left != null) {
                stack.push(node.left);
                depthStack.push(currentDepth +1);
            }
        }
        return maxDepth;
    }
}
