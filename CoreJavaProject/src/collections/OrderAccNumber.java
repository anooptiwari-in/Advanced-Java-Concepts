package collections;

import java.util.Comparator;

public class OrderAccNumber<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		Long accNo1 = ((Emp)o1).getAccNo();
		Long accNo2 = ((Emp)o2).getAccNo();
		
		return accNo1.compareTo(accNo2);
	}
}
