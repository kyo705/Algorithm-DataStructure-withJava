package ProgrammersProblems;

public class Floid {
    static final int INF = 200*100000; // return�� �ִ�
    int[][] map = new int[200][200]; //�ִܰŸ� ��
    
    //�÷��̵� �˰��� Ȱ��(��� ��忡�� ��� ������ �ִܰŸ�)
    void floid(int n){
        for(int k=0;k<n;k++){ //�߰����� ���
            for(int i=0;i<n;i++){ //���� ���
                for(int j=0;j<n;j++){ //���� ���
                    if(map[i][k]+map[k][j]<map[i][j])
                        map[i][j]=map[i][k]+map[k][j];
                }
            }
        }
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        
        //map�� �ʱ갪 ����
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    map[i][j]=0;
                else
                    map[i][j]=INF;
            }
        }
        for(int[] fare : fares){
            map[fare[0]-1][fare[1]-1]=fare[2];
            map[fare[1]-1][fare[0]-1]=fare[2];
        }
        
        //map�� �ִܰŸ� floid�˰������� ����
        floid(n);
        
        //������ �����Ǵ� ������ 1���� �����ϹǷ� ���� 1�� �ٿ���
        s--;
        a--;
        b--;
        
        for(int i=0;i<n;i++){  //i : �ս� ����
            answer=Math.min(answer,map[s][i]+map[i][a]+map[i][b]);
        }
        return answer;
    }
}