package com.wenbin.logic.bit;

/**
 * 比特位计数 https://leetcode-cn.com/problems/counting-bits
 */
public class CountingBits {

  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      result[i] = result[i >> 1] + (i & 1);
    }

    return result;
  }
}
