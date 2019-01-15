package com.learn.himant.tree;

/**
 * @author Himant Dewangan
 *
 * Program to calculate the depth or height of a given tree.
 */
public class DepthOfTree {

	public int find(final Node root) {
		if (root == null) {
			return 0;
		} else {
			int lDepth = find(root.left);
			int rDepth = find(root.right);
			
			if (lDepth > rDepth) {
				return lDepth + 1;
			} else {
				return rDepth + 1;
			}
		}
		
	}
}
