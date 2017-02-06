package trees;

import java.util.LinkedList;
import java.lang.*;
import java.util.*;

/*
 * Documentation:
 * http://www.quora.com/Data-Structures/What-are-some-of-the-use-cases-of-various-traversal-methods-for-trees
 * http://en.wikipedia.org/wiki/Tree_traversal
 */
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
	
	public void putArray(Key[] keys, Value[] values)
	{
		if (keys == null) { throw new IllegalArgumentException("keys cannot be null."); }
		if (values == null) { throw new IllegalArgumentException("values cannot be null."); }
		
		if (keys.length != values.length) { throw new IllegalArgumentException("keys and values must have the same length"); }
		
		for (int i = 0; i < keys.length; i++) {
			this.put(keys[i], values[i]);
		}
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
	
	//
	// Depth-first traversal
	public void traversePreorder()
	{
		this.traversePreorder(this.root);
	}
	
	private void traversePreorder(Node node)
	{
		if (node == null) { return; }
		
		System.out.printf("(Key %s, Value %s)", node.key, node.val);
		this.traversePreorder(node.left);
		this.traversePreorder(node.right);
	}
	
	public void traverseInorder()
	{
		this.traverseInorder(this.root);
	}
	
	private void traverseInorder(Node node)
	{
		if (node == null) { return; }
		
		this.traverseInorder(node.left);
		System.out.printf("(Key %s, Value %s)", node.key, node.val);
		this.traverseInorder(node.right);
	}	
	
	//http://www.youtube.com/watch?v=2lxVhW5-GTk&feature=plcp
	public void traverseIterativeInorder()
	{
		Stack<Node> stack = new Stack<Node>();
		Node current = this.root;
		
		while ((current != null) || (stack.isEmpty() == false))
		{
			// if current is not null, we push current and shift focus to its left sub-tree
			if (current != null)
			{
				stack.push(current);
				current = current.left;
			}
			else
			{
				// pop out nodes from the stack and shift focus to its right sub-tree
				current = stack.pop();
				System.out.printf("(Key %s, Value %s)", current.key, current.val);
				current = current.right;
			}
		}
	}
	
	// http://www.youtube.com/watch?v=2lxVhW5-GTk&feature=plcp
	public void traverseIterativePreorder()
	{
		Stack<Node> stack = new Stack<Node>();
		Node current = this.root;
		
		while ((current != null) || (stack.isEmpty() == false))
		{
			if (current != null)
			{
				System.out.printf("(Key %s, Value %s)", current.key, current.val);
				stack.push(current.right);
				current = current.left;
			}
			else
			{
				current = stack.pop();
			}
		}
	}
	
	public void traversePostorder()
	{
		this.traversePostorder(this.root);
	}
	
	private void traversePostorder(Node node)
	{
		if (node == null) { return; }
		
		this.traversePostorder(node.left);
		this.traversePostorder(node.right);
		System.out.printf("(Key %s, Value %s)", node.key, node.val);
	}
	
	// http://www.youtube.com/watch?v=XUZxmxmistg
	public void traverseIterativePostorder()
	{
		Stack<Node> stack = new Stack<Node>();
		Node previous = null;
		
		stack.push(this.root);
		while (stack.isEmpty() == false)
		{
			Node current = stack.peek();
			// make sure it is not a null
			if (current == null)
			{
				stack.pop();
			}
			// if it's leaf node, print it
			else if (current.left == null && current.right == null)
			{
				System.out.printf("(Key %s, Value %s)", current.key, current.val);
				stack.pop();
			}			
			// 3rd - check if previous pointer is our left child
			// if so we need to push right for processing
			else if (current.left == previous)
			{
				stack.push(current.right);
			}
			// 4th - if previous pointer is current pointer's right child, print itself
			else if (current.right == previous)
			{				
				System.out.printf("(Key %s, Value %s)", current.key, current.val);
				stack.pop();
			}
			else
			{
				// otherwise push the left child for processing
				stack.push(current.left);
			}
			
			previous = current;			
		}
	}
	
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        root = delete(root, key);       
    }

    private Node delete(Node x, Key key) 
    {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
    
     public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    
    public boolean isEmpty() {
        return size() == 0;
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
