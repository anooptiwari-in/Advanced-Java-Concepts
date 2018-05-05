package maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import collections.Emp;

public class EmpCache<K, V> {
	// HashMap, TreeMap and WeakHashMap
	private HashMap<K, V> map;
	
	public EmpCache(){
		map = new HashMap<K, V>();
	}
	
	public void addNewEmployee(V emp){
		K key = (K) new Integer(emp.hashCode());
		map.put(key, emp);
	}
	
	public V getEmployee(K empNo){
		return map.get(empNo);
	}
	
	// Traversing Map.  Map is not traversible.
	public void listAll(){
		/*
		// Using values()
		Collection<V> empList = map.values();  // Converts all values of Map into Collection.
		
		for(V emp : empList){
			System.out.println(emp);
		}
		*/
		/*
		// Using keySet()
		Set<K> keyList = map.keySet();
		for(K empNo : keyList){
			System.out.println(map.get(empNo));
		}
		*/
		///* // Using EntrySet
		Set<Entry<K, V>> objList= map.entrySet();
		
		for(Entry<K, V> emp : objList){
			System.out.println("Key: "+emp.getKey()+"  "+" Value:"+emp.getValue());
		}
		//*/
	}
	
	public static void main(String[] args) {
		EmpCache cache = new EmpCache();
		
		cache.addNewEmployee(new Emp(100, "xxx", 20000, "99998888", 100L));
		cache.addNewEmployee(new Emp(50, "xxx", 20000, "11112222", 90L));
		cache.addNewEmployee(new Emp(110, "xxx", 20000, "55556666", 155L));
		
		System.out.println(cache.getEmployee(50));
		System.out.println(cache.getEmployee(110));
		System.out.println(cache.getEmployee(100));
	}
}
