package LinkedList;

import java.util.Iterator;

public class DescendingIterator<E> implements Iterator<E>{
	MyLinkedList<E> list=null;
	Node<E> cursor;
	 public DescendingIterator(MyLinkedList<E> list) {
		this.list=list;
		cursor=list.tail;
	}
	@Override
	public boolean hasNext() {
			if(cursor!=null){
				return true;
			}
		return false;
	}

	@Override
	public E next() {
		if(hasNext()){
			Node<E> old=cursor;
			cursor=cursor.getPrev();
			return old.getObject();
		}
		return null;
	}

}
