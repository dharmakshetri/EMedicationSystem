package co.emedicationsystem.model;

import java.util.ArrayList;
import java.util.List;

import co.emedicationsystem.PastPatientMedicatonList;

/**
 * Created by Dharma on 7/28/2015.
 */
public class PastMedication {


    private String personalId;
    private String name;
    private List<PastPatientMedicatonList> medicationList= new ArrayList<PastPatientMedicatonList>();
    /**
	 * @param personalId
	 * @param name
	 * @param medicationList
	 */
	public PastMedication(String personalId, String name, List<PastPatientMedicatonList> medicationList) {
		super();
		this.personalId = personalId;
		this.name = name;
		this.medicationList = medicationList;
	}
	
    /**
	 * @return the personalId
	 */
	public String getPersonalId() {
		return personalId;
	}
	/**
	 * @param personalId the personalId to set
	 */
	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the medicationList
	 */
	public List<PastPatientMedicatonList> getMedicationList() {
		return medicationList;
	}
	/**
	 * @param medicationList the medicationList to set
	 */
	public void setMedicationList(List<PastPatientMedicatonList> medicationList) {
		this.medicationList = medicationList;
	}
	
}
