package com.masivian.lca.service.api;

import com.masivian.lca.model.BinaryTree;

/**
 * The Interface ILowestCommonAncestorService.
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 */
public interface ILowestCommonAncestorService {

	/**
	 * Creates the binary tree
	 * 
	 * @param values the binary tree values
	 * @return the binary tree
	 */
	public BinaryTree createBinaryTree(int[] values);

	/**
	 * Gets the lowest common ancestor.
	 * 
	 * @param values  the binary tree values
	 * @param nodeOne node one to find in tree
	 * @param nodeTwo node two to find in tree
	 * @return the lowest common ancestor (LCA)
	 */
	public String getLowestCommonAncestor(int[] values, Integer nodeOne, Integer nodeTwo);
}
