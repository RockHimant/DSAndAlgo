package com.learn.himant.arrayAndHashing;

/* 
 * Problem Statement:
 * Given two strings s and t, determine if t is an anagram of s.
 * 
 * Algorithm:
 * This class will implement a solution using a HashMap to count the frequency of each character in both strings.
 * 
 * Time Complexity: O(n)
 * - Iterating through the strings takes O(n) time.
 * - Updating the HashMap takes O(1) average time.
 * 
 * Space Complexity: O(k)
 * - In the worst case, the HashMap will store all unique characters from both strings.
 * 
 * @author Himant
*/
public class ValidAnagram {

    public boolean solve(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false; // Anagrams must be of the same length
        }
        java.util.HashMap<Character, Integer> charCount = new java.util.HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!charCount.containsKey(c) || charCount.get(c) == 0) {
                return false; // Character in t not found in s or count mismatch
            }
            charCount.put(c, charCount.get(c) - 1);
        }
        return true; // All characters match
    }

}
