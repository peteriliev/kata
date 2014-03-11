package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS6 {

	private static int[] pred;
	private static int[] color;
	private static int WHITE = 0;
	private static int GREY = 1;
	private static int BLACK = 2;

	public static int[] bfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		Queue<Integer> q = new LinkedList<>();
		color[vertex] = GREY;
		q.add(vertex);

		while (!q.isEmpty()) {
			final int peek = q.poll();

			for (final int neighbor : g.getNeighbors(peek)) {
				if (color[neighbor] == WHITE) {
					pred[neighbor] = peek;
					color[neighbor] = GREY;
					q.add(neighbor);
				}
			}
			color[peek] = BLACK;
		}

		return pred;
	}
}
