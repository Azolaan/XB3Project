package LA_pages;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraSP {
	private DirectedEdge[] edgeTo;
	private double[] distTo;
	private IndexMinPQ<Double> pq;

	/**
	 * constructor for DijkstraSP ADT
	 * 
	 * @param G an edge-weighted digraph.
	 * @param s starting business of a path.
	 */
	public DijkstraSP(EdgeWeightedDigraph G, business_coord s) {
		edgeTo = new DirectedEdge[G.V()];
		distTo = new double[G.V()];
		pq = new IndexMinPQ<Double>(G.V());

		for (int v = 0; v < G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		distTo[s.get_ID()] = 0.0;
		pq.insert(s.get_ID(), 0.0);

		while (!pq.isEmpty())
			relax(G, pq.delMin());
	}

	/**
	 * accessor for whether a business has been marked or not.
	 * 
	 * @param v ending business of a path.
	 * @return true if v is marked and false otherwise.
	 */
	public boolean hasPathTo(business_coord v) {
		return distTo[v.get_ID()] < Double.POSITIVE_INFINITY;
	}

	/**
	 * adds the businesses in a path into a stack.
	 * 
	 * @param v ending business of a path.
	 * @return an iterable stack of businesses of a path.
	 */
	public Iterable<DirectedEdge> pathTo(business_coord v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v.get_ID()]; e != null; e = edgeTo[e.from().get_ID()]) {
			path.push(e);
		}
		return path;
	}

	private void relax(EdgeWeightedDigraph G, int v) {
		for (DirectedEdge e : G.adj(v)) {
			business_coord w = e.to();
			if (distTo[w.get_ID()] > distTo[v] + e.weight()) {
				distTo[w.get_ID()] = distTo[v] + e.weight();
				edgeTo[w.get_ID()] = e;
				if (pq.contains(w.get_ID()))
					pq.changeKey(w.get_ID(), distTo[w.get_ID()]);
				else
					pq.insert(w.get_ID(), distTo[w.get_ID()]);
			}
		}
	}
}
