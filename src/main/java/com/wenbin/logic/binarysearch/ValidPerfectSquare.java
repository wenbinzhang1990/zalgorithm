package com.wenbin.logic.binarysearch;

/**
 * 有效的完全平方数  https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

  public boolean isPerfectSquare(int num) {
    int l = 0;
    int r = num;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if ((long) mid * mid < num) {
        l = mid + 1;
      } else if ((long) mid * mid > num) {
        r = mid - 1;
      } else {
        return true;
      }
    }
    return false;
  }
}
