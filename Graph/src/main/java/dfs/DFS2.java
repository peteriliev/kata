package com.iliev.peter.kata.dfs;

import com.iliev.peter.kata.IGraph;

public class DFS2 {

	private static int[] pred;
	private static int[] color;
	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	public static int[] dfs(final IGraph g, final int vertex) {
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];

		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		visit(g, vertex);

		for (int neighbour : g.getVertices()) {
			if (WHITE == color[neighbour]) {
				visit(g, neighbour);
			}
		}

		return pred;
	}

	public static void visit(final IGraph g, final int vertex) {
		color[vertex] = GREY;

		for (final int neigh : g.getNeighbors(vertex)) {
			if (WHITE != color[neigh]) {
				continue;
			}
			pred[neigh] = vertex;
			visit(g, neigh);
		}

		color[vertex] = BLACK;
	}
}