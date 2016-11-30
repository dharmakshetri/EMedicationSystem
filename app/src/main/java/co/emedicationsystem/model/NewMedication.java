package co.emedicationsystem.model;

import java.util.ArrayList;
import java.util.List;

import co.emedicationsystem.NewPatientMedicatonList;

/**
 * Created by Dharma on 7/28/2015.
 */
public class NewMedication {
    private String personalId;
    private String name;
    private List<NewPatientMedicatonList> medicationList= new ArrayList<NewPatientMedicatonList>();
    /**
	 * @param personalId
	 * @param name
	 * @param newPatientMedication
	 */
	public NewMedication(String personalId, String name, List<NewPatientMedicatonList> newPatientMedication) {
		super();
		this.personalId = personalId;
		this.name = name;
		this.medicationList = newPatientMedication;
	}
    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NewPatientMedicatonList> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(NewPatientMedicatonList medicationList) {
        this.medicationList.add(medicationList);
    }


}
