package main.java.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.IGraph;

public class Dijkstra26 {

	private static int[] pred;
	private static int[] paths;
	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[][] sssp(final IGraph g, final int vertex) throws Exception
	{
		final int numVertex = g.getNumVertices();

		pred = new int[numVertex];
		paths = new int[numVertex];

		PriorityQueue<Path> pq = new PriorityQueue<>(numVertex, new Comparator<Path>() {

			@Override
			public int compare(Path o1, Path o2)
			{
				return o1.weight - o2.weight;
			}
		});

		for (int i = 0; i < numVertex; i++) {
			pred[i] = i;
			paths[i] = i == vertex ? 0 : INFINITY;
			pq.add(new Path(i, paths[i]));
		}

		while (!pq.isEmpty()) {
			final Path poll = pq.poll();
			System.out.println(String.format("Polled = %s", poll.toString()));

			for (final int neighbor : g.getNeighbors(poll.vertex)) {
				final int polledWeight = g.getEdgeWeight(poll.vertex, neighbor);
				final int pathSoFar = paths[poll.vertex];
				final int newWeight = polledWeight + pathSoFar;
				if (paths[neighbor] > newWeight) {
					paths[neighbor] = newWeight;
					pred[neighbor] = poll.vertex;
					reduce(pq, neighbor, newWeight);
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void reduce(final PriorityQueue<Path> pq, final int poll, final int polledWeight)
	{
		Path ptr = null;
		for (final Path p : pq) {
			if (p.vertex == poll) {
				ptr = p;
				break;
			}
		}
		System.out.println(ptr);
		pq.remove(ptr);
		pq.add(new Path(poll, polledWeight));
	}

	private static class Path {
		public int vertex;
		public int weight;

		public Path(final int vertxt, final int weight) {
			this.vertex = vertxt;
			this.weight = weight;
		}

		@Override
		public String toString()
		{
			return String.format("Path: Vertext = %d, Weight = %d", vertex, weight);
		}
	}
}
