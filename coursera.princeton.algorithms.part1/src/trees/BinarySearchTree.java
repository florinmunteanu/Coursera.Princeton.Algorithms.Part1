package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> 
{
	private Node root;
	
	private class Node
	{
		private Key key;          // key
		private Value val;        // associated value
		private Node left, right; // links to subtrees
		private int N;            // # nodes in subtree rooted here
		
		public Node(Key key, Value val, int N)
		{
			this.key = key;
			this.val = val;
			this.N = N;
		}	
	}
	
	public int size()
	{
		return this.size(this.root);
	}
	
	private int size(Node x)
	{
		if (x == null) { return 0; }
		else           { return x.N; }
	}
	
	public Value get(Key key)
	{
		return this.get(this.root, key);
	}
	
	private Value get(Node x, Key key)
	{
		if (x == null) { return null; }
		
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) { return this.get(x.left, key); }
		else if (cmp > 0) { return this.get(x.right, key); }
		else              { return x.val; }
	}
	
	public void put(Key key, Value val)
	{
		this.root = this.put(this.root, key, val);
	}
	
	private Node put(Node x, Key key, Value val)
	{
		if (x == null) { return new Node(key, val, 1); }
		
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) { x.left = this.put(x.left, key, val); }
		else if (cmp > 0) { x.right = this.put(x.right, key, val); }
		else              { x.val = val; }
		
		x.N = this.size(x.left) + size(x.right) + 1;
		return x;
	}
	
	public Key min()
	{
		return this.min(this.root).key;
	}
	
	private Node min(Node x)
	{
		if (x.left == null) { return x; }
		return this.min(x.left);
	}
	
	public Key floor(Key key)
	{
		Node x = this.floor(root, key);
		if (x == null) { return null; }
		return x.key;
	}
	
	private Node floor(Node x, Key key)
	{
		if (x == null) { return null; }
		
		int cmp = key.compareTo(x.key);
		if (cmp == 0) { return x; }
		if (cmp < 0)  { return this.floor(x.left, key); }
		
		Node t = this.floor(x.right, key);
		if (t != null) { return t; }
		else 		   { return x; }	
	}
	
	public Key select(int k)
	{
		return this.select(this.root, k).key;
	}
	
	private Node select(Node x, int k)
	{
		// Return Node containing key of rank k.
		if (x == null) { return null; }
		
		int t = this.size(x.left);
		if      (t > k) { return this.select(x.left, k); }
		else if (t < k) { return this.select(x.right, k-t-1); }
		else            { return x; }
	}
	
	public void displayTree()
	{
		this.displayTree(this.root);
	}
	
	// Queue based level order traversal
	// Requires space proportional to the maximum number of nodes at a given depth
	private void breadthFirstTraversal(Node root)
	{
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (queue.isEmpty() == false)
		{
			Node n = queue.removeFirst();
			System.out.printf("(Key %s, Value %s)", n.key, n.val);
			if (n.left != null)
			{
				queue.add(n.left);			
			}
			if (n.right != null)
			{
				queue.add(n.right);
			}
		}		
	}
	
	private void displayTree(Node root)
	{
		if (root == null) { return; }
		LinkedList<Node> level = new LinkedList<>();
		
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;
		
		level.add(root);
		while (level.isEmpty() == false)
		{
			Node n = level.removeFirst();
			
			nodesInCurrentLevel--;
			
			System.out.print(n.val + " ");
			if (n.left != null)  { level.add(n.left); nodesInNextLevel += 1; }
			if (n.right != null) { level.add(n.right); nodesInNextLevel += 1; }
			
			if (nodesInCurrentLevel == 0)
			{
				System.out.println();
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}
	}
}
