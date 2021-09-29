package ProgrammersProblems;

import java.util.*;

public class Tuple {
    public int[] solution(String s) {
        
        String[] list = s.split("},");
        if(list.length>1){
             list[0] = list[0].substring(2);
            for(int i=1;i<list.length-1;i++){
                list[i] = list[i].substring(1);
            }
            list[list.length - 1] = list[list.length - 1].substring(1,list[list.length - 1].length()-2);
        }else{
            list[0] = list[0].substring(2,list[0].length()-2);
        }
       
        
        Comparator<String> comp = new Comparator<>(){
            public int compare(String a, String b){
                if(a.length()>b.length()){
                    return 1;
                }else if(a.length()==b.length())
                    return 0;
                else{
                    return -1;
                }
            }
        };
        
        Arrays.sort(list,comp);
        
        int[] answer = new int[list.length];
        for(int i=0;i<list.length;i++){
            String[] num = list[i].split(",");
            //초기 값
            if(num.length==1){
                answer[i]=Integer.parseInt(num[0]);
            }else{ //초기값 이용해서 한단계씩 answer에 값 늘려가기
                for(int k=0;k<num.length;k++){
                    boolean plag = true;
                    for(int j=0;j<num.length-1;j++){
                        if(answer[j]==Integer.parseInt(num[k])){
                            plag=false;
                            break;
                        }
                    }
                    if(plag==true){
                        answer[i]=Integer.parseInt(num[k]);
                        break;
                    }
                }
            }
        }
        return answer;
    }
}