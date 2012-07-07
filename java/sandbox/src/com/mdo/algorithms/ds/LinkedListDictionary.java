package com.mdo.algorithms.ds;


public class LinkedListDictionary implements IDictionary {

	private LinkedNode<DataNode> head;
	private LinkedNode<DataNode> tail;
	private int count;
	
	public LinkedListDictionary() {
		count = 0;
	}
	
	public void add(String key, Object data) {
		LinkedNode<DataNode>  node = new LinkedNode<DataNode>(new DataNode(key,data));
		if (head == null) {
			// instantiate head
			head = node;
		}
		
		if (tail != null) {
			tail.setNext(node);
			node.setPrev(tail);
		}
		
		// set tail to node
		tail = node;
		count++;
	}

	public void delete(String key) {
		LinkedNode<DataNode> node = findNode(key);
		if (node != null) {
			count--;
			LinkedNode<DataNode> prev = node.getPrev();
			LinkedNode<DataNode> next = node.getNext();
			if (prev != null) {
				prev.setNext(next);
			}
			if (next != null) {
				next.setPrev(prev);
			}
		}
	}

	public Object get(String key) {
		LinkedNode<DataNode> node = findNode(key);
		return node.getData().getData();
	}
	
	public int getCount() {
		return count;
	}
	
	
	private LinkedNode<DataNode> findNode(String key) {
		LinkedNode<DataNode> currentNode = head;
		
		// Iterate through the linked list
		while(currentNode != null) {
			
			if (currentNode.getData().getName().equals(key)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		
		return null;
	}

}
