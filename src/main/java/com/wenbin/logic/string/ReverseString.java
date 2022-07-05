package com.wenbin.logic.string;

/**
 * 反转字符串 https://leetcode-cn.com/problems/reverse-string/
 */
public class ReverseString {

  public void reverseString(char[] s) {
    if (s == null || s.length == 0) {
      return;
    }

    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }
}
