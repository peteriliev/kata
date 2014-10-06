package main.java.dfs;

import main.java.IGraph;

public class DFS3 {

	public static int[] dfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		colors = new int[len];
		pred = new int[len];

		for (int i = 0; i < len; i++) {
			colors[i] = WHITE;
			pred[i] = i;
		}

		visit(g, vertex);

		for (final int lefover : g.getVertices()) {
			if (WHITE != colors[lefover]) {
				continue;
			}
			visit(g, lefover);
		}

		return pred;
	}

	private static int[] colors;
	private static int[] pred;

	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;

	private static void visit(final IGraph g, final int vertex)
	{
		colors[vertex] = GRAY;
		for (final int neighbor : g.getNeighbors(vertex)) {
			if (WHITE != colors[neighbor]) {
				continue;
			}
			pred[neighbor] = vertex;
			visit(g, neighbor);
		}

		colors[vertex] = BLACK;
	}
}
