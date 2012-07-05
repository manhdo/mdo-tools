package com.mdo.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	public List<Edge> edges;
	public List<Node> vertices;
	public HashMap<String,Node> verticesMap;
	
	
	public Graph() {
		edges = new ArrayList<Edge>();
		vertices = new ArrayList<Node>();
		verticesMap = new HashMap<String,Node>();
	}
	
	public void addVertex(Node node) {
		vertices.add(node);
		verticesMap.put(node.name, node);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public Node addVertex(String name) {
		Node node = verticesMap.get(name);
		if (node == null) {
			node = new Node(name,null);
			verticesMap.put(name, node);
			vertices.add(node);
		}
		return node;
	}
	
	public List<Node> dijkstra(String start, String begin) {
		
		PriorityQueue<Node> vertexQueue = new PriorityQueue<Node>();
		return null;
	}
	
}
