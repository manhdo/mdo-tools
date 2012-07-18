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
	
	public T getItem(T data) {
		if (root == null) return null;
		if (data == null) return null;
		
		try {
			// do a binary search
			BinaryNode<T> node = findItem(data);
			if (node != null) return node.getData();
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	public BinaryNode<T> getNode(T data) {
		if (root == null) return null;
		if (data == null) return null;
		
		try {
			// do a binary search
			BinaryNode<T> node = findItem(data);
			return node;
		} catch (Exception e) {
			return null;
		}
	}
	
	// Iteratively add the item to the tree
	private void addItemToTree(T item) {
		if (item == null) return;
		
		BinaryNode<T> currentNode = root;
		while(currentNode != null) {
			int cmpResult = currentNode.getData().compareTo(item);
			if (cmpResult > 0) {
				// cmpResult is greater
				BinaryNode<T> right = currentNode.getRight();
				if (right == null) {
					right = new BinaryNode<T>(item);
					right.setParent(currentNode);
					currentNode.setRight(right);
					break;
				} else {
					currentNode = right;
				}
			} else if (cmpResult < 0){
				// just add to left
				BinaryNode<T> left = currentNode.getLeft();
				if (left == null) {
					left = new BinaryNode<T>(item);
					left.setParent(currentNode);
					currentNode.setLeft(left);
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
	
	// Iteratively find the correct item
	private BinaryNode<T> findItem(T item) {
		if (item == null) return null;
		
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
				return currentNode;
			}
		}
		return null;
	}
	
	public void printTreeDijstra() {
	}
}
