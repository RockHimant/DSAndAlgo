package com.learn.himant.tree;

public class Node {

	Object value;
	Node left;
	Node right;
	
	public Node(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public void printNodeValue() {
		System.out.println(this.value);
	}
}
