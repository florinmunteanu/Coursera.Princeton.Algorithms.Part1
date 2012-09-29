package week1;

public class QuickUnionUF {

	private int[] id;

	public QuickUnionUF(int N)
	{
		// initial array
		// 0 1 2 3 4 5 6
		// union (5, 0)
		// root(5) = 5
		// root(0) = 0
		// id[root(5)] = 0
		
		this.id = new int[N];
		for (int i = 0; i < N; i++)
		{		
			this.id[i] = i;
		}
	}
	
	private int root(int i)
	{
		while (i != this.id[i])
		{
			i = this.id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return this.root(p) == this.root(q);
	}
	
	public void union(int p, int q)
	{
		int i = this.root(p);
		int j = this.root(q);
		this.id[i] = j;
	}
}
