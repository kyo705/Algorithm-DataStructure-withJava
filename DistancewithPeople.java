package ProgrammersProblems;

import java.util.*;
public class DistancewithPeople{
    
    boolean bfs(int[][] map,int y ,int x){
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visit = new boolean[5][5];
        int[] pos = new int[3];
        pos[0]=y;
        pos[1]=x;
        pos[2]=0;
        visit[pos[0]][pos[1]]=true;
        queue.add(pos);
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int[] dy = {0,1,0,-1};
            int[] dx = {1,0,-1,0};
            for(int j=0;j<4;j++){
                int[] next = new int[3];
                next[0]=cur[0]+dy[j];
                next[1]=cur[1]+dx[j];
                next[2]=cur[2]+1;
                if(next[0]<0||next[0]>=5||next[1]<0||next[1]>=5||next[2]>2){
                    continue;
                }
                if(map[next[0]][next[1]]==-1||visit[next[0]][next[1]]==true) {
                	continue;
                }
                if(map[next[0]][next[1]]==1){
                    return false;
                }
                visit[next[0]][next[1]]=true;
                queue.add(next);
            }
        }
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<5;i++){
            answer[i]=1;
        }
        
        for(int i=0;i<5;i++){
            int[][] map = new int[5][5];
            
            for(int y=0;y<5;y++){
                for(int x=0;x<5;x++){
                    if(places[i][y].charAt(x)=='P'){
                        map[y][x]=1;
                    }else if(places[i][y].charAt(x)=='O'){
                        map[y][x]=0;
                    }else if(places[i][y].charAt(x)=='X'){
                        map[y][x]=-1;
                    }
                }
            }
            boolean plag = true;
            for(int y=0;y<5;y++){
                for(int x=0;x<5;x++){
                    if(map[y][x]==1){
                        if(bfs(map,y,x)==false){
                            answer[i]=0;
                            plag=false;
                            break;
                        }
                    }
                }
                if(plag == false){
                    break;
                }
            }
        }
        return answer;
    }
}