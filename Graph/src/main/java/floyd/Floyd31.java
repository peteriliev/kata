package main.java.floyd;

import main.java.IGraph;

public class Floyd31 {

	private static final int INFINITY = Integer.MAX_VALUE;

	public static int[][] assp(final IGraph graph) {
		final int len = graph.getNumVertices();
		final int[][] result = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (i == j) {
					result[i][i] = 0;
					continue;
				}

				try {
					result[i][j] = graph.getEdgeWeight(i, j) == Integer.MIN_VALUE ? INFINITY
							: graph.getEdgeWeight(i, j);
				} catch (Exception e) {
					result[i][j] = INFINITY;
				}
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				for (int k = 0; k < len; k++) {
					final int j_i = result[j][i];
					final int i_k = result[i][k];
					if (INFINITY == j_i || INFINITY == i_k) {
						continue;
					}
					final int new_path = j_i + i_k;
					final int old_path = result[j][k];
					if (new_path < old_path) {
						result[j][k] = new_path;
					}

				}
			}
		}

		return result;
	}
}
