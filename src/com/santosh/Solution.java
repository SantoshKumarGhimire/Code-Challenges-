package com.santosh;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	// inserting new node into binary tree

	public static Node insertNode(Node root, int data) {

		if (root == null)
			return new Node(data);

		else {
			Node current;

			if (data < root.left.data) {

				current = insertNode(root.left, data);

				root.left = current;

			}

			else {

				current = insertNode(root.right, data);

				root.right = current;
			}
		}

		return root;
	}

	
	//Breath first search 
	static void levelOrder(Node root) {

		List<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Node n = queue.remove(0);

			System.out.print(n.data + " ");

			if (n.left != null)

				queue.add(n.left);

			if (n.right != null)

				queue.add(n.right);
		}

	}
	
	// height of binary tree

	private static int getHeight(Node root) {

		int heightLeft = 0;

		int heightRight = 0;

		if (root.left != null) {

			heightLeft = getHeight(root.left) + 1;
		}
		if (root.right != null) {

			heightRight = getHeight(root.right) + 1;
		}

		return (heightLeft > heightRight ? heightLeft : heightRight);
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		Node root = null;

		while (T-- > 0) {

			int data = sc.nextInt();

			root = insertNode(root, data);
		}

		int height = getHeight(root);

		System.out.println(height);

		levelOrder(root);
	}

}
