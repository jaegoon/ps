package ps.algospot.chap6.clocksync;

import java.lang.*;
import java.io.*;
import java.util.*;

/*

 */
class Jaegoon {
	 
	// static int N;
	static int TC;
	static int answer;
	static int clock[]; // 12시 : 0, 3시 : 1, 6시 :2, 9시 : 3 
	static Scanner sc;
	static int buttonCnt[];
	static int testIdx;

	static int switchs[][] = {{0, 1, 2}, {3,7,9,11}, {4,10,14,15}, {0,4,5,6,7}, {6,7,8,10,12}, {0,2,14,15}, {3, 14, 15} , {4, 5, 7, 14, 15} , {1,2,3,4,5}, {3,4,5,9,13}};
	
	static void init() {

		clock = new int[17];
		buttonCnt = new int[10];
		answer = Integer.MAX_VALUE;
		testIdx = 0;
		
		for(int i=0; i<=15; i++) {
			 int temp = sc.nextInt();
			 clock[i] = (temp/3)%4;
		}
		
	}
	
	static void clocking(int num) {
		
		for(int i=0; i<switchs[num].length; i++) {
			if(clock[switchs[num][i]] == 3) clock[switchs[num][i]] = 0;
			else clock[switchs[num][i]]++;
		}
	}
	
	static void dfs(int btnNum, int clickCnt) {
		
		if(btnNum > 9) {
			
			if(checking()) {
				if(answer > clickCnt) answer = clickCnt;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			dfs(btnNum+1, clickCnt+i);
			clocking(btnNum);
		}
		
	}
	
	static boolean checking() {
		
		for(int i=0; i<=15; i++) {
			if(clock[i] != 0) return false;
		}
		
		return true;
	}
	
	public static void main(String [] args) throws Exception {
		
		sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			init();
			
			if(checking()) {
				answer = 0;
			}
			else {
				dfs(0, 0);
			}
			
			if(answer == Integer.MAX_VALUE) answer = -1;
			System.out.println(answer);
		}
		
		sc.close();
	}

}