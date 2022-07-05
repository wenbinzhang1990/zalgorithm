package com.wenbin.logic.dp;

/**
 * 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/description/
 */
public class MaximumProductSubarray {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int max = nums[0];
    int[] dpMax = new int[nums.length + 1];
    dpMax[0] = nums[0];
    int[] dpMin = new int[nums.length + 1];
    dpMin[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      dpMax[i] = Math.max(nums[i], Math.max(dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]));
      dpMin[i] = Math.min(nums[i], Math.min(dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]));
      max = Math.max(max, Math.max(dpMax[i], dpMin[i]));
    }
    return max;
  }
}
