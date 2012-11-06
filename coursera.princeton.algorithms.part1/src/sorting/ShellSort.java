package sorting;

public class ShellSort 
{
	public void sort(int[] a)
	{
		if (a == null)
		{
			a = new int[] { 62, 83, 18, 53, 7, 17, 95, 86, 47, 69, 25, 28 };
		}
		int N = a.length;
		
		int h = 1;
		while (h < N/3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364
		
		while (h >= 1)
		{
			// h-sort the array
			for (int i = h; i < N; i++)
			{
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
				{
					this.swap(a, j, j-h);
				}
			}
			
			h = h / 3;
		}
	}
	
	private boolean less(int v, int w)
	{
		return v < w;
	}
	
	private void swap(int[] a, int i, int j)
	{
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
