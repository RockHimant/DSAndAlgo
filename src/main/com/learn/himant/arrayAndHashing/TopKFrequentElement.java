package com.learn.himant.arrayAndHashing;

/* 
 * Problem Statement:
 * Given an integer array and an integer k, return the k most frequent elements.
 * 
 * Algorithm:
 * This class will implement a solution using a HashMap to store the frequency of each element and a PriorityQueue to keep track of the top k elements.
 * 
 * Time Complexity: O(n log k)
 * - Where n is the number of elements in the array.
 * - Building the frequency map takes O(n) time.
 * - Inserting elements into the priority queue takes O(log k) time, and we do this for n elements.
 * 
 * Space Complexity: O(n)
 * - In the worst case, the HashMap will store all unique elements from the array.
 * 
 * @author Himant
 */
public class TopKFrequentElement {

    public int[] solve(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0]; // No elements to process
        }
        java.util.HashMap<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        if (k > frequencyMap.size()) {
            k = frequencyMap.size();
        }
        java.util.PriorityQueue<java.util.Map.Entry<Integer, Integer>> minHeap =
                new java.util.PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (java.util.Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().getKey(); // Get the most frequent elements
        }
        return result;
    }

    public int[] solveWithoutPQ(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        java.util.HashMap<Integer, Integer> frequencyMap = new java.util.HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        if (k > frequencyMap.size()) {
            k = frequencyMap.size();
        }

        @SuppressWarnings("unchecked")
        java.util.List<Integer>[] buckets = new java.util.ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }
        for (java.util.Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int frequency = buckets.length - 1; frequency >= 1 && index < k; frequency--) {
            for (int num : buckets[frequency]) {
                if (index < k) {
                    result[index++] = num;
                }
            }
        }
        return result;
    }

}
