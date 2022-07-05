package com.wenbin.logic.dp;

import java.util.Arrays;

/**
 * 最长上升子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLISByDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (dp[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }

            dp[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}
