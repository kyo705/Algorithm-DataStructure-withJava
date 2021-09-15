package ComparatorAndComparable.Comparator1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ComparatorAndComparable.Comparable1.EdgeInfo;

public class ComparatorEx {

	public static void main(String[] args) {
		// EdgeInfo��ü ���� �� list�� ����
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
		
		//comparator ��ü�� �͸�ü�� �������̵��ؼ� EdgeInfo ��ü�� �켱���� ����
		Comparator<EdgeInfo> comp = new Comparator<EdgeInfo>() {
			
			@Override
			public int compare(EdgeInfo o1, EdgeInfo o2) {
				if(o1.getEdgevalue()>o2.getEdgevalue()) {
					return 1;
				}else if(o1.getEdgevalue()==o2.getEdgevalue()) {
					if(o1.getEndnode()>o2.getEndnode()) {
						return 1;
					}else if(o1.getEndnode()==o2.getEndnode()) {
						return 0;
					}else {
						return -1;
					}
				}else {
					return -1;
				}
			}
		};
		//comp�� �������� �����ϱ� ��
		System.out.print("���� �� : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
		System.out.println("");
		
		//list�� comp�������� ����
		list.sort(comp);
		System.out.print("���� �� : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
	}

}
