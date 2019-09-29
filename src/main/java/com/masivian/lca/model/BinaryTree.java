package com.masivian.lca.model;

import io.swagger.annotations.ApiModel;

/**
 * The Class BinaryTree to represent a binary tree.
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 */
@ApiModel(description = "Details about Binary Tree. ")
public class BinaryTree {

	/**
	 * root node of binary tree
	 */
	private Node root;

	/**
	 * gets the root
	 * 
	 * @return the root
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * sets the root
	 * 
	 * @param root root to set
	 */
	public void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * Method to add recursive nodes to root creating a binary tree
	 * 
	 * @param current node to add
	 * @param value   value of the node
	 * @return binary tree
	 */
	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.getValue()) {
			current.setLeft(addRecursive(current.getLeft(), value));
		} else if (value > current.getValue()) {
			current.setRight(addRecursive(current.getRight(), value));
		} else {
			// value already exists
			return current;
		}

		return current;
	}

	/**
	 * method to add values of the binary tree
	 * 
	 * @param value value to add
	 */
	public void add(int value) {
		root = addRecursive(root, value);
	}

}