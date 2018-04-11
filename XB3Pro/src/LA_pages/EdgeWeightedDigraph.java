package LA_pages;

import edu.princeton.cs.algs4.Bag;

/**
 * class for EdgeWeightedDigraph ADT Modified version of referenced material
 * 
 * **********REFERENCED MATERIAL********** 
 * Title: EdgeWeightedDigraph.java
 * Authors: Robert Sedgewick, Kevin Wayne Available:
 * https://algs4.cs.princeton.edu/44sp/EdgeWeightedDigraph.java.html
 * 
 * @author Group 13
 */
public class EdgeWeightedDigraph {
	private final int V;
	private int E;
	private Bag<DirectedEdge>[] adj;

	/**
	 * constructor for EdgeWeightedDigraph ADT
	 * 
	 * @param V
	 *            number of nodes in an edge-weighted digraph.
	 */
	public EdgeWeightedDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<DirectedEdge>[]) new Bag[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<DirectedEdge>();
		}
	}

	/**
	 * accessor for number of nodes in an edge-weighted digraph.
	 * 
	 * @return number of nodes in an edge-weighted digraph.
	 */
	public int V() {
		return V;
	}

	/**
	 * accessor for number of edges in an edge-weighted digraph.
	 * 
	 * @return number of edges in an edge-weighted digraph.
	 */
	public int E() {
		return E;
	}

	/**
	 * modifier for adding an edge to an edge-weighted digraph.
	 * 
	 * @param e
	 *            directed edge to be added.
	 */
	public void addEdge(DirectedEdge e) {
		business_coord v = e.from();
		business_coord w = e.to();
		adj[v.get_ID()].add(e);
		E++;
	}

	/**
	 * accessor for an iterable list of businesses of an edge-weighted digraph.
	 * 
	 * @param v
	 *            index of a starting business.
	 * @return an iterable list of businesses of an edge-weighted digraph.
	 */
	public Iterable<DirectedEdge> adj(int v) {
		return adj[v];
	}
}
