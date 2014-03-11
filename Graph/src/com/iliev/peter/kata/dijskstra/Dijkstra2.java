package com.iliev.peter.kata.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.iliev.peter.kata.IGraph;

public class Dijkstra2 {

	private static int[] paths;
	private final static int INFINITY = Integer.MAX_VALUE;

	public static int[] sssp(final IGraph g, final int vertex) throws Exception
	{
		final int len = g.getNumVertices();
		paths = new int[len];

		for (int i = 0; i < len; i++) {
			paths[i] = INFINITY;
		}
		paths[vertex] = 0;

		final PriorityQueue<Path> pq = new PriorityQueue<>(len, new PathComparator());
		for (final int foo : g.getVertices()) {
			pq.add(new Path(foo, paths[foo]));
		}
		System.out.println(pq.peek());
		while (!pq.isEmpty()) {
			final Path closestVertex = pq.poll();

			for (final int neighbor : g.getNeighbors(closestVertex.vertex)) {
				final int currentPath = paths[neighbor];
				final int edge = g.getEdgeWeight(closestVertex.vertex, neighbor);
				final int newPath = edge + paths[closestVertex.vertex];
				if (newPath < currentPath) {
					reduce(pq, neighbor, newPath);
					paths[neighbor] = newPath;
				}
			}
		}

		return paths;
	}

	private static void reduce(final PriorityQueue<Path> pq, final int vertex, final int newWeight)
	{
		Path ptr = null;
		for (final Path path : pq) {
			if (path.vertex == vertex) {
				ptr = path;
				break;
			}
		}
		pq.remove(ptr);
		pq.add(new Path(vertex, newWeight));
	}

	private static class PathComparator implements Comparator<Path> {

		@Override
		public int compare(final Path p1, final Path p2)
		{
			return p1.weight - p2.weight;
		}

	}

	private static class Path {
		private final int vertex;
		private final int weight;

		public Path(final int vertex, final int weight) {
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
			return String.format("Path: vertex = %s, weight = %s", vertex, weight);
		}
	}
}
