/**
 * Optimal Binary Search Tree
 * 
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches to keys[i].
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
 * 
 * Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency. Level of root is 1.
 * 
 * Example 1
 * Input:  keys[] = {10, 12}, freq[] = {34, 50}
 * There can be following two possible BSTs
 *         10                       12
 *           \                     /
 *            12                 10
 *             I                 II
 * Frequency of searches of 10 and 12 are 34 and 50 respectively.
 * The cost of tree I is 34*1 + 50*2 = 134
 * The cost of tree II is 50*1 + 34*2 = 118
 * 
 * Example 2
 * Input:  keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
 * There can be following possible BSTs
 *     10               12                 20         10              20
 *       \             /   \              /             \            /
 *        12          10    20           12              20         10
 *          \                           /               /           \
 *           20                        10             12             12
 *      I               II             III             IV             V
 * Among all possible BSTs, cost of the fifth BST is minimum.
 * Cost of the fifth BST is 1*50 + 2*34 + 3*8 = 142
 * 
 */

Code:

public class OptimalBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Test Cases
		int element[] = { 10, 12, 16, 21 };
		int frequency[] = { 4, 2, 6, 3 };

		int arr[][] = new int[element.length][element.length];

		for (int i = 0; i < element.length; i++) {
			arr[i][i] = frequency[i];
		}

		for (int num = 1; num < element.length; num++) {
			for (int i = 0; i < element.length - 1; i++) {
				int j = i + num;
				if (j < element.length) {
					int sum = add(i, j, frequency);
					int smallest = lookup(i, j, arr);
					arr[i][j] = sum + smallest;
				}
			}
		}
		System.out.println(arr[0][element.length - 1]);
	}

	private static int lookup(int i, int j, int[][] arr) {
		// TODO Auto-generated method stub
		if ((j - i) == 1) {
			return Math.min(arr[i][i], arr[j][j]);
		} else {
			int val1 = arr[i + 1][j];
			int val2 = arr[i][j - 1];
			int minVal = Math.min(val1, val2);

			for (int root = i + 1; root < j; root++) {
				int val = arr[i][root - 1] + arr[root + 1][j];
				minVal = Math.min(val, minVal);
			}
			return minVal;
		}
	}

	private static int add(int i, int j, int[] frequency) {
		// TODO Auto-generated method stub
		int sum1 = 0;
		for (int m = i; m <= j; m++) {
			sum1 += frequency[m];
		}
		return sum1;
	}
}
