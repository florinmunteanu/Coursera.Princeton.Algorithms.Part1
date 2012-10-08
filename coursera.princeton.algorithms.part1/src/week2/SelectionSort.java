package week2;

public class SelectionSort 
{
	public void sort(int[] data)
	{
		if (data == null)
		{
			data = new int[] { 10, 5, 6, 8, 0, 12, 9, 1, 4 };
		}
		for (int i = 0; i < data.length; i++)
		{
			int min = i;
			for (int j = i + 1; j < data.length; j++)
			{
				if (data[j] < data[min])
				{
					min = j;
				}
			}
			this.swap(data, i, min);
		}
		
		this.displayArray(data);
	}
	
	private void displayArray(int[] data)
	{
		for (int i = 0; i < data.length; i++)
		{
			System.out.print(data[i]+ " ");			
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
