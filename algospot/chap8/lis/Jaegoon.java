package ps.algospot.chap8.lis;

import java.lang.*;
import java.util.*;
import java.io.*;

// 난이도 : 중-하
/*
 * 종만북 8장 LIS
*/
public class Jaegoon {

	static int N, tc;
	static int numbers[];
	static int dp [];
	static int answer;
	
	public static void main(String [] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			N = sc.nextInt();
			numbers = new int[N+1]; // map[y][x]
			dp = new int[N+1];
			
			for(int i =1;i<=N; i++) {
				numbers[i] = sc.nextInt();
			}
			
			answer = 0;
			for(int i =1;i<=N; i++) {
				dp[i] = 1;
				for(int j=1;j<i;j++) {
					if(numbers[i]>numbers[j] && dp[i] < dp[j]+1) dp[i] = dp[j]+1;
				}
				if(answer<dp[i]) answer = dp[i];
			}
			
			//answer = dp[N];
			System.out.println(answer);
		}
	}

}