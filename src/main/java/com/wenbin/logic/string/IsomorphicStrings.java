package com.wenbin.logic.string;

/**
 * 同构字符串 https://leetcode-cn.com/problems/isomorphic-strings
 */
public class IsomorphicStrings {

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    char[] ch1 = s.toCharArray();
    char[] ch2 = t.toCharArray();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (s.indexOf(ch1[i]) != t.indexOf(ch2[i])) {
        return false;
      }
    }

    return true;
  }
}
