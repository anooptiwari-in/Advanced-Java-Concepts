package association.oneOne;


public class TestOneOne {
	
	public static void main(String[] aa) {
		Employee emp1 = new Employee(1000, "Chandra");
		Desk desk1 = new Desk(55, "Wing 2", "a22", emp1);  // Constr injection
		emp1.setDesk(desk1 );	// Setter inject

		// Association of Desk being set in Employee through Constructor.
		
		//System.out.println(emp1.getEmpNo()+"    "+desk1.getDeskNo());

		//emp1.showData(); // Reaching to Desk object through Emp object.
		System.out.println(emp1);
		
		//desk1.showDeskDetails(); // Reaching to Employee from Desk object.
		System.out.println(desk1);
	}
}
