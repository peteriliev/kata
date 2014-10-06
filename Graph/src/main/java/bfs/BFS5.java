package main.java.bfs;

import java.util.LinkedList;
import java.util.Queue;

import main.java.IGraph;

public class BFS5 {

	private static int[] color;
	private static int[] pred;

	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static int[] bfs(final IGraph graph, final int vertex)
	{
		final int len = graph.getNumVertices();
		color = new int[len];
		pred = new int[len];
		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}

		final Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		color[vertex] = GREY;

		while (!q.isEmpty()) {
			final int peek = q.peek();

			for (final int neighbor : graph.getNeighbors(peek)) {
				if (color[neighbor] != WHITE) {
					continue;
				}
				color[neighbor] = GREY;
				pred[neighbor] = peek;
				q.add(neighbor);
			}

			color[peek] = BLACK;
			q.poll();
		}

		return pred;
	}
}
