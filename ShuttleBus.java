package ProgrammersProblems;

import java.util.*;
import java.time.LocalTime;
public class ShuttleBus {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.sort(timetable);
        //��Ʋ���� �����忡 ������ �ð����� list�� ����
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<timetable.length;i++){
            list.add(timetable[i]);
        }
        //���� ���� �����ð�
        String bus = "09:00";
        int count;

        //n�� 1���� ũ�� �� �������� ���� ���� ����, n�� 1�̸� 9�� ������ ������
        while(n>1){
            count=m; //���� �ȿ� Ż �� �ִ� �ִ� �ο�
            
            //������ Ż �� �ִ� �ο��� ������ list���� �����ϰ� count�� �Ѱ� ����
            while(count>0){
                if(bus.compareTo(list.get(0))>=0){
                    list.remove(0);
                    count--;
                }else{
                    break;
                }
            }
            n--;
            //���� ���� �����ð� ����
            LocalTime time = LocalTime.parse(bus);
            bus = time.plusMinutes(t).toString();
        }
        
        //������ ���� Ÿ��
        count=m;
         while(count>1){
                if(bus.compareTo(list.get(0))>=0){
                    list.remove(0);
                    count--;
                    }else{
                    	break;
                    }
                }
         
         //������ ���� �ڸ��� list����� �����ִٸ� ���� list�� ������ ž�� �������� ������ Ȯ���ϰ� �� ����
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