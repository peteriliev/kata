package com.iliev.peter.kata.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.iliev.peter.kata.IGraph;

public class Dijkstra27 {

	private static int[] paths;
	private static int[] pred;
	private static int INFINITY = Integer.MAX_VALUE;

	private static PriorityQueue<Path> pq = new PriorityQueue<>(new Comparator<Path>() {

		@Override
		public int compare(Path o1, Path o2)
		{
			return o1.weight - o2.weight;
		}
	});

	public static int[][] sssp(final IGraph g, final int vertex) throws Exception
	{
		final int len = g.getNumVertices();
		paths = new int[len];
		pred = new int[len];
		for (int i = 0; i < len; i++) {
			paths[i] = INFINITY;
			pred[i] = i;
			pq.add(new Path(i, i == vertex ? 0 : INFINITY));
		}
		paths[vertex] = 0;

		while (!pq.isEmpty()) {
			final Path polled = pq.poll();

			for (final int neighbor : g.getNeighbors(polled.vertex)) {
				final int currentWeight = paths[neighbor];
				final int newWeight = g.getEdgeWeight(polled.vertex, neighbor) + paths[polled.vertex];
				if (newWeight < currentWeight) {
					update(pq, neighbor, newWeight);
					paths[neighbor] = newWeight;
					pred[neighbor] = polled.vertex;
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void update(final PriorityQueue<Path> pq2, final int neighbor, final int newWeight)
	{
		Path ptr = null;
		for (Path p : pq2) {
			if (p.vertex == neighbor) {
				ptr = p;
				break;
			}
		}
		if (null == ptr) {
			throw new RuntimeException("PQ neightbor not found");
		}
		pq2.remove(ptr);
		pq2.add(new Path(neighbor, newWeight));
	}

	private static class Path {
		public int vertex;
		public int weight;

		public Path(final int vertext, final int weight) {
			this.vertex = vertext;
			this.weight = weight;
		}

		@Override
		public String toString()
		{
			return String.format("Path: ver. = %s weight. = %s", vertex, weight);
		}

		@Override
		public boolean equals(final Object o)
		{
			if (!(o instanceof Path)) {
				return false;
			}

			final Path op = (Path) o;

			return op.weight == this.weight && op.vertex == this.vertex;
		}
	}
}
