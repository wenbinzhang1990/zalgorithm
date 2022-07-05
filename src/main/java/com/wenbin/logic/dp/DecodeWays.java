package com.wenbin.logic.dp;

/**
 * 解码方法 https://leetcode-cn.com/problems/decode-ways/
 */
public class DecodeWays {

  public static void main(String[] args) {
    DecodeWays decodeWays = new DecodeWays();
    decodeWays.numDecoding("120");
  }

  public int numDecoding(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= n; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }

      int second = Integer.parseInt(s.substring(i - 2, i));
      if (second >= 10 && second <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[n];
  }
}
