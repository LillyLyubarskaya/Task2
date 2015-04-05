package ArrayList;

import java.time.LocalDateTime;
import java.util.ListIterator;

public class MyListIterator<E> implements ListIterator<E>{
	MyArrayList<E> list;
	E last=null;
	int lastIndex=-1;
	private int bound;
	private Node<E>[] storage;
	private int cursor=-1;
	public static void main(String[] args) {
	}
     public MyListIterator(MyArrayList<E> list,int arg0) {
    	 this.storage=list.storage;
    	 this.list=list;
    	 cursor=arg0-1;
    	 bound=arg0;
	}
	@Override
	public void add(E e) {
	}

	@Override
	public boolean hasNext() {
		return (++cursor<storage.length);
	}

	@Override
	public boolean hasPrevious() {
		return (--cursor>=bound);
	}

	@Override
	public E next() {
		last=null;
		if(hasNext()){
			last=storage[cursor].getObject();
			lastIndex=cursor;
		}
		return last;
	}

	@Override
	public int nextIndex() {
		return (cursor+1);
	}

	@Override
	public E previous() {
		last=null;
		if(hasPrevious()){
			last=storage[cursor+1].getObject();
			lastIndex=cursor+1;
		}
			
		return last;
	}
	@Override
	public int previousIndex() {
		return cursor;
	}
	@Override
	public void remove() {
		list.remove(last,LocalDateTime.now());
	}
	@Override
	public void set(E e) {
		list.set(lastIndex, e, null,LocalDateTime.now());
		
	}

}
