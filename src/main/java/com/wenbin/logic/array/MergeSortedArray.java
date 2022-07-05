package com.wenbin.logic.array;

import java.util.Arrays;

/**
 * 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

  // 循环合并
  public void mergeForIteration(int[] nums1, int m, int[] nums2, int n) {
    int numsOne = m - 1;
    int numsTwo = n - 1;
    for (int i = m + n - 1; i >= 0; i--) {
      if (numsOne < 0) {
        nums1[i] = nums2[numsTwo--];
        continue;
      }

      if (numsTwo < 0) {
        nums1[i] = nums1[numsOne--];
        continue;
      }

      nums1[i] = nums1[numsOne] > nums2[numsTwo] ? nums1[numsOne--] : nums2[numsTwo--];
    }
  }

  //数学合并
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }
}
