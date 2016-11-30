package co.emedicationsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import co.emedicationsystem.model.Patient;
import co.emedicationsystem.utils.Common;


public class LoginActivity extends Activity {
EditText etIdNumber, etDigitCode;
Button btnSignIn;
    //String idNumber="444444";
    //String digitCode="123456";

    String personalIdNumber="";
    ArrayList<String> digitCode;
 // User Session Manager Class
 	UserSessionManager session;
 	private boolean isValid=true; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.login);
        digitCode= new ArrayList<String>();
        //Common.loadMedcationlistFromAsset(getApplicationContext());
        Patient patient= new Patient();


     // User Session Manager
        session = new UserSessionManager(getApplicationContext()); 
        
        
        etIdNumber=(EditText)findViewById(R.id.editTextIdNumber);
        etDigitCode=(EditText)findViewById(R.id.editTextDigitCode);
        btnSignIn=(Button)findViewById(R.id.buttonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
    

	@Override
    public void onClick(View v) {
    	
    	 String enteredPatientIdNumber=etIdNumber.getText().toString().trim();
         String enteredPatientDigitCode= etDigitCode.getText().toString().trim();
    	Log.e("PID", "ID-"+enteredPatientIdNumber);
    	Log.e("Code", "Code-"+enteredPatientDigitCode);
    	if (enteredPatientIdNumber.length()==0 && enteredPatientDigitCode.length()==0) {
    		
    		
    		etIdNumber.setError( "Personal id number is required !" );
    		etDigitCode.setError( "Digit code is required !" );
    		//Toast.makeText(getApplicationContext(),"Personal id number and Digit code must be enter",Toast.LENGTH_SHORT).show();
            return;
		}
    	
    	if (enteredPatientIdNumber.length()<11){
    		etIdNumber.setError( "Personal id number is required(11 digit) !" );
           //Toast.makeText(getApplicationContext(),"Personal id number must be 11 digit",Toast.LENGTH_SHORT).show();
            return;
        }
        //if id number and gidit code match then get data fromver
        if (enteredPatientDigitCode.length()<6){
        	etDigitCode.setError( "6 digit code is required !" );
           // Toast.makeText(getApplicationContext(),"Digit Code must be 6 digit",Toast.LENGTH_SHORT).show();
            return;
        }
       
        isValid=checkPatientValid(enteredPatientIdNumber,enteredPatientDigitCode);
        Log.e("CHECK","isValid="+isValid);
        if (!isValid) {
        	Toast.makeText(getApplicationContext(),"Wrong id and Code error !",Toast.LENGTH_SHORT).show();
		}
        /*if (isValid){
            Intent iLogin= new Intent(LoginActivity.this, PatientMedicationList.class);
            iLogin.putExtra(Common.USERNAME,Common.demoUser);
            startActivity(iLogin);

        }else{
            Toast.makeText(getApplicationContext(),"ID Number and Digit Code not match.",Toast.LENGTH_SHORT).show();
        }*/
    }
});
    }

    private  boolean checkPatientValid(String pId, String dCode){
        boolean isValide=true;

        for (int p = 0; p< Common.patientList.size(); p++){

            String strCode=Common.patientList.get(p).getCode();
            String [] splitCode=strCode.split(",");

            if (pId.equalsIgnoreCase(Common.patientList.get(p).getPersonalId())){
                for (int dc=0;dc<splitCode.length;dc++){
                    if (dCode.equalsIgnoreCase(splitCode[dc].toString())) {
                    	isValide=true;
                    	session.createUserLoginSession(Common.patientList.get(p).getPersonalId(), Common.patientList.get(p).getName());
                        Intent iLogin = new Intent(LoginActivity.this, PatientMedicationList.class);
                        iLogin.putExtra(Common.TAG_PERSONALID, Common.patientList.get(p).getPersonalId());
                        iLogin.putExtra(Common.TAG_NAME, Common.patientList.get(p).getName());
                        
                        iLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						
						// Add new Flag to start new Activity
                        iLogin.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						startActivity(iLogin);
						overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
						finish();
						return isValide;
                    }else{
                    	//Toast.makeText(getApplicationContext(),"Wrong id and Code error !",400).show();
                    	Log.e("Codes","ELSE isValide="+isValide);
                    	isValide=false;
                    }
                }

            }else{
            	//Toast.makeText(getApplicationContext(),"Wrong id and Code error !",400).show();
            	Log.e("Codes","ELSELSE isValide="+isValide);
            	isValide=false;
            }
        }
        return  isValide;
    }
    
    @Override
	public void onBackPressed() {
		Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
		super.onBackPressed();
	}
}
