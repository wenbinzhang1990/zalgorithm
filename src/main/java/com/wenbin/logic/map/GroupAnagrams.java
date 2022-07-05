package com.wenbin.logic.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortedStr = String.valueOf(chars);
      if (!map.containsKey(sortedStr)) {
        map.put(sortedStr,new ArrayList<String>());
      }

      map.get(sortedStr).add(str);
    }

    return new ArrayList<>(map.values());

  }
}
