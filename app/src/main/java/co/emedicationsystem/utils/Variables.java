/**
 * 
 */
package co.emedicationsystem.utils;

import java.util.ArrayList;

import co.emedicationsystem.model.Medication;
import co.emedicationsystem.model.NewMedication;
import co.emedicationsystem.model.PastMedication;
import co.emedicationsystem.model.Patient;

/**
 * @author Dharma
 * 
 */
public interface Variables {

	static ArrayList<NewMedication> curretMedicationList = new ArrayList<NewMedication>();

	static ArrayList<PastMedication> pastMedicationList = new ArrayList<PastMedication>();

	static ArrayList<String> listAllMedicines = new ArrayList<String>();
	static ArrayList<String> listAllMedicinesIds = new ArrayList<String>();
	static ArrayList<String> listAllMedicinesTypes = new ArrayList<String>();

	static String typeNew = "new";
	static String typeOngoing = "ongoing";
	static String typePast = "past";
	
	static String TAG_ID="id";
	static String TAG_TYPE="TYPE";

	// patients
	public static String TAG_PERSONALID = "personalid";
	public static String TAG_NAME = "name";
	public static String TAG_AGE = "age";
	public static String TAG_GENDER = "gender";
	public static String TAG_CODE = "code";
	public static String TAG_EMAIL = "email";
	public static String TAG_ADDRESS = "address";

	static ArrayList<Patient> patientList = new ArrayList<Patient>();

	// past medicines

	public static String TAG_PAST_PERSONALID = "personalid";
	public static String TAG_PAST_NAME = "name";
	public static String TAG_PAST_PASTMEDICATION = "pastmedicine";
	public static String TAG_PAST_DOSAGE = "dosage";
	public static String TAG_PAST_TIME = "time";
	public static String TAG_PAST_REASON = "reason";
	public static String TAG_PAST_USAGE = "usage";

	static ArrayList<PastMedication> pastMedicinetList = new ArrayList<PastMedication>();

	// new or ongoing medication
	public static String TAG_NEW_PERSONALID = "personalid";
	public static String TAG_NEW_NAME = "name";
	public static String TAG_NEW_MEDICINENAME = "medicinename";
	public static String TAG_NEW_DOSAGE = "dosage";
	public static String TAG_NEW_TIME = "time";
	public static String TAG_NEW_DIAGONIS = "diagnosis";
	public static String TAG_NEW_INITIATEDON = "initiatedon";
	public static String TAG_NEW_STATUS = "status";
	public static String TAG_NEW_REMARK = "remarks";

	static ArrayList<NewMedication> newMedicinetList = new ArrayList<NewMedication>();

	public static String USERNAME = "username";
	public static String demoUser = "John Cena";
	public static String strMedicationList = "medicationList";


	static ArrayList<Medication> medNewList = new ArrayList<Medication>();
	static ArrayList<Medication> medUpdateList = new ArrayList<Medication>();
	static ArrayList<Medication> medPastList = new ArrayList<Medication>();

}
