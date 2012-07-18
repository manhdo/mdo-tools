package com.mdo.algorithms.ds;

public class BinaryNode<T extends Comparable> {
	static int LEFT = -1;
	static int RIGHT = 1;
	static int EQUAL = 0;
	
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	public BinaryNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}
}
