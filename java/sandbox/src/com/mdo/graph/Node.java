package com.mdo.graph;

import java.util.List;


public class Node {
	public String name;
	public Object data;
	public List<Edge> connections;
	
	public Node(String name, Object data) {
		this.name = name;
		this.data = data;
	}
}
