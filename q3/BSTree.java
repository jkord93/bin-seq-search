package q3;

/**
 * BSTree @author Justin Kord Student number 0360764 This class allows you to
 * insert into a BinarySearchTree, search the tree for values and calculate the
 * height of the tree.
 **/

public class BSTree {

	/* Class containing left and right child of current node and key value */
	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	// Root of BST
	Node root;

	// Constructor
	BSTree() {
		root = null;
	}

	// This method mainly calls insertRec()
	void insert(int key) {
		root = insertRec(root, key);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, int key) {

		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		/* return the (unchanged) node pointer */
		return root;
	}

	int count = 0;

	public Node search(Node root, int key) {
		// Base Cases: root is null or key is present at root
		if (root == null || root.key == key)
			return root;

		// val is greater than root's key
		if (root.key > key)
			return search(root.left, key);

		// val is less than root's key
		if (root.key < key)
			count++;
		return search(root.right, key);
	}

	public boolean find(int id) {
		Node current = root;
		while (current != null) {
			if (current.key == id) {
				System.out.println("Found a " + current.key);
				return true;
			} else if (current.key > id) {
				count++;
				current = current.left;
			} else {
				count++;
				current = current.right;
			}
		}
		System.out.println("Found nothing");
		return false;
	}

	// This method mainly calls InorderRec()
	void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.key);
			inorderRec(root.right);
		}

	}

	// findHeight method to determine the depth of the tree
	int findHeight(Node aNode) {
		if (aNode == null) {
			return -1;
		}

		int lefth = findHeight(aNode.left);
		int righth = findHeight(aNode.right);

		if (lefth > righth) {
			return lefth + 1;
		} else {
			return righth + 1;
		}
	}
}
