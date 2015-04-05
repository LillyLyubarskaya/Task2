package ArrayList;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class MyArrayListTest {
    private MyArrayList<String> str;
    LocalDateTime now= LocalDateTime.now();
    @Before
    public void init(){
    	str=new MyArrayList<>();
    	str.add("Bogdan", null,now);
    	str.add("Adriy", null,now);
    	str.add("Michael", null,now);
    }
    //public boolean add(E arg0,Date oldDate, Date date)
	@Test
	public void test_add() {
		String s="Lilly";
		str.add(s, null,now);
		assertTrue(s.equals(str.get(3)));
	}
	//add(int arg0, E arg1,Date oldDate, Date date)
	@Test
	public void test_add_1() {
		String s="Lilly";
		str.add(1,s, null,now);
		assertTrue(s.equals(str.get(1)));
	}
	//public boolean addAll(Collection<? extends E> arg0,Date date,Date oldDate)
	@Test
	public void test_add_All() {
		ArrayList<String> list=new ArrayList<>();
		list.add("Illya");
    	list.add("Liza");
    	list.add("Michael");
		String s="Lilly";
		list.add(s);
		boolean is=str.addAll(list, now, now);
		assertTrue(s.equals(str.get(5))|| !is);
	}
	//public void clear()
	@Test
	public void test_clear(){
    	str.clear();
    	assertTrue(str.isEmpty(now));
		
	}
	//public boolean contains(Object obj)
	@Test
	public void test_contains(){
		String s="Lilly";
		str.add(s, null,now);
    	assertTrue(str.contains(s));
		
	}
	//public <T>boolean containsAll(Collection<T> coll) 
	@Test
	public void test_containsAll(){
		ArrayList<String> list=new ArrayList<>();
		list.add("Bogdan");
    	list.add("Michael");
    	list.add("Adriy");
    	assertTrue(str.containsAll(list,now));
	}
	//public E get(int index)
	@Test
	public void test_get(){
		String s="Michael";
    	assertTrue(s.equals(str.get(2)));
	}
	//test date functionality
	@Test
	public void test_Date(){
		LocalDateTime d=LocalDateTime.of(2017, 3, 3, 5, 6);
		str.removeOld(d);
    	assertTrue(str.isEmpty(now));
	}
	//public int indexOf(Object obj)
	@Test
	public void test_IndexOf(){
		String s="Isabel";
		str.add(0,s, null,now);
    	assertTrue(str.indexOf(s)==0);
	}
	//public boolean isEmpty()
	@Test
	public void test_isEmpty(){
		str.clear();
    	assertTrue(str.isEmpty(now));
	}
	//public int lastIndexOf(Object arg0)
	@Test
	public void test_lastIndexOf(){
		String s="Michael";
		str.add(s, null,now);
		assertTrue(str.lastIndexOf(s,now)==2);
	}
	//public boolean remove(Object obj)
	@Test
	public void test_remove(){
		String s="Michael";
		assertTrue(str.remove(s,now));
	}
	//public E remove(Object obj)
	@Test
	public void test_remove_1(){
	  String s="Michael";
	  assertTrue(s.equals(str.remove(2,now)));
	}
	//public boolean removeAll(Collection<?> arg)
	@Test
	public void test_removeAll(){
		System.out.println("REMOVE ALL");
		ArrayList<String> list=new ArrayList<>();
		list.add("Bogdan");
    	list.add("Michael");
    	list.add("Adriy");
	  assertTrue(str.removeAll(list,now));
	}
	//public boolean retainAll(Collection<?> arg0) 
	@Test
	public void test_retainAll(){
		System.out.println("RETAIN ALL");
		ArrayList<String> list=new ArrayList<>();
		list.add("Bogdan");
    	list.add("Michael");
	  assertTrue(str.retainAll(list,now));
	}
	//public E set(int arg0, E arg1)
	@Test
	public void test_Set(){
		LocalDateTime d=LocalDateTime.of(2013, 3, 3, 5, 6);
		System.out.println("SET");
		str.set(0, "Delila",d,d);
		System.out.println("CURRENT SIZE "+str.size(d));
	  assertTrue(str.get(0).equals("Delila"));
	}
	//public List<E> subList(int arg0, int arg1) 
	@Test
	public void test_Sublist(){
	  ArrayList<String> list=(ArrayList<String>)str.subList(0,1,now);
	  assertTrue(list.contains("Bogdan"));
	}
	//public Object[] toArray() 
	@Test
	public void test_toArray(){
	  Object [] array=str.toArray(now);
	  System.out.println("TO ARRAY");
	  System.out.println(array[0]);
	  assertTrue(array[0].equals("Bogdan"));
	}
	//public <T> T[] toArray(T[] arg0) 
	@Test
	public void test_toArray_1(){
	   Object [] array={"Michael","Bogdan"};
	   Object [] result=str.toArray(array,now);
	   System.out.println("TO ARRAY");
	   System.out.println("SIZE "+result.length);
	   assertTrue(result[0].equals("Michael"));
	}
	//public Iterator<E> iterator()
	@Test
	public void test_iterator(){
	   Iterator<String> s=str.iterator(now);
	   String arg0=s.next();
	   assertTrue(arg0.equals("Bogdan"));
	}
	//public ListIterator<E> listIterator() 
	@Test
	public void test_listIterator(){
		System.out.println("LIST ITERATOR");
	   ListIterator<String> s=str.listIterator(now);
	   String arg0=s.next();
	   String arg1=s.next();
	   s.next();
	   System.out.println("arg1 "+arg1);
	   String arg2=s.previous();
	   System.out.println("arg2 "+arg2);
	   assertTrue(arg0.equals("Bogdan"));
	}
}
