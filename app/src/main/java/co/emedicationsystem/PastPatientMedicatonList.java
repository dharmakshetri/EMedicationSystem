package co.emedicationsystem;

/**
 * Created by Dharma on 7/29/2015.
 */
public class PastPatientMedicatonList {
	private String id;
    private String medicinename;
    /**
	 * @param medicinename
	 * @param dosage
	 * @param time
	 * @param reason
	 * @param usage
	 */
	public PastPatientMedicatonList(String id,String medicinename, String dosage, String time, String reason, String usage) {
		super();
		this.id=id;
		this.medicinename = medicinename;
		this.dosage = dosage;
		this.time = time;
		this.reason = reason;
		this.usage = usage;
	}
	private String dosage;
    private String time;
    private String reason;
    private String usage;
    /**
	 * @return the medicinename
	 */
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicinename() {
		return medicinename;
	}
	/**
	 * @param medicinename the medicinename to set
	 */
	public void setMedicinename(String medicinename) {
		this.medicinename = medicinename;
	}
	/**
	 * @return the dosage
	 */
	public String getDosage() {
		return dosage;
	}
	/**
	 * @param dosage the dosage to set
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return the usage
	 */
	public String getUsage() {
		return usage;
	}
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
}
