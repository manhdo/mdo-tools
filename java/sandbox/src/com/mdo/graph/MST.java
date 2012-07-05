package com.mdo.graph;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Minimum Spanning Tree
 * @author mdo
 *
 */
public class MST {

	public static void main(String[] args) {
		InputStream stream = MST.class.getResourceAsStream("data.graph");
		Scanner inFile = new Scanner(stream);
		
		Graph graph = new Graph();
		int numVertices = Integer.parseInt(inFile.nextLine());
		int numEdges = Integer.parseInt(inFile.nextLine());
		while(inFile.hasNext()) {
			String line = inFile.nextLine();
			System.out.println(line);
			String[] parts = line.split(" ");
			

			String source = parts[0];
			String destination = parts[1];
			String id = source + "->" + destination;
			String weight = parts[2];
			
			Edge edge = new Edge(id, graph.addVertex(source), graph.addVertex(destination), 
					Double.parseDouble(weight));
			graph.addEdge(edge);
		}
		
		System.out.println(graph.edges.size());
	}
}
