package ProgrammersProblems;

import java.util.*;
public class MonitorCamera {
    public int solution(int[][] routes) {
        int answer = 0;
        Comparator<int[]> comp = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]>o2[1]) {
					return 1;
				}else if(o1[1]==o2[1]) {
					return 0;
				}else {
					return -1;
				}
			}
		};
        Arrays.sort(routes,comp);
        ArrayList<int[]> array = new ArrayList<>(Arrays.asList(routes));

        while(!array.isEmpty()){
            int x=0;
            int y=x+1;
            int z=array.get(x)[1];
            while(y<array.size()){
                if(array.get(y)[0]<=z&&array.get(y)[1]>=z){
                    array.remove(y);
                }else {
                    y++;
                }
            }
            array.remove(x);
            answer++;
        }
        
        return answer;
    }
}