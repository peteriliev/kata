package main.java;

public interface IGraph {
	//boolean isDirected();
	
	int getNumVertices();
	
	int[] getVertices();
	
	int[] getNeighbors(final int u);
	
	boolean isEdge(final int u, final int v);
	
	boolean isEdge(final int u, final int v, final int weight);
	
	int getEdgeWeight(final int u, final int v) throws Exception;

	void addVertex(final int u);
	
	void addEdge(final int u, final int v);
	
	void addEdge(final int u, final int v, final int weight);
	
	void removeEdge(final int u, final int v);
}
