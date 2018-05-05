package rmi;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {

	public static void main(String[] args) {
		File baseCode = new File("./bin/");

		try {
			// 1. Get the complete absolute path to the place of .class file
			String codeBase = baseCode.getAbsoluteFile().toURI().toURL().toString();
			System.out.println(codeBase);
			
			// 2. Set path as a system property.
			System.setProperty("java.rmi.server.codebase", codeBase);
			
			// 3. Create a service object
			Calculator calci = new CalculatorImpl();
			
			// 4. Publish a service object
			Naming.rebind("rmi://localhost:1099/RmiServer1", calci);
			// rmi: Protocol
			// localhost: IP address of a server where RMI Registry is working.
			// Port Number(1099): Default port number for RMI Registry.
			// RmiServer : Unique name for the services running on Rmi Registry.
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
		
		System.out.println("Server Started.");
	}
}
