package io.avinash.main;

public class Main {

	public static void main(String[] args) {

		Main mainObject = new Main();
		int[] unsortedArray = { 5, 1,-565,1564,0,62,13,456,1567,36,95,64,89,1656,921564 ,1,1,3};
		
		int[] sortedArray = mainObject.mergeSort(unsortedArray);
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Unsorted Array");
		for(int arrayIterator = 0;arrayIterator<unsortedArray.length;arrayIterator++){
			System.out.print(unsortedArray[arrayIterator]+" ");
		}
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Sorted Array");
		for(int arrayIterator = 0;arrayIterator<sortedArray.length;arrayIterator++){
			System.out.print(sortedArray[arrayIterator]+" ");
		}

	}

	
	//Method to do merge sort
	public int[] mergeSort(int[] array) {

		//To end the recursion call
		if (array.length < 2){
			return array;
		}
		
		int[] leftSubArray = new int[array.length/2];
		
		int[] rightSubArray = new int[array.length - (array.length/2)];

		for(int arrayIterator = 0;arrayIterator<array.length/2;arrayIterator++){
			leftSubArray[arrayIterator] = array[arrayIterator];
		}
		
		for(int arrayIterator = 0 ;arrayIterator<(array.length - (array.length/2));arrayIterator++){
			rightSubArray[arrayIterator] = array[(array.length/2)+arrayIterator];
		}
		
		//sorting left and right sub arrays
		leftSubArray = mergeSort(leftSubArray);
		rightSubArray = mergeSort(rightSubArray);
		
		int[] sortedArray = mergeSubArrays(leftSubArray, rightSubArray);
		return sortedArray;

	}
	//Method to merge sorted subarrays in ascending order
	public int[] mergeSubArrays(int[] leftSubArray, int[] rightSubArray) {

		int leftSubArrayIterator = 0, rightSubArrayIterator = 0, mergedSortedArrayIterator = 0;
		int[] mergedSortedArray = new int[leftSubArray.length + rightSubArray.length];

		while (leftSubArrayIterator < leftSubArray.length && rightSubArrayIterator < rightSubArray.length) {

			if (leftSubArray[leftSubArrayIterator] < rightSubArray[rightSubArrayIterator]) {
				mergedSortedArray[mergedSortedArrayIterator] = leftSubArray[leftSubArrayIterator];
				leftSubArrayIterator++;
			} else {
				mergedSortedArray[mergedSortedArrayIterator] = rightSubArray[rightSubArrayIterator];
				rightSubArrayIterator++;
			}
			mergedSortedArrayIterator++;

		}
		// After this operation either any one of the subarray would be empty so
		// we would add the remaining
		while (leftSubArrayIterator < leftSubArray.length) {
			mergedSortedArray[mergedSortedArrayIterator] = leftSubArray[leftSubArrayIterator];
			leftSubArrayIterator++;
			mergedSortedArrayIterator++;
		}
		while (rightSubArrayIterator < rightSubArray.length) {
			mergedSortedArray[mergedSortedArrayIterator] = rightSubArray[rightSubArrayIterator];
			rightSubArrayIterator++;
			mergedSortedArrayIterator++;
		}

		return mergedSortedArray;

	}

}
