package com.iliev.peter.kata.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.iliev.peter.kata.IGraph;

public class Dijkstra3 {

	private static int[] paths;
	private static int[] pred;

	private final static int INFINITY = Integer.MAX_VALUE;

	public static int[][] sssp(final IGraph g, final int vertex) throws Exception
	{
		paths = new int[g.getNumVertices()];
		pred = new int[g.getNumVertices()];
		for (int i = 0; i < paths.length; i++) {
			paths[i] = INFINITY;
			pred[i] = i;
		}

		paths[vertex] = 0;
		final PriorityQueue<Path> pq = new PriorityQueue<>(paths.length, new PathComparator());
		for (final int v : g.getVertices()) {
			pq.add(new Path(v, paths[v]));
		}

		while (!pq.isEmpty()) {
			final Path poll = pq.poll();

			for (final int neighbor : g.getNeighbors(poll.vertex)) {
				final int currentPath = paths[neighbor];
				final int polledPath = paths[poll.vertex];
				final int newPath = g.getEdgeWeight(poll.vertex, neighbor) + polledPath;
				if (newPath < currentPath) {
					replace(pq, neighbor, newPath);
					paths[neighbor] = newPath;
					pred[neighbor] = poll.vertex;
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void replace(final PriorityQueue<Path> pq, final int vertex, final int newWeight)
	{
		Path ptr = null;
		for (final Path p : pq) {
			if (p.vertex == vertex) {
				ptr = p;
				break;
			}
		}
		pq.remove(ptr);
		pq.add(new Path(vertex, newWeight));
	}

	private static class Path {
		private final int vertex;
		private final int weight;

		Path(final int vertex, final int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		public int getVertex()
		{
			return vertex;
		}

		public int getWeight()
		{
			return weight;
		}

		@Override
		public String toString()
		{
			return String.format("Path: vertex = %n, weight = %n", vertex, weight);
		}
	}

	private static class PathComparator implements Comparator<Path> {

		@Override
		public int compare(final Path p1, final Path p2)
		{
			return p1.weight - p2.weight;
		}
	}
}
