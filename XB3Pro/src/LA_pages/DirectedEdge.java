package LA_pages;

/**
 * class for DirectedEdge ADT
 * Modified version of referenced material
 * 
 * **********REFERENCED MATERIAL**********
 * Title: DirectedEdge.java
 * Authors: Robert Sedgewick, Kevin Wayne
 * Available: https://algs4.cs.princeton.edu/44sp/DirectedEdge.java.html
 * 
 * @author Group 13
 */
public class DirectedEdge {
	private final business_coord v;
	private final business_coord w;
	private final double weight;

	/**
	 * constructor for DirectedEdge ADT
	 * 
	 * @param v
	 *            starting business of a directed edge.
	 * @param w
	 *            ending business of a directed edge.
	 * @param weight
	 *            distance between the two businesses.
	 */
	public DirectedEdge(business_coord v, business_coord w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	/**
	 * accessor for starting business of a directed edge.
	 * 
	 * @return starting business of a directed edge.
	 */
	public business_coord from() {
		return this.v;
	}

	/**
	 * accessor for ending business of a directed edge.
	 * 
	 * @return ending business of a directed edge.
	 */
	public business_coord to() {
		return this.w;
	}

	/**
	 * accessor for the distance between two businesses.
	 * 
	 * @return the distance between two businesses.
	 */
	public double weight() {
		return this.weight;
	}
}
