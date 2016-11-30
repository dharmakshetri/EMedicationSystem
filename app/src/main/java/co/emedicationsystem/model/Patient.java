package co.emedicationsystem.model;

/**
 * Created by Dharma on 7/28/2015.
 */
public class Patient {
    public Patient() {
    }

    public Patient(String personalId, String name, String age, String gender, String code) {
        this.personalId = personalId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.code = code;
    }

    private String personalId;
    private String name;
    private String age;
    private String gender;
    private String email;
    private String address;
    private String code;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
