package sportfacility.web.controllers.responses.customer;

import java.util.ArrayList;
import java.util.List;

import sportfacility.web.controllers.responses.timetable.GetTimetableResponse;

public class GetCustomerResponse {

	private int membershipNumber;
	private String id;
	private String name;
	private String surname;
	private int age;
	
	private List<GetTimetableResponse> reservations = new ArrayList<>();
	
	public GetCustomerResponse() 
	{
		super();
	}
	
	public GetCustomerResponse(String name, String surname, int age, String id, int membershipNumber) 
	{
		super();
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setId(id);
		this.setMembershipNumber(membershipNumber);
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("The Customer name is incorrect");
		
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	public void setSurname(String surname) 
	{
		if (surname == null || surname.trim().isEmpty())
			throw new IllegalArgumentException("The Customer surname is incorrect");
		
		this.surname = surname;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		if (age < 18)
			throw new IllegalArgumentException("The Customer must have at least 18 years");
		
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) 
	{
		if (id == null)
			throw new IllegalArgumentException("The Customer id is null");
		
		if (id.length() != 7)
			throw new IllegalArgumentException("Incorrect format for the id (incorrect length)");
		
		for (int i = 0; i < id.length() - 1; i++)
		{
			if (!Character.isDigit(id.charAt(i)))
			{
				throw new IllegalArgumentException("Incorrect format for the id (character at position " + i + " must be a digit)");
			}
		}
		
		if (!Character.isLetter(id.charAt(6)))
		{
			throw new IllegalArgumentException("Incorrect format for the id (character at last position must be a letter)");
		}
		
		this.id = id;
	}
	
	public int getMembershipNumber() 
	{
		return membershipNumber;
	}
	
	public void setMembershipNumber(int membershipNumber) 
	{
		if (Integer.toString(membershipNumber).length() != 4)
			throw new IllegalArgumentException("Incorrect format for the membership number (incorrect lenght)");
		
		this.membershipNumber = membershipNumber;
	}
	
	public void addReservation(GetTimetableResponse t)
	{
		if (t == null)
			throw new IllegalArgumentException("Can't add a null reservation");
		
		reservations.add(t);
	}
	
	public boolean removeReservation(GetTimetableResponse t)
	{
		if (t == null)
			throw new IllegalArgumentException("Can't remove a null reservation");
		
		for(int i = 0; i < reservations.size(); i++)
		{
			if (t.equals(reservations.get(i)))
			{
				reservations.remove(i);
				return true;
			}
		}
		return false;
	}

	public List<GetTimetableResponse> getReservations() {
		return reservations;
	}
}
