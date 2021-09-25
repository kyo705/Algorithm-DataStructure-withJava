package ProgrammersProblems;

 public class LockAndKey {
    public boolean solution(int[][] key, int[][] lock) {
        int t = key.length-1;
        for(int y=0;y<t+lock.length;y++){
            for(int x=0;x<t+lock.length;x++){
            	//ȸ�� ����(0��, 90�� 180�� 270��)
                for(int i=0;i<4;i++){
                	//�ڹ���� ���踦 ���� �ڷᱸ�� ����
                    int[][] arr = new int[2*t+lock.length][2*t+lock.length];
                    //arr �ʱ�ȭ
                    for(int a=0;a<lock.length;a++){
                        for(int b=0;b<lock.length;b++){
                            arr[a+t][b+t]=lock[a][b];
                        }
                    }
                    //arr�� key�� ����
                    func(arr,key,i,y,x);
                    //���� arr ���� ������ ������ �Ǵ�
                    if(match(arr,t,lock.length)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    void func(int[][] arr, int[][] key, int cir, int cy, int cx){
        for(int y=0;y<key.length;y++){
            for(int x=0;x<key.length;x++){
                if(cir==0){
                    arr[y+cy][x+cx]+=key[y][x];
                }else if(cir==1){
                    arr[y+cy][x+cx]+=key[key.length-1-x][y];
                }else if(cir==2){
                    arr[y+cy][x+cx]+=key[key.length-1-y][key.length-1-x];
                }else{
                    arr[y+cy][x+cx]+=key[x][key.length-1-y];
                }
            }
        }
    }
    boolean match(int[][] arr,int t, int k){
        for(int y=0;y<k;y++){
            for(int x=0;x<k;x++){
                if(arr[y+t][x+t]!=1){
                    return false;
                }
            }
        }
        return true;
    }
}