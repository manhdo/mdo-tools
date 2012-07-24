package com.mdo.algorithms.ds;

import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;


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
			int cmpResult = item.compareTo(currentNode.getData());
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
					break;
				} else {
					currentNode = right;
				}
			} else if (cmpResult < 0){
				// just add to left
				BinaryNode<T> left = currentNode.getLeft();
				if (left == null) {
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
	
	public void printPreOrder() {
		Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
		//stack.push(root);
		
		HashMap<String,String> visited = new HashMap<String,String>();
		stack.push(root);
		while(!stack.isEmpty()) {
			BinaryNode<T> currentNode = stack.peek();
			
			BinaryNode<T> right = currentNode.getRight();
			BinaryNode<T> left = currentNode.getLeft();
			
			if (left == null || visited.containsKey(left.toString())) {
				visited.put(currentNode.toString(), null);
				System.out.println(currentNode.getData().toString());
				
				stack.pop();
				if (right != null) {
					//System.out.println("right");
					stack.push(right);
				}
			} else {
				//System.out.println("left");
				stack.push(left);
			}
		}
	}
	
	
	private void printPreOrderRe(BinaryNode<T> currentNode) {
		if (currentNode == null) return;
		
		printPreOrderRe(currentNode.getLeft());
		System.out.println(currentNode.getData().toString());
		printPreOrderRe(currentNode.getRight());
	}
	
	public void printPreOrderRecurse() {
		printPreOrderRe(root);
	}
	
	public void printBreathFirst() {
		Queue<BinaryNode<T>> queue = new ConcurrentLinkedQueue<BinaryNode<T>>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			BinaryNode<T> currentItem = queue.remove();
			System.out.println(currentItem.getData().toString());

			
			// push left
			if (currentItem.getLeft() != null) {
				queue.add(currentItem.getLeft());
			}
			// push right first
			if (currentItem.getRight() != null) {
				queue.add(currentItem.getRight());
			}
		}
	}
}
