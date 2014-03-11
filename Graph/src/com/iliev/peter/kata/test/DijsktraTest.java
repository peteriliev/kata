package com.iliev.peter.kata.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.iliev.peter.kata.Graph;
import com.iliev.peter.kata.IGraph;
import com.iliev.peter.kata.dijskstra.Dijkstra27;

public class DijsktraTest {

	@Test
	public void t4() throws Exception
	{
		final IGraph g = Graph.newInstance(19);

		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);

		g.addEdge(0, 1, 6);
		g.addEdge(0, 2, 8);
		g.addEdge(0, 3, 18);

		g.addEdge(1, 4, 11);

		g.addEdge(2, 3, 9);

		g.addEdge(4, 5, 3);

		g.addEdge(5, 2, 7);
		g.addEdge(5, 3, 4);

		final int[] paths = Dijkstra27.sssp(g, 0)[0];
		final int[] pred = Dijkstra27.sssp(g, 0)[1];
		System.out.println(Arrays.toString(paths));
		System.out.println(Arrays.toString(pred));

		assertTrue(paths[0] == 0);
		assertTrue(paths[1] == 6);
		assertTrue(paths[2] == 8);
		assertTrue(paths[3] == 17);
		assertTrue(paths[4] == 17);
		assertTrue(paths[5] == 20);

		assertTrue(pred[0] == 0);
		assertTrue(pred[1] == 0);
		assertTrue(pred[2] == 0);
		assertTrue(pred[3] == 2);
		assertTrue(pred[4] == 1);
		assertTrue(pred[5] == 4);
	}

	private static boolean areConnected(final int[] pred, final int u, final int v)
	{
		if (u >= pred.length || v >= pred.length) {
			return false;
		}

		final int rootU = getRoot(pred, u);
		final int rootV = getRoot(pred, v);

		return rootU == rootV;
	}

	private static int getRoot(final int[] pred, final int vertex)
	{
		int foo = vertex;

		while (foo != pred[foo]) {
			foo = pred[foo];
		}

		return foo;
	}
}