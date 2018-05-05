package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * This is remote interface.
 * 	The java.rmi.Remote is a marker interface.(Serializable, Cloneable, Remote)
 * 	Every method must throw RemoteException
 * 		
 */
public interface Calculator extends Remote {
	int add(int val1, int val2) throws RemoteException ;  // Methods are public and abstract
	int subtract(int val1, int val2) throws RemoteException;
}
