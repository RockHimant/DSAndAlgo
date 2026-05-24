package com.learn.himant.twopointer;
/**
 * Valid Palindrome
 *
 * Problem Statement:
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Algorithm:
 * This class will implement the two-pointer technique to solve the problem efficiently:
 * - Initialize two pointers, one at the beginning and one at the end of the string.
 * - Move the pointers towards each other, skipping non-alphanumeric characters.
 * - Compare the characters at the pointers (ignoring case).
 * - If all corresponding characters match, it's a palindrome.
 *
 * Time Complexity: O(n)
 * - Each character is visited at most once.
 *
 * Space Complexity: O(1)
 * - Only constant extra space is used for variables.
 * 
 *
 * @author Himant
 */
public class ValidPelindrome {

    public boolean solve(String s) {
        if (s == null) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
