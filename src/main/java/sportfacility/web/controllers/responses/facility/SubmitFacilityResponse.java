package sportfacility.web.controllers.responses.facility;

public class SubmitFacilityResponse {
	
	private String facilityCode;

	public SubmitFacilityResponse(String facilityCode) {
		super();
		this.setFacilityCode(facilityCode);
	}

	public String getFacilityCode() 
	{
		return facilityCode;
	}
	
	public void setFacilityCode(String facilityCode) 
	{
		if (facilityCode == null || facilityCode.trim().isEmpty())
			throw new IllegalArgumentException("The facility code is incorrect");
		
		if (facilityCode.length() != 4)
			throw new IllegalArgumentException("Incorrect format for the facilityCode (incorrect length)");
		
		for (int i = 0; i < facilityCode.length()/2; i++)
		{
			if (!Character.isLetter(facilityCode.charAt(i)))
				throw new IllegalArgumentException("Incorrect format for the facilityCode (character at position " + i + " must be a letter)");
			
			if (!Character.isDigit(facilityCode.charAt(i + 2)))
				throw new IllegalArgumentException("Incorrect format for the facilityCode (character at position " + (i + 2) + " must be a digit)");		
		}
		
		this.facilityCode = facilityCode;
	}
}
