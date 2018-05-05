package exceptions;

public class ArrayServices {
	private int[] intList;
	private int index, sizeArray;

	public ArrayServices (int sizeArray){
		intList=new int[sizeArray];
		index = 0;
		this.sizeArray = sizeArray;
	}

	public void addNewValue(int value) throws ArrayExhaustedException {  // index=0 array is empty.
		if (index > sizeArray-1)
			//System.out.println("Array exhausted."+value);
			throw new ArrayExhaustedException("Integer array exhausted. Capacity: "+sizeArray);
		else {
			intList[index++] = value;    // index 10  array 0, 1, 3  .. 9
			System.out.println("Element added into array: "+value);
		}
	}

	public static void main(String[] args){
		ArrayServices as = new ArrayServices(5);
		
		try{
			as.addNewValue(1);
			as.addNewValue(2);
			as.addNewValue(3);
			as.addNewValue(4);
			as.addNewValue(5);
			as.addNewValue(6);
		} catch(ArrayExhaustedException e){
			e.printStackTrace();
		}
	}
}