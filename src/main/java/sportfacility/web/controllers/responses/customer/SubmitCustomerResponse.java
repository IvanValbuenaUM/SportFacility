package sportfacility.web.controllers.responses.customer;

public class SubmitCustomerResponse {

	private int membershipNumber;
	
	public SubmitCustomerResponse(int membershipNumber) {
		super();
		this.setMembershipNumber(membershipNumber);
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

}
