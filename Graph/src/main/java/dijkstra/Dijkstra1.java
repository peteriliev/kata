package main.java.dijskstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.IGraph;

public class Dijkstra1 {

	private static int[] paths;
	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[] sssp(final IGraph graph, final int vertex) throws Exception
	{
		final int len = graph.getNumVertices();
		paths = new int[len];
		for (int i = 0; i < len; i++) {
			paths[i] = INFINITY;
		}
		paths[vertex] = 0;

		final PriorityQueue<Path> pq = new PriorityQueue<>(len, new PathComparator());

		for (final int v : graph.getVertices()) {
			pq.offer(new Path(v, paths[v]));
		}

		while (!pq.isEmpty()) {
			final Path min = pq.poll();
			for (final int neighbor : graph.getNeighbors(min.getVertex())) {
				int dist = graph.getEdgeWeight(min.getVertex(), neighbor);
				int newLen = dist + (paths[min.vertex]);
				
				if (newLen < paths[neighbor]) {
					final Path tmp = new Path(neighbor, paths[neighbor]);
					Path ptr = null;
					for (Path p : pq) {
						if (p.eq2(tmp)) {
							ptr = p;
							break;
						}
					}
					pq.remove(ptr);
					pq.add(new Path(neighbor, newLen));
					paths[neighbor] = newLen;
				}
			}
		}

		return paths;
	}

	private static class PathComparator implements Comparator<Path> {

		@Override
		public int compare(final Path o1, final Path o2)
		{
			if (null == o1 && null == o2) {
				return -1;
			}

			if (null == o1) {
				return -1;
			}

			if (null == o2) {
				return 1;
			}

			return ((Path) o1).getWeight() - ((Path) o2).getWeight();
		}
	}

	private static class Path {

		private final int vertex;
		private int weight;

		public Path(final int vertext, final int weight) {
			this.vertex = vertext;
			this.weight = weight;
		}

		public void setWeight(final int newLen)
		{
			this.weight = newLen;
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
		public boolean equals(Object objPath)
		{
			if (!(objPath instanceof Path)) {
				return false;
			}

			return ((Path) objPath).weight == this.weight && ((Path) objPath).vertex == this.vertex;
		}

		public boolean eq2(Object objPath)
		{
			if (!(objPath instanceof Path)) {
				return false;
			}

			return ((Path) objPath).weight == this.weight && ((Path) objPath).vertex == this.vertex;
		}

		@Override
		public String toString()
		{
			return String.format("Path: vertex = %s, weight = %s", Integer.toString(vertex), Integer.toString(weight));
		}
	}
}
