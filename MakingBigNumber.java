package ProgrammersProblems;

 public class MakingBigNumber {
    StringBuilder answer = new StringBuilder();
    
    public String solution(String number, int k) {
    	//number에서 k개 만큼 앞에서부터 줄여가며 큰수 만들기
        dfs(0,k,number);
        return answer.toString();
    }
    //cur는 현재 위치, count는 줄여줄 남은 갯수
    void dfs(int cur, int count,String number){
    	//줄일 갯수가 없을 경우 마지막 남은 값들을 answer에 더해줌
        if(count==0){
            answer.append(number.substring(cur));
            return;
        }
        //그렇지 않을 경우, 만들 수 있는 가장 큰 수 하나를 선택
        char maxi = '0';
        for(int i=cur;i<=cur+count;i++){
            if(cur+count==number.length()){
                return;
            }
            if(number.charAt(i)>=maxi){
                maxi=number.charAt(i);
            }
        }
        for(int i=cur;i<number.length();i++){
            if(maxi==number.charAt(i)){
                answer.append(number.charAt(i));
                dfs(i+1,count-(i-cur),number);
                return;
            }
        }
    }
}
