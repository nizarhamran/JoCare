package com.example.jocare.ViewHolder;

import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jocare.R;

public class ReminderViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

    public TextView text_name, text_notes, text_dosage,text_daytime,text_weekday, text_dob, text_Time;
    public ReminderViewHolder(@NonNull View itemView) {
        super(itemView);

        text_name = itemView.findViewById(R.id.text_name);
        text_notes = itemView.findViewById(R.id.text_notes);
        text_dosage = itemView.findViewById(R.id.text_dosage);
        text_daytime = itemView.findViewById(R.id.text_daytime);
        text_weekday = itemView.findViewById(R.id.text_weekday);
        text_dob = itemView.findViewById(R.id.text_dob);
        text_Time = itemView.findViewById(R.id.text_Time);

        itemView.setOnCreateContextMenuListener(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        menu.setHeaderTitle("Select Menu");
        menu.add(0,0,getAdapterPosition(),"Delete");
       // menu.add(0,1,getAdapterPosition(),"Update");
    }


}
