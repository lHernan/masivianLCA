package com.masivian.lca;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.masivian.lca.exception.CustomLCAException;
import com.masivian.lca.service.impl.LowestCommonAncestorService;

/**
 * The class LowestCommonAncestorTest to test behavior of LCA service
 *
 * @author <a href="hernan.laguado@gmail.com">Hernan Carreno</a>
 *
 */
public class LowestCommonAncestorTest {

	/** values of binary tree to test. */
	private static final int valuesOfBinaryTree[] = { 8, 15, 30, 10, 5, 55, 2, 6 };
	
	/** The Constant NODE_ONE. */
	private static final int NODE_ONE = 30;
	
	/** The Constant NODE_TWO. */
	private static final int NODE_TWO = 10;
	
	/** The Constant NODE_NOT_PRESENT. */
	private static final int NODE_NOT_PRESENT = 1;

	/** The Constant EXPECTED_RESULT. */
	private static final String EXPECTED_RESULT = "The LCA of node 30 and node 10 is: 15";

	/**
	 * Gets the lowest common ancestor success and create tree.
	 */
	@Test
	public void getLowestCommonAncestorSuccess() throws IOException {

		final LowestCommonAncestorService lowestCommonAncestorService = new LowestCommonAncestorService();

		final String result = lowestCommonAncestorService.getLowestCommonAncestor(valuesOfBinaryTree, NODE_ONE,
				NODE_TWO);
		assertEquals(result, EXPECTED_RESULT);

	}

	/**
	 * Test when node is not present, an exception is expected
	 */
	@Test(expected = CustomLCAException.class)
	public void exceptionWhenNodeIsNotPresentInTree() {
		final LowestCommonAncestorService lowestCommonAncestorService = new LowestCommonAncestorService();
		lowestCommonAncestorService.getLowestCommonAncestor(valuesOfBinaryTree, NODE_ONE, NODE_NOT_PRESENT);
	}

}
