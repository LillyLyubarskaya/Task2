package LinkedList;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Data structure, that describes linked list
 * @author Lilly_94
 * @param <E>
 */
public class MyLinkedList<E> {
	/**
	 * link to first element
	 */
	Node<E> head;
	/**
	 * link to last element
	 */
    Node<E> tail;
    /**
     * Size of structure
     */
    int size=0;
	/**
	 * Tested
	 * @param c
	 * @param oldLocalDateTime
	 * @param LocalDateTime
	 * @return
	 */
	public boolean addAll(Collection<? extends E> c,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		boolean is=true;
		for(Object o:c){
			is=add((E)o, oldLocalDateTime, LocalDateTime);
		}
		return is;
	}
	/**
	 * Tested
	 */
	public void clear() {
		tail=null;
		head=null;
		int size=0;
	}
   /**
    * Tested
    * @param c
    * @param oldLocalDateTime
    * @return
    */
	public boolean containsAll(Collection<?> c,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		boolean is=true;
		for(Object o:c){
			if(!contains(o))
				is=false;
		}
		return is;
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public boolean isEmpty(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return (size==0);
	}
    /**
     * Tested
     * @param c
     * @param oldLocalDateTime
     * @return
     */
	public boolean removeAll(Collection<?> c,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		boolean is=true;
		for(Object o:c){
			if(!remove(o))
				is=false;
		}
		return is;
	}
	/**
	 * Tested
	 * @param c
	 * @param oldLocalDateTime
	 * @return
	 */
	public boolean retainAll(Collection<?> c,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> curr=head;
		boolean is=true;
		for(Object o:c){
			if(!contains(o))
				is=false;
		}
    	if(head!=null){
    		do{
    			if(!searchInCollection(c, curr.getObject())){
    				remove(curr);
    			}
    			curr=curr.getNext();
    		}while(curr!=null );
    	}
		return is;
	}
    private boolean searchInCollection(Collection<?> c,E element){
    	boolean is=false;
    	for(Object o:c){
    		if(o.equals(element))
    			is=true;
    	}
    	return is;
    }
	/**
	 * Tested
	 * @param oldLocalDateTime
	 * @return
	 */
	public Object[] toArray(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> curr=head;
		Object [] result=new Object[size];
		int cursor=0;
		do{
			result[cursor]=curr.getObject();
			curr=curr.getNext();
			cursor++;
		}while(curr!=null);
		return result;
	}
    /**
     * Tested
     * @param arg0
     * @param oldLocalDateTime
     * @return
     */
	public <T> T[] toArray(T[] arg0,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		T[] result=(T[]) new Object [0];
		for(int i=0;i<arg0.length;i++){
			if(contains(arg0[i])){
				result=Arrays.copyOfRange(result,0,result.length+1);
				result[result.length-1]=arg0[i];
			}
		}
		return result;
	}
	/**
	 * Tested
	 * @param e
	 * @param oldLocalDateTime
	 * @param LocalDateTime
	 * @return
	 */
	public boolean add(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		size++;
		boolean is=!contains(e);
		if(tail!=null){
			Node<E> oldTail=tail;
			Node<E> newTail=new Node<>(e, LocalDateTime);
			newTail.setPrev(oldTail);
			oldTail.setNext(newTail );
			tail=newTail;
		}
		if(tail==null && head==null){
			tail=head=new Node<>(e, LocalDateTime);
		}
		return is;
	}
    public void removeOld(LocalDateTime oldLocalDateTime){
    	if(oldLocalDateTime!=null){
    		Node<E> curr=head;
        	if(head!=null){
        		do{
        			if(curr.getLocalDateTime().isBefore(oldLocalDateTime)){
        				remove(curr.getObject());
        			}
        			curr=curr.getNext();
        		}while(curr!=null );
        	}
    	}
    }
	/**
	 * Tested
	 * @param e
	 * @param oldLocalDateTime
	 * @param LocalDateTime
	 */
	public void addFirst(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> newHead=new Node<E>(e, LocalDateTime);
		if(head!=null){
			size++;
			Node<E> oldHead=head;
			oldHead.setPrev(newHead);
			newHead.setNext(oldHead);
			head=newHead;
		}
		else{
			head=newHead;
		}
	}
	/**
	 * Tested
	 * @param e
	 * @param oldLocalDateTime
	 * @param LocalDateTime
	 */
	public void addLast(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		add(e, oldLocalDateTime, LocalDateTime);
	}
	/**
	 * Tested
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		return (indexOf(o)!=-1);
	}

	
	public Iterator<E> descendingIterator() {
		return new DescendingIterator<>(this);
	}
	/**
	 * Tested
	 * @param oldLocalDateTime
	 * @return
	 */
	public E element(LocalDateTime oldLocalDateTime) {
		return getFirst(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E getFirst(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return head.getObject();
	}
    /**
     * Test
     * @param oldLocalDateTime
     * @return
     */
	public E getLast(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return tail.getObject();
	}
	public Iterator<E> iterator() {
		return new MyListIterator<>(this, 0);
	}
    /**
     * Tested
     * @param e
     * @param oldLocalDateTime
     * @param LocalDateTime
     * @return
     */
	public boolean offer(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		return add(e, oldLocalDateTime, LocalDateTime);
	}
    /**
     * Tested
     * @param e
     * @param oldLocalDateTime
     * @param LocalDateTime
     * @return
     */
	public boolean offerFirst(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		boolean is=contains(e);
		addFirst(e, oldLocalDateTime, LocalDateTime);
		return is;
	}
    /**
     * Tested
     * @param e
     * @param oldLocalDateTime
     * @param LocalDateTime
     * @return
     */
	public boolean offerLast(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		boolean is=contains(e);
		addLast(e, oldLocalDateTime, LocalDateTime);
		return is;
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E peek(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return getFirst(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E peekFirst(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return getFirst(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E peekLast(LocalDateTime oldLocalDateTime) {
		return getLast(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E poll(LocalDateTime oldLocalDateTime) {
		return removeFirst(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E pollFirst(LocalDateTime oldLocalDateTime) {
		return removeFirst(oldLocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E pollLast(LocalDateTime oldLocalDateTime) {
		return removeLast(oldLocalDateTime);
	}
	/**
	 * Tested
	 * @param oldLocalDateTime
	 * @param LocalDateTime
	 * @return
	 */
	public E pop(LocalDateTime oldLocalDateTime) {
		E result=getFirst(oldLocalDateTime);
		removeFirst(oldLocalDateTime);
		return result;
	}
    /**
     * Tested
     * @param e
     * @param oldLocalDateTime
     * @param LocalDateTime
     */
	public void push(E e,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		addFirst(e, oldLocalDateTime, LocalDateTime);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E remove(LocalDateTime oldLocalDateTime) {
		E result=getFirst(oldLocalDateTime);
		removeFirst(oldLocalDateTime);
		return result;
	}
	private boolean remove(Object o) {
		int index=indexOf(o);
		int cursor=0;
		Node<E> curr=head;
		if(index!=-1 ){
			while(cursor<index){
				cursor++;
				curr=curr.getNext();
			}
			size--;
			if(curr.getPrev()!=null){
				curr.getPrev().setNext(curr.getNext());
			}
			if(curr.getNext()!=null){
				curr.getNext().setPrev(curr.getPrev());
			}
			if(head!=curr){
				if(curr==tail)
				   curr=tail=curr.getPrev();
				else
					curr=curr.getPrev();
			}else{
				if(head==tail &&  tail==curr)
					tail=head=curr=null;
				else{
					curr=head=curr.getNext();
				}	
			}
			return true;
		}
		return false;
	}
	/**
	 * Tested
	 * @param oldLocalDateTime
	 * @param o
	 * @return
	 */
	public boolean remove(LocalDateTime oldLocalDateTime,Object o){
		removeOld(oldLocalDateTime);
		return remove(o);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E removeFirst(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> result=head;
		if(result!=null){
			remove(head.getObject());
			return result.getObject();
		}
		return null;
	}
    /**
     * Tested
     * @param o
     * @param oldLocalDateTime
     * @return
     */
	public boolean removeFirstOccurrence(Object o,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return remove(o);
	}
    /**
     * Tested
     * @param oldLocalDateTime
     * @return
     */
	public E removeLast(LocalDateTime oldLocalDateTime) {
		Node<E> result=tail;
		if(result!=null){
			if(removeLastOccurrence(tail.getObject(),oldLocalDateTime))
			    return result.getObject();
		}
		return null;
	}
	/**
	 * Tested
	 * @param o
	 * @param oldLocalDateTime
	 * @return
	 */
	public boolean removeLastOccurrence(Object o,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		int index=lastIndexOf(o);
		System.out.println("INDEX "+index);
		int cursor=0;
		Node<E> curr=head;
		if(index!=-1 ){
			while(cursor<index){
				cursor++;
				curr=curr.getNext();
			}
			size--;
			if(curr.getPrev()!=null){
				curr.getPrev().setNext(curr.getNext());
			}
			if(curr.getNext()!=null){
				curr.getNext().setPrev(curr.getPrev());
			}
			if(head!=curr){
				if(curr==tail)
				   curr=tail=curr.getPrev();
				else
					curr=curr.getPrev();
			}else{
				if(head==tail &&  tail==curr)
					tail=head=curr=null;
				else{
					curr=head=curr.getNext();
				}	
			}
			return true;
		}
		return false;
	}
    /**
     * Tested
     * @return
     */
	public int size() {
		return size;
	}
    /**
     * Tested
     * @param arg0
     * @param arg1
     * @param oldLocalDateTime
     * @param LocalDateTime
     */
	public void add(int arg0, E arg1,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> curr=reference(arg0);
		if(curr!=null){
			size++;
			Node<E> newNode=new Node<E>(arg1, LocalDateTime);
			Node<E> prev=curr.getPrev();
			if(prev!=null){
				prev.setNext(newNode);
				newNode.setPrev(prev);
			}
			curr.setPrev(newNode);
			newNode.setNext(curr);
		}
	}
    /**
     * Tested
     * @param arg0
     * @param arg1
     * @param oldLocalDateTime
     * @param LocalDateTime
     * @return
     */
	public boolean addAll(int arg0, Collection<? extends E> arg1,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		boolean is=true;
		for(E e:arg1){
			is=!contains(e);
			add(arg0,e,oldLocalDateTime,LocalDateTime);
			arg0++;
		}
		return is;
	}
    /**
     * Tested
     * @param arg0
     * @return
     */
	public E get(int arg0) {
		int cursor=0;
		E result=null;
		Node<E> curr=head;
		if(head!=null && arg0!=-1){
			while(cursor<arg0){
				cursor++;
				curr=curr.getNext();
			};
			result=curr.getObject();
		}
		return result;
	}
    /**
     * Tested
     * @param o
     * @return
     */
	public int indexOf(Object o) {
		Node<E> curr=head;
		int index=-1;
		int cursor=0;
		if(head!=null){
			do{
				if(o.equals(curr.getObject()))
					index=cursor;
				curr=curr.getNext();
				cursor++;
			}while(curr!=null && index==-1);
		}
		return index;
	}
    /**
     * Tested
     * @param o
     * @return
     */
	public int lastIndexOf(Object o) {
		Node<E> curr=head;
		int index=-1;
		int cursor=0;
		if(head!=null){
			System.out.println("Head not null");
			do{
				if(o.equals(curr.getObject()))
					index=cursor;
				curr=curr.getNext();
				cursor++;
			}while(curr!=null);
		}
		return index;
	}

	
	public ListIterator<E> listIterator() {
		return new MyListIterator<E>(this,0);
	}

	
	public ListIterator<E> listIterator(int arg0) {
		return new MyListIterator<E>(this,arg0);
	}
    /**
     * Tested
     * @param arg0
     * @param oldLocalDateTime
     * @return
     */
	public E remove(int arg0,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		E result=get(arg0);
		remove(result);
		return result;
	}

	 Node<E> reference(int arg0){
		int cursor=0;
		Node<E> curr=head;
		if(head!=null && arg0!=-1){
			while(cursor<arg0){
				cursor++;
				curr=curr.getNext();
			};
		}
		return curr;
	}
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param oldLocalDateTime
	 * @return
	 */
	public E set(int arg0, E arg1,LocalDateTime oldLocalDateTime,LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> curr=reference(arg0);
		E result=curr.getObject();
		curr.setObject(arg1);
		return result;
	}

	/**
	 * Tested
	 * @param arg0
	 * @param arg1
	 * @param oldLocalDateTime
	 * @return
	 */
	public List<E> subList(int arg0, int arg1,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		Node<E> curr=reference(arg0);
		if(head!=null && arg0!=-1 && arg1!=-1 && curr!=null){
			ArrayList<E> lst=new ArrayList<>();
			lst.add(curr.getObject());
			int cursor=arg0;
			while(cursor<arg1){
				cursor++;
				curr=curr.getNext();
				lst.add(curr.getObject());
			};
			return lst;
		}
		return null;
	}

}
