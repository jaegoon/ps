package ps.algospot.chap8.jumpgame;

import java.lang.*;
import java.util.*;
import java.io.*;

// 난이도 : 중-하
/*
 * 종만북 8장 JUMPGAME
   BFS + 메모이제이션 이용
*/
public class Jaegoon {

	static int N, tc;
	static int answer;
	static int map[][];
	static int memo[][];
	//static boolean answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		tc = Integer.parseInt(st.nextToken());
		
		for(int t=1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			memo = new int[N+1][N+1];
			map = new int[N+1][N+1];
			
			for(int x=1; x<=N;x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=1;y<=N;y++) {
					map[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			answer = bfs(1,1);
			if(answer==1) System.out.println("YES");
			else System.out.println("NO");
		}
		
	}
	
	static int bfs(int x, int y) {
		
		if(memo[x][y] != 0) return memo[x][y];
		if(x==N && y==N) return 1;
		
		int val = 0;
		if(x+map[x][y] <= N) val = bfs(x+map[x][y], y);
		if(val>0) return memo[x][y] = 1;
		
		if(y+map[x][y] <= N) val = bfs(x,map[x][y]+y);
		if(val>0) return memo[x][y] = 1;
		
		
		return memo[x][y] = -1;
	}	
}