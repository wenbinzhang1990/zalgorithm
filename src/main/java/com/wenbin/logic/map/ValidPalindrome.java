package com.wenbin.logic.map;

/**
 * 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);
      if (!Character.isLetterOrDigit(leftChar)) {
        left++;
        continue;
      }

      if (!Character.isLetterOrDigit(rightChar)) {
        right--;
        continue;
      }

      if (Character.toLowerCase(leftChar) == (Character.toLowerCase(rightChar))) {
        left++;
        right--;
        continue;
      }

      return false;
    }

    return true;
  }
}
