package ComparatorAndComparable.Comparable1;

import java.util.ArrayList;
import java.util.List;

public class ComparableEx {

	public static void main(String[] args) {
		//Edgeinfo��ü ���� �� list�� ����
		//Edgeinfo��ü�� comparable�� implements�ؼ� edge���̱������� ��ü�񱳰���
		EdgeInfo edge1 = new EdgeInfo(1, 2, 2);
		EdgeInfo edge2 = new EdgeInfo(2, 3, 4);
		EdgeInfo edge3 = new EdgeInfo(1, 3, 3);
		EdgeInfo edge4 = new EdgeInfo(5, 1, 1);
		EdgeInfo edge5 = new EdgeInfo(2, 5, 3);
		EdgeInfo edge6 = new EdgeInfo(2, 4, 5);
		List<EdgeInfo> list = new ArrayList<EdgeInfo>();
		list.add(edge1);
		list.add(edge2);
		list.add(edge3);
		list.add(edge4);
		list.add(edge5);
		list.add(edge6);
		//edge�� ���̷� �����ϱ� ��
		System.out.print("���� �� : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
		System.out.println("");
		
		//list�� edge�� ���̷� �������� ����
		list.sort(null);
		System.out.print("���� �� : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
	}

}
