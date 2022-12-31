package sportfacility.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Customer {
	
	@Id
	@Column(name="cust_membershipnumber")
	private int membershipNumber;
	
	@Column(name="cust_id")
	private String id;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="cust_surname")
	private String surname;
	
	@Column(name="cust_age")
	private int age;
	
	@OneToMany(mappedBy = "customer")
	private List<Timetable> reservations = new ArrayList<>();
	public  Customer() {

	}
	public Customer(String name, String surname, int age, String id, int membershipNumber) 
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
	
	private void setName(String name) 
	{
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("The Customer name is incorrect");
		
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	private void setSurname(String surname) 
	{
		if (surname == null || surname.trim().isEmpty())
			throw new IllegalArgumentException("The Customer surname is incorrect");
		
		this.surname = surname;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	private void setAge(int age) 
	{
		if (age < 18)
			throw new IllegalArgumentException("The Customer must have at least 18 years");
		
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	
	private void setId(String id) 
	{
		if (id == null)
			throw new IllegalArgumentException("The Customer id null");
		
		if (id.length() != 7)
			throw new IllegalArgumentException("Incorrect format for the id (incorrect lenght)");
		
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
	
	private void setMembershipNumber(int membershipNumber) 
	{
		if (membershipNumber < 0 || membershipNumber > 9999)
			throw new IllegalArgumentException("Incorrect format for the membership number (incorrect lenght)");
		
		this.membershipNumber = membershipNumber;
	}
	
	public void addReservation(Timetable t)
	{
		if (t == null)
			throw new IllegalArgumentException("Can't add a null reservation");
		
		reservations.add(t);
	}
	
	public boolean removeReservation(Timetable t)
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

	public List<Timetable> getReservations() {
		return reservations;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"membershipNumber=" + membershipNumber +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", age=" + age +
				", reservations=" + reservations +
				'}';
	}
}
