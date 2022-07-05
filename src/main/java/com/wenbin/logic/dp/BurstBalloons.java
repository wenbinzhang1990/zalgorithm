package com.wenbin.logic.dp;

/**
 * 戳气球 https://leetcode-cn.com/problems/burst-balloons/
 */
public class BurstBalloons {

  public static void main(String[] args) {
    BurstBalloons burstBalloons = new BurstBalloons();
    burstBalloons.maxCoins(new int[]{3, 1, 5, 8});
  }

  public int maxCoins(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int length = nums.length;
    int[] nums2 = new int[length + 2];
    System.arraycopy(nums, 0, nums2, 1, length);
    nums2[0] = 1;
    nums2[length + 1] = 1;
    length = nums2.length;
    int[][] dp = new int[length][length];
    for (int i = length - 2; i >=0; i--) {
      for (int j = i + 2; j < length; j++) {
        for (int k = i + 1; k < j; k++) {
          dp[i][j] = Math.max(dp[i][k] + dp[k][j] + nums2[i] * nums2[k] * nums2[j], dp[i][j]);
        }
      }
    }

    return dp[0][length - 1];
  }
}
