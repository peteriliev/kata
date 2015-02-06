package test.java;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import main.java.Graph;
import main.java.IGraph;
import main.java.floyd.Floyd31;

import org.junit.Test;

public class FloydTest {

	@Test
	public void t4() throws Exception {
		final IGraph g = Graph.newInstance(19);

		g.addVertex(0);
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);

		g.addEdge(0, 1, 2);
		g.addEdge(0, 4, 4);

		g.addEdge(1, 2, 3);

		g.addEdge(2, 3, 5);
		g.addEdge(2, 4, 1);

		g.addEdge(3, 0, 8);

		g.addEdge(4, 3, 7);

		final int[][] paths = Floyd31.assp(g);
		System.out.println(Arrays.toString(paths));

		assertTrue(paths[0][2] == 5);
		assertTrue(paths[2][0] == 13);
	}
}
