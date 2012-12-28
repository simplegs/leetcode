/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.
*/

/*
My Solution

This question is a n2 problem.
sort first
then loop from the smallest, and get the other two from the bigger ones, 
it should get the unique pairs by only (n),

so the total should be n2

Several tricks here:

1, how to avoid duplicate result without using set
	compare with each next i, j, k, with the previous one, if same, then continue
	



*/


import java.util.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // sort first
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>>	result = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < num.length - 2; i++){
		
			// avoid the duplicate i
			if(i > 0 && num[i] == num[i - 1])	continue;
			int j = i + 1;
			int k = num.length - 1;
			while(j < k){
				int temp = num[j] + num[k];
				if(num[i] + temp < 0)	j++;
				else if(num[i] + temp > 0)	k--;
				else{
					// avoid the duplicate j
					if(j > i + 1 && num[j] == num[j - 1])	{	j++; continue;}
					// avoid the duplicate k
					if(k < num.length - 1 && num[k] == num[k + 1])	{	k--; continue;}
					ArrayList<Integer>	tempList = new ArrayList<Integer>();
					tempList.add(num[i]);
					tempList.add(num[j]);
					tempList.add(num[k]);
					result.add(tempList);
					j++;
					k--;
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args){
		int[] num = {1, 2, 3, 4, 5, 0, -1, -2, -3, -4, -5};
		System.out.println(threeSum(num));
	
	}
}