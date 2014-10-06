package main.java.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.IGraph;

public class Dijkstra25 {

	private static int[] paths;
	private static int[] pred;
	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[][] sssp(final IGraph g, final int v) throws Exception
	{
		final int len = g.getNumVertices();
		paths = new int[len];
		pred = new int[len];
		for (int i = 0; i < len; i++) {
			paths[i] = INFINITY;
			pred[i] = i;
		}
		paths[v] = 0;

		final PriorityQueue<Path> pq = new PriorityQueue<>(len, new Comparator<Path>() {

			@Override
			public int compare(Path o1, Path o2)
			{
				return o1.weight - o2.weight;
			}
		});

		for (final int vertex : g.getVertices()) {
			pq.add(new Path(vertex, paths[vertex]));
		}

		while (!pq.isEmpty()) {
			final Path poll = pq.poll();
			System.out.println(poll);
			for (final int neighbor : g.getNeighbors(poll.vertex)) {
				final int currentPath = paths[neighbor];
				
				final int newPath = paths[poll.vertex] + g.getEdgeWeight(poll.vertex, neighbor);
				if (currentPath > newPath) {
					paths[neighbor] = newPath;
					pred[neighbor] = poll.vertex;
					updatePQ(pq, neighbor, newPath);
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void updatePQ(final PriorityQueue<Path> pq, final int neighbor, final int newPath)
	{
		Path tmp = null;
		for (final Path path : pq) {
			if (path.vertex == neighbor) {
				tmp = path;
				break;
			}
		}
		pq.remove(tmp);
		pq.add(new Path(neighbor, newPath));
	}

	private static class Path {
		int vertex;
		int weight;

		public Path(final int vertex, final int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString()
		{
			return String.format("Vertex = %s; weight = %s", Integer.toString(vertex), Integer.toString(weight));
		}
	}
}
