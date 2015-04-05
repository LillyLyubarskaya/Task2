package ArrayList;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import LinkedList.MyLinkedList;
/**
 * 
 * @author Lilly_94
 * @param <E>
 */
public class MyArrayList<E>{
 Node<E>[] storage=new Node[0];
	public boolean add(E arg0,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		if(!contains(arg0)){
			storage=Arrays.copyOfRange(storage,0, storage.length+1);
			storage[storage.length-1]=new Node<E>(arg0,LocalDateTime);
			removeOld(oldLocalDateTime);
			return true;
		}
		removeOld(oldLocalDateTime);
		return false;
	}
	public void add(int arg0, E arg1,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		Collection<E> c=new ArrayList<E>();
		c.add(arg1);
		addRange(arg0,oldLocalDateTime,LocalDateTime,c);
		removeOld(oldLocalDateTime);
	}
	private boolean addRange(int arg0,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime,Collection<? extends E> args){
		Node<E>[] newStorage=new Node[storage.length+args.size()];
		boolean result=true;
		for(int i=0;i<arg0;i++)
				newStorage[i]=storage[i];
		int counter=0;
		int counterAdded=0;
		for(E e:args){
			if(!contains(e)){
				newStorage[counterAdded+arg0]=new Node<E>(e,LocalDateTime);
				counterAdded++;		
			}
			else
			{
				result=false;
			}
		}
		for(int i=arg0;i<storage.length;i++)
			newStorage[i+counterAdded]=storage[i];
		removeNull(newStorage);
		storage=newStorage;
		removeOld(oldLocalDateTime);
		return result;
	}
	public void removeOld(LocalDateTime oldLocalDateTime){
		if(oldLocalDateTime!=null){
			for(int i=0;i<storage.length;i++)
	    		if(storage[i].getLocalDateTime().isBefore(oldLocalDateTime)){
	    			System.out.println("Delete "+storage[i].getObject().toString());
	    			storage[i]=null;
	    		}
			}
			removeNull();
	}
	private void removeNull(){
		Node<E> [] newStorage=new Node[storage.length-countNull()];
		System.out.println(newStorage.length);
		int counter=0;
		for(int i=0;i<storage.length;i++){
			if(storage[i]!=null){
				newStorage[counter]=storage[i];
				counter++;
			}	
		}
		storage=newStorage;
		System.out.println("Storage size "+storage.length);
	}
	private void removeNull(Node<E>[] storage){
		System.out.println("Remove null");
		Node<E> [] newStorage=new Node[storage.length-countNull()];
		System.out.println(newStorage.length);
		int counter=0;
		for(int i=0;i<storage.length;i++){
			if(storage[i]!=null){
				newStorage[counter]=storage[i];
				counter++;
			}	
		}
		storage=newStorage;
		System.out.println("Storage size "+storage.length);
	}
	public int countNull(){
		int result=0;
		for(Node<E> e:storage){
			if(e==null)
				result++;
		}
		return result;		
	}
	public boolean addAll(Collection<? extends E> arg0,LocalDateTime oldLocalDateTime,LocalDateTime LocalDateTime) {
		boolean is=true;
		for(E e:arg0){
			is=add(e,oldLocalDateTime,LocalDateTime);
		}
		return is;
	}
	public boolean addAll(int arg0, Collection<? extends E> arg1,LocalDateTime LocalDateTime,LocalDateTime oldLocalDateTime) {
		return addRange(arg0, oldLocalDateTime, oldLocalDateTime, arg1);
	}
	public void clear() {
		storage=new Node[0];
		
	}
	public boolean contains(Object obj) {
		for(Node<E> el:storage){
    		if(obj.equals(el.getObject()))
    			return true;	
    	}
    	return false;
	}
	public <T>boolean containsAll(Collection<T> coll,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		boolean is=true;
		for(T e:coll){
			if(!contains(e))
				is=false;
		}
		return is;
	}
	public E get(int index) {
		if(index<=storage.length-1 && storage[index]!=null)
			return storage[index].getObject();
		return null;
	}
	public int indexOf(Object obj) {
		int counter=0;
		for(Node<E> el:storage){
    		if(obj.equals(el.getObject()))
    			return counter;
    		counter++;		
    	}
    	return -1;
	}
	public boolean isEmpty(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return (storage.length==0);
	}
	public Iterator<E> iterator(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return new MyIterator<E>(storage);
	}
	public int lastIndexOf(Object arg0,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		int index=-1;
		int i=0;
		for(Node<E> e:storage){
			if(e.getObject().equals(arg0))
				index=i;
			i++;	
		}
		return index;
	}

	
	public ListIterator<E> listIterator(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return new MyListIterator<E>(this,0);
	}
	public ListIterator<E> listIterator(int arg0,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return new MyListIterator<E>(this,arg0);
	}

	
	public boolean remove(Object obj,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		int index=indexOf(obj);
		if(index!=-1){
			storage[index]=null;
			removeNull();
		}
		return (index!=-1);
	}

	
	public E remove(int index,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		E result=get(index);
		if(result!=null){
			storage[index]=null;
			removeNull();
		}
		return result;
	}

	
	public boolean removeAll(Collection<?> arg,LocalDateTime oldLocalDateTime) {
		boolean is=true;
		for(Object e: arg){
			if(!remove(e,oldLocalDateTime))
				is=false;
		}
		return is;
	}
	public boolean retainAll(Collection<?> arg0,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		boolean result=true;
		Node<E>[] tempStorage=new Node[storage.length];
		for(Object e:arg0){
			if(contains(e)){
				int index=indexOf(e);
				tempStorage[index]=new Node<E>((E) e,LocalDateTime.now());
			}
			else{
				result=false;
			}
		}
		storage=tempStorage;
		return result;
	}

	
	public E set(int arg0, E arg1,LocalDateTime oldLocalDateTime, LocalDateTime LocalDateTime) {
		removeOld(oldLocalDateTime);
		if(arg0>=storage.length)
			return null;
		storage[arg0]=new Node<E>(arg1,LocalDateTime);
		return arg1;
	}
	public int size(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		return storage.length;
	}
	public List<E> subList(int arg0, int arg1,LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		ArrayList<E> lst=new ArrayList<>();
		if(arg0>=storage.length || arg1>=storage.length)
			return null;
		for(int i=arg0;i<=arg1;i++)
			lst.add(get(i));
		return lst;
	}
	public Object[] toArray(LocalDateTime oldLocalDateTime) {
		removeOld(oldLocalDateTime);
		Object [] arr=new Object[storage.length];
		for(int i=0;i<storage.length;i++)
			arr[i]=storage[i].getObject();
		return arr;
	}
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
	public static void main(String ...args){
		MyArrayList<String> lst=new MyArrayList<>();
		//lst.add("Lilly", new LocalDateTime());
		System.out.println(lst.get(0));
	}

}
