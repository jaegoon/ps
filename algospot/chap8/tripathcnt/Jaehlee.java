package gitStudy.acmicpc.algospot.chap8.trianglepath;

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
	static int map[][];
	static long dp[][];
	static int dpCnt[][];
	
	static void init() {
		
		N = sc.nextInt();
		answer = 0;
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];
		dpCnt = new int[N+1][N+1];
		
		for(int y=1; y<=N;y++) {
			for(int x=1; x<=y;x++) {
				map[y][x] = sc.nextInt();
				dp[y][x] = -1;
			}
		}
		
	}
	static long dfs(int y, int x) {
		
		if(y == N) {
			dpCnt[y][x] = 1;
			return dp[y][x] = map[y][x];
		}
		else if(dp[y][x] != -1) return dp[y][x];
		
		
		long temp1=0, temp2=0;
		temp1 = dfs(y+1, x);
		if(x+1 <=N) temp2 = dfs(y+1, x+1);
		
		//System.out.println(y+" "+x+" "+dpCnt[y+1][x]);
		//if(x+1 <=N) System.out.println(y+" "+x+" "+dpCnt[y+1][x+1]);
		
		if(temp1 > temp2) {
			dpCnt[y][x] = dpCnt[y+1][x];
			return dp[y][x] = temp1+map[y][x];
		}
		else if(temp1 < temp2) {
			dpCnt[y][x] = dpCnt[y+1][x+1];
			return dp[y][x] = temp2+map[y][x];
		}
		
		else {
			dpCnt[y][x] = dpCnt[y+1][x]+dpCnt[y+1][x+1];
			return dp[y][x] = temp1+map[y][x];
		}
		
	}
	
	public static void main(String [] args) throws Exception {
		
		sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			init();
			
			dfs(1,1);
			
			answer = dpCnt[1][1];
			System.out.println(answer);
		}
		
		sc.close();
	}

}



