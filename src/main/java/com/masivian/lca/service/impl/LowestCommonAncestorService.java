package com.masivian.lca.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.masivian.lca.exception.CustomLCAException;
import com.masivian.lca.model.BinaryTree;
import com.masivian.lca.model.Node;
import com.masivian.lca.service.api.ILowestCommonAncestorService;

/**
 * The class LowestCommonAncestorService to find the LCA between two nodes of
 * given binary tree
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 */
@Service
public class LowestCommonAncestorService implements ILowestCommonAncestorService {

	/** The logger. */
	private static final Logger LOGGER = LogManager.getLogger(LowestCommonAncestorService.class.getName());

	/** The Constant LCA_RESULT_FORMAT. */
	private static final String LCA_RESULT_FORMAT = "The LCA of node %s and node %s is: %s";

	/** The Constant BINARY_TREE_RESULT_FORMAT. */
	private static final String BINARY_TREE_RESULT_FORMAT = "The binary tree with root %s was created.";

	/** The Constant LCA_ERROR. */
	private static final String LCA_ERROR = "Error calculating the LCA, one of the nodes isn't in the tree.";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BinaryTree createBinaryTree(int[] arr) {
		BinaryTree bt = new BinaryTree();
		for (int i = 0; i < arr.length; i++) {
			bt.add(arr[i]);
		}
		LOGGER.info(String.format(BINARY_TREE_RESULT_FORMAT, bt.getRoot().getValue()));
		return bt;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLowestCommonAncestor(int[] values, Integer nodeOne, Integer nodeTwo) {
		// create the binary tree
		BinaryTree Node = createBinaryTree(values);
		Node rootNode = Node.getRoot();
		Node nodeA = new Node(nodeOne);
		Node nodeB = new Node(nodeTwo);
		// check if the nodes are in tree
		if (containsNodeRecursive(rootNode, nodeOne) && containsNodeRecursive(rootNode, nodeTwo)) {
			final Node lca = getLCA(rootNode, nodeA, nodeB);
			String result = String.format(LCA_RESULT_FORMAT, nodeOne, nodeTwo, lca.getValue());
			LOGGER.info(result);
			return result;
		} else
			throw new CustomLCAException(LCA_ERROR);
	}

	/**
	 * gets LCA of a binary tree given two nodes
	 * 
	 * @param root  the binary tree node
	 * @param nodeA node to find
	 * @param nodeB node to find
	 * @return the LCA node found between node A and B
	 */
	public Node getLCA(Node root, Node nodeA, Node nodeB) {
		if (root == null)
			return null;
		if (root.getValue() == nodeA.getValue() || root.getValue() == nodeB.getValue())
			return root;

		Node left = getLCA(root.getLeft(), nodeA, nodeB);
		Node right = getLCA(root.getRight(), nodeA, nodeB);

		// If we get left and right not null , it is LCA for a and b
		if (left != null && right != null)
			return root;
		if (left == null)
			return right;
		else
			return left;

	}

	/**
	 * Check if the binary tree contains a node
	 * 
	 * @param current current node
	 * @param value   value of the node
	 * @return true if found, false otherwise
	 */
	private boolean containsNodeRecursive(Node current, int value) {
		if (current == null) {
			return false;
		}
		if (value == current.getValue()) {
			return true;
		}
		return value < current.getValue() ? containsNodeRecursive(current.getLeft(), value)
				: containsNodeRecursive(current.getRight(), value);
	}

}
