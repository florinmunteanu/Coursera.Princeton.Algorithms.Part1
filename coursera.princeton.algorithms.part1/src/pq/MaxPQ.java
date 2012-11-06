package pq;

public class MaxPQ<Key extends Comparable<Key>> 
{
	private Key[] pq;   // heap-ordered complete binary tree
	private int N = 0;  // in pq[1..N] with pq[0] unused
	
	public MaxPQ(int maxN)
	{
		this.pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return this.N;
	}
	
	public void insert(Key v)
	{
		this.N++;
		this.pq[N] = v;
		this.swim(this.N);
	}
	
	public Key deleteMax()
	{
		Key max = this.pq[1];         // Retrieve max key from top
		this.exchange(1, this.N--);   // Exchange with last item
		this.pq[N+1] = null;          // Avoid loitering
		this.sink(1);                 // Restore heap property
		
		return max;
	}
	
	private void swim(int k)
	{
		while (k > 1 && this.less(k/2, k))
		{
			this.exchange(k/2, k);
			k = k/2;
		}
	}
	
	private void sink(int k)
	{
		while (2*k <= N)
		{
			int j = 2*k;
			if (j < N && this.less(j, j+1)) 
			{
				j++;
			}
			if (this.less(k, j) == false)
			{
				break;
			}
			k = j;
		}
	}
	
	private boolean less(int i, int j)
	{
		return this.pq[i].compareTo(this.pq[j]) < 0;
	}
	
	private void exchange(int i, int j)
	{
		Key t = this.pq[i];
		this.pq[i] = this.pq[j];
		this.pq[j] = t;
	}	
}