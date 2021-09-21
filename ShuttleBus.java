package ProgrammersProblems;

import java.util.*;
import java.time.LocalTime;
public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        //셔틀버스 정류장에 도착한 시간들을 list에 담음
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<timetable.length;i++){
            list.add(timetable[i]);
        }
        //최초 버스 도착시간
        String bus = "09:00";
        int count;

        //n이 1보다 크면 그 다음에도 오는 버스 존재, n이 1이면 9시 버스가 마지막
        while(n>1){
            count=m; //버스 안에 탈 수 있는 최대 인원
            
            //버스에 탈 수 있는 인원이 있으면 list에서 제거하고 count를 한개 낮춤
            while(count>0){
                if(bus.compareTo(list.get(0))>=0){
                    list.remove(0);
                    count--;
                }else{
                    break;
                }
            }
            n--;
            //다음 버스 도착시간 구함
            LocalTime time = LocalTime.parse(bus);
            bus = time.plusMinutes(t).toString();
        }
        
        //마지막 버스 타임
        count=m;
         while(count>1){
                if(bus.compareTo(list.get(0))>=0){
                    list.remove(0);
                    count--;
                    }else{
                    	break;
                    }
                }
         
         //마지막 버스 자리에 list목록이 남아있다면 남은 list가 버스에 탑승 가능한지 안한지 확인하고 답 구함
         if(!list.isEmpty()){
        	 if(list.get(0).compareTo(bus)<=0){
                LocalTime time = LocalTime.parse(list.get(0));
                answer = time.minusMinutes(1).toString();
            }else{
                answer = bus;
            }
            
        }else{
            answer = bus;
        }
        return answer;
    }
}