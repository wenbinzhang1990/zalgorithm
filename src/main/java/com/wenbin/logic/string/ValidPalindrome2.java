package com.wenbin.logic.string;

/**
 * 验证回文字符串 Ⅱ https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2 {

  public boolean validPalindrome(String s) {
    char[] chars = s.toCharArray();
    int i = 0;
    int j = chars.length - 1;
    while (i < j && chars[i] == chars[j]) {
      i++;
      j--;
    }
    if (isValid(chars, i + 1, j)) {
      return true;
    }
    if (isValid(chars, i, j - 1)) {
      return true;
    }
    return false;
  }

  private boolean isValid(char[] chars, int i, int j) {
    while (i < j) {
      if (chars[i++] != chars[j--]) {
        return false;
      }
    }
    return true;
  }
}
