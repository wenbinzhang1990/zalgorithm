package com.wenbin.logic.bit;

/**
 * 颠倒二进制位 https://leetcode-cn.com/problems/reverse-bits/
 */
public class ReverseBits {

  public int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      res = (res << 1) + (n & 1);
      n >>= 1;
    }
    return res;
  }
}
