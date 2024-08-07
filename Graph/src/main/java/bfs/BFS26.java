package main.java.bfs;

import java.util.LinkedList;
import java.util.Queue;

import main.java.IGraph;

public class BFS26 {

	private static int pred[];
	private static int color[];
	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static int[] bfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}

		final Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		color[vertex] = GREY;

		while (!q.isEmpty()) {
			final int poll = q.poll();

			for (final int neighbor : g.getNeighbors(poll)) {
				if (WHITE != color[neighbor]) {
					continue;
				}
				q.add(neighbor);
				pred[neighbor] = poll;
				color[neighbor] = GREY;
			}

			color[poll] = BLACK;
		}

		return pred;
	}
}
