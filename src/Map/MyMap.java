package Map;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MyMap<K,V>  {
	private static final int SIZE = 2048;
	private int amount=0;
	private Entry <K,V> head=null;
    private Entry<K,V> table[] = new Entry[SIZE];
	static class Entry<K,V> {
        final K key;
        V value;
        LocalDateTime LocalDateTime;
        Entry<K,V> next;
        Entry(K k, V v) {
            key = k;
            value = v;
        }
        Entry(K k, V v,LocalDateTime dt){
        	key = k;
            value = v;
            LocalDateTime=dt;
        }
        public V getValue() {
            return value;
        }
        public void setValue(V value) {
            this.value = value;
        }
 
        public K getKey() {
            return key;
        }
        public void setLocalDateTime(LocalDateTime LocalDateTime){
        	this.LocalDateTime=LocalDateTime;
        }
        public LocalDateTime getLocalDateTime(){
        	return this.LocalDateTime;
        }
    }

	public V get(Object k) {
        int hash = k.hashCode() % SIZE;
        Entry<K,V> e = table[hash];
        if(e!=null && e.getKey().equals(k))
        	return e.getValue();
        else{
        	for(int i=0;i<SIZE;i++)
        		if(table[i]!=null && table[i].getKey().equals(k))
        			return e.getValue();
        }
        return null;
    }
public Entry<K,V> getEntry(K k,LocalDateTime old){
	removeOld(old);
	int hash = k.hashCode() % SIZE;
    Entry<K,V> e = table[hash];
    if(table[hash].getKey().equals(k))
    	return e;
    else{
    	for(int i=0;i<SIZE;i++)
    		if(table[i]!=null && table[i].getKey().equals(k)){
    			return table[i];
    		}
    }
    return null;
}
	 public void clear(){
		 for(int i=0;i<SIZE;i++)
			 table[i]=null;
		     amount=0;
	 }
	 public V put(K k, V v,LocalDateTime dateTime,LocalDateTime old) {
		    removeOld(old);
	        int hash = k.hashCode() % SIZE;
	        Entry<K,V> e = table[hash];
	        Entry<K,V> entryInNewBucket = new Entry<K,V>(k, v);
	        entryInNewBucket.setLocalDateTime(dateTime);
	        if(e != null) {
	            if(e.key.equals(k)) {
	                e.value = v;
	                e.setLocalDateTime(dateTime);
	            } else {
	            	for(int i=0;i<SIZE;i++)
	            		if(table[i]==null){
	            			table[i]=entryInNewBucket;
	            			break;
	            		}	
	            	amount++;
	            }
	        } else {
	           
	            table[hash] = entryInNewBucket;
	            amount++;
	        }
	        return null;
	    }
	 public static void main(String...args){
		 MyMap<String,String> map = new MyMap<String,String>();
		 //map.put("KIM", "KIM");
		 //Entry<String,String> e = map.get("KIM");
	        //System.out.println(""+e.getValue());
		 
	 }
	
	public boolean containsValue(Object value,LocalDateTime old) {
		removeOld(old);
		for(int i=0;i<SIZE;i++)
    		if(table[i]!=null && table[i].getValue().equals(value)){
    			return true;
    		}
		return false;
	}
	
	public Set<Entry<K,V>> entrySet(LocalDateTime old) {
		removeOld(old);
		HashSet<Entry<K,V>> s=new HashSet<>();
		for(Entry<K,V> e:table){
			if(e!=null)
				s.add(e);
		}
		return (Set<Entry<K,V>>)s;
	}
	
	public boolean isEmpty(LocalDateTime old) {
		removeOld(old);
		return (amount==0) ? true:false;
	}
	
	public Set<K> keySet(LocalDateTime old) {
		removeOld(old);
		HashSet<K> set=new HashSet<>();
		for(int i=0;i<SIZE;i++)
    		if(table[i]!=null){
    			set.add(table[i].getKey());
    		}
		return set;
	}
	
	public int size(LocalDateTime old) {
		removeOld(old);
		return amount;
	}
	
	public Collection<V> values(LocalDateTime old) {
		removeOld(old);
		ArrayList<V> list=new ArrayList<>();
		for(int i=0;i<SIZE;i++)
    		if(table[i]!=null){
    			list.add(table[i].getValue());
    		}
		return list;
	}
	public void putAll(Map<? extends K ,? extends V> m,LocalDateTime dateTime,LocalDateTime old) {
		removeOld(old);
		for(Object e:m.entrySet()){
			java.util.Map.Entry<? extends K ,? extends V> entry=(java.util.Map.Entry<? extends K ,? extends V>)e;
			put(entry.getKey(),entry.getValue(),dateTime,old);
		}
	}
    public void removeOld(LocalDateTime LocalDateTime){
    	for(int i=0;i<SIZE;i++)
    		if(table[i]!=null)
    			if(table[i].LocalDateTime.isBefore(LocalDateTime)){
    			table[i]=null;
    			amount--;
    		}     
    }
	
	public boolean containsKey(Object arg0,LocalDateTime LocalDateTime) {
		removeOld(LocalDateTime);
		for(int i=0;i<SIZE;i++)
    		if(table[i]!=null ){
    			if(table[i].getKey().equals(arg0))
    				return true;
    		}
		return false;
	}
	
	public V remove(Object arg0,LocalDateTime LocalDateTime) {
		removeOld(LocalDateTime);
		for(int i=0;i<SIZE;i++)
    		if(table[i]!=null &&(table[i].getKey().equals(arg0)||table[i].getValue().equals(arg0))){
    			V res=table[i].getValue();
    			table[i]=null;
    			amount--;
    			return res;
    		}
		return null;
	}
}
