package com.wenbin.logic.string;

/**
 * 旋转字符串 https://leetcode-cn.com/problems/rotate-string/
 */
public class RotateString {

  public boolean rotateString1(String a, String b) {
    return a.length() == b.length() && (a + a).contains(b);
  }


  public static void main(String[] args) {
    RotateString rotateString = new RotateString();
    rotateString.rotateString("abcde", "cdeab");
  }

  public boolean rotateString(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }

    int len = a.length();
    for (int i = 0; i < len; i++) {
      String first = a.substring(0, 1);
      String last = a.substring(1, len);
      a = last + first;
      if (a.equals(b)) {
        return true;
      }
    }
    return false;
  }
}
