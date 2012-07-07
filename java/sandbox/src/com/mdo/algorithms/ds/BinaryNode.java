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
	
	public void addItem(T item) {
		int result = data.compareTo(item);
		
		if (result == RIGHT) {
			// go right
			if (right != null) {
				right.addItem(item);
			} else {
				right = new BinaryNode<T>(item);
			}
		} else {
			// Go left
			if (left != null) {
				left.addItem(item);
			} else {
				left = new BinaryNode<T>(item);
			}
		}
	}
	
	public BinaryNode<T> getNode(T item) throws Exception {
		if (data.equals(item)) return this;
		
		int result = data.compareTo(item);
		if (result == RIGHT) {
			if (right != null) {
				return right.getNode(item);
			} else {
				// Throw error
				throw new Exception("No such node with key: " + item);
			}
		} else {
			if (left != null) {
				return left.getNode(item);
			} else {
				throw new Exception("No such node with key: " + item);
			}
		}
	}
}
