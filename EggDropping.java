/**
 * Egg Dropping Problem
 * 
 * You are given m eggs, and access to a n-storey building.
 * 
 * The aim is to find out the highest floor from which an egg will not break when dropped out of a window from that floor.
 * If an egg is dropped and does not break, it is undamaged and can be dropped again.
 * However, once an egg is broken, that’s it for that egg.
 * 
 * If an egg breaks when dropped from floor j, then it would also have broken from any floor above that.
 * If an egg survives a fall, then it will survive any fall shorter than that.
 * 
 * The question is: What strategy should you adopt to minimize the number egg drops it takes to find the solution?
 */

public class eggDropping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int noFloors = 10;
		int noEggs = 2;
		
		eggDrop(noFloors, noEggs);
	}

	private static void eggDrop(int noFloors, int noEggs) {
		// TODO Auto-generated method stub
		
		int arr[][]=new int[noEggs+1][noFloors+1];
		
		for(int j=1;j<=noFloors;j++)
		{
			arr[1][j]=j;
		}
		
		int floorToLook=0, copy=0;
		for(int i=2;i<=noEggs;i++)
		{
			for(int j=1;j<=noFloors;j++)
			{
				arr[i][j]=Integer.MAX_VALUE;
				if(i>j)
				{
					arr[i][j]=arr[i-1][j];
				}
				else
				{
					for(int k=1;k<=j;k++)
					{
						copy=arr[i][j];
						
						arr[i][j]=Math.min(arr[i][j], 1 + Math.max(arr[i-1][k-1], arr[i][j-k]));
						
						if(copy>arr[i][j])
						{
							floorToLook = k;
						}
						
					}
				}
			}
		}
		
		for(int i=1;i<=noEggs;i++)
		{
			for(int j=1;j<=noFloors;j++)
			{
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Start from Floor ---> "+floorToLook);
	}
}