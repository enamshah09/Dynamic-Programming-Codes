/**
 * 139. Word Break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 * 
 * For example, given
 * 
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */

Code:

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s==null)
        {
            return true;
        }
        
        boolean arr[][]=new boolean[s.length()][s.length()];
        
        for(int num=1;num<=s.length();num++)
        {
            for(int i=0;i<=s.length()-num;i++)
            {
                int j=i+num-1;
                
                if(wordDict.contains(s.substring(i,j+1)))
                {
                    arr[i][j]=true;
                }
                else
                {
                    for(int k=i;k<=j;k++)
                    {
                        if(i==k)
                        {
                            if(arr[i][k] && arr[k+1][j])
                            {
                                arr[i][j]=true;
                                break;
                            }
                        }
                        else
                        {
                            if(j==k)
                            {
                                if(arr[i][k-1] && arr[k][j])
                                {
                                    arr[i][j]=true;
                                    break;
                                }
                            }
                            else
                            {
                                if(arr[i][k] && arr[k+1][j])
                                {
                                    arr[i][j]=true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        /*for(int p=0;p<arr.length;p++)
        {
            for(int q=0;q<arr[0].length;q++)
            {
                System.out.print(arr[p][q]+"\t");
            }
            System.out.println();
        }*/
        
        return arr[0][s.length()-1];
    }
}