package algomonster;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

class MaxDepthOfBinaryTree {
	public static class Node<T> {
		public T val;
		public Node<T> left;
		public Node<T> right;

		public Node(T val) {
			this(val, null, null);
		}

		public Node(T val, Node<T> left, Node<T> right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private static int dfs(Node<Integer> root) {
		// Null node adds no depth
		if (root == null)
			return 0;
		// num nodes in longest path of current subtree = max num nodes of its two
		// subtrees + 1 current node
		return Math.max(dfs(root.left), dfs(root.right)) + 1;
	}

	public static int treeMaxDepth(Node<Integer> root) {
		return (root != null) ? dfs(root) - 1 : 0;
	}

	// this function builds a tree from input; you don't have to modify it
	// learn more about how trees are encoded in
	// https://algo.monster/problems/serializing_tree
	public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
		String val = iter.next();
		if (val.equals("x"))
			return null;
		Node<T> left = buildTree(iter, f);
		Node<T> right = buildTree(iter, f);
		return new Node<T>(f.apply(val), left, right);
	}

	public static List<String> splitWords(String s) {
		return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
	}

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);

		String treeVal = "5 4 3 x x 8 x x 6 x x";

		// Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(),
		// Integer::parseInt);
		// scanner.close();

		// Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(),
		// Integer::parseInt);

		Node<Integer> root = buildTree(splitWords(treeVal).iterator(), Integer::parseInt);
		int res = treeMaxDepth(root);
		System.out.println(res);
	}

}
