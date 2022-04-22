import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class App15 {
 
    public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long[N - 1];	// 거리
		long[] cost = new long[N];	// 비용 
		
		// 거리 입력 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		// 리터당 기름값 입력
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}
		
		long sum = 0;
		long minCost = cost[0];	// 이전 까지의 과정 중 주유 최소 비용 
 
		for(int i = 0; i < N - 1; i++) {
			
			/*
			 *  현재 주유소가 이전 주유소의 기름값보다 쌀 경우
			 *  minCost를 갱신해준다. 
             * 
             *  이걸 생각 못했다니... ㅡㅡ;;;;; 
             *  내림차순으로 정렬하면 아래와 같은 배열로 더 저렴한 가격으로 계산이 가능하다... 
             *  8, 9, 5, 4, 2, 7, 1 -> 8, 8, 5, 4, 2, 2, 1
			 */
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);
		}
		
		System.out.println(sum);
		
	}      
     
    
}
