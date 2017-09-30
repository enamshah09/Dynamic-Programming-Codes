/**
 * 416. Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Note:
 * 	1. Each of the array element will not exceed 100.
 * 	2. The array size will not exceed 200.
 * 
 * Example 1:
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 
 * Example 2:
 * Input: [1, 2, 3, 5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */

Code:

public class PartitionEqualSubsetSum {
	
	static int input[] = {1, 3, 5, 5, 2, 1, 1, 6, 3, 3};
	
	static int totalSum=0;
	static int partitionSum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		calSum();
		
		boolean sumExists = subsetSum();
		
		System.out.println(sumExists);
	}

	private static boolean subsetSum() {
		// TODO Auto-generated method stub
		
		if((totalSum%2)!=0)
		{
			return false;
		}
		
		partitionSum=totalSum/2;
		
		boolean arr[][]=new boolean[input.length+1][partitionSum+1];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=true;
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[0].length;j++)
			{
				if(j-input[i-1]<0)
				{
					arr[i][j]=arr[i-1][j];
				}
				else
				{
					arr[i][j]=arr[i-1][j-input[i-1]] || arr[i-1][j];
				}
			}
		}
		
		if(arr[input.length][partitionSum])
		{
			retrieveSubset(arr);
		}
		
		return arr[input.length][partitionSum];
	}

	private static void retrieveSubset(boolean arr[][]) {
		// TODO Auto-generated method stub
		
		int i=arr.length-1;
		int j=arr[0].length-1;
		
		while(j!=0)
		{
			if(arr[i-1][j]==arr[i][j])
			{
				i--;
			}
			else
			{
				System.out.println("Subset="+input[i-1]);
				j=j-input[i-1];
				i--;
			}
		}
	}

	private static void calSum() {
		// TODO Auto-generated method stub
		
		for(int i=0;i<input.length;i++)
		{
			totalSum+=input[i];
		}
	}
}
