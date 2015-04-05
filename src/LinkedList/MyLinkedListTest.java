/**
 * 
 */
package LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Lilly_94
 *
 */
public class MyLinkedListTest {
	MyLinkedList<String> lst=new MyLinkedList<>();
	LocalDateTime now=LocalDateTime.now();
    @Before
    public void init(){
    	lst.add("Lilly", null, LocalDateTime.now());
		lst.add("Harry", null, LocalDateTime.now());
		lst.add("Marry", null, LocalDateTime.now());
    }
	@Test
	public void test_add() {
		assertTrue(lst.get(1).equals("Harry"));
	}
	@Test
	public void test_remove() {
		lst.remove(now,"Marry");
		assertTrue(lst.getLast(now).equals("Harry"));
	}
	@Test
	public void test_removeAll() {
		lst.add("Agata", null, LocalDateTime.now());
		ArrayList<String> list=new ArrayList<>();
		list.add("Lilly");
		list.add("Agata");
		assertTrue(lst.removeAll(list,null));
	}
	@Test
	public void test_retainAll() {
		ArrayList<String> list=new ArrayList<>();
		list.add("Lilly");
		list.add("Harry");
		assertTrue(lst.retainAll(list,null));
	}
	@Test
	public void test_isEmpty() {
		assertFalse(lst.isEmpty(now));
	}
	@Test
	public void test_contains() {
		assertTrue(lst.contains("Lilly"));
	}
	@Test
	public void test_containsAll() {
		ArrayList<String> list=new ArrayList<>();
		list.add("Lilly");
		list.add("Harry");
		assertTrue(lst.containsAll(list, null));
	}
	@Test
	public void test_toArray() {
		Object []arr =lst.toArray(now);
		assertTrue(arr[0].equals("Lilly"));
	}
	@Test
	public void test_addAll() {
		ArrayList<String> list=new ArrayList<>();
		list.add("Max");
		list.add("Agata");
		LocalDateTime l=now;
		boolean is=lst.addAll(list, l, l);
		assertTrue(is);
	}
	@Test
	public void test_toArray_1() {
		Object [] arr={"Lilly","Daryna"};
		arr=lst.toArray(arr,now);
		assertTrue(arr[0].equals("Lilly"));
	}
	@Test
	public void test_clear() {
		lst.clear();
		assertTrue(lst.head==null);
	}
	@Test
	public void test_addFirst() {
		lst.addFirst("Mira", now.plusMinutes(1), now);
		assertTrue(lst.head.getObject().equals("Mira"));
	}
	@Test
	public void test_addLast() {
		lst.addLast("Mira", now.plusMinutes(1), now);
		assertTrue(lst.tail.getObject().equals("Mira"));
	}
	@Test
	public void test_element() {
		assertTrue(lst.element(now).equals("Lilly"));
	}
	@Test
	public void test_size() {
		lst.add("Irina", now, now);
		lst.remove(now,"Lilly");
		assertTrue(lst.size()==3);
	}
	@Test
	public void test_getFirst() {
		lst.add("Irina", now, now);
		lst.remove(now,"Lilly");
		assertTrue(lst.getFirst(now).equals("Harry"));
	}
	@Test
	public void test_getLast() {
		lst.add("Irina", now, now);
		lst.remove(now,"Lilly");
		assertTrue(lst.getLast(now).equals("Irina"));
	}
	@Test
	public void test_offer() {
		lst.offer("Irina", now, now);
		assertTrue(lst.getLast(now).equals("Irina"));
	}
	@Test
	public void test_offerFirst() {
		lst.offerFirst("Faust", now, now);
		assertTrue(lst.getFirst(now).equals("Faust"));
	}
	@Test
	public void test_offerLast() {
		lst.offerLast("Nigga", now, now);
		assertTrue(lst.getLast(now).equals("Nigga"));
	}
	@Test
	public void test_peek() {
		lst.offerFirst("Captain", now, now);
		lst.offerFirst("Doctor", now, now);
		lst.offerFirst("Lollipop", now, now);
		assertTrue(lst.peek(now).equals("Lollipop"));
	}
	@Test
	public void test_peekFirst() {
		lst.offerFirst("Captain", now, now);
		lst.offerFirst("Doctor", now, now);
		lst.offerFirst("Lollipop", now, now);
		assertTrue(lst.peekFirst(now).equals("Lollipop"));
	}
	@Test
	public void test_peekLast() {
		lst.offerLast("Captain", now, now);
		lst.offerFirst("Doctor", now, now);
		lst.offerLast("Lollipop", now, now);
		assertTrue(lst.peekLast(now).equals("Lollipop"));
	}
	@Ignore
	public void test_poll() {
		String result=lst.poll(now.plusMinutes(1));
		assertTrue(lst.isEmpty(now) && result==null);
	}
	@Test
	public void test_pollFirst() {
		String result=lst.pollFirst(now);
		assertTrue(lst.getFirst(now).equals("Harry") && result.equals("Lilly"));
	}
	@Test
	public void test_pollLast() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Igor", now, bound);
		lst.add("Sasha", now, bound);
		String result=lst.pollLast(bound);
		assertTrue(lst.getLast(bound).equals("Igor") && result.equals("Sasha"));
	}
	@Test
	public void test_pop() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Igor", now, bound);
		lst.add("Sasha", now, bound);
		String result=lst.pop(bound);
		assertTrue(result.equals("Igor")&& lst.size()==1);
	}
	@Test
	public void test_push() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Igor", now, bound);
		lst.add("Sasha", now, bound);
		lst.push("Masha",bound,bound);
		assertTrue(lst.getFirst(bound).equals("Masha")&& lst.size()==3);
	}
	@Test
	public void test_removeFirst() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Igor", now, bound);
		lst.add("Sasha", now, bound);
		lst.removeFirst(bound);
		assertTrue(lst.getFirst(bound).equals("Sasha")&& lst.size()==1);
	}
	@Test
	public void test_removeFirstOccurense() {
		lst.add("Lilly", now, now);
		lst.add("Sasha", now, now);
		lst.removeFirstOccurrence("Lilly", now);
		assertTrue(lst.getFirst(now).equals("Harry"));
	}
	@Test
	public void test_removeLast() {
		System.out.println("Remove last");
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Lilly", bound, bound);
		lst.add("Sasha", bound, bound);
		System.out.println(lst.get(0));
		System.out.println(lst.get(1));
		lst.removeLast(bound);
		assertTrue(lst.getLast(bound).equals("Lilly"));
	}
	@Test
	public void test_removeLastOccurence() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		System.out.println(lst.get(0));
		System.out.println(lst.get(1));
		lst.removeLastOccurrence("Lilly",bound);
		assertTrue(lst.getLast(bound).equals("Sasha"));
	}
	@Test
	public void test_add_1() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		System.out.println(lst.get(0));
		System.out.println(lst.get(1));
		lst.add(1,"Kira",bound,bound);
		assertTrue(lst.get(1).equals("Kira"));
	}
	@Test
	public void test_addAll_1() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Dusya");
		lst.addAll(1,list,bound,bound);
		assertTrue(lst.get(5).equals("Lilly"));
	}
	@Test
	public void test_get() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Dusya");
		lst.addAll(1,list,bound,bound);
		assertTrue(lst.get(4).equals("Dusya"));
	}
	@Test
	public void test_indexOf() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Dusya");
		lst.addAll(1,list,bound,bound);
		assertTrue(lst.indexOf("Dusya")==4);
	}
	@Test
	public void test_lastIndexOf() {
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Lilly");
		lst.addAll(1,list,bound,bound);
		assertTrue(lst.lastIndexOf("Lilly")==5);
	}
	@Test
	public void test_subList() {
		System.out.println("SubList");
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Lilly");
		lst.addAll(1,list,bound,bound);
		List<String> list1=lst.subList(0, 4, bound);
		System.out.println("SIZE "+list1.size());
		assertTrue(list1.get(4).equals("Lilly"));
	}
	@Test
	public void test_set() {
		System.out.println("SubList");
		LocalDateTime bound=LocalDateTime.now().plusMinutes(1);
		lst.add("Sasha", bound, bound);
		lst.add("Lilly", bound, bound);
		ArrayList<String> list=new ArrayList<>();
		list.add("Zina");
		list.add("Ira");
		list.add("Rapper");
		list.add("Lilly");
		lst.addAll(1,list,bound,bound);
		lst.set(0, "Igor", now,bound);
		assertTrue(lst.get(0).equals("Igor"));
	}
	@Test
	public void test_descendingIterator() {
		DescendingIterator<String> it=new DescendingIterator<>(lst);
		String st=null;
		while(it.hasNext()){
			 st=it.next();
		}
		assertTrue(st.equals(lst.head.getObject()));
	}
	@Test
	public void test_Iterator() {
		Iterator<String> it=lst.iterator();
		String st=null;
		while(it.hasNext()){
			 st=it.next();
		}
		assertTrue(st.equals(lst.tail.getObject()));
	}
	@Test
	public void test_ListIterator() {
		System.out.println("TEST LISTITERATOR");
		ListIterator<String> it=lst.listIterator();
		String st=null;
		String st1=null;
		while(it.hasNext()){
			 st=it.next();
		}
		System.out.println();
		
		while(it.hasPrevious()){
			 st1=it.previous();
		}
		assertTrue(st.equals(lst.tail.getObject()) && st1.equals(lst.head.getObject()));
	}
	@Test
	public void test_ListIterator_1() {
		System.out.println("TEST LISTITERATOR");
		ListIterator<String> it=lst.listIterator(1);
		String st=null;
		String st1=null;
		while(it.hasNext()){
			 st=it.next();
		}
		System.out.println();
		
		while(it.hasPrevious()){
			 st1=it.previous();
		}
		assertTrue(st.equals(lst.tail.getObject()) && st1.equals(lst.head.getObject()));
	}
}
