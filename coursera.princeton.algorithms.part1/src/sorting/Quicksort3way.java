package sorting;

public class Quicksort3way 
{	
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);       // Eliminate dependence on input
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo) return;
		int lt = lo, i = lo + 1, gt = hi; // lt = lower than, gt = greater than
		
		Comparable v = a[lo];             // pivot
		while (i <= gt)
		{
			int cmp = a[i].compareTo(v);
			if      (cmp < 0) exchange(a, lt++, i++);
			else if (cmp > 0) exchange(a, i, gt--);
			else              i++;
		} // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi]
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	
	private static void exchange(Comparable[] a, int i, int j)
	{
		Comparable aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
