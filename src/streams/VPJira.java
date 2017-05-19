package streams;


import java.util.ArrayList;
import java.util.List;


public class VPJira {

	static List<String> persons;
	public static void main(String[] args) {
		persons = new ArrayList<String>();
		persons.add("vjonavada");
		persons.add("vjonavada1");
		persons.add("vjonavada2");
		persons.add("cberkmans");
		persons.add("cberkmans1");
		persons.add("cberkmans2");
		persons.add("cberkman3s");
		persons.add("lpanneerselvam");
		persons.add("lpanneerselvam3");
		
		List<JiraTicket> jList = new ArrayList<JiraTicket>();
		jList.add(new JiraTicket("ECI-10", "cberkmans", "rbhat", "Pre-Certified", "Pending Info", "20 day(s) ago", "Pending Info"));
		jList.add(new JiraTicket("ECI-11", "lpanneerselvam", "rbhat", "Certified", "Open", "20 day(s) ago", "Pending Info"));
		jList.add(new JiraTicket("ECI-12", "slambha", "rbhat", "Auto-Certified", "Closed", "25 day(s) ago", "Pending Info"));
		jList.add(new JiraTicket("ECI-13", "cberkmans", "rbhat", "Auto-Certified", "Pending Info", "2 day(s) ago", "Pending Info"));
		jList.add(new JiraTicket("ECI-14", "vjonavada", "rbhat", "None", "Pending Verification", "10 day(s) ago", "Pending Info"));
		jList.add(new JiraTicket("ECI-15", "vjonavada", "rbhat", "Pre-Certified", "In Progress", "26 day(s) ago", "Pending Info"));
		
		jList.stream().filter(p -> persons.contains(p.getCreatedBy())).forEach(p -> System.out.println(p.getTicketId()));
		
	}
/*    @SuppressWarnings("unchecked")
    private static java.util.function.Predicate<String> noAdminControllerPaths(JiraTicket j) {
        return new Stringpersons.contains(j.getCreatedBy());
    }*/

}

class JiraTicket {
	private String ticketId;
	private String createdBy;
	private String assignedTo;
	private String certificationType;
	private String jiraStatus;
	private String lastUpdate;
	private String status;
	
	public JiraTicket(String ticketId, String createdBy, String assignedTo, String certificationType, String jiraStatus,
			String lastUpdate, String status) {
		super();
		this.ticketId = ticketId;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.certificationType = certificationType;
		this.jiraStatus = jiraStatus;
		this.lastUpdate = lastUpdate;
		this.status = status;
	}

	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}
	public String getJiraStatus() {
		return jiraStatus;
	}
	public void setJiraStatus(String jiraStatus) {
		this.jiraStatus = jiraStatus;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
