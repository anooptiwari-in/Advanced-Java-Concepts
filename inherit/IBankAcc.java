package inherit;

public interface IBankAcc {
	float rateInterest = 10.75f;  // Public final and Static

	float deposit(float amt);	// Public abstract.
	void withdraw(float amt);

}