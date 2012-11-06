package quickunion;

public class WeightedQuickUnionUF {

	private int[] id;
	
	private int[] size;
	
	public WeightedQuickUnionUF(int N)
	{
		this.id = new int[N];
		this.size = new int[N];
		for (int i = 0; i < N; i++)
		{
			//every node is a root
			this.id[i] = i;
			//size of each tree is 1
			this.size[i] = 1;
		}
	}
	
	private int root(int i)
	{
		// get the root of node i
		// navigate all the way to the root
		while(i != this.id[i])
		{
			// path compression
			// make every other node in path
			// point to its grandparent
			// id[i] = id[id[i]];
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
		
		if (this.size[i] < this.size[j])
		{
			this.id[i] = j;
			this.size[j] += this.size[i];
		}
		else
		{
			this.id[j] = i;
			this.size[i] += this.size[j];
		}
	}
}