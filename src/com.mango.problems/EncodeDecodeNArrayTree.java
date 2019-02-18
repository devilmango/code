package com.mango.problems;

import com.mango.ds.NArrayTreeNode;
import com.mango.ds.TreeNode;

import java.util.Objects;

/**
 * LeetCode: 431 Encode N-ary tree to binary tree.
 *
 * implement encode and decode algorithm
 */
public class EncodeDecodeNArrayTree {

    private TreeNode encode(NArrayTreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        TreeNode binaryTreeRoot = new TreeNode(root.weight);

        // Store first child on left side and rest all child on the right of left child
        if(!root.childes.isEmpty()) {
            binaryTreeRoot.leftChild = encode(root.childes.get(0));
            TreeNode binaryTreeRootIterator = binaryTreeRoot.leftChild;
            for (int childsIterator = 1; childsIterator< root.childes.size(); childsIterator++) {
                binaryTreeRootIterator.rightChild = encode(root.childes.get(childsIterator));
                binaryTreeRootIterator = binaryTreeRootIterator.rightChild;
            }
        }

        return binaryTreeRoot;
    }

    private NArrayTreeNode decode(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }

        NArrayTreeNode nArrayTreeNodeRoot = new NArrayTreeNode(root.weight);
        TreeNode binaryTreeRootIterator = root.leftChild;
        while (binaryTreeRootIterator != null) {
            nArrayTreeNodeRoot.childes.add(decode(binaryTreeRootIterator));
            binaryTreeRootIterator = binaryTreeRootIterator.rightChild;
        }

        return nArrayTreeNodeRoot;
    }

    public void startEncodeDecode() {
        sampleTest1();
        sampleTest2();
    }

    private Boolean checkTwoNArrayTreeAreSame(NArrayTreeNode root1, NArrayTreeNode root2) {
        if ((Objects.isNull(root1) && Objects.isNull(root2)) ||
                Objects.isNull(root1) ||
                Objects.isNull(root2) ||
                root1.weight != root2.weight ||
                root1.childes.size() != root2.childes.size()) {
            return Boolean.FALSE;
        }
        Boolean status = Boolean.TRUE;
        for(int childIterator = 0; childIterator<root1.childes.size() ; childIterator++) {
            status = status && checkTwoNArrayTreeAreSame(root1.childes.get(childIterator), root2.childes.get(childIterator));
            if (!status) {
                return  status;
            }
        }

        return status;
    }

    private static final String MESSAGE = "EncodeDecode Result: [%s]";

    private void sampleTest1() {
        /*
        /*
         *           8            --> root
         *        /  |   \
         *       4   9    3
         *      /   / \
         *     1   2  13
         */
        NArrayTreeNode root = new NArrayTreeNode(8);
        root.childes.add(new NArrayTreeNode(4));
        root.childes.add(new NArrayTreeNode(9));
        root.childes.add(new NArrayTreeNode(3));

        root.childes.get(0).childes.add(new NArrayTreeNode(1));
        root.childes.get(1).childes.add(new NArrayTreeNode(2));
        root.childes.get(1).childes.add(new NArrayTreeNode(13));

        System.out.println("Test 1: N Array tree level 2 with N=3");
        System.out.println(String.format(MESSAGE, checkTwoNArrayTreeAreSame(root, decode(encode(root)))));
        System.out.println("------------------------------------------");
    }

    private void sampleTest2() {
        /*
        /*
         *           1            --> root
         *        /  |   \
         *       3   2    4
         *      / \
         *     5   6
         */
        NArrayTreeNode root = new NArrayTreeNode(1);
        root.childes.add(new NArrayTreeNode(3));
        root.childes.add(new NArrayTreeNode(2));
        root.childes.add(new NArrayTreeNode(4));

        root.childes.get(0).childes.add(new NArrayTreeNode(5));
        root.childes.get(0).childes.add(new NArrayTreeNode(6));

        System.out.println("Test 2: N Array tree level 2 with N=3");
        System.out.println(String.format(MESSAGE, checkTwoNArrayTreeAreSame(root, decode(encode(root)))));
        System.out.println("------------------------------------------");
    }
}
