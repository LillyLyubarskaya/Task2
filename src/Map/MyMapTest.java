/**
 * 
 */
package Map;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import Map.MyMap.Entry;

/**
 * @author Lilly_94
 *
 */
public class MyMapTest {
	MyMap<String,String> map=new MyMap<>();
	LocalDateTime now=LocalDateTime.now();
	@Before
	public void init(){
		map.put("Lilly", "Lyubarskaya", now, now);
		map.put("Amely", "Pulen", now, now);
		
	}

	/**
	 * Test method for {@link Map.MyMap#get(java.lang.Object)}.
	 */
	@Test
	public void testGet() {
		Entry<String,String> entry=new Entry<String, String>("Vasyliy", "Ivanov", now);
		map.put(entry.getKey(),entry.getValue(), now, now);
		assertTrue(map.get("Vasyliy").equals("Ivanov"));
	}

	/**
	 * Test method for {@link Map.MyMap#getEntry(java.lang.Object, java.time.LocalDateTime)}.
	 */
	@Test
	public void testGetEntry() {
		Entry<String,String> entry=map.getEntry("Lilly", now);
		assertTrue(entry.getValue().equals("Lyubarskaya"));
	}

	/**
	 * Test method for {@link Map.MyMap#clear()}.
	 */
	@Test
	public void testClear() {
		map.clear();
		assertTrue(map.isEmpty(now));
	}

	/**
	 * Test method for {@link Map.MyMap#put(java.lang.Object, java.lang.Object, java.time.LocalDateTime, java.time.LocalDateTime)}.
	 */
	@Test
	public void testPut() {
		map.put("Igor","Semenchyk", now, now);
		assertTrue(map.get("Igor").equals("Semenchyk"));
	}
	/**
	 * Test method for {@link Map.MyMap#containsValue(java.lang.Object, java.time.LocalDateTime)}.
	 */
	@Test
	public void testContainsValue() {
		assertTrue(map.containsValue("Pulen", now));
	}

	/**
	 * Test method for {@link Map.MyMap#entrySet(java.time.LocalDateTime)}.
	 */
	@Test
	public void testEntrySet() {
		HashSet<Entry<String,String>> set=(HashSet<Entry<String,String>>)map.entrySet(now);
		assertTrue(set.size()==2);
	}

	/**
	 * Test method for {@link Map.MyMap#isEmpty(java.time.LocalDateTime)}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(!map.isEmpty(now));
	}

	/**
	 * Test method for {@link Map.MyMap#keySet(java.time.LocalDateTime)}.
	 */
	@Test
	public void testKeySet() {
		HashSet<String> set=(HashSet<String>)map.keySet(now);
		assertTrue(set.contains("Lilly"));
	}

	/**
	 * Test method for {@link Map.MyMap#size(java.time.LocalDateTime)}.
	 */
	@Test
	public void testSize() {
		map.put("Harry", "Potter", now, now);
		assertTrue(map.size(now)==3);
	}

	/**
	 * Test method for {@link Map.MyMap#values(java.time.LocalDateTime)}.
	 */
	@Test
	public void testValues() {
		Collection<String> values=map.values(now);
		assertTrue(values.contains("Pulen"));
	}

	/**
	 * Test method for {@link Map.MyMap#putAll(java.util.Map, java.time.LocalDateTime, java.time.LocalDateTime)}.
	 */
	@Test
	public void testPutAll() {
		HashMap<String,String> list=new HashMap<>();
		list.put("Vova","Kuzmenko");
		list.put("Andriy","Konoz");
		list.put("Ira","Ivanchyk");
		map.putAll(list, now, now);
		assertTrue(map.containsKey("Vova", now) && map.containsKey("Ira", now));
	}
	/**
	 * Test method for {@link Map.MyMap#containsKey(java.lang.Object, java.time.LocalDateTime)}.
	 */
	@Test
	public void testContainsKey() {
		assertTrue(map.containsKey("Amely", now));
	}

	/**
	 * Test method for {@link Map.MyMap#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemove() {
		String val=map.remove("Lilly",now);
		assertTrue(val.equals("Lyubarskaya"));
	}

}
