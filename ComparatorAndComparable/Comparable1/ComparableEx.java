package ComparatorAndComparable.Comparable1;

import java.util.ArrayList;
import java.util.List;

public class ComparableEx {

	public static void main(String[] args) {
		//Edgeinfo객체 생성 및 list에 저장
		//Edgeinfo객체에 comparable을 implements해서 edge길이기준으로 객체비교가능
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
		//edge의 길이로 정렬하기 전
		System.out.print("정렬 전 : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
		System.out.println("");
		
		//list를 edge의 길이로 오름차순 정렬
		list.sort(null);
		System.out.print("정렬 후 : ");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getEdgevalue()+" ");
		}
	}

}
