package com.learn.himant.arrayAndHashing;

/* 
 * Problem Statement:
 * Given an array of strings, group anagrams together.
 * 
 * Algorithm:
 * This class will implement a solution using a HashMap to store groups of anagrams.
 * 
 * Time Complexity: O(m * n)
 * - Where m is the number of strings and n is the average length of each string.
 * - Sorting each string takes O(n log n) time, and we do this for m strings.
 * 
 * Space Complexity: O(m * n)
 * - In the worst case, the HashMap will store all strings.
 * 
 * @author Himant
 */
public class GroupAnagram {

    public java.util.List<java.util.List<String>> solve(String[] strs) {
        java.util.List<java.util.List<String>> result = new java.util.ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result; // No anagrams possible
        }
        java.util.HashMap<String, java.util.List<String>> anagramGroups = new java.util.HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            java.util.Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramGroups.computeIfAbsent(sortedStr, k -> new java.util.ArrayList<>()).add(str);
        }
        result.addAll(anagramGroups.values());
        return result;
    }

}
