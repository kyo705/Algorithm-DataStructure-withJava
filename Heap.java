package HeapwtihArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
	
	private int size; //heap ���� ��ҵ� ��
	private static final int defaultvalue = 10; //array�� �ʱⰪ(�ּڰ�)
	private Object[] array; //heap�� ������ array
	private final Comparator<? super E> comparator; //<E> ��ü�� ���ϱ� ���� comparator

	//�ʱ� �迭 ���� x
	Heap(){
		this(null);
	}
	Heap(Comparator<? super E> comparator){
		this.array = new Object[defaultvalue];
		this.comparator = comparator;
		this.size = 0;
	}
	//�ʱ� �迭 ���� o
	Heap(int length){
		this(length,null);
	}
	Heap(int length,Comparator<? super E> comparator){
		this.array = new Object[length];
		this.comparator = comparator;
		this.size = 0;
	}
	
	// ���� �ε����� �θ� ��� �ε����� ��ȯ
	private int getParent(int index) {
		return index / 2;
	}
	
	// ���� �ε����� ���� �ڽ� ��� �ε����� ��ȯ 
	private int getLeftChild(int index) {
		return index * 2;
	}
	
	// ���� �ε����� ������ �ڽ� ��� �ε����� ��ȯ
	private int getRightChild(int index) {
		return index * 2 + 1;
	}
	
	//�迭 ũ�⸦ ����
	private void resize(int length) {
		Object[] newarray = new Object[length];
		for(int i=0;i<newarray.length;i++) {
			newarray[i] = this.array[i];
		}
		this.array = null;
		this.array = newarray;
	}
	
	//heap ������ �� �߰�
	public void add(E value) {
		//�켱 array�� ���� ���� �� �ִ��� Ȯ��. ���ٸ� ������ 2�� up
		if(size + 1 == array.length) {
			resize(array.length*2);
		}
		
		//array�� ���� �ε����� value ���� �־ ����
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
	
	//comparator�� ���� �� ��
	@SuppressWarnings("unchecked")
	private void shiftupComparator(int index,E value, Comparator<? super E> comp) {
		while(index>1) {
			int parent = getParent(index); //�θ� ��� �ε���
			Object parentval = array[parent]; //�θ� ����� ��
			
			//���� ����� ���� �θ����� ������ Ŭ ��� (��ġ �ٲ� x)
			if(comp.compare(value,(E)parentval)>=0) {
				break;
			}
			
			array[index] = parentval;
			index=parent;
		}
		array[index] = value;
	}
	
	//comparator�� �������� ���� ��
	@SuppressWarnings("unchecked")
	private void shiftupComparable(int index, E value) {
		//value�� comparable�� implements �ؾ���
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
	
	//heap���� �켱������ ��带 ���� ��
	@SuppressWarnings("unchecked")
	public E remove() {
		if(array[1]==null) {
			throw new NoSuchElementException();
		}
		
		E value = (E)array[1]; //heap�� �켱���� ���� ����
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
			
			//�ڽ� ��� �� ���� ��� ����
			if(right <= size && comp.compare((E)array[right], (E)childval)<0) {
				child = right;
				childval = array[right];
			}
			
			//value ���� �ڽ� ��� �� ��
			if(comp.compare(value, (E) childval)<=0) {
				break;
			}
			
			array[parent] = childval;
			parent = child;
		}
		
		array[parent] = value;
		
		//array ũ�Ⱑ size ���� Ŭ �� arrayũ�� ����
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
			//�ڽ� ��� �� ���� ��� ����
			if(right<= size && ((Comparable<? super E>)childval).compareTo((E)array[right])>0) {
				child = right;
				childval = array[right];
			}
			
			//value���� �ڽ� ��� ��
			if(comp.compareTo((E)childval)<=0) {
				break;
			}
			
			array[parent] = childval;
			parent = child;
		}
		
		array[parent] = comp;
		
		//array ũ�Ⱑ size ���� Ŭ �� arrayũ�� ����
		if(array.length > defaultvalue && size< array.length/4) {
			resize(Math.max(defaultvalue, array.length/2));
		}
	}
	
	//heap�� ������
	public int size() {
		return this.size;
	}
	
	//heap�� ù��° ��
	@SuppressWarnings("unchecked")
	public E peek() {
		if(array[1]==null) {
			throw new NoSuchElementException();
		}
		return (E)array[1];
	}
	
	//heap�� ������� Ȯ��
	public boolean isEmpty() {
		return size==0;
	}
	
	//heap�� array�� ��ȯ
	public Object[] toArray() {
		return Arrays.copyOf(array, size + 1);
	}
}
