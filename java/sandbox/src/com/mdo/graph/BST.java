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
		
		
		DataNode b = tree.getItem(new DataNode("B","abccd"));
		//BinaryNode bNode = tree.getNode(new DataNode("B",null));
		//System.out.println(root);
		
		System.out.println("breath first");
		tree.printBreathFirst();
		System.out.println("depth first");
		tree.printPreOrder();
		
		System.out.println("depth first rec");
		tree.printPreOrderRecurse();
		
	}
}
