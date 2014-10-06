package main.java.dfs;

import main.java.IGraph;

public class DFS25 {

	private static int pred[];
	private static int color[];
	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static int[] dfs(final IGraph g, final int v)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];
		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		visit(g, v);

		for (final int unvisited : g.getVertices()) {
			if (WHITE != color[unvisited]) {
				continue;
			}
			visit(g, unvisited);
		}

		return pred;
	}

	private final static void visit(final IGraph g, final int v)
	{
		color[v] = GREY;

		for (final int neighbor : g.getNeighbors(v)) {
			if (WHITE != color[neighbor]) {
				continue;
			}
			pred[neighbor] = v;
			visit(g, neighbor);
		}

		color[v] = BLACK;
	}
}
