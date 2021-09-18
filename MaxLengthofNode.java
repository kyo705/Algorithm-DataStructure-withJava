package ProgrammersProblems;

import java.util.*;

public class MaxLengthofNode {
public int solution(int n, int[][] edge) {
        
        //한 노드에서 다른 노드들로 가는 거리배열
        int[] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i]=Integer.MAX_VALUE;
        }
        
        array[0] = 0;
        int[] a = new int[2]; // 다른 노드의 번호와 거리를 배열에 담음
        a[0] = 0; //초기 노드의 거리
        a[1] = 1; //초기 노드의 번호
        
        //거리 순으로 우선순위 정함
        Comparator<int[]> comp = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) {
					return 1;
				}else if(o1[0]==o2[0]) {
					return 0;
				}else {
					return -1;
				}
			}
		};
        
        //우선순위큐(heap구조)에 가능한 노드 정보를 넣고 최단 거리 구함(Dijkstra 알고리즘)
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(comp);
        queue.add(a);
        while(!queue.isEmpty()){
            int[] b = queue.poll();
            for(int i=0;i<edge.length;i++){
                for(int j=0;j<edge[i].length;j++){

                    if(edge[i][j]==b[1]){
                        int[] v = new int[2];
                        v[0] = array[edge[i][j]-1] + 1;
                        v[1] = edge[i][Math.abs(j-1)];
                        if(v[0]<array[v[1]-1]){
                            array[v[1]-1] = v[0];
                            queue.add(v);
                        }
                    }
                }
            }
        }
        
        // 연결되지 않은 노드의 값을 -1로 변경
        for(int i=0;i<array.length;i++){
            if(array[i]==Integer.MAX_VALUE){
                array[i]=-1;
            }
        }
        int max = 0; //최단거리 노드의 간선 길이 최댓값
        int count = 0; // max값이 같은 노드들 갯수
        
        //거리 배열을 for문을 통해 돌면서 거리 최댓값과 갯수를 구함
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
                count=1;
            }else if(max == array[i]){
                count++;
            }
        }
       
        return count;
    }
}
