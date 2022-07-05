package com.wenbin.logic.string;

/**
 * 最后一个单词的长度 https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

  public static void main(String[] args) {
    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
    lengthOfLastWord.lengthOfLastWord("a");
  }

  public int lengthOfLastWord(String s) {
    int length = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) != ' ') {
        length++;
      } else {
        if (length > 0) {
          return length;
        }
      }
    }

    return length;
  }

  public int lengthOfLastWordByLib(String s) {
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
  }
}
