package io;

import java.io.Serializable;

public class Emp implements Serializable {

	/*
	 * Finger Print
	 * 	* Super classes and interfaces
	 * 	* Instance fields
	 * 	* Adding or removing methods.
	 * 
	 * 	* Content of a method.
	 */
	
	/*
	 * Which fields are by default serializable?
	 * 	* All primitives
	 * 	* Objects implementing interface 'Serializable' are serializable
	 * 	* Objects involved in distributed environment are seriealizable.
	 
	 * Which field is prevented from serialization?
	 * 	* Transient fields
	 * 	* Static fields
	 
	 * What is forceful serialization?
	 * 	* Externalization.  // Custom serialization.
	 
	 * Marker interface
	 * 	* Serializable, Cloneable, Remote
	 */
	private static final long serialVersionUID = -1051036423781163403L;
	
	private int empNo;
	
	private transient String empNm;
	private float empSal;
	
	private double empCtc;
	private long contact;
	
	private static int nextEmpNo;
	
	// Constructor
	public Emp(){
		super();
		empNo = ++nextEmpNo;
		empNm = "xxxx";
		System.out.println("In constructor: "+empNo);
	}
	
	// Destructor
	@Override
	protected void finalize() throws Throwable{
		System.out.println("\tIn destructor: "+empNo);
		super.finalize();  // Distructor chaning.  Must be very last step.
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empNm=" + empNm + "]";
	}
}
