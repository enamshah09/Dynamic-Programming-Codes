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
