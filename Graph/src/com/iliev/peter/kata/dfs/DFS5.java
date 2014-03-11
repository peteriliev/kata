package com.iliev.peter.kata.dfs;

import com.iliev.peter.kata.IGraph;

public class DFS5 {

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

		for (int unvisited : graph.getVertices()) {
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

		for (final int neighbor : graph.getNeighbors(vertex)) {
			if (WHITE != color[neighbor]) {
				continue;
			}
			pred[neighbor] = vertex;
			visit(graph, neighbor);
		}

		color[vertex] = BLACK;
	}
}
