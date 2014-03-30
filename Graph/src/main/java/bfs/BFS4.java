package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS4 {
	private static int[] color;
	private static int[] pred;

	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static final int[] bfs(final IGraph graph, final int vertex)
	{
		final int len = graph.getNumVertices();
		color = new int[len];
		pred = new int[len];
		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		color[vertex] = GREY;
		final Queue<Integer> q = new LinkedList<>();
		q.add(vertex);

		while (!q.isEmpty()) {
			final int peek = q.peek();
			color[peek] = GREY;

			for (final int neighbor : graph.getNeighbors(peek)) {
				if (WHITE != color[neighbor]) {
					continue;
				}
				pred[neighbor] = peek;
				q.add(neighbor);
			}
			q.poll();
			color[peek] = BLACK;
		}

		return pred;
	}
}
