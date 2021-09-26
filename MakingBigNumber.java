package ProgrammersProblems;

 public class MakingBigNumber {
    StringBuilder answer = new StringBuilder();
    
    public String solution(String number, int k) {
    	//number���� k�� ��ŭ �տ������� �ٿ����� ū�� �����
        dfs(0,k,number);
        return answer.toString();
    }
    //cur�� ���� ��ġ, count�� �ٿ��� ���� ����
    void dfs(int cur, int count,String number){
    	//���� ������ ���� ��� ������ ���� ������ answer�� ������
        if(count==0){
            answer.append(number.substring(cur));
            return;
        }
        //�׷��� ���� ���, ���� �� �ִ� ���� ū �� �ϳ��� ����
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
