package com.wenbin.logic.string;

/**
 * 仅仅反转字母 https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {

  public String reverseOnlyLetters(String s) {
    int left = 0, right = s.length() - 1;
    char[] chars = s.toCharArray();
    while (left < right) {
      if (!Character.isLetter(chars[left])) {
        left++;
        continue;
      }

      if (!Character.isLetter(chars[right])) {
        right--;
        continue;
      }

      char temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
    }

    return String.valueOf(chars);
  }
}
