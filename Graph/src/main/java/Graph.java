package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph implements IGraph {

	final Map<Integer, List<Node>> vertices;

	private Graph(final int numVertices) {
		vertices = new HashMap<>(numVertices);
	}

	public static IGraph newInstance(final int numVertices)
	{
		return new Graph(numVertices);
	}

	@Override
	public int getNumVertices()
	{
		return vertices.size();
	}

	@Override
	public boolean isEdge(int u, int v)
	{
		return isEdge(u, v, EMPTY_WEIGHT);
	}

	private final static int EMPTY_WEIGHT = Integer.MIN_VALUE;

	@Override
	public boolean isEdge(int u, int v, int weight)
	{
		final List<Node> node = vertices.get(u);

		if (null == node) {
			return false;
		}

		return node.contains(new Node(v, weight));
	}

	@Override
	public int getEdgeWeight(int u, int v) throws Exception
	{
		final List<Node> node = vertices.get(u);

		if (null == node) {
			throw new Exception("Node doesnt exist");
		}

		for (final Node n : node) {
			if (n.getVertex() == v) {
				return n.getWeight();
			}
		}

		return EMPTY_WEIGHT;
	}

	@Override
	public void addEdge(int u, int v)
	{
		addEdge(u, v, EMPTY_WEIGHT);
	}

	@Override
	public void addEdge(int u, int v, int weight)
	{
		final List<Node> node = vertices.get(u);

		if (node == null) {
			final List<Node> newList = new ArrayList<>();
			newList.add(Node.newInstance(v, weight));
			vertices.put(u, newList);
		} else {
			final Node newN = Node.newInstance(v, weight);
			if (node.contains(newN)) {
				return;
			}

			node.add(newN);
		}
	}

	@Override
	public void removeEdge(int u, int v)
	{
		final List<Node> node = vertices.get(u);

		if (node == null) {
			return;
		} else {
			for (int i = 0; i < node.size(); i++) {
				if (v == node.get(i).getVertex()) {
					node.remove(i);
				}
			}
		}
	}

	private final static class Node {

		private final int weight;

		private final int vertex;

		private Node(final int vertex, final int weight) {
			this.weight = weight;
			this.vertex = vertex;
		}

		public static Node newInstance(final int vertex, final int weight)
		{
			return new Node(vertex, weight);
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
		public boolean equals(Object otherNode)
		{
			if (!(otherNode instanceof Node)) {
				return false;
			}

			return vertex == ((Node) otherNode).getVertex() && weight == ((Node) otherNode).getWeight();
		}
	}

	@Override
	public int[] getVertices()
	{
		final Integer[] tmp = vertices.keySet().toArray(new Integer[vertices.size()]);
		final int[] result = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			result[i] = tmp[i];
		}
		Arrays.sort(result);
		return result;
	}

	@Override
	public int[] getNeighbors(int u)
	{
		final List<Node> tmp = vertices.get(u);
		if (null == tmp) {
			return new int[0];
		}

		int[] result = new int[tmp.size()];

		for (int i = 0; i < tmp.size(); i++) {
			result[i] = tmp.get(i).getVertex();
		}
		Arrays.sort(result);

		int[] result2 = new int[tmp.size()];
		for (int i = 0; i < tmp.size(); i++) {
			result2[i] = result[tmp.size() - i - 1];
		}

		return result2;
	}

	@Override
	public void addVertex(int u)
	{
		vertices.put(u, null);
	}
}