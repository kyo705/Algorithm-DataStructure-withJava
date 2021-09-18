package ProgrammersProblems;

import java.util.*;

public class MaxLengthofNode {
public int solution(int n, int[][] edge) {
        
        //�� ��忡�� �ٸ� ����� ���� �Ÿ��迭
        int[] array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i]=Integer.MAX_VALUE;
        }
        
        array[0] = 0;
        int[] a = new int[2]; // �ٸ� ����� ��ȣ�� �Ÿ��� �迭�� ����
        a[0] = 0; //�ʱ� ����� �Ÿ�
        a[1] = 1; //�ʱ� ����� ��ȣ
        
        //�Ÿ� ������ �켱���� ����
        Comparator<int[]> comp = new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0]) {
					return 1;
				}else if(o1[0]==o2[0]) {
					return 0;
				}else {
					return -1;
				}
			}
		};
        
        //�켱����ť(heap����)�� ������ ��� ������ �ְ� �ִ� �Ÿ� ����(Dijkstra �˰���)
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(comp);
        queue.add(a);
        while(!queue.isEmpty()){
            int[] b = queue.poll();
            for(int i=0;i<edge.length;i++){
                for(int j=0;j<edge[i].length;j++){

                    if(edge[i][j]==b[1]){
                        int[] v = new int[2];
                        v[0] = array[edge[i][j]-1] + 1;
                        v[1] = edge[i][Math.abs(j-1)];
                        if(v[0]<array[v[1]-1]){
                            array[v[1]-1] = v[0];
                            queue.add(v);
                        }
                    }
                }
            }
        }
        
        // ������� ���� ����� ���� -1�� ����
        for(int i=0;i<array.length;i++){
            if(array[i]==Integer.MAX_VALUE){
                array[i]=-1;
            }
        }
        int max = 0; //�ִܰŸ� ����� ���� ���� �ִ�
        int count = 0; // max���� ���� ���� ����
        
        //�Ÿ� �迭�� for���� ���� ���鼭 �Ÿ� �ִ񰪰� ������ ����
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
                count=1;
            }else if(max == array[i]){
                count++;
            }
        }
       
        return count;
    }
}
