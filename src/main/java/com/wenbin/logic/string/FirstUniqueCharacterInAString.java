package com.wenbin.logic.string;

/**
 * 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {

  public int firstUniqChar(String s) {
    int[] sArray = new int[26];
    for (int i = 0; i < s.length(); i++) {
      sArray[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length(); i++) {
      if (sArray[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }
}
