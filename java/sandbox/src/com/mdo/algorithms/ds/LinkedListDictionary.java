package com.mdo.algorithms.ds;


public class LinkedListDictionary implements IDictionary {

	private LinkedNode head;
	private LinkedNode tail;
	private int count;
	
	public LinkedListDictionary() {
		count = 0;
	}
	
	public void add(String key, Object data) {
		LinkedNode node = new LinkedNode(data);
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
		LinkedNode node = findNode(key);
		if (node != null) {
			count--;
			LinkedNode prev = node.getPrev();
			LinkedNode next = node.getNext();
			if (prev != null) {
				prev.setNext(next);
			}
			if (next != null) {
				next.setPrev(prev);
			}
		}
	}

	public Object get(String key) {
		// TODO Auto-generated method stub
		LinkedNode node = findNode(key);
		return node.getData();
	}
	
	public int getCount() {
		return count;
	}
	
	
	private LinkedNode findNode(String key) {
		LinkedNode currentNode = head;
		
		// Iterate through the linked list
		while(currentNode != null) {
			
			if (currentNode.getName().equals(key)) {
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		
		return null;
	}

}
