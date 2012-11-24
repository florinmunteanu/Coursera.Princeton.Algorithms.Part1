package trees;

public class RedBlackBST<Key extends Comparable<Key>, Value> 
{
	private static final boolean RED   = true;
	private static final boolean BLACK = false;
	
	private Node root; // BST node with color bit
	
	private class Node
	{
		Key key;     		// key
		Value val;   		// associated data
		Node left, right;   // subtrees
		int N;				// number of nodes in this subtree
		boolean color;      // color of link from parent to this node
		
		public Node(Key key, Value val, int N, boolean color)
		{
			this.key = key;
			this.val = val;
			this.N = N;
			this.color = color;
		}	
		
		public String toString()
		{
			return this.key.toString();
		}
	}
	
	private boolean isRed(Node x)
	{
		if (x == null) { return false; }
		return x.color == RED;
	}
	
	private Node rotateLeft(Node h)
	{
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		
		x.color = h.color;
		h.color = RED;
		
		x.N = h.N;
		h.N = 1 + this.size(h.left) + this.size(h.right);
		
		return x;
	}
	
	private Node rotateRight(Node h)
	{
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		
		x.color = h.color;
		h.color = RED;
		
		x.N = h.N;
		h.N = 1 + this.size(h.left) + this.size(h.right); 
		
		return x;
	}
	
	private void flipColors(Node h)
	{
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;		
	}
	
	public void put(Key key, Value val)
	{
		this.root = this.put(root, key, val);
		this.root.color = BLACK;
	}
	
	private Node put(Node h, Key key, Value val)
	{
		if (h == null)
		{
			return new Node(key, val, 1, RED);
		}
		
		int cmp = key.compareTo(h.key);
		if      (cmp < 0) h.left = this.put(h.left, key, val);
		else if (cmp > 0) h.right = this.put(h.right, key, val);
		else              h.val = val;
		
		if (this.isRed(h.right) && this.isRed(h.left) == false)
		{
			h = this.rotateLeft(h);
		}
		if (this.isRed(h.left) && this.isRed(h.left.left))
		{
			h = this.rotateRight(h);
		}
		if (this.isRed(h.left) && this.isRed(h.right))
		{
			this.flipColors(h);
		}
		
		h.N = this.size(h.left) + this.size(h.right) + 1;
		
		return h;	
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
		
	private int size(Node x)
	{
		if (x == null) { return 0; }
		else           { return x.N; }
	}
}
