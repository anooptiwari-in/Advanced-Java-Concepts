package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) {
		String url = "rmi://localhost:1099/RmiServer1";
		
		try {
			Calculator calci = (Calculator)Naming.lookup(url);
			
			System.out.println(calci.add(5, 10));  // Polymorphism
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

}
