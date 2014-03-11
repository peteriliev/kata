package com.iliev.peter.kata.bfs;

import java.util.LinkedList;
import java.util.Queue;

import com.iliev.peter.kata.IGraph;

public class BFS27 {

	private static int[] pred;
	private static int[] color;
	
	private final static int WHITE = 0;
	private final static int GREY = 1;
	private final static int BLACK = 2;
	
	public static int[] bfs(final IGraph g, final int vertex)
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		color = new int[len];
		
		for (int i = 0; i < len; i++) {
			color[i] = WHITE;
			pred[i] = i;
		}
		
		final Queue<Integer> q = new LinkedList<>();
		q.add(vertex);
		color[vertex] = GREY;
		
		while(!q.isEmpty()) {
			final int polled = q.poll();
			color[polled] = BLACK;
			
			for (final int neighbor : g.getNeighbors(polled)) {
				if (WHITE != color[neighbor]) {
					continue;
				}
				pred[neighbor] = polled;
				color[neighbor] = GREY;
				q.add(neighbor);
			}
		}
		
		
		return pred;
	}
}
