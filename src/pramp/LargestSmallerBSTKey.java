package pramp;

import java.io.*;
import java.util.*;

/***********************************************************
 * CODE INSTRUCTIONS: * 1) The method findLargestSmallerKey you're * asked to
 * implement is located at line 36. * 2) Use the helper code below to implement
 * it. * 3) In a nutshell, the helper code allows you to * to build a Binary
 * Search Tree. * 4) Jump to line 82 to see an example for how the * helper code
 * is used to test findLargestSmallerKey. *
 ***********************************************************/

class Solution {

	static class Node {
		int key;
		Node left;
		Node right;
		Node parent;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}
	}

	static class BinarySearchTree {

		Node root;

		private int largestSmallerKey = -1;

		int findLargestSmallerKey(int num) {
			// your code goes here
			largestSmallerKey = -1;
			findLargestSmallerKey(this.root, num);
			return largestSmallerKey;
		}

		void findLargestSmallerKey(Node root, int target) {
			if (root == null) {
				return;
			}

			if (root.key < target && largestSmallerKey < root.key) {
				largestSmallerKey = root.key;
			}

			if (root.key >= target) {
				findLargestSmallerKey(root.left, target);
			} else {
				findLargestSmallerKey(root.right, target);
			}
		}

		/*
		 * 
		 * if(root.val < target && root.val > global) { global = root.val }
		 * 
		 * if root.val > target go left else go right
		 * 
		 * 
		 * 
		 */

		// inserts a new node with the given number in the
		// correct place in the tree
		void insert(int key) {

			// 1) If the tree is empty, create the root
			if (this.root == null) {
				this.root = new Node(key);
				return;
			}

			// 2) Otherwise, create a node with the key
			// and traverse down the tree to find where to
			// to insert the new node
			Node currentNode = this.root;
			Node newNode = new Node(key);

			while (currentNode != null) {
				if (key < currentNode.key) {
					if (currentNode.left == null) {
						currentNode.left = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if (currentNode.right == null) {
						currentNode.right = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
	}

	/*********************************************
	 * Driver program to test above function *
	 *********************************************/

	public static void main(String[] args) {

		// Create a Binary Search Tree
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(9);
		bst.insert(25);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		bst.insert(14);

		int result = bst.findLargestSmallerKey(17);
		System.out.println("Largest smaller number is " + result);

	}
}

/**
 * Largest Smaller BST Key First, make sure your peer understands the question.
 * If you or your peer have a hard time understanding how to go about solving
 * this problem, or could use a reminder of how BSTs work, take this interactive
 * BST application for a spin. Some tend to first look for num in the tree and
 * then look for its predecessor. However, num isn’t necessarily a key in the
 * given tree. It could be any number. Moreover, even if num is in the tree,
 * finding it first won’t help. To get the full score for problem solving, your
 * peer must be able to explain why it’s possible to always store the last key
 * smaller than num without comparing it to the previously stored key.
 **/