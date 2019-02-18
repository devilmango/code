package com.mango.problems;

import com.mango.ds.TreeNode;

import java.util.Objects;

/**
 * Check if given binary tree is BST.
 * Source: Unknown
 *
 * Tree may contain node with same weight. If so, put that node in left side
 */
public class BinaryTreeIsBST {

    private Boolean isBST(TreeNode root) {
        return isBSTUtility(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private Boolean isBSTUtility(TreeNode root, int min, int max) {

        if (Objects.isNull(root)) {
            return Boolean.TRUE;
        }

        if (root.weight < min || root.weight > max) {
            return Boolean.FALSE;
        }

        return isBSTUtility(root.leftChild, min, root.weight) &&
                isBSTUtility(root.rightChild, root.weight, max);
    }

    public void checkForBST() {
        //sampleTest1();
        sampleTest2();
        sampleTest3();
        sampleTest4();
        sampleTest5();
        sampleTest6();
        sampleTest7();
    }
    private static final String MESSAGE = "isBST: [%s]";

    private void sampleTest1() {
        /*
         *         null    --> root
         */
        System.out.println("Test 1: Null root");
        System.out.println(String.format(MESSAGE, isBST(null)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest2() {
        /*
         *         8    --> root
         */
        TreeNode root = new TreeNode(8);

        System.out.println("Test 2: Only one Vertex");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest3() {
        /*
         *         8    --> root
         *        /
         *       3
         */
        TreeNode root = new TreeNode(8);
        root.leftChild =  new TreeNode(3);

        System.out.println("Test 1: Tree with only left child");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest4() {
        /*
         *         8    --> root
         *        /
         *       3
         *      /
         *     1
         */
        TreeNode root = new TreeNode(8);
        root.leftChild =  new TreeNode(3);
        root.leftChild.leftChild =  new TreeNode(1);

        System.out.println("Test 4: Tree with two left child");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest5() {
        /*
         *         8    --> root
         *        / \
         *       3   2
         */
        TreeNode root = new TreeNode(8);
        root.leftChild =  new TreeNode(3);
        root.rightChild =  new TreeNode(2);

        System.out.println("Test 5: Balanced tree with two child");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest6() {
        /*
        /*
         *         8    --> root
         *        / \
         *       4   9
         *      /   / \
         *     1   2  13
         */
        TreeNode root = new TreeNode(8);
        root.leftChild =  new TreeNode(4);
        root.leftChild.leftChild =  new TreeNode(1);

        root.rightChild =  new TreeNode(9);
        root.rightChild.leftChild =  new TreeNode(2);
        root.rightChild.rightChild =  new TreeNode(13);

        System.out.println("Test 6: Balanced tree with two level");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }

    private void sampleTest7() {
        /*
        /*
         *         8    --> root
         *        / \
         *       4  12
         *      /   / \
         *     1   9  13
         */
        TreeNode root = new TreeNode(8);
        root.leftChild =  new TreeNode(4);
        root.leftChild.leftChild =  new TreeNode(1);

        root.rightChild =  new TreeNode(12);
        root.rightChild.leftChild =  new TreeNode(9);
        root.rightChild.rightChild =  new TreeNode(13);

        System.out.println("Test 7: Balanced tree with two level and BST");
        System.out.println(String.format(MESSAGE, isBST(root)));
        System.out.println("------------------------------------------");
    }
}
