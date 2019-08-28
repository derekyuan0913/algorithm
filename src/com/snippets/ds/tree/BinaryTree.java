package com.snippets.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTree {

    public final static int NULL = Integer.MAX_VALUE;

    /*
    * 利用数组构造二叉树
    * */

    public static TreeNode createBinaryTree(int[] nodes) {
        return createBinaryTree(nodes, 0);
    }

    public static TreeNode createBinaryTree(int[] nodes, int index) {

        if (index > nodes.length -1) return null;
        if (nodes[index] == NULL) return null;

        TreeNode root = new TreeNode(nodes[index]);
        root.left = createBinaryTree(nodes, 2*index+1);
        root.right = createBinaryTree(nodes, 2*index+2);
        return root;
    }


    /*
    * 先序遍历(递归)
    * 考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根-左-右)
    * */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        printNode(root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /*
     * 中序遍历(递归)
     * 考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左-根-右)
     * */
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        printNode(root);
        inOrderTraversal(root.right);
    }

    /*
    * 后序遍历(递归)
    * 考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左-右-根)
    * */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        printNode(root);
    }


    public static void levelTraversal(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while ( !queue.isEmpty()) {
            TreeNode node = queue.poll();
            printNode(node);
            if (node.left !=null) queue.offer(node.left);
            if (node.right !=null) queue.offer(node.right);
        }
    }
    /*
     * 先序遍历(非递归)
     * 考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根-左-右)
     * */
    public static void nonRecursivePreOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            TreeNode node = root;
            while (node!= null || !stack.isEmpty()) {

                if(node != null) {
                    printNode(node);
                    stack.push(node);
                    node = node.left;
                }else {
                    node = stack.pop().right;
                }
            }
        }
    }


    /*
     * 中序遍历(非递归)
     * 考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左-根-右)
     * */
    public static void nonRecursiveInOrderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                printNode(node);
                node = node.right;
            }
        }

    }

    /*
     * 后序遍历(非递归)
     * 考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左-右-根)
     * */
    public static void nonRecursivePostOrderTraversal(TreeNode root) {

        /*
        * TODO: 完成后续遍历非递归实现
        * */


    }

    private static void printNode(TreeNode node) {
        System.out.print(node.val +" ");
    }



    public static void main(String[] args) {

        int[] nodes = {
                                5,
                       4,                   8,
                 11,     NULL,        13,         4,
                7, 2, NULL,NULL,  NULL, NULL,  NULL, 1};


        TreeNode root = createBinaryTree(nodes, 0);

        System.out.println("Pre order traversal:");
        preOrderTraversal(root);
        System.out.println();
        nonRecursivePreOrderTraversal(root);

        System.out.println("\nIn order traversal:");
        inOrderTraversal(root);
        System.out.println();
        nonRecursiveInOrderTraversal(root);

        System.out.println("\nPost order traversal:");
        postOrderTraversal(root);
        //System.out.println();
        //nonRecursivePostOrderTraversal(root);

        System.out.println("\nLevel traversal:");
        levelTraversal(root);
    }
}






