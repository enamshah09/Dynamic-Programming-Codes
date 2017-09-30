/**
 * 312. Burst Balloons
 * 
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i.
 * After the burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * Example:
 * Given [3, 1, 5, 8]
 * Return 167
 * 
 * Explanation:
 * nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */

Code:

class Solution {
    public int maxCoins(int[] arr) {
        
        if(arr.length==0)
        {
            return 0;
        }
        
        if(arr.length==1)
        {
            return arr[0];
        }
        
        int burstBalloon[][] = new int[arr.length][arr.length];
        
        for(int num = 1;num<=arr.length;num++)
        {
            for(int i = 0;i<=arr.length-num;i++)
            {
                int j=i+num-1;
                for(int k=i;k<=j;k++)
                {
                    int leftBalloon=1;
                    int rightBalloon=1;
                    if(i!=0)
                    {
                        leftBalloon=arr[i-1];
                    }
                    
                    if(j!=arr.length-1)
                    {
                        rightBalloon=arr[j+1];
                    }
                    
                    int leftSum=0;
                    int rightSum=0;
                    if(i!=k)
                    {
                        leftSum=burstBalloon[i][k-1];
                    }
                    
                    if(j!=k)
                    {
                        rightSum=burstBalloon[k+1][j];
                    }
                    
                    burstBalloon[i][j]=Math.max(burstBalloon[i][j], (leftSum + rightSum + leftBalloon * arr[k] * rightBalloon));
                } 
            }
        }
        
        for(int p=0;p<burstBalloon.length;p++)
        {
            for(int q=0;q<burstBalloon[0].length;q++)
            {
                System.out.print(burstBalloon[p][q]+"\t");
            }
            System.out.println();
        }
        
        return burstBalloon[0][arr.length-1];
    }
}