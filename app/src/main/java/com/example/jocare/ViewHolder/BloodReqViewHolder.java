package com.example.jocare.ViewHolder;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jocare.R;

public class BloodReqViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

    public TextView PatientNameV, PatientBloodTypeV, BloodNeededV, UnitsNeededV, BankNameV;
    public BloodReqViewHolder(@NonNull View itemView) {
        super(itemView);

        PatientNameV = itemView.findViewById(R.id.getPatientNameV);
        PatientBloodTypeV = itemView.findViewById(R.id.getPatientBloodV);
        BloodNeededV = itemView.findViewById(R.id.getBloodNeededV);
        UnitsNeededV = itemView.findViewById(R.id.getUnitsNeeded);
        BankNameV = itemView.findViewById(R.id.getBloodBankV);


        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select Menu");
        menu.add(0,0,getAdapterPosition(),"Delete");

    }


}
