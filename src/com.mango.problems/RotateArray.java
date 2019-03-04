package com.mango.problems;

import java.util.Arrays;

/**
 * LeetCode: 189. Rotate Array
 */
public class RotateArray {

    private void rotate(int[] nums, int k) {
        if (nums.length == 0 || k < 1 || k > nums.length) {
            System.out.println("Result: " + Arrays.toString(nums) + "\n");
            return;
        }

        for (int iterator = 0; iterator < k; iterator++) {
            int temp = nums[0];
            nums[0] = nums[nums.length -1];

            for (int arrayIterator = 1; arrayIterator < nums.length; arrayIterator++) {
                int holder = nums[arrayIterator];
                nums[arrayIterator] = temp;
                temp = holder;
            }
        }
        System.out.println("Result: " + Arrays.toString(nums) + "\n");
    }

    public void initiateSampleRotation() {
        sampleRotation1();
        sampleRotation2();
        sampleRotation3();
    }

    private void sampleRotation1() {
        int[] nums = {};
        System.out.println("Test1: Array: " + Arrays.toString(nums));
        System.out.println("k = " + 1);
        rotate(nums.clone(), 1);

        int[] nums2 = {1, 2};
        System.out.println("Test1: Array: " + Arrays.toString(nums2));
        System.out.println("k = " + 100);
        rotate(nums2.clone(), 100);

        System.out.println("Test1: Array: " + Arrays.toString(nums2));
        System.out.println("k = " + -3);
        rotate(nums2.clone(), -3);
    }

    private void sampleRotation2() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test2: Array: " + Arrays.toString(nums));
        System.out.println("k = " + 1);
        rotate(nums.clone(), 1);
        System.out.println("k = " + 2);
        rotate(nums.clone(), 2);
        System.out.println("k = " + 3);
        rotate(nums.clone(), 3);

    }

    private void sampleRotation3() {
        int[] nums = {-1,-100,3,99};
        System.out.println("Test3: Array: " + Arrays.toString(nums));
        System.out.println("k = " + 1);
        rotate(nums.clone(), 1);
        System.out.println("k = " + 2);
        rotate(nums.clone(), 2);
    }
}
