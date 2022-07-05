package com.wenbin.logic.bit;

/**
 * 2的幂 https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }
}
