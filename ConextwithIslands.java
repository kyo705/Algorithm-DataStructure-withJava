import java.util.*;
class ConextwithIslands {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        
        Comparator<int[]> comp = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]>o2[2]) {
					return 1;
				}else if(o1[2]==o2[2]) {
					return 0;
				}else {
					return -1;
				}
			}
		};
        
        Arrays.sort(costs,comp);
        for(int i=0;i<costs.length;i++){
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            if(parent[a]!=parent[b]){
                if(parent[a]<parent[b]){
                    for(int j=0;j<parent.length;j++){
                        if(parent[j]==parent[b]&&j!=b){
                            parent[j]=parent[a];
                        }
                    }
                    parent[b]=parent[a];
                }else if(parent[a]>parent[b]){
                    for(int j=0;j<parent.length;j++){
                        if(parent[j]==parent[a]&&j!=a){
                            parent[j]=parent[b];
                        }
                    }
                    parent[a]=parent[b];
                }
                answer += c;
            }
        }
        return answer;
    }
}
