package com.wenbin.logic.dp;

/**
 * 打家劫舍 II https://leetcode-cn.com/problems/house-robber-ii/
 */
public class HouseRobber2 {

  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    int[] dpFirst = new int[nums.length];
    dpFirst[0] = nums[0];
    dpFirst[1] = Math.max(nums[0], nums[1]);
    int[] dpLast = new int[nums.length];
    dpLast[0] = 0;
    dpLast[1] = nums[1];

    for (int i = 2; i < nums.length; i++) {
      dpLast[i] = Math.max(dpLast[i - 1], dpLast[i - 2] + nums[i]);
      if (i != nums.length - 1) {
        dpFirst[i] = Math.max(dpFirst[i - 1], dpFirst[i - 2] + nums[i]);
      } else {
        dpFirst[i] = dpFirst[i - 1];
      }

    }

    return Math.max(dpFirst[nums.length - 1], dpLast[nums.length - 1]);
  }

  public static void main(String[] args) {
    HouseRobber2 houseRobber2 = new HouseRobber2();
    houseRobber2.rob2(new int[]{1, 2, 3, 1});
  }

  public int rob2(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return nums[0];
    }

    if (nums.length == 2) {
      return Math.max(nums[0], nums[1]);
    }

    return Math.max(rob2(nums, 0, nums.length - 2), rob2(nums, 1, nums.length - 1));
  }

  public int rob2(int[] nums, int start, int end) {
    int[] dp = new int[end - start + 1];
    dp[0] = nums[start];
    dp[1] = Math.max(nums[start], nums[start + 1]);
    for (int i = 2; i <= end - start; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i + start]);
    }

    return dp[end - start];
  }

}
