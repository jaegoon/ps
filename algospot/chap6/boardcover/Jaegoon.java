package ps.algospot.chap6.boardcover;
import java.lang.*;
import java.io.*;
import java.util.*;

/*
 3개 블럭 모양 체크할때
 위에서 -> 아래 방향으로만 체크해서 중복되지 않도록 함.
 * 
 */
class Jaegoon {
	 
	// static int N;
	static int TC, H, W;
	static int answer;
	static char map[][];
	static Scanner sc;
	static boolean visit[][];
	static ArrayList<Point> emptySpace;
	static int testIdx;
	
	// 총 8 모양 중 4개만 체크해서 중복되지 않도록함. ㄱ / ㄴ / ㄱ반대 / ㄴ반대
	static int dx1[]  = {1, 0, 1, 0};
	static int dy1[]  = {0, 1, 0, 1};
	static int dx2[]  = {1, 1, 0, -1};
	static int dy2[]  = {1, 1, 1, 1};
	
	static class Point{
		int y;
		int x;
		Point(int x, int y){
			this.y = y;
			this.x = x;
		}
	}
	
	static void init() {
		
		H = sc.nextInt();
		W = sc.nextInt();
		map = new char[H+1][W+1];
		visit = new boolean[H+1][W+1];
		answer = 0;
		emptySpace = new ArrayList<Point>();
		
		for(int y=1; y<=H;y++) {
			String tempStr = sc.next();
			for(int x=1;x<=W;x++) {
				char c = tempStr.charAt(x-1);
				map[y][x] = c;
				if(c == '.') {
					emptySpace.add(new Point(x,y));
				}
			}
			
		}
		
	}
	
	static int dfs(int remains, int pointNum, boolean visit[][]) {
		Point p = emptySpace.get(pointNum);
		int x = p.x;
		int y = p.y;	
		
		int temp = 0;
		for(int i = 0; i<4; i++) {
			int nx1 = x + dx1[i];
			int ny1 = y + dy1[i];
			int nx2 = x + dx2[i];
			int ny2 = y + dy2[i];
			
			if(nx1 <1 || W < nx1 || nx2 <1 || W < nx2 || ny1 <1 || H < ny1 || ny2 <1 || H < ny2) continue;
			else if(visit[ny1][nx1] || visit[ny2][nx2]) continue;
			else if(map[ny1][nx1] == '.' && map[ny2][nx2]== '.') {
				
				if(remains-3 == 0) {
					visit[y][x] = false;
					System.out.println("# "+testIdx);
					printVisitMap(visit);
					visit[y][x] = true;
					testIdx++;
					return 1;
					
				}
				
				visit[ny1][nx1] = true;
				visit[ny2][nx2] = true;
				
				for(int j=pointNum+1; j<emptySpace.size(); j++) {
					
					if(!visit[emptySpace.get(j).y][emptySpace.get(j).x]) {
						visit[emptySpace.get(j).y][emptySpace.get(j).x] = true;
						temp += dfs(remains-3, j, visit);
						visit[emptySpace.get(j).y][emptySpace.get(j).x] = false;
					}
				}				
				visit[ny1][nx1] = false;
				visit[ny2][nx2] = false;
			}
		}
		
		return temp;
	}
	
	static void printVisitMap(boolean visit[][]) {
		
		for(int y=1;y<=H;y++) {
			for(int x=1;x<=W;x++) {
				int temp = visit[y][x]?1:0;
				System.out.print(temp+" ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	
	public static void main(String [] args) throws Exception {
		
		sc = new Scanner(System.in);
		TC = sc.nextInt();
		
		for(int t=1; t<=TC; t++) {
			
			init();
			
			if(emptySpace.size() %3 != 0) answer = 0;
			else {
				testIdx=1;
				visit[emptySpace.get(0).y][emptySpace.get(0).x] = true;
				answer = dfs(emptySpace.size(), 0, visit);
			}
			
			System.out.println(answer);
		}
		
		sc.close();
	}

}