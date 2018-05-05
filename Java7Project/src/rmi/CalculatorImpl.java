package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = 3003888972364944311L;

	protected CalculatorImpl() throws RemoteException {
		super();
	}
	
	@Override
	public int add(int val1, int val2) throws RemoteException {
		System.out.println("The add() executed");
		return val1 + val2;
	}

	@Override
	public int subtract(int val1, int val2) throws RemoteException {
		System.out.println("The subtract() executed");
		return val1 - val2;
	}
}
