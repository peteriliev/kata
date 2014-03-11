package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS2 {

	private static int[] colors;
	private static int[] pred;

	private static final int WHITE = 0;
	private static final int GRAY = 1;
	private static final int BLACK = 2;

	public static int[] bfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		colors = new int[len];
		pred = new int[len];

		for (int i = 0; i < len; i++) {
			colors[i] = WHITE;
			pred[i] = i;
		}

		final Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		colors[vertex] = GRAY;

		while (!queue.isEmpty()) {
			final int peek = queue.peek();

			for (final int neighbor : g.getNeighbors(peek)) {
				if (WHITE != colors[neighbor]) {
					continue;
				}

				colors[neighbor] = GRAY;
				pred[neighbor] = peek;
				queue.add(neighbor);
			}

			queue.poll();
			//colors[peek] = BLACK;
		}

		return pred;
	}

}
