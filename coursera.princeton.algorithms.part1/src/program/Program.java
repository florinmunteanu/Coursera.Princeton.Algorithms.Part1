package program;

import pq.MaxPQ;

//import sorting.ShellSort;

//import week2.InsertionSort;
//import week2.SelectionSort;

public class Program {

	public static void main(String[] args) 
	{
		MaxPQ<String> pq = new MaxPQ<String>(30);
		pq.insert("S");
		pq.displayArray();
		pq.insert("E");
		pq.displayArray();
		pq.insert("A");
		pq.displayArray();
		pq.insert("R");
		pq.displayArray();
		pq.insert("C");
		pq.displayArray();
		pq.insert("H");
		pq.displayArray();
		pq.insert("E");
		pq.displayArray();
		pq.insert("X");
		pq.displayArray();
		pq.insert("A");
		pq.displayArray();
		pq.insert("M");
		pq.displayArray();
		pq.insert("P");
		pq.displayArray();
		pq.insert("L");
		pq.displayArray();
		pq.insert("E");
		pq.displayArray();
		//SelectionSort s = new SelectionSort();
		//s.sort(null);
		//InsertionSort s = new InsertionSort();
		//s.sort(null);
		
		//ShellSort s = new ShellSort();
		//s.sort(null);
		
		/* Test MergeSort*/
		/*
		System.out.println("Merge sort over array ");
		Comparable[] array = new Comparable[] {5, 10, 0, 2, 6, 9};
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		
		MergeSort.sort(array);
		
		System.out.println();
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		*/
		
		/* Test Quicksort */
		/*
		System.out.println("Quick sort over array");
		Comparable[] array = new Comparable[] {5, 10, 0, 2, 6, 9};
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		
		Quicksort.sort(array);
		
		System.out.println();
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		*/
	}
}
