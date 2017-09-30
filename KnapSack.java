/**
 * 0-1 Knapsack Problem
 * 
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */

Code:

public class KnapSack {

	static int wt[] = {1, 4, 3, 5};
	static int price[] = {1, 5, 4, 7};
	static int totalWeight=7;
	static int arr[][] = new int [wt.length+1][totalWeight+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Sort the weight and price using Optimized Bubble sort
		sortFun();
		
		knapSack();
		
		retriveWeigth();
		
	}

	private static void retriveWeigth() {
		// TODO Auto-generated method stub
		
		int i=arr.length-1;
		int j=arr[0].length-1;
		while(arr[i][j]!=0)
		{
			if(arr[i-1][j]==arr[i][j])
			{
				i--;
			}
			else
			{
				System.out.println("Weight="+wt[i-1]);
				j=j-wt[i-1];
				i--;
			}
		}
	}

	private static void knapSack() {
		// TODO Auto-generated method stub
		
		//Initialize 1st row and 1st column in the matrix
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=0;
		}
		
		for(int j=0;j<arr[0].length;j++)
		{
			arr[0][j]=0;
		}
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[0].length;j++)
			{
				if(j-wt[i-1]>=0)
				{
					arr[i][j] = Math.max(price[i-1] + arr[i - 1][j - wt[i - 1]], arr[i - 1][j]);
				}
				else
				{
					arr[i][j]=arr[i-1][j];
				}
			}
		}
		
		/*for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}*/
	}

	private static void sortFun() {
		// TODO Auto-generated method stub
		
		boolean swap = false;
		
		//Using Optimized Bubble sort
		for(int i=0;i<wt.length-1;i++)
		{
			swap = false;
			for(int j=0;j<wt.length-i-1;j++)
			{
				if(wt[j]>wt[j+1])
				{
					int wtTemp = wt[j];
					wt[j] = wt[j+1];
					wt[j+1]=wtTemp;
					
					int priceTemp = price[j];
					price[j]=price[j+1];
					price[j+1]=priceTemp;
					
					swap=true;
				}
			}
			if(swap==false)
			{
				break;
			}
		}
	}
}
