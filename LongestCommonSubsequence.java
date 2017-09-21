
public class LongestCommonSubsequence {

	static String s1="abcdaf";
	static String s2="acbcf";
	
	static int arr[][]=new int[s2.length()+1][s1.length()+1];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lcs();
		
		retriveSequence();
	}

	private static void retriveSequence() {
		// TODO Auto-generated method stub
		
		StringBuffer sb = new StringBuffer();
		
		int i=s2.length();
		int j=s1.length();
		
		while(arr[i][j]!=0)
		{
			if(s2.charAt(i-1)==s1.charAt(j-1))
			{
				sb.insert(0, s2.charAt(i-1));
				i--;
				j--;
			}
			else
			{
				if(arr[i][j-1]>arr[i-1][j])
				{
					j--;
				}
				else
				{
					i--;
				}
			}
		}
		System.out.println(sb.toString());
	}

	private static void lcs() {
		// TODO Auto-generated method stub
		
		//Initialize 1st column
		for(int i=0;i<arr.length;i++)
		{
			arr[i][0]=0;
		}
		
		//Initialize 1st row
		for(int j=0;j<arr[0].length;j++)
		{
			arr[0][j]=0;
		}
		
		int maxLength=Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr[0].length;j++)
			{
				if(s2.charAt(i-1)==s1.charAt(j-1))
				{
					arr[i][j]=arr[i-1][j-1]+1;
				}
				else
				{
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
				
				if(arr[i][j]>maxLength)
				{
					maxLength=arr[i][j];
				}
			}
			
		}
		System.out.println(arr[s2.length()][s1.length()]);
	}

}
