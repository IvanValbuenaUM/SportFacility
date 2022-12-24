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
		if (name == null || name.trim().isEmpty())
			throw new IllegalArgumentException("The Customer´s name is incorrect");
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	private void setSurname(String surname) 
	{
		if (surname == null || surname.trim().isEmpty())
			throw new IllegalArgumentException("The Customer´s surname is incorrect");
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
		if (id == null)
			throw new IllegalArgumentException("The Customer´s id null");
		
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
	
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", age=" + age + ", id=" + id + ", membershipNumber="
				+ membershipNumber + "]";
	}


	@SuppressWarnings("unused")
	private String serialization() {
		return getMembershipNumber() + "/" + getSurname() + "/" + getName() + "/" + getAge() + "/" + getId();
	}
	
	@SuppressWarnings("unused")
	private void parse(String lineText) {
		String[] parts = lineText.split("/");
		if (parts.length != 5)
			throw new IllegalArgumentException("Incorrect customer information in database");
		setMembershipNumber(Integer.valueOf(parts[0]));
		setSurname(parts[1]);
		setName(parts[2]);
		setAge(Integer.valueOf(parts[3]));
		setId(parts[4]);
	}

}
