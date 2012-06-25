package com.mdo.graph;

public class Edge implements Comparable<Edge>{
	public String id;
	public Node source;
	public Node destination;
	public double weight;
	
	public Edge(String id, Node source, Node dest, double weight) {
		this.id = id;
		this.source = source;
		this.destination = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge arg0) {
		Double s = new Double(weight);
		return s.compareTo(new Double(arg0.weight));
	}
}
