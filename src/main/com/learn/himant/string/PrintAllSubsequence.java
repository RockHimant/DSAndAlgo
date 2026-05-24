package com.learn.himant.string;

public class PrintAllSubsequence {

    public void solve(String str) {
        if (str == null) {
            return;
        }
        printSubsequences(str, 0, new StringBuilder());
    }   

    private void printSubsequences(String str, int index, StringBuilder current) {
        if (index == str.length()) {
            if (current.length() > 0) {
                System.out.println(current.toString());
            }
            return;
        }

        // Include the current character
        current.append(str.charAt(index));
        printSubsequences(str, index + 1, current);

        // Backtrack and exclude the current character
        current.deleteCharAt(current.length() - 1);
        printSubsequences(str, index + 1, current);
    }

}
