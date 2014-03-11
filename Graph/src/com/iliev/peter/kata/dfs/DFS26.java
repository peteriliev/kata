package com.iliev.peter.kata.dfs;

import com.iliev.peter.kata.IGraph;

public class DFS26 {

	private static int pred[];
	private static int color[];
	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

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
			if (WHITE != color[unvisited]) {
				continue;
			}
			visit(g, unvisited);
		}

		return pred;
	}

	private static void visit(final IGraph g, final int vertex)
	{
		color[vertex] = GREY;

		for (final int neighbor : g.getNeighbors(vertex)) {
			if (WHITE != color[neighbor]) {
				continue;
			}
			pred[neighbor] = vertex;
			visit(g, neighbor);
		}

		color[vertex] = BLACK;
	}
}