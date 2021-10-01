package ProgrammersProblems;

import java.util.*;

public class SearchOfRanking {
    public int[] solution(String[] info, String[] query) {
        
        Map<String,Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<4*3*3*3;i++){
            list.add(new ArrayList<>());
        }
        map.put("-",0);
        map.put("cpp",1);
        map.put("java",2);
        map.put("python",3);
        map.put("backend",1);
        map.put("frontend",2);
        map.put("junior",1);
        map.put("senior",2);
        map.put("chicken",1);
        map.put("pizza",2);
        
        for(int i=0;i<info.length;i++){
            String[] str = info[i].split(" ");
            int[] arr = {map.get(str[0])*3*3*3,map.get(str[1])*3*3,map.get(str[2])*3,map.get(str[3])};
            int score = Integer.parseInt(str[4]);
            for(int j=0;j<1<<4;j++){
                int idx = 0;
                for(int k=0;k<4;k++){
                    if((j&1<<k)!=0){
                        idx += arr[k];
                    }
                }
                list.get(idx).add(score);
            }
        }
        
        int[] answer = new int[query.length];
        
        for(int i=0;i<4*3*3*3;i++){
            Collections.sort(list.get(i));
        }
        for(int i=0;i<query.length;i++){
            String[] str = query[i].split(" ");
            int idx = map.get(str[0])*3*3*3 + map.get(str[2])*3*3 + map.get(str[4])*3 + map.get(str[6]);
            int score = Integer.parseInt(str[7]);
            int point = Collections.binarySearch(list.get(idx),score);
            if(point<0){
                point = -(point+1);
            }else{
                for(int j=point-1;j>=0;j--){
                    if(list.get(idx).get(j)==score){
                        point = j;
                    }else{
                        break;
                    }
                }
            }
            answer[i] = list.get(idx).size()-point;
        }
        return answer;
    }
}