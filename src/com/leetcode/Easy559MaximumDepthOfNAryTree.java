package com.leetcode;

import java.util.*;


/*
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

* */
public class Easy559MaximumDepthOfNAryTree {

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Easy559MaximumDepthOfNAryTreeSolution {

    /*
    * 解法1：迭代（利用节点和深度双栈，或单栈存储<节点,深度> ）
    * */
    public int maxDepth(Node root) {

        if(root == null) return 0;

        Stack<Node> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);
        int maxDepth = 1;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int currentDepth = depthStack.pop();
            if(node.children.isEmpty()) {
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            for(Node child: node.children) {
                stack.push(child);
                depthStack.push(currentDepth+1);
            }
        }

        return maxDepth;
    }


    /*
    * 解法2 递归
    * */
    public int maxDepth2(Node root) {
        if(root == null) return 0;
        if(root.children.isEmpty()) return 1;

        List<Integer> list = new ArrayList<>();
        for (Node child : root.children) list.add(maxDepth2(child));

        return Collections.max(list)+1;

    }
}
