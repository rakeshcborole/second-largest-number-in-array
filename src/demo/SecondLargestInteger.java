package demo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Q. How do you find the second largest number in an array in Java?
 * 
 * @author Rakesh
 *
 */
public class SecondLargestInteger {

	public static void main(String[] args) {
		System.out.println(new SecondLargestInteger().find(new int[] { 56, 34, 21, 18, 12, 2 }));
	}

	/**
	 * Find second largest element
	 * 
	 * @param numbers - the input array
	 * @return second largest integer
	 */
	private Integer find(int[] numbers) {
		PriorityQueue<Integer> maxHeap = maxHeap();
		for (int i = 0; i < 2; i++) {
			maxHeap.offer(numbers[i]);
		}
		for (int i = 2; i < numbers.length; i++) {
			if (numbers[i] < maxHeap.peek()) {
				maxHeap.offer(numbers[i]);
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}

	/**
	 * Build a max heap
	 * 
	 * @return
	 */
	private PriorityQueue<Integer> maxHeap() {
		return new PriorityQueue<Integer>(2, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
	}
}
