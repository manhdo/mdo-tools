package com.mdo.algorithms.ds;

// Doubly LinkedList
public class LinkedNode<T> {
	private T data;
	private LinkedNode<T> next;
	private LinkedNode<T> prev;
	
	public LinkedNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LinkedNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}

	public LinkedNode<T> getPrev() {
		return prev;
	}

	public void setPrev(LinkedNode<T> prev) {
		this.prev = prev;
	}
}
