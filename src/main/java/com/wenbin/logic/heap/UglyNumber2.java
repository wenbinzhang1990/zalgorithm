package com.wenbin.logic.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数 https://leetcode-cn.com/problems/ugly-number-ii https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class UglyNumber2 {

  public static void main(String[] args) {
    UglyNumber2 uglyNumber2 = new UglyNumber2();
    uglyNumber2.nthUglyNumberByHeap(10);
  }

  //dp实现
  public int nthUglyNumberByDp(int n) {
    int a = 0, b = 0, c = 0;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      int aInt = dp[a] * 2;
      int bInt = dp[b] * 3;
      int cInt = dp[c] * 5;
      dp[i] = Math.min(Math.min(aInt, bInt), cInt);
      if (aInt == dp[i]) {
        a++;
      }

      if (bInt == dp[i]) {
        b++;
      }

      if (cInt == dp[i]) {
        c++;
      }
    }

    return dp[n - 1];
  }

  //堆实现
  public int nthUglyNumberByHeap(int n) {
    long result = 1;
    PriorityQueue<Long> pq = new PriorityQueue();
    Set<Long> set = new HashSet();
    int[] primes = new int[]{2, 3, 5};
    for (int i = 1; i < n; i++) {
      for (int num : primes) {
        if (!set.contains(num * result)) {
          set.add(num * result);
          pq.add(num * result);
        }
      }

      result = pq.poll();
    }

    return (int) result;
  }
}
