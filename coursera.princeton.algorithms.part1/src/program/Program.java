package program;

import sorting.Heapsort;
import sorting.Quicksort;
import sorting.MergeSort;
import pq.MaxPQ;

import trees.BinarySearchTree;
import trees.RedBlackBST;

public class Program 
{
	public static void main(String[] args) 
	{
		Program.testRedBlackTree();
	}
	
	private static void testQueues()
	{
		java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<Integer>();
		queue.offer(5);
		queue.offer(2);
		queue.offer(3);
		queue.offer(1);
		
		System.out.printf("%s ", queue.toString());
		System.out.println();
	}
	
	private static void testLinkedLists()
	{
		java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();
		queue.add(5);
		queue.add(2);
		queue.add(3);
		queue.add(1);

		Integer firstElement = queue.removeFirst();
		
		System.out.printf("%s ", queue);
		System.out.println();
	}
	
	private static void testBST()
	{
		BinarySearchTree<String, String> bst = new BinarySearchTree<String, String>();
		/*bst.put("B", "B");
		bst.put("I", "I");
		bst.put("N", "N");		
		bst.put("A", "A");
		bst.put("R", "R");
		bst.put("Y", "Y");*/
		//bst.displayTree();
		
		String[] keys = new String[] { "H", "F", "P", "D", "G", "M", "R", "A", "E", "L", "N", "Q", "T" };
		bst.putArray(keys, keys);		
		
		System.out.println("Inorder traversal of tree \"H F P D G M R A E L N Q T\"");		
		bst.traverseInorder();		
		System.out.println();	
		bst.traverseIterativeInorder();		
		System.out.println();
		System.out.println();
		
		System.out.println("Preorder traversal of tree \"H F P D G M R A E L N Q T\"");
		bst.traversePreorder();
		System.out.println();
		bst.traverseIterativePreorder();
		System.out.println();
		System.out.println();
		
		System.out.println("Postorder traversal of tree \"H F P D G M R A E L N Q T\"");
		bst.traversePostorder();
		System.out.println();
		bst.traverseIterativePostorder();
		System.out.println();
		System.out.println();
		
		System.out.println();
	}
	
	private static void testHeapSort()
	{
		Heapsort h = new Heapsort();
		h.sort(new Comparable[] { "", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" });
	}
	
	private static void testQuickSort()
	{
		/* Test Quicksort */
		
		System.out.println("Quick sort over array");
		Comparable[] array = new Comparable[] {5, 10, 0, 2, 6, 9};
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		
		Quicksort.sort(array);
		
		System.out.println();
		for (Comparable i : array) System.out.print(i.toString() + ", ");		
	}
	
	private static void testMergeSort()
	{
		/* Test MergeSort*/
		
		System.out.println("Merge sort over array ");
		Comparable[] array = new Comparable[] {5, 10, 0, 2, 6, 9};
		for (Comparable i : array) System.out.print(i.toString() + ", ");
		
		MergeSort.sort(array);
		
		System.out.println();
		for (Comparable i : array) System.out.print(i.toString() + ", ");		
	}
	
	private static void testMaxPQ()
	{
		//Test MaxPQ
		
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
	}
	
	private static void testRedBlackTree()
	{
		RedBlackBST<String, String> tree = new RedBlackBST<String, String>();
		tree.put("S", "S");
		tree.put("E", "E");
		tree.put("A", "A");
		tree.put("R", "R");
		tree.put("C", "C");
		tree.put("H", "H");
		tree.put("X", "M");
		tree.put("P", "P");
		tree.put("L", "L");
	}
}
