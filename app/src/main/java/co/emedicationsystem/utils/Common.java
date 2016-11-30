package co.emedicationsystem.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import co.emedicationsystem.NewPatientMedicatonList;
import co.emedicationsystem.PastPatientMedicatonList;
import co.emedicationsystem.model.Medication;
import co.emedicationsystem.model.NewMedication;
import co.emedicationsystem.model.PastMedication;
import co.emedicationsystem.model.Patient;

/**
 * Created by Dharma on 7/18/2015.
 */
public class Common implements Variables {

	private static NewMedication newMedication;
	private static PastMedication pastMedication;
	static Context context;

	public static boolean isNetworkAvailable(Context mcontext) {
		ConnectivityManager connectivityManager = (ConnectivityManager) mcontext.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	public static String loadJSONFromAsset(Context mContext) {

		context = mContext;
		String json = null;
		// medList = medicationlist.getArrayList();

		try {

			InputStream is = mContext.getAssets().open("medication.json");

			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			json = new String(buffer, "UTF-8");

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;

	}

	// return patient deatils json

	public static String returnPatientJson(Context mContext) {

		context = mContext;
		String patientJson = null;

		try {

			InputStream is = mContext.getAssets().open("patient.json");

			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			patientJson = new String(buffer, "UTF-8");

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return patientJson;

	}

	public static void parsePatientDeatilsJson(Context ctx, String jsonString) {
		try {
			// First clear the clist before adding
			// clist.clear();

			// String jsonString = loadJSONFromAsset(ctx);
			JSONObject jsonMainObj = new JSONObject(jsonString);
			JSONArray patientsJsonArray = jsonMainObj.getJSONArray("patients");

			for (int p = 0; p < patientsJsonArray.length(); p++) {

				JSONObject patient_obj = patientsJsonArray.getJSONObject(p);
				// set values to the contacts unit, conts

				Patient patient = new Patient();
				if (patient_obj.has(Common.TAG_PERSONALID)) {
					patient.setPersonalId(patient_obj.getString(Common.TAG_PERSONALID));
				} else {
					patient.setPersonalId("N/A");
				}
				if (patient_obj.has(Common.TAG_NAME)) {
					patient.setName(patient_obj.getString(Common.TAG_NAME));
				} else {
					patient.setName("N/A");
				}
				if (patient_obj.has(Common.TAG_AGE)) {
					patient.setAge(patient_obj.getString(Common.TAG_AGE));
				} else {
					patient.setAge("N/A");
				}
				if (patient_obj.has(Common.TAG_CODE)) {
					patient.setCode(patient_obj.getString(Common.TAG_CODE));
				} else {
					patient.setCode("N/A");
				}
				if (patient_obj.has(Common.TAG_EMAIL)) {
					patient.setEmail(patient_obj.getString(Common.TAG_EMAIL));
				} else {
					patient.setEmail("N/A");
				}
				if (patient_obj.has(Common.TAG_ADDRESS)) {
					patient.setAddress(patient_obj.getString(Common.TAG_ADDRESS));
				} else {
					patient.setAddress("N/A");
				}
				if (patient_obj.has(Common.TAG_AGE)) {
					patient.setAge(patient_obj.getString(Common.TAG_AGE));
				} else {
					patient.setAge("N/A");
				}
				patientList.add(patient);
				System.out.println(" patientList List=" + patientList.toString());
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// return past medicine deatils json

	public static String returnPastMedicationJson(Context mContext) {

		context = mContext;
		String patientJson = null;

		try {

			InputStream is = mContext.getAssets().open("pastmedication.json");

			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			patientJson = new String(buffer, "UTF-8");

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return patientJson;

	}

	public static void parsePastPatientMedicationDeatilsJson(Context ctx, String jsonString) {
		try {
			// First clear the clist before adding
			// clist.clear();

			// String jsonString = loadJSONFromAsset(ctx);
			JSONObject jsonMainObj = new JSONObject(jsonString);
			JSONArray pastMedicineJsonArray = jsonMainObj.getJSONArray("PastMedication");
			for (int pm = 0; pm < pastMedicineJsonArray.length(); pm++) {

				JSONObject past_medicine_obj = pastMedicineJsonArray.getJSONObject(pm);
				// set values to the contacts unit, conts

				ArrayList<PastPatientMedicatonList> pastList = new ArrayList<PastPatientMedicatonList>();
				PastPatientMedicatonList pastPatientMedication;

				String personalId = past_medicine_obj.getString(Common.TAG_NEW_PERSONALID);
				String name = past_medicine_obj.getString(Common.TAG_NEW_NAME);
				// newMedication.setPersonalId(new_medicine_obj.getString(Common.TAG_NEW_PERSONALID));
				// newMedication.setName(new_medicine_obj.getString(Common.TAG_NEW_NAME));
				// set valu to the contacts unit, conts
				JSONArray pastPatientMedicineJsonArray = past_medicine_obj.getJSONArray("MedicationList");
				for (int ppm = 0; ppm < pastPatientMedicineJsonArray.length(); ppm++) {

					JSONObject past_patient_medicine_obj = pastPatientMedicineJsonArray.getJSONObject(ppm);

					String id = past_patient_medicine_obj.getString(Common.TAG_ID);
					String medicinename = past_patient_medicine_obj.getString(Common.TAG_NEW_MEDICINENAME);
					String dosage = past_patient_medicine_obj.getString(Common.TAG_PAST_DOSAGE);
					String time = past_patient_medicine_obj.getString(Common.TAG_PAST_TIME);
					String reason = past_patient_medicine_obj.getString(Common.TAG_PAST_REASON);
					String usage = past_patient_medicine_obj.getString(Common.TAG_PAST_USAGE);

					pastPatientMedication = new PastPatientMedicatonList(id, medicinename, dosage, time, reason, usage);
					pastList.add(pastPatientMedication);
					pastMedication = new PastMedication(personalId, name, pastList);
					// newMedication.setMedicationList(newPatientMedication);
				}

				Variables.pastMedicationList.add(pastMedication);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	// return new and ongoing medicine deatils json

	public static String returnNewMedicationJson(Context mContext) {

		context = mContext;
		String patientJson = null;

		try {

			InputStream is = mContext.getAssets().open("currentmedication.json");

			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			patientJson = new String(buffer, "UTF-8");

		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return patientJson;

	}

	public static void parseNewPatientMedicationDeatilsJson(Context ctx, String jsonString) {
		try {
			// First clear the clist before adding
			// clist.clear();

			// String jsonString = loadJSONFromAsset(ctx);
			JSONObject jsonMainObj = new JSONObject(jsonString);
			JSONArray newMedicineJsonArray = jsonMainObj.getJSONArray("CurrentMedication");

			Log.d("log", "CurrentMedication=" + jsonString);
			Log.d("log", "CurrentMedication=" + newMedicineJsonArray.length());
			for (int nm = 0; nm < newMedicineJsonArray.length(); nm++) {
				ArrayList<NewPatientMedicatonList> newList = new ArrayList<NewPatientMedicatonList>();
				JSONObject new_medicine_obj = newMedicineJsonArray.getJSONObject(nm);
				NewPatientMedicatonList newPatientMedication;

				String personalId = new_medicine_obj.getString(Common.TAG_NEW_PERSONALID);
				String name = new_medicine_obj.getString(Common.TAG_NEW_NAME);
				// newMedication.setPersonalId(new_medicine_obj.getString(Common.TAG_NEW_PERSONALID));
				// newMedication.setName(new_medicine_obj.getString(Common.TAG_NEW_NAME));
				// set values to the contacts unit, conts
				JSONArray newPatientMedicineJsonArray = new_medicine_obj.getJSONArray("MedicationList");

				for (int npm = 0; npm < newPatientMedicineJsonArray.length(); npm++) {

					JSONObject new_patient_medicine_obj = newPatientMedicineJsonArray.getJSONObject(npm);
					String id = new_patient_medicine_obj.getString(Common.TAG_ID);

					String medicinename = new_patient_medicine_obj.getString(Common.TAG_NEW_MEDICINENAME);
					String dosage = new_patient_medicine_obj.getString(Common.TAG_NEW_DOSAGE);
					String time = new_patient_medicine_obj.getString(Common.TAG_NEW_TIME);
					String diagnosis = new_patient_medicine_obj.getString(Common.TAG_NEW_DIAGONIS);
					String initiatedOn = new_patient_medicine_obj.getString(Common.TAG_NEW_INITIATEDON);
					String status = new_patient_medicine_obj.getString(Common.TAG_NEW_STATUS);
					String remarks = new_patient_medicine_obj.getString(Common.TAG_NEW_REMARK);
					newPatientMedication = new NewPatientMedicatonList(id, medicinename, dosage, time, diagnosis, initiatedOn, status, remarks);
					newList.add(newPatientMedication);
					newMedication = new NewMedication(personalId, name, newList);
				}

				Variables.curretMedicationList.add(newMedication);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public static void loadMedcationlistFromAsset(Context ctx) {
		try {
			// First clear the clist before adding
			// clist.clear();

			String jsonString = loadJSONFromAsset(ctx);
			JSONObject jsonMainObj = new JSONObject(jsonString);
			JSONArray jsonArray = jsonMainObj.getJSONArray("data");

			for (int data = 0; data < jsonArray.length(); data++) {

				if (data == 0) {
					JSONObject medication_obj = jsonArray.getJSONObject(data);
					// set values to the contacts unit, conts
					// med.setId(medication_obj.getString("_id"));
					JSONArray jsonListArray = medication_obj.getJSONArray("medicationList");
					for (int mList = 0; mList < jsonListArray.length(); mList++) {
						JSONObject medicationList_obj = jsonListArray.getJSONObject(mList);

						Medication medObject = new Medication();
						if (medicationList_obj.has("Dosage")) {
							medObject.setDosage(medicationList_obj.getString("Dosage"));
						} else {
							medObject.setDosage("N/A");
						}
						medNewList.add(medObject);
					}
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
