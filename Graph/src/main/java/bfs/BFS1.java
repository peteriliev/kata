package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS1 {
	public static int[] bfs(final IGraph g, final int start) {
		final int len = g.getNumVertices();
		color = new int[len];
		pred = new int[len];
		
		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		final Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		color[start] = GREY;

		while (!queue.isEmpty()) {

			final int peek = queue.peek();
			for (final int neighbour : g.getNeighbors(peek)) {
				if (WHITE != color[neighbour]) {
					continue;
				}
				pred[neighbour] = peek;
				color[neighbour] = GREY;
				queue.add(neighbour);
			}

			color[queue.poll()] = BLACK;
		}

		return pred;
	}

	private static final int WHITE = 0;
	private static final int GREY = 1;
	private final static int BLACK = 2;

	private static int[] pred;
	private static int[] color;
}