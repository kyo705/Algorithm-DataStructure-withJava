package ProgrammersProblems;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 불량사용자 {
	
	static boolean[] possible;
    @SuppressWarnings("rawtypes")
	static ArrayList<HashSet> list = new ArrayList<>();
    static HashSet<String> set;
    static ArrayList<String> list2 = new ArrayList<>();
    
    
    public int solution(String[] user_id, String[] banned_id) {
        Arrays.sort(banned_id);
        
        for(int i=0;i<banned_id.length;i++){
            banned_id[i]=banned_id[i].replace('*', '.');
        }
        possible = new boolean[user_id.length];
        dfs(0,user_id,banned_id);
        
        int answer = list.size();
        return answer;
    }
    
    @SuppressWarnings("unchecked")
	static void dfs(int num, String[] user_id, String[] banned_id){
        if(num == banned_id.length){
           set = new HashSet<>();
           set.addAll(list2);
          
            for(int i=0;i<list.size();i++) {
                if(list.get(i).containsAll(set)) {
                    return;
                }
            }
            list.add(set);
            return;
        }
        
        Pattern pattern = Pattern.compile(banned_id[num]);
        for(int i=0;i<user_id.length;i++){
            Matcher matcher = pattern.matcher(user_id[i]);
            
            if(matcher.matches() && !possible[i]){
                list2.add(user_id[i]);
                possible[i]=true;
                dfs(num+1,user_id,banned_id);
                possible[i]=false;
                list2.remove(user_id[i]);
            }
        }
    }
}
