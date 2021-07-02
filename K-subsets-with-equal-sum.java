import java.io.*;
import java.util.*;

public class Main {


	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int rssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(vidx>=arr.length){
		    if(rssf==k){
		        boolean flag = true;
		        for(int i=0; i<subsetSum.length-1; i++){
		            if(subsetSum[i]!=subsetSum[i+1]){
		                flag = false;
		                break;
		            }
		        }
		        if(flag){
		            for(ArrayList<Integer> partition: ans){
		                System.out.print(partition+" ");
		            }
		            System.out.println();
		        }
		    }
		    return;
		}
		
		for(int i=0; i<ans.size(); i++){
		    ArrayList<Integer> set = ans.get(i);
		    if(set.size()!=0){
		        set.add(arr[vidx]);
		        subsetSum[i]+=arr[vidx];
		        solution(arr, vidx+1, n, k, subsetSum, rssf, ans);
		        subsetSum[i]-=arr[vidx];
		        set.remove(set.size()-1);
		        
		    }else{
		        set.add(arr[vidx]);
		        subsetSum[i]+=arr[vidx];
		        solution(arr, vidx+1, n, k, subsetSum, rssf+1, ans);
		        subsetSum[i]-=arr[vidx];
		        set.remove(set.size()-1);
		        break;
		    }
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	
	

}