package ps.algospot.chap8.snail;

import java.lang.*;
import java.io.*;
import java.util.*;

/*
 */
class Jaehlee {
	 
		static int N;	
		static int TC, M;
		static double answer;
		static double dp[][];
		static Scanner sc;
		
		static void init() {
			
			N = sc.nextInt();
			M = sc.nextInt();
			dp = new double[M+1][2*(N+1)];
			answer = 0;
			
			for(int i=1;i<=M;i++) {
				for(int j=0;j<=2*M;j++) {
					dp[i][j] = -1;
				}
			}
			
		}
		
		static double dfs(int day, int dist) {
			
			//System.out.println(day+" "+dist);
			
			// 종료조건
			if(N-dist <= 1) { return dp[day][dist] = 1;}
			if(day == M) {
				if(N-dist > 2) return 0;
				else if(N-dist == 2) return 0.75;
			}
			
			// 메모이제이션 활용
			if(dp[day][dist] != -1) return dp[day][dist];
			
			
			//solve
			double temp = 0;
			temp += (0.75) * dfs(day+1, dist+2);
			temp += (0.25) * dfs(day+1, dist+1);
			
			//System.out.println(day+" "+temp);
			
			//메모이제이션 저장
			return dp[day][dist]= temp;
		}
		
		public static void main(String [] args) throws Exception {
			
			sc = new Scanner(System.in);
			TC = sc.nextInt();
			
			for(int t=1; t<=TC; t++) {
				
				init();
				
				answer = dfs(1, 0);
				
				System.out.println(String.format("%.8f", answer));
			}
			
			sc.close();
		}

	}