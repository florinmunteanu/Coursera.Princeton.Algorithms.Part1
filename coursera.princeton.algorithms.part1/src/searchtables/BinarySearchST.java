package searchtables;

public class BinarySearchST<Key extends Comparable<Key>, Value> 
{
	private Key[] keys;
	private Value[] vals;
	private int N;
	
	public BinarySearchST(int capacity)
	{
		this.keys = (Key[])new Comparable[capacity];
		this.vals = (Value[])new Comparable[capacity];			
	}
	
	public int size()
	{
		return this.N;
	}
	
	public boolean isEmpty()
	{
		return (this.N == 0);
	}
	
	public Value get(Key key)
	{
		if (this.isEmpty()) return null;
		
		int i = this.rank(key);
		if (i < N && this.keys[i].compareTo(key) == 0)
		{
			return this.vals[i];
		}
		else { return null; }
	}
	
	public int rank(Key key)
	{
		int lo = 0, hi = N-1;
		while (lo <= hi)
		{
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(this.keys[mid]);
			
			if      (cmp < 0) { hi = mid - 1; }
			else if (cmp > 0) { lo = mid + 1; }
			else 			  { return mid; }
		}
		return lo;
	}
	
	// Recursive version
	private int rank(Key key, int lo, int hi)
	{
		if (hi < lo) return lo;
		
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(this.keys[mid]);
		
		if      (cmp < 0) { return this.rank(key, lo, mid-1); }
		else if (cmp > 0) { return this.rank(key, mid+1, hi); }
		else              { return mid; } 
			
	}
	
	public void put(Key key, Value val)
	{
		int i = this.rank(key);
		if (i < N && this.keys[i].compareTo(key) == 0)
		{			
			this.vals[i] = val;
			return;
		}
		for (int j = N; j > i; j--)
		{
			this.keys[j] = this.keys[j-1];
			this.vals[j] = this.vals[j-1];
		}
		this.keys[i] = key;
		this.vals[i] = val;
		this.N++;
	}
	
	public Key min()
	{
		return this.keys[0];
	}
	
	public Key max()
	{
		return this.keys[this.N-1];
	}
	
	public Key select(int k)
	{
		return this.keys[k];
	}	
}
