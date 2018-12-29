package intranet.impl;

public class Employee extends User{
	private static final long serialVersionUID = 1L;

	public Employee(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
	}
	
	public void sendOrder(TechSupportGuy tsg, Order order) {
		tsg.reciveOrder(order);
	}
}
