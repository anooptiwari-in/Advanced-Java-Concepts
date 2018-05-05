package collections;

import java.util.Comparator;

public class OrderContactNumber<T> implements Comparator<T> {

	// Auxiliary comparison
	@Override
	public int compare(Object o1, Object o2) {
		String contactNo1 = ((Emp)o1).getContactNo();
		String contactNo2 = ((Emp)o2).getContactNo();
		
		return contactNo2.compareTo(contactNo1);
	}
}