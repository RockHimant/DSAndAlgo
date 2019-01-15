package com.learn.himant.tree;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DepthOfTreeTest {
	
	private DepthOfTree depthOfTree;
	
	@Before
	public void setUp() {
		depthOfTree = new DepthOfTree();
	}

	@Test
	public void shouldGiveCorrectDepth() {
		Node root = getTestTree();
		int depth = depthOfTree.find(root);
		assertEquals(depth, 4);
	}
	
	public Node getTestTree() {
		Node root = new Node(9);
		root.setLeft(new Node(2));
		root.setRight(new Node(1));
		root.getLeft().setLeft(new Node(2));
		root.getLeft().setRight(new Node(0));
		root.getLeft().getLeft().setLeft(new Node(4));
		return root;
	}
}
