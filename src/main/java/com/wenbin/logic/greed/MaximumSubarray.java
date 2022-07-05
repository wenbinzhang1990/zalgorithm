package com.wenbin.logic.greed;

public class MaximumSubarray {

  public static void main(String[] args) {
    MaximumSubarray maximumSubarray = new MaximumSubarray();
    maximumSubarray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
  }

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(sum, max);
      if (sum <= 0) {
        sum = 0;
      }
    }

    return sum;
  }

  public int maxSubArrayByDp(int[] nums) {
    int[] db = new int[nums.length];
    db[0] = nums[0];
    int max = db[0];
    for (int i = 1; i < nums.length; i++) {
      db[i] = db[i - 1] > 0 ? (db[i - 1] + nums[i]) : nums[i];
      if (max < db[i]) {
        max = db[i];
      }
    }

    return max;
  }
}
