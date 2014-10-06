package main.java.dfs;

import main.java.IGraph;

public class DFS4 {

	private static int[] color;
	private static int[] pred;

	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static int[] dfs(final IGraph graph, final int vertex)
	{
		final int len = graph.getNumVertices();
		color = new int[len];
		pred = new int[len];
		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		visit(graph, vertex);

		for (final int unvisited : graph.getVertices()) {
			if (WHITE != color[unvisited]) {
				continue;
			}
			visit(graph, unvisited);
		}

		return pred;
	}

	private static void visit(final IGraph graph, final int vertex)
	{
		color[vertex] = GREY;
		for (final int neighbour : graph.getNeighbors(vertex)) {
			if (WHITE != color[neighbour]) {
				continue;
			}

			color[neighbour] = GREY;
			pred[neighbour] = vertex;
			visit(graph, neighbour);
		}
		color[vertex] = BLACK;
	}
}
