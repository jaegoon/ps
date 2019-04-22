package ps.algospot.chap8.poly;
import java.lang.*;
import java.io.*;
import java.util.*;

/*
 */
class Jaegoon {
	 
	static int N;
	static int TC;
	static int answer;
	static int dp[][];
	static Scanner sc;
	static int Mod= 10000000;
	
	static void init() {
		
		N = sc.nextInt();
		answer = 0;
		dp = new int[N+1][N+1];
		for(int y=1;y<=N;y++) {
			for(int x=1;x<=N;x++) {
				dp[y][x] = -1;
			}
		}
	}
	
	
	// poly만들 box개수, 현재 row box개수
	static int dfs(int boxCnt, int rowBox) {
		
		// 종료조건
		if(boxCnt-rowBox == 0) {
			return 1;
		}
		
		// 메모이제이션 활용
		if(dp[boxCnt][rowBox] != -1) return dp[boxCnt][rowBox];
		
		//solve
		int temp = 0;
		for(int i=1; i<=boxCnt-rowBox;i++) {
			temp += (rowBox+i-1)*dfs(boxCnt-rowBox, i);
			temp %= Mod;
		}
		
		//메모이제이션 저장
		//System.out.println(temp);
		return dp[boxCnt][rowBox] = temp;
		
	}
	
	public static void main(String [] args) throws Exception {
		
		sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			init();
			int temp=0;
			
			for(int i =1; i<=N; i++) {
				temp = dfs(N, i);
				//System.out.println(i+" "+temp);
				answer += temp;
				answer %= Mod;
			}
			
			
			System.out.println(answer);
		}
		
		sc.close();
	}

}