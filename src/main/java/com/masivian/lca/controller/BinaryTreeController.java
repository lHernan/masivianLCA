package com.masivian.lca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.lca.model.BinaryTree;
import com.masivian.lca.service.api.ILowestCommonAncestorService;

/**
 * The Class BinaryTreeController to create binary tree and get LCA of given
 * tree.
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 */
@RestController
@RequestMapping(path = "/binaryTree")
public class BinaryTreeController {

	/** The lowest common ancestor service. */
	@Autowired
	ILowestCommonAncestorService lowestCommonAncestorService;

	/**
	 * Creates the binary tree.
	 * 
	 * @param values the binary tree values
	 * @return the binary tree
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/createBinaryTree", consumes = "application/json", produces = "application/json")
	public @ResponseBody BinaryTree createBinaryTree(@RequestParam int[] values) {
		return lowestCommonAncestorService.createBinaryTree(values);
	}

	/**
	 * Gets the lowest common ancestor of two nodes in binary tree
	 * 
	 * @param values  values of the binary tree
	 * @param nodeOne node one to find
	 * @param nodeTwo node two to find
	 * @return the lowest common ancestor of nodeOne and nodeTwo
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/getLowestCommonAncestor")
	public @ResponseBody String getLowestCommonAncestor(@RequestParam int[] values, @RequestParam Integer nodeOne,
			@RequestParam Integer nodeTwo) {
		return lowestCommonAncestorService.getLowestCommonAncestor(values, nodeOne, nodeTwo);

	}

}
