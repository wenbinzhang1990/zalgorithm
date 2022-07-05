package com.wenbin.logic.string;

/**
 * 反转字符串中的单词 III https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAString3 {

  public String reverseWords2(String s) {
    char[] sentence = s.toCharArray();
    int i = 0, j = 0;
    while (j < sentence.length) {
      while (i < sentence.length && sentence[i] == ' ') {
        ++i;
      }
      while (j < sentence.length && sentence[j] != ' ') {
        ++j;
      }
      reverse(sentence, i, j - 1);
      i = j;
      ++j;
    }
    s = String.valueOf(sentence);
    return s;
  }

  private void reverse(char[] arr, int start, int end) {
    if (arr.length == 0) {
      return;
    }

    while (start < end) {
      char temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      ++start;
      --end;
    }
  }

  public String reverseWords(String s) {
    if (s.length() == 0) {
      return s;
    }

    String[] strs = s.split(" ");
    for (int i = 0; i < strs.length; i++) {
      strs[i] = reverseWord(strs[i]);
    }

    return String.join(" ", strs);
  }

  private String reverseWord(String word) {
    int left = 0;
    int right = word.length() - 1;
    char[] chars = word.toCharArray();
    while (left < right) {
      char temp = chars[left];
      chars[left] = chars[right];
      chars[right] = temp;
      left++;
      right--;
    }

    return String.valueOf(chars);
  }
}
