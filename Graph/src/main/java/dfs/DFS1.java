package main.java.dfs;

import main.java.IGraph;

public class DFS1 {

	public static int[] dfs(final IGraph g, final int start)
	{
		pred = new int[g.getVertices().length];
		color = new int[g.getVertices().length];

		for (int i = 0; i < pred.length; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		visit(g, start);

		for (final int v : g.getVertices()) {
			if (WHITE == color[v]) {
				visit(g, v);
			}
		}

		return pred;
	}

	private static void visit(final IGraph g, final int vertex)
	{
		color[vertex] = GREY;

		for (int i : g.getNeighbors(vertex)) {
			if (WHITE == color[i]) {
				pred[i] = vertex;
				visit(g, i);
			}
		}

		color[vertex] = BLACK;
	}

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private final static int BLACK = 2;

	private static int[] pred;
	private static int[] color;
}
