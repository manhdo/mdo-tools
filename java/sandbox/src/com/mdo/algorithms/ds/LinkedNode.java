package com.mdo.algorithms.ds;

// Doubly LinkedList
public class LinkedNode {
	private String name;
	private Object data;
	private LinkedNode next;
	private LinkedNode prev;
	
	public LinkedNode(Object data) {
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LinkedNode getNext() {
		return next;
	}

	public void setNext(LinkedNode next) {
		this.next = next;
	}

	public LinkedNode getPrev() {
		return prev;
	}

	public void setPrev(LinkedNode prev) {
		this.prev = prev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
