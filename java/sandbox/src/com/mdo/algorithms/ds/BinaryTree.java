package com.mdo.algorithms.ds;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree {
	private BinaryNode<DataNode> root;

	
	public BinaryTree() {
		// create a binary tree
	}
	
	public void addItem(DataNode data) {
		if (root == null) {
			root = new BinaryNode<DataNode>(data);	
		} else {
			//root.addItem(data);
		}
	}
	
	public DataNode getItem(DataNode data) {
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
	
	public void addItemToTree(DataNode item) {
		Queue<BinaryNode<DataNode>> queue = new ConcurrentLinkedQueue<BinaryNode<DataNode>>();
	}
	
	/*
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
	*/
	
}
