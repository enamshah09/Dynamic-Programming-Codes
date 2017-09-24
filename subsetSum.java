public class subsetSum {
	
	static int input[] = {2, 3, 7, 8, 10};
	static int sum = 11;
	
	static boolean arr[][]=new boolean[input.length+1][sum+1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		subsetSum();
	}

	private static void retrieveCombination() {
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

	private static void subsetSum() {
		// TODO Auto-generated method stub
		
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
		
		if(arr[input.length][sum])
		{
			retrieveCombination();
		}
		System.out.println(arr[input.length][sum]);	
	}
}
