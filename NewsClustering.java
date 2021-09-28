package ProgrammersProblems;

import java.util.*;
import java.util.Map.Entry;
public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=0;i<str1.length()-1;i++){
            if(str1.charAt(i)>='a' && str1.charAt(i)<='z' && str1.charAt(i+1)>='a' && str1.charAt(i+1)<='z'){
                String s = Character.toString(str1.charAt(i))+Character.toString(str1.charAt(i+1));
                map1.put(s,map1.getOrDefault(s,0)+1);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            if(str2.charAt(i)>='a' && str2.charAt(i)<='z' && str2.charAt(i+1)>='a' && str2.charAt(i+1)<='z'){
                String s = Character.toString(str2.charAt(i))+Character.toString(str2.charAt(i+1));
                map2.put(s,map2.getOrDefault(s,0)+1);
            }
        }
        
        int u = 0;
        int n = 0;
        
        for(Iterator<Entry<String, Integer>> it1 = map1.entrySet().iterator();it1.hasNext();){
            Map.Entry<String, Integer> ent1 = (Map.Entry<String,Integer>)it1.next();
            for(Iterator<Entry<String, Integer>> it2 = map2.entrySet().iterator();it2.hasNext();){
                Map.Entry<String, Integer> ent2 = (Map.Entry<String,Integer>)it2.next();
                if(ent1.getKey().equals(ent2.getKey())){
                    if(ent1.getValue()<ent2.getValue()){
                        n+=ent1.getValue();
                        u+=ent2.getValue();
                    }else{
                        n+=ent2.getValue();
                        u+=ent1.getValue();
                    }
                    it1.remove();
                    it2.remove();
                    break;
                }
            }
        }
        
        for(Map.Entry<String,Integer> ent : map1.entrySet()){
            u+=ent.getValue();
        }
        for(Map.Entry<String,Integer> ent : map2.entrySet()){
            u+=ent.getValue();
        }
        if(u==0){
            return 65536;
        }else{
            answer= (65536*n/u);
        }
        return answer;
    }
}