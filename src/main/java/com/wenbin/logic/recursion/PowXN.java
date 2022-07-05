package com.wenbin.logic.recursion;

/**
 * Pow(x, n) https://leetcode-cn.com/problems/powx-n/ 注意：暴力求解会出现问题，一旦数量过大会出现java.lang.StackOverflowError
 */
public class PowXN {

  /**
   * 将每次x*x转化为每次xN*xN,将时间复杂度从n缩短成logN，避免StackOverflowError
   */
  public double myPow(double x, int n) {
    return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
  }


  public double quickMul(double x, int n) {
    if (n == 0) {
      return 1.0;
    }

    double y = quickMul(x, n / 2);
    return n % 2 == 0 ? y * y : y * y * x;
  }
}
