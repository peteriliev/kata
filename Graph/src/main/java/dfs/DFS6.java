package main.java.dfs;

import main.java.IGraph;

public class DFS6 {

	private static int[] pred;
	private static int[] color;
	private static int WHITE = 0;
	private static int GREY = 1;
	private static int BLACK = 2;

	public static int[] dfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		visit(g, vertex);

		for (final int unvisited : g.getVertices()) {
			if (color[unvisited] == WHITE) {
				visit(g, unvisited);
			}
		}

		return pred;
	}

	private static void visit(final IGraph graph, final int vertex)
	{

		color[vertex] = GREY;

		for (final int neighbor : graph.getNeighbors(vertex)) {
			if (color[neighbor] == WHITE) {
				pred[neighbor] = vertex;
				visit(graph, neighbor);
			}
		}

		color[vertex] = BLACK;
	}
}
