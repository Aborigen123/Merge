package мerge;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();		
				
		int  r, n = 0;

		System.out.println("Enter the number of array elements:");

		n = sc.nextInt();

				int[] array = new int[n];
				
				System.out.println("Enter the number to which the range of random numbers will be added (by default from 0 to the number you lead)");
				r = sc.nextInt();
				
				System.out.println("Here is your array of" +n+ " array elements");
				
				for(int i = 0; i<n; i++){
					array[i] = rand.nextInt(r);
		 	
				System.out.println(array[i]);
			}
				System.out.println("Sorted");
				
				int[] a = mergeSort(array);
				
				 for(int i = 0; i<a.length; i++){
					 System.out.println(a[i]);
				 }

	}
	 public static int[] mergeSort(int[] arr) {
		    if (arr.length <= 1)  return arr;

		    int mid = arr.length / 2;
		    int[] left = new int[mid];
		    int[] right = new int[mid + arr.length%2];

		    int j = 0;
		    for (int i = 0; i < arr.length; i++) {
		        if (i < arr.length / 2) {
		            left[i] = arr[i];
		        } else {
		            right[j++] = arr[i];
		        }
		    }
		    return Merge(mergeSort(left), mergeSort(right));
		}

		public static int[] Merge(int[] left, int[] right) {
		    int a = 0, b = 0;
		    int[] merged = new int[left.length + right.length];
		    //збираємо посортований  массив із лівої і правої частини
		    for (int i = 0; i < left.length + right.length; i++) {
		        //поочередно берем менший член із крайнього лівого і правого
		        if (b < right.length && a < left.length)
		            if (left[a] > right[b] && b < right.length)
		                merged[i] = right[b++];
		            else
		                merged[i] = left[a++];
		        else
		            if (b < right.length)
		                merged[i] = right[b++];
		            else
		                merged[i] = left[a++];
		    }
		    return merged;
		}

}
