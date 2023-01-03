package sportfacility.web.controllers.responses.timetable;

public class SubmitTimetableResponse {
	
	private String id;

	public SubmitTimetableResponse(String id) {
		super();
		this.setId(id);
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
}
