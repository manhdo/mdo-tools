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
		BinaryNode<DataNode> curNode = root;
		
		// add the item to the tree
		while(curNode != null) {
			DataNode dataNode = curNode.getData();
			int result = item.compareTo(dataNode);
			if (result == 1) {
				// right
				if (curNode.getRight() != null) {
					curNode = curNode.getRight();
				} else {
					curNode.setRight(new BinaryNode<DataNode>(item));
					curNode = null;
				}
			} else {
				// left and center
				if (curNode.getLeft() != null) {
					curNode = curNode.getLeft();
				} else {
					curNode.setLeft(new BinaryNode<DataNode>(item));
					curNode = null;
				}
			}
		}
	}
	
	
	public BinaryNode<DataNode> getNode(DataNode item) throws Exception {
		BinaryNode<DataNode> curNode = root;
		if (item == null) return null;
		
		while (curNode != null) {
			DataNode dataNode = curNode.getData();
			if (item.equals(dataNode)) return curNode;
			
			int result = item.compareTo(dataNode);
			if (result == 1) {
				curNode = curNode.getRight();
			} else {
				curNode = curNode.getLeft();
			}
		}
		return null;
	}
	
}
