package com.masivian.lca.model;

/**
 * The Class Node to represent a node in binary tree.
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 *
 */
public class Node {

	/** value of the node */
	private int value;

	/** left of the node */
	private Node left;

	/** right of the node */
	private Node right;

	/**
	 * the node with value
	 * 
	 * @param value value of the node
	 */
	public Node(int value) {
		this.setValue(value);
		setRight(null);
		setLeft(null);
	}

	/**
	 * gets left of the node
	 * 
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * sets left of the node
	 * 
	 * @param left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * gets right of the node
	 * 
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * sets right of the node
	 * 
	 * @param right the right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * gets the value of the node
	 * 
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * sets the value of the node
	 * 
	 * @param value the value
	 */
	public void setValue(int value) {
		this.value = value;
	}
}
