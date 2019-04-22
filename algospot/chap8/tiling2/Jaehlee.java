package gitStudy.acmicpc.algospot.chap8.tiling2;

import java.lang.*;
import java.io.*;
import java.util.*;

/*
 */import java.lang.*;
 import java.io.*;
 import java.util.*;

 /*
  */

class Jaehlee {
  
 	static int N;	
 	static int TC;
 	static int answer;
 	static Scanner sc;
 	static int dp[];
 	
 	static void init() {
 		
 		N = sc.nextInt();
 		answer = 0;
 		dp = new int[N+1];
 	}
 	
 	static void solve() {
 		
 		dp[0] = 0;
 		dp[1] = 1;
 		if(N>=2) dp[2] = 2;
 		
 		for(int i=3;i<=N;i++) {
 			dp[i] = (dp[i-1]+dp[i-2])%1000000007;
 		}
 		
 		answer = dp[N];
 	}
 	
 	public static void main(String [] args) throws Exception {
 		
 		sc = new Scanner(System.in);
 		TC = sc.nextInt();
 		
 		for(int t=1; t<=TC; t++) {
 			
 			init();
 			
 			solve();
 			
 			System.out.println(answer);
 		}
 		
 		
 		
 		sc.close();
 	}

 }