package quickunion;

public class QuickFindUF {
	
	private int[] id;
	
	public QuickFindUF(int N)
	{
		this.id = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
		}
	}
	
	public boolean connected(int p, int q)
	{
		return this.id[p] == this.id[q];
	}
	
	public void union(int p, int q)
	{
		int pId = this.id[p];
		int qId = this.id[q];
		
		for (int i = 0; i < this.id.length; i++)
		{
			if (this.id[i] == pId)
			{
				this.id[i] = qId;			
			}
		}
	}
	
	public void writeToConsole()
	{
		for (int i = 0; i < this.id.length; i++)
		{
			System.out.print(this.id[i]);
		}
	}
}
