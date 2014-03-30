package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS3 {

	private static int[] color;
	private static int[] pred;

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private static final int BLACK = 2;

	public static int[] bfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		color = new int[len];
		pred = new int[len];

		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		final Queue<Integer> q = new LinkedList<>();

		q.add(vertex);
		color[vertex] = WHITE;
		while (!q.isEmpty()) {
			final int peek = q.peek();

			for (final int neighbor : g.getNeighbors(peek)) {
				if (color[neighbor] != WHITE) {
					continue;
				}
				pred[neighbor] = peek;
				color[neighbor] = GREY;
				q.add(neighbor);
			}
			q.poll();
			color[peek] = BLACK;
		}

		return pred;
	}
}