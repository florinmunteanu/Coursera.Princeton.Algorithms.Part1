package week4;

class MaxPQ<Key extends Comparable<Key>>
{
	private Key[] pq;
	private int N = 0;
		
	public MaxPQ(int max)
	{
		this.pq = (Key[])new Comparable[max+1];
	}
	
	/* Create a priority queue from the keys in a[]. */
	public MaxPQ(Key[] a)
	{
		
	}
	
	/* Insert a key into priority queue. */
	public void insert(Key v)
	{
		this.N++;
		this.pq[N] = v;
		this.swim(N);
	}
	
	/* Returns the largest key. */
	public Key max()
	{
		return this.pq[1];	
	}
	
	/* Return and remove the largest key. */
	public Key deleteMax()
	{
		Key max = this.pq[1];  // Retrieve max key from top.
		this.exchange(1, N);   // Exchange with last item.
		this.N--;              //
		this.pq[N+1] = null;   // Avoid loitering.
		
		this.sink(1);          // Restore heap priority.
		return max;
	}
	
	/* Is the priority queue empty? */
	public boolean isEmpty()
	{ 
		return this.N == 0;
	}
	
	/* Number of keys in the priority queue. */
	public int size()
	{
		return this.N;
	}
	
	private boolean less(int i, int j)
	{
		return this.pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exchange(int i, int j)
	{
		Key value = this.pq[i];
		this.pq[i] = this.pq[j];
		this.pq[j] = value;
	}
	
	private void swim(int k)
	{
		while (k > 1 && this.less(k/2, k))
		{
			this.exchange(k/2,k);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while(2*k <= N)
		{
			int j = 2*k;
			if (j < this.N && this.less(j, j+1))
			{
				j++;
			}
			if (this.less(k, j) == false)
			{
				break;
			}
			this.exchange(k, j);
			k = j;
		}
	}
}