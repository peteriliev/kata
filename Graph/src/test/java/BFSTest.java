package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import main.java.Graph;
import main.java.IGraph;
import main.java.bfs.BFS30;

import org.junit.Test;

public class BFSTest {

	@Test
	public void t1() {
		final IGraph g = Graph.newInstance(0);
		g.addEdge(0, 1);

		assertTrue(g.isEdge(0, 1));
	}

	@Test
	public void t11() {
		final IGraph g = Graph.newInstance(0);
		g.addEdge(0, 1);

		assertTrue(g.isEdge(0, 1));
		g.removeEdge(0, 1);
		assertFalse(g.isEdge(0, 1));
	}

	@Test
	public void t12() {
		final IGraph g = Graph.newInstance(0);
		g.addEdge(0, 1, 13);

		assertTrue(g.isEdge(0, 1, 13));
		assertFalse(g.isEdge(0, 1, 14));

		g.removeEdge(0, 1);
		assertFalse(g.isEdge(0, 1, 13));
		assertFalse(g.isEdge(0, 1, 14));
	}

	@Test
	public void t2() {
		final IGraph g = Graph.newInstance(0);

		assertFalse(g.isEdge(0, 1));
	}

	@Test
	public void t3() {
		final IGraph g = Graph.newInstance(0);

		g.addEdge(0, 1);
		assertFalse(g.isEdge(1, 0));
	}

	@Test
	public void t4() {
		final IGraph g = Graph.newInstance(19);

		myAdd(g, 2, 11);
		myAdd(g, 2, 10);
		myAdd(g, 2, 1);

		myAdd(g, 1, 3);
		myAdd(g, 1, 0);
		myAdd(g, 3, 12);

		myAdd(g, 3, 4);
		myAdd(g, 0, 6);
		myAdd(g, 0, 8);

		myAdd(g, 13, 4);
		myAdd(g, 15, 9);
		myAdd(g, 5, 9);

		myAdd(g, 13, 4);
		myAdd(g, 15, 9);
		myAdd(g, 5, 9);

		myAdd(g, 5, 4);
		myAdd(g, 5, 6);
		myAdd(g, 6, 7);

		myAdd(g, 8, 7);
		myAdd(g, 8, 14);

		myAdd(g, 16, 17);
		myAdd(g, 17, 18);

		final int[] result = BFS30.bfs(g, 0);
		System.out.println(Arrays.toString(result));

		assertTrue(areConnected(result, 0, 0));
		assertTrue(areConnected(result, 0, 15));
		assertTrue(areConnected(result, 0, 13));
		assertTrue(areConnected(result, 11, 15));

		assertFalse(areConnected(result, 0, 18));

		assertFalse(areConnected(result, 5, 17));
		assertTrue(areConnected(result, 16, 16));
		assertFalse(areConnected(result, 16, 18));
		assertFalse(areConnected(result, 17, 16));
		assertFalse(areConnected(result, 17, 19));
	}

	private static boolean areConnected(final int[] pred, final int u, final int v) {
		if (u >= pred.length || v >= pred.length) {
			return false;
		}

		final int rootU = getRoot(pred, u);
		final int rootV = getRoot(pred, v);

		return rootU == rootV;
	}

	private static int getRoot(final int[] pred, final int vertex) {
		int foo = vertex;

		while (foo != pred[foo]) {
			foo = pred[foo];
		}

		return foo;
	}

	private static void myAdd(final IGraph graph, final int u, final int v) {
		graph.addEdge(u, v);
		graph.addEdge(v, u);
	}
}