/**
 * 
 */
package co.emedicationsystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.emedicationsystem.utils.Common;
import co.emedicationsystem.utils.Variables;

public class CustomAdapter extends BaseAdapter implements Variables {
	ArrayList<String> MedicineName, Ids, Types;
	Context context;
	int[] imageId;
	private static LayoutInflater inflater = null;
	String patient_id;

	public CustomAdapter(Context mcontext, String patientId,ArrayList<String> listAllMedicines, ArrayList<String> listAllMedicinesIds, ArrayList<String> listAllMedicinesTypes) {
		// TODO Auto-generated constructor stub
		MedicineName = listAllMedicines;
		Ids=listAllMedicinesIds;
		Types=listAllMedicinesTypes;
		context = mcontext;
		patient_id=patientId;
		//imageId = prgmImages;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return MedicineName.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class Holder {
		TextView tvMName,tvStatus;
		ImageView img;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder = new Holder();
		View rowView;
		rowView = inflater.inflate(R.layout.drugnamelist, null);
		holder.tvMName = (TextView) rowView.findViewById(R.id.tvDrugName);
		holder.img = (ImageView) rowView.findViewById(R.id.imageView1);
		
		holder.tvStatus = (TextView) rowView.findViewById(R.id.tvStatus);
		
		holder.tvMName.setText(MedicineName.get(position));
		
		final String type=Types.get(position).toString();
		holder.tvStatus.setText(type);
		
		final String id=Ids.get(position).toString();
		if (type.equalsIgnoreCase(Variables.typeNew)) {
			rowView.setBackgroundColor(context.getResources().getColor(R.color.green));
		}
		if (type.equalsIgnoreCase(Variables.typeOngoing)) {
			rowView.setBackgroundColor(context.getResources().getColor(R.color.orange));
		}
		if (type.equalsIgnoreCase(Variables.typePast)) {
			rowView.setBackgroundColor(context.getResources().getColor(R.color.bluedark));
		}
		rowView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (type.equalsIgnoreCase(Variables.typeNew)|| type.equalsIgnoreCase(Variables.typeOngoing)) {
					Intent imedicine=new Intent(context,NewMedicationList.class);
					imedicine.putExtra(Variables.TAG_TYPE, type);
					imedicine.putExtra(Variables.TAG_ID, id);
					imedicine.putExtra(Common.TAG_PERSONALID, patient_id);
					imedicine.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					Activity activity = (Activity) context;
					activity.startActivity(imedicine);
					activity.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
				}
				if (type.equalsIgnoreCase(Variables.typePast)) {
					Intent imedicine=new Intent(context,PastMedicationList.class);
					imedicine.putExtra(Variables.TAG_TYPE, type);
					imedicine.putExtra(Variables.TAG_ID, id);
					imedicine.putExtra(Common.TAG_PERSONALID, patient_id);
					imedicine.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					Activity activity = (Activity) context;
					activity.startActivity(imedicine);
					activity.overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_in_right);
				}
				
			}
		});
		return rowView;
	}

}