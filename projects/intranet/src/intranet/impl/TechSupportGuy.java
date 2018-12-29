package intranet.impl;

import java.util.ArrayList;
import java.util.List;

public class TechSupportGuy extends Employee{
	private static final long serialVersionUID = 1L;
	private List<Order> Orders;
	
	public TechSupportGuy(int iD, String firstName, String secondName, Date birthDate, String eMail, String login,
			String password) {
		super(iD, firstName, secondName, birthDate, eMail, login, password);
		Orders = new ArrayList<>();
		setType("TechSupport");
		super.logging("TechSupportGuy Created");
	}
	
	public void reciveOrder(Order order) {
		Orders.add(order);
	}
	
	public List<Order> viewOrders() {
		return Orders;
	}

	@Override
	public String toString() {
		return "TechSupportGuy [ID=" + getID() + ", FirstName=" + getFirstName() + ", SecondName=" + getSecondName() 
				+ ", BirthDate=" + getBirthDate() + ", Age=" + getAge() + ", EMail=" + getEMail() 
				+ ", Login=" + getLogin() + ", Password=" + getPassword() + ", Orders=" + Orders + "]";
	}
	
}
