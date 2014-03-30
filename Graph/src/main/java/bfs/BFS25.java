package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS25 {

	private static int pred[];
	private static int color[];
	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;

	public static int[] bfs(final IGraph g, final int v)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];
		for (int i = 0; i < len; i++) {
			pred[i] = i;
			color[i] = WHITE;
		}
		
		final Queue<Integer> q = new LinkedList<>();
		q.add(v);
		color[v] = GREY;
		
		while (!q.isEmpty()) {
			final int poll = q.poll();
			
			for (final int neighbor : g.getNeighbors(poll)) {
				if (WHITE != color[neighbor]) {
					continue;
				}
				pred[neighbor] = poll;
				color[neighbor] = GREY;
				q.add(neighbor);
			}
			
			color[poll] = BLACK;
		}

		return pred;
	}
}
