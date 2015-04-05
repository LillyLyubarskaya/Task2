package LinkedList;

import java.util.ListIterator;

public class MyListIterator<E> implements ListIterator<E>{
	MyLinkedList<E> list=null;
	Node<E> cursor;
	Node<E> last;
	public MyListIterator(MyLinkedList<E> list,int i) {
			this.list=list;
			cursor=list.reference(i);
	}
	@Override
	public void add(E arg0) {
		list.add(arg0, null, null);
		
	}

	@Override
	public boolean hasNext() {
		if(cursor.getNext()!=null)
			return true;
		return false;
	}

	@Override
	public boolean hasPrevious() {
		if(cursor.getPrev()!=null)
			return true;
		return false;
	}

	@Override
	public E next() {
		if(hasNext()){
			last=cursor=cursor.getNext();
			return cursor.getObject();
		}
		return null;
	}

	@Override
	public int nextIndex() {
		return list.indexOf(cursor);
	}

	@Override
	public E previous() {
		if(hasPrevious()){
			last=cursor=cursor.getPrev();
			return cursor.getObject();
		}
		return null;
	}

	@Override
	public int previousIndex() {
		 return list.indexOf(cursor);
	}

	@Override
	public void remove() {
		list.remove(null, last.getObject());
		
	}

	@Override
	public void set(E arg0) {
		list.set(list.indexOf(last.getObject()), arg0, null, last.getLocalDateTime());
		
	}

}
