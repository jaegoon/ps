package ps.algospot.chap8.asymtiling;

import java.lang.*;
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
	}
	
	static int solve2() {
		
		if(N%2==1) {
			return (dp[N] - dp[N/2] + 1000000007)%1000000007;
		}
		else {
			
			int temp1 = (dp[N] - dp[N/2] + 1000000007)%1000000007;
			return (temp1 - dp[N/2-1] + 1000000007)%1000000007;
		}
		
	}
	
	public static void main(String [] args) throws Exception {
		
		sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			init();
			
			solve();
			if(N<=2) answer = 0;
			else answer = solve2();
			
			
			System.out.println(answer);
		}
		
		
		
		sc.close();
	}

}