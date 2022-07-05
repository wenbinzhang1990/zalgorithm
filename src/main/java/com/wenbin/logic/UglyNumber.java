package com.wenbin.logic;

/**
 * 丑数 https://leetcode-cn.com/problems/ugly-number/
 */
public class UglyNumber {

  public boolean isUgly(int num) {
    if (num <= 0) {
      return false;
    }

    int[] ugly = new int[]{2, 3, 5};
    for (int uglyNum : ugly) {
      while (num % uglyNum == 0) {
        num /= uglyNum;
      }
    }

    return num == 1;
  }
}
