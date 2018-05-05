package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class EntityList<T> {
	//private ArrayList<T> entityList;  // Dynamic array
	//private LinkedList<T> entityList; // Linked List(Doubly linked list)
	//private HashSet<T> entityList;	// HashSet(Implementation of HashTable)
	//private LinkedHashSet<T> entityList;	// HashSet(Implementation of HashTable)
	private TreeSet<T> entityList;
	/*

	public EntityList(int capacity){
		entityList = new ArrayList<T>(capacity); // Capacity=10
	}
	*/

	public EntityList(){
		//entityList = new LinkedList<T>();  // No capacity please.
		//entityList = new HashSet<T>();
		//entityList = new LinkedHashSet<T>();
		entityList = new TreeSet<T>();
	}

	// add	
	public void addNewEntity(T obj){
		//if (!(isExisting(obj)))
			entityList.add(obj);
	}
	/*
	public void insertEntity(T obj, int position){
		entityList.add(position, obj);
	}
	*/
	// list all
	public void listAll(){
		/*
		for(int idx=0; idx<entityList.size(); idx++){
			System.out.println(entityList.get(idx));
		}
		*/
		/*  // Using Iterator
		Iterator itr = entityList.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		*/
		///*
		// Using enhanced for loop
		for(T x : entityList){
			System.out.println(x);
		}
		//*/
		/*
		ListIterator lItr = entityList.listIterator(); // ListIterator extends Iterator
		while(lItr.hasNext()){
			System.out.println(lItr.next());
		}
		while(lItr.hasPrevious()){
			System.out.println(lItr.previous());
		}
		*/
		// Write method to remove given object
		// List of entities with entityId in given range.
	}

	// isExisting
	public boolean isExisting(T entity){
		return entityList.contains(entity);
	}

	// Remove

	public static void main(String[] argv){
		//EntityList<Integer> list = new EntityList<Integer>(4);  // ArrayList
		EntityList<Integer> list = new EntityList<Integer>();  // LinkedList

		list.addNewEntity(20);
		list.addNewEntity(20);  // Duplicate
		list.addNewEntity(10);
		list.addNewEntity(50);
		list.addNewEntity(35);
		list.addNewEntity(90);	
		System.out.println(list.isExisting(90));
		System.out.println(list.isExisting(75));
		
		//list.insertEntity(77, 3);  // 20, 10, 50, 77, 35, 90
		
	
		list.listAll();

		//EntityList<Emp> list1 = new EntityList<Emp>(4);  // ArrayList
		EntityList<Emp> list1 = new EntityList<Emp>();	// LinkedList
		//list1.addNewEntity("aaaa");
		//list1.addNewEntity(10);
		list1.addNewEntity(new Emp(100, "xxx", 20000));
		list1.addNewEntity(new Emp(50, "xxx", 20000));
		list1.addNewEntity(new Emp(110, "xxx", 20000));
		//list1.addNewEntity(null);
		//list1.addNewEntity(null);
		System.out.println("From listAll()");
		list1.listAll();

		System.out.println(list1.isExisting(new Emp(100, "yyy", 30000)));
	}
}
