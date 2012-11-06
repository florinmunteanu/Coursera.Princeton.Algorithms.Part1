package sorting;

public class MergeSort 
{	
	public static Comparable[] aux; //auxiliary array for merges
	
	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		// Merge a[lo..mid] with a[mid+1..hi]
		int i = lo, j = mid + 1;
		
		// Copy a[lo..hi] to aux[lo..hi]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k]; 
		}
		
		for (int k = lo; k <= hi; k++) {
			if      (i > mid)              a[k] = aux[j++];
			else if (j > hi )              a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else                           a[k] = aux[i++];
		}
	}
	
	public static void sort(Comparable[] a)
	{
		aux = new Comparable[a.length]; // Allocate space just once
		sort(a, 0, a.length - 1);       
	}
		
	public static void sort(Comparable[] a, int lo, int hi)
	{
		//Sort a[lo..hi]
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		
		sort(a, lo, mid); 
		sort(a, mid+1, hi);
		
		merge(a, lo, mid, hi);
	}
	
	public static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
}
