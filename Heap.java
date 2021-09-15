package HeapwtihArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	
	private int size; //heap 안의 요소들 수
	private static final int defaultvalue = 10; //array의 초기값(최솟값)
	private Object[] array; //heap을 구현할 array
	private final Comparator<? super E> comparator; //<E> 객체를 비교하기 위한 comparator

	//초기 배열 길이 x
	Heap(){
		this(null);
	}
	Heap(Comparator<? super E> comparator){
		this.array = new Object[defaultvalue];
		this.comparator = comparator;
		this.size = 0;
	}
	//초기 배열 길이 o
	Heap(int length){
		this(length,null);
	}
	Heap(int length,Comparator<? super E> comparator){
		this.array = new Object[length];
		this.comparator = comparator;
		this.size = 0;
	}
	
	// 받은 인덱스의 부모 노드 인덱스를 반환
	private int getParent(int index) {
		return index / 2;
	}
	
	// 받은 인덱스의 왼쪽 자식 노드 인덱스를 반환 
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	// 받은 인덱스의 오른쪽 자식 노드 인덱스를 반환
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	//배열 크기를 변경
	private void resize(int length) {
		Object[] newarray = new Object[length];
		for(int i=0;i<newarray.length;i++) {
			newarray[i] = this.array[i];
		}
		this.array = null;
		this.array = newarray;
	}
	
	//heap 구조에 값 추가
	public void add(E value) {
		//우선 array에 값을 넣을 수 있는지 확인. 없다면 사이즈 2배 up
		if(size + 1 == array.length) {
			resize(array.length*2);
		}
		
		//array의 다음 인덱스에 value 값을 넣어서 정렬
		shiftup(size + 1 , value); 
		size++;
	}
	
	private void shiftup(int index, E value) {
		if(comparator != null) {
			shiftupComparator(index, value, comparator);
		}else {
			shiftupComparable(index, value);
		}
	}
	
	//comparator가 존재 할 때
	@SuppressWarnings("unchecked")
	private void shiftupComparator(int index,E value, Comparator<? super E> comp) {
		while(index>1) {
			int parent = getParent(index); //부모 노드 인덱스
			Object parentval = array[parent]; //부모 노드의 값
			
			//현재 노드의 값이 부모노드의 값보다 클 경우 (위치 바꿈 x)
			if(comp.compare(value,(E)parentval)>=0) {
				break;
			}
			
			array[index] = parentval;
			index=parent;
		}
		array[index] = value;
	}
	
	//comparator가 존재하지 않을 때
	@SuppressWarnings("unchecked")
	private void shiftupComparable(int index, E value) {
		//value에 comparable을 implements 해야함
		Comparable<? super E> comp = (Comparable<? super E>) value;
		
		while(index>1) {
			int parent = getParent(index);
			Object parentval = array[parent];
			
			if(comp.compareTo((E)parentval)>=0) {
				break;
			}
			
			array[index] = parentval;
			index = parent;
		}
		
		array[index] = comp;
	}
	
	//heap에서 우선순위인 노드를 꺼낼 때
	@SuppressWarnings("unchecked")
	public E remove() {
		if(array[1]==null) {
			throw new NoSuchElementException();
		}
		
		E value = (E)array[1]; //heap의 우선순위 값을 꺼냄
		E target = (E)array[size];
		array[size] = null; 
		shiftdown(1,target);
		
		return value;
	}
	
	private void shiftdown(int index, E value) {
		if(comparator != null) {
			shiftdownComparator(index, value, comparator);
		}else {
			shiftdownComparable(index, value);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftdownComparator(int index, E value, Comparator<? super E> comp) {
		
		array[index] = null;
		size--;
		
		int parent = index;
		int child;
		
		while((child = getLeftChild(index)) <= size) {
			int right = getRightChild(index);
			Object childval = array[child];
			
			//자식 노드 중 작은 노드 선택
			if(right <= size && comp.compare((E)array[right], (E)childval)<0) {
				child = right;
				childval = array[right];
			}
			
			//value 값과 자식 노드 값 비교
			if(comp.compare(value, (E) childval)<=0) {
				break;
			}
			
			array[parent] = childval;
			parent = child;
		}
		
		array[parent] = value;
		
		//array 크기가 size 보다 클 때 array크기 조정
		if(array.length > defaultvalue && size< array.length/4) {
			resize(Math.max(defaultvalue, array.length/2));
		}
	}
	
	@SuppressWarnings("unchecked")
	private void shiftdownComparable(int index, E value) {
		
		Comparable<? super E> comp = (Comparable<? super E>) value;
		
		array[index] = null;
		size--;
		
		int parent = index;
		int child;
		
		while((child = getLeftChild(parent)) <= size) {
			
			int right = getRightChild(index);
			Object childval = array[child];
			//자식 노드 중 작은 노드 선택
			if(right<= size && ((Comparable<? super E>)childval).compareTo((E)array[right])>0) {
				child = right;
				childval = array[right];
			}
			
			//value값과 자식 노드 비교
			if(comp.compareTo((E)childval)<=0) {
				break;
			}
			
			array[parent] = childval;
			parent = child;
		}
		
		array[parent] = comp;
		
		//array 크기가 size 보다 클 때 array크기 조정
		if(array.length > defaultvalue && size< array.length/4) {
			resize(Math.max(defaultvalue, array.length/2));
		}
	}
	
	//heap의 사이즈
	public int size() {
		return this.size;
	}
	
	//heap의 첫번째 값
	@SuppressWarnings("unchecked")
	public E peek() {
		if(array[1]==null) {
			throw new NoSuchElementException();
		}
		return (E)array[1];
	}
	
	//heap이 비었는지 확인
	public boolean isEmpty() {
		return size==0;
	}
	
	//heap을 array로 변환
	public Object[] toArray() {
		return Arrays.copyOf(array, size + 1);
	}
}
