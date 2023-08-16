package com.psdsa.array;

import java.util.Arrays;

/**
 * I/P : [4,3,7,8,6,11,1]
 * O/P: [3  1  6  4  8  7  11]  or [1  6  3  8  4  11  7]
 * */
public class ArrangeElementsInZigzagOrder {

	public static void main(String[] args) {
		int[] array = new int[] {4,3,7,8,6,11,1};
		arrangeApproach1(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
		
		System.out.println();
		
		arrangeApproach2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "  ");
		}
	}
	
	/*
	 * Step1: Sort the array
	 * Step2: Swap each pair i.e a[0],a[1]  and a[1],a[2] and so on..
	 * Complexity:  nlogn + n  = nlogn
	 * */
	public static void arrangeApproach1(int[] array) {
		Arrays.sort(array);
		for(int i=0; i<array.length-1; i=i+2) {
			int temp = array[i+1];
			array[i+1] = array[i];
			array[i] = temp;
		}
	}
	
	/*
	 * Try to follow any of the below pattern in single iteration-
	 *    a[0] < a[1] > a[2] < a[3] > a[4] ... 
	 *    a[0] > a[1] < a[2] > a[3] < a[4] ... 
	 * Iterate the elements and check if the element follows the pattern
	 * else swap it.
	 * Eg. for the first pattern
	 * if i is even, check if a[i] < a[i+1], else swap
	 * if i is odd , check if a[i] > a[i+1], else swap
	 * 
	 * Complexity:  O(n)
	 * */
	public static void arrangeApproach2(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			if((i%2==0 && array[i] > array[i+1]) || 
					(i%2==1 && array[i] < array[i+1])) {
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
		}
	}
}
