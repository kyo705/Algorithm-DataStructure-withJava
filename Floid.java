package ProgrammersProblems;

public class Floid {
    static final int INF = 200*100000; // return의 최댓값
    int[][] map = new int[200][200]; //최단거리 맵
    
    //플로이드 알고리즘 활용(모든 노드에서 모든 노드로의 최단거리)
    void floid(int n){
        for(int k=0;k<n;k++){ //중간지점 노드
            for(int i=0;i<n;i++){ //시작 노드
                for(int j=0;j<n;j++){ //도착 노드
                    if(map[i][k]+map[k][j]<map[i][j])
                        map[i][j]=map[i][k]+map[k][j];
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        //map의 초깃값 설정
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    map[i][j]=0;
                else
                    map[i][j]=INF;
            }
        }
        for(int[] fare : fares){
            map[fare[0]-1][fare[1]-1]=fare[2];
            map[fare[1]-1][fare[0]-1]=fare[2];
        }
        
        //map의 최단거리 floid알고리즘으로 구함
        floid(n);
        
        //기존의 제공되는 값들이 1부터 시작하므로 값을 1씩 줄여줌
        s--;
        a--;
        b--;
        
        for(int i=0;i<n;i++){  //i : 합승 지점
            answer=Math.min(answer,map[s][i]+map[i][a]+map[i][b]);
        }
        return answer;
    }
}