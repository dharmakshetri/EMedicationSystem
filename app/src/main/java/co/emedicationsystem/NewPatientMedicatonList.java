package co.emedicationsystem;

/**
 * Created by Dharma on 7/29/2015.
 */
public class NewPatientMedicatonList {
	private String id;
	private String medicinename;
	private String dosage;
	private String time;
	private String diagnosis;
	private String initiatedOn;
	private String status;
	private String remarks;

	/**
	 * @param dosage
	 * @param time
	 * @param diagnosis
	 * @param initiatedOn
	 * @param status
	 * @param remarks
	 */
	public NewPatientMedicatonList(String id, String medicinename, String dosage, String time, String diagnosis, String initiatedOn, String status, String remarks) {
		super();
		this.id = id;
		this.medicinename = medicinename;
		this.dosage = dosage;
		this.time = time;
		this.diagnosis = diagnosis;
		this.initiatedOn = initiatedOn;
		this.status = status;
		this.remarks = remarks;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicinename;
	}

	public void setMedicineName(String medicinename) {
		this.medicinename = medicinename;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getInitiatedOn() {
		return initiatedOn;
	}

	public void setInitiatedOn(String initiatedOn) {
		this.initiatedOn = initiatedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
