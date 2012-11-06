package sorting;

public class InsertionSort 
{
	public void sort(int[] data)
	{
		if (data == null)
		{
			data = new int[] { 10, 5, 6, 8, 0, 12, 9, 1, 4 };
		}
		
		for (int i = 0; i < data.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (data[j] < data[j - 1])
				{
					this.swap(data, j, j - 1);
				}
				else
				{
					break;
				}
			}
		}
		
		this.displayArray(data);
	}
	
	private void displayArray(int[] data)
	{ 
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	private void swap(int[] data, int i, int j)
	{
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}
