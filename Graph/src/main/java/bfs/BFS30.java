package main.java.bfs;

import java.util.LinkedList;
import java.util.Queue;

import main.java.IGraph;

public class BFS30 {

	private static int[] pred;
	private static int[] color;

	private static final int BLACK = 1;
	private static final int WHITE = 0;

	public static int[] bfs(final IGraph g, final int vertex) {
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(vertex);
		color[vertex] = BLACK;

		while (!q.isEmpty()) {
			final int polled = q.poll();

			for (final int neighbor : g.getNeighbors(polled)) {
				if (WHITE != color[neighbor]) {
					continue;
				}

				pred[neighbor] = polled;
				color[neighbor] = BLACK;
				q.add(neighbor);
			}
		}

		return pred;
	}
}
