package com.mango.problems;

import java.util.Objects;

/**
 * LeetCode: 563 Binary Tree Tilt
 */
public class BinaryTreeTilt {

    private int findTilt(TreeNode root) {
        return findTiltUtility(root).tiltValue;
    }

    private TiltDataCollector findTiltUtility(TreeNode root) {
        if (Objects.isNull(root)) {
            return new TiltDataCollector(0, 0);
        }

        TiltDataCollector leftTiltDataCollector = findTiltUtility(root.leftChild);
        TiltDataCollector rightTiltDataCollector = findTiltUtility(root.rightChild);

        int totalTiltSoFar = (leftTiltDataCollector.tiltValue + rightTiltDataCollector.tiltValue) +
                Math.abs(leftTiltDataCollector.totalWeightOfChild - rightTiltDataCollector.totalWeightOfChild);
        int totalWeightSoFar = leftTiltDataCollector.totalWeightOfChild + rightTiltDataCollector.totalWeightOfChild;

        return new TiltDataCollector(
                totalTiltSoFar,
                (root.weight + totalWeightSoFar)
        );
    }

    class TiltDataCollector {
        public int tiltValue;
        public int totalWeightOfChild;

        public TiltDataCollector(int tiltValue, int totalWeightOfChild) {
            this.tiltValue = tiltValue;
            this.totalWeightOfChild = totalWeightOfChild;
        }
    }

    class TreeNode {
        public int weight;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode (int weight) {
            this.weight = weight;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public void processSolution() {
        sampleTest1();
        sampleTest2();
        sampleTest3();
        sampleTest4();
        sampleTest5();
        sampleTest6();
    }

    private void sampleTest1() {
        /*
         *         null    --> root
         */
        System.out.println("Test 1: Null root");
        System.out.println("Total Tilt Of Tree: ["+ findTilt(null) +"]");
        System.out.println("------------------------------------------");
    }

    private void sampleTest2() {
        /*
         *         8    --> root
         */
        TreeNode root = new TreeNode(8);

        System.out.println("Test 2: Only one Vertex");
        System.out.println("Total Tilt Of Tree: ["+ findTilt(root) +"]");
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
        System.out.println("Total Tilt Of Tree: ["+ findTilt(root) +"]");
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
        System.out.println("Total Tilt Of Tree: ["+ findTilt(root) +"]");
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
        System.out.println("Total Tilt Of Tree: ["+ findTilt(root) +"]");
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

        System.out.println("Test 5: Balanced tree with two level");
        System.out.println("Total Tilt Of Tree: ["+ findTilt(root) +"]");
        System.out.println("------------------------------------------");
    }
}
