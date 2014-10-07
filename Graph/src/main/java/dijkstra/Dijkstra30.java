package main.java.dijkstra;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.IGraph;

public class Dijkstra30 {

	private static int paths[];
	private static int pred[];
	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[][] sssp(final IGraph g, final int vertex) throws Exception {
		final int len = g.getNumVertices();
		paths = new int[len];
		pred = new int[len];

		for (int i = 0; i < len; i++) {
			pred[i] = i;
			paths[i] = i == vertex ? 0 : INFINITY;
		}

		final PriorityQueue<Node> pq = new PriorityQueue<Dijkstra30.Node>(new Comparator<Node>() {
			@Override
			public int compare(final Node n1, final Node n2) {
				return n1.weight - n2.weight;
			}
		});

		for (final int v : g.getVertices()) {
			pq.add(new Node(v, paths[v]));
		}

		while (!pq.isEmpty()) {
			final Node polled = pq.poll();

			for (final int neighbor : g.getNeighbors(polled.vertex)) {
				final int currentPath = paths[neighbor];
				final int newPath = paths[polled.vertex] + g.getEdgeWeight(polled.vertex, neighbor);
				if (newPath < currentPath) {
					pred[neighbor] = polled.vertex;
					paths[neighbor] = newPath;
					update(pq, neighbor, newPath);
				}
			}
		}

		return new int[][] { paths, pred };
	}

	private static void update(final PriorityQueue<Node> pq, final int node, final int newPath) {
		Node target = null;
		for (final Node n : pq) {
			if (n.vertex == node) {
				target = n;
				break;
			}
		}
		pq.remove(target);
		pq.add(new Node(node, newPath));
	}

	static class Node {
		public final int vertex;
		public final int weight;

		public Node(final int vertex, final int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.format("Node: vertex=%i; weight=%i", vertex, weight);
		}
	}
}