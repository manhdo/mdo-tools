package com.mdo.algorithms.ds;


public class BinaryTree<T extends Comparable<T>> {
	private BinaryNode<T> root;

	
	public BinaryTree() {
		// create a binary tree
	}
	
	public BinaryNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryNode<T> root) {
		this.root = root;
	}

	public void addItem(T data) {
		if (root == null) {
			root = new BinaryNode<T>(data);	
		} else {
			addItemToTree(data);
		}
	}
	
	public DataNode getItem(T data) {
		if (root == null) return null;
		if (data == null) return null;
		
		try {
			// do a binary search
			//BinaryNode<DataNode> node = root.getNode(data);
			return null;//node.getData();
		} catch (Exception e) {
			return null;
		}
	}
	
	private void addItemToTree(T item) {
		if (item == null) return;
		
		BinaryNode<T> currentNode = root;
		while(currentNode != null) {
			int cmpResult = currentNode.getData().compareTo(item);
			if (cmpResult > 0) {
				// cmpResult is greater
				BinaryNode<T> right = currentNode.getRight();
				if (right == null) {
					currentNode.setRight(new BinaryNode<T>(item));
					break;
				} else {
					currentNode = right;
				}
			} else if (cmpResult < 0){
				// just add to left
				BinaryNode<T> left = currentNode.getLeft();
				if (left == null) {
					currentNode.setLeft(new BinaryNode<T>(item));
					break;
				} else {
					currentNode = left;
				}
			} else {
				// they are equal to ignore for this implementation
				currentNode = null;
			}
		}
	}
	
	
}
