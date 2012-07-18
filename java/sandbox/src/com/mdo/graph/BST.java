package com.mdo.graph;

import com.mdo.algorithms.ds.BinaryNode;
import com.mdo.algorithms.ds.BinaryTree;
import com.mdo.algorithms.ds.DataNode;

public class BST {
	public static void main(String[] args) {
		
		BinaryTree<DataNode> tree = new BinaryTree<DataNode>();
		tree.addItem(new DataNode("D", ""));
		tree.addItem(new DataNode("Z", ""));
		tree.addItem(new DataNode("B", ""));
		tree.addItem(new DataNode("A", ""));
		tree.addItem(new DataNode("C", ""));
		tree.addItem(new DataNode("G", ""));
		
		BinaryNode<DataNode> root = tree.getRoot();
		
		System.out.println(root);
	}
}
