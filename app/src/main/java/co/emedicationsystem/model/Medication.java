package co.emedicationsystem.model;

/**
 * Created by Dharma on 7/18/2015.
 */
public class Medication {

    private String id;
    private String dosage;
    private String frequency;
    private String reason;
    private String initiate;
    private String remark;
    private String usedFor;

    //private List<CurrentMedication> currentMedicationList;

    public Medication(){}
    public Medication(String id, String dosage, String frequency, String initiate, String reason, String remark, String usedFor) {
        this.id = id;
        this.dosage = dosage;
        this.frequency = frequency;
        this.initiate = initiate;
        this.reason = reason;
        this.remark = remark;
        this.usedFor = usedFor;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getInitiate() {
        return initiate;
    }

    public void setInitiate(String initiate) {
        this.initiate = initiate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsedFor() {
        return usedFor;
    }

    public void setUsedFor(String usedFor) {
        this.usedFor = usedFor;
    }

    /*public class CurrentMedication{



    }*/
}
