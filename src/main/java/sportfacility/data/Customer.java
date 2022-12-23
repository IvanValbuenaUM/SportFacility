package sportfacility.data;

public class Customer {
	
	private String name;
	private String surname;
	private int age;
	private String id;
	private int membershipNumber;
	
	
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
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	private void setSurname(String surname) 
	{
		this.surname = surname;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	private void setAge(int age) 
	{
		
		if (age < 18)
		{
			throw new IllegalArgumentException("The Customer must have at least 18 years");
		}
		
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	
	private void setId(String id) 
	{
		if (id.length() != 7)
		{
			throw new IllegalArgumentException("Incorrect format for the id (incorrect lenght)");
		}
		
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
		if (Integer.toString(membershipNumber).length() != 4)
		{
			throw new IllegalArgumentException("Incorrect format for the membership number (incorrect lenght)");
		}
		
		this.membershipNumber = membershipNumber;
	}

}
