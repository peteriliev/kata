package com.iliev.peter.kata.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.iliev.peter.kata.IGraph;

public class Dijkstra6 {

	private static int[] pred;
	private static int[] paths;

	private final static int INFINITY = Integer.MAX_VALUE;

	public static int[][] sssp(final IGraph g, final int vertex) throws Exception
	{
		final int len = g.getNumVertices();
		pred = new int[len];
		paths = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			paths[i] = INFINITY;
		}
		paths[vertex] = 0;

		final PriorityQueue<Path> pq = new PriorityQueue<>(len, new PathComparator());
		for (final int v : g.getVertices()) {
			pq.add(new Path(v, paths[v]));
		}

		while (!pq.isEmpty()) {
			final Path poll = pq.poll();

			for (final int neighbor : g.getNeighbors(poll.getVertex())) {
				final int currentPath = paths[neighbor];
				final int newPath = paths[poll.getVertex()] + g.getEdgeWeight(poll.vertex, neighbor);
				if (newPath < currentPath) {
					update(pq, neighbor, newPath);
					paths[neighbor] = newPath;
					pred[neighbor] = poll.vertex;
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void update(final PriorityQueue<Path> pq, final int vertex, final int newWeigh)
	{
		Path ptr = null;
		for (final Path path : pq) {
			if (path.vertex == vertex) {
				ptr = path;
				break;
			}
		}
		pq.remove(ptr);
		pq.add(new Path(vertex, newWeigh));

	}

	private static class PathComparator implements Comparator<Path> {

		@Override
		public int compare(final Path p1, final Path p2)
		{
			return p1.weight - p2.weight;
		}
	}

	private static class Path {
		private int weight;
		private int vertex;

		public Path(final int vertex, final int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getWeight()
		{
			return weight;
		}

		public int getVertex()
		{
			return vertex;
		}

		@Override
		public String toString()
		{
			return String.format("Path: vertex = %n, weight = %n", vertex, weight);
		}
	}
}
