package ArrayList;

import java.util.Iterator;

public class MyIterator<E> implements Iterator<E>{
	private Node<E>[] storage;
	int pointer=-1;
    public MyIterator(Node<E>[] storage) {
		this.storage=storage;
	}
	@Override
	public boolean hasNext() {
		return (++pointer<storage.length && storage[pointer]!=null);
	}

	@Override
	public E next() {
		E next =null;
		if(hasNext())
			next=storage[pointer].getObject();
		return next;
	}

}
