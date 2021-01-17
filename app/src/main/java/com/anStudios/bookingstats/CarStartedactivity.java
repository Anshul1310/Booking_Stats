package com.anStudios.bookingstats;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CarStartedactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_startedactivity);
    }

    public void fill_petrol(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(CarStartedactivity.this);
        View v = LayoutInflater.from(CarStartedactivity.this).inflate(R.layout.fill_petrol, null);
        builder.setView(v);
        EditText price=v.findViewById(R.id.fillPetrol_price);
        TextView addBill=v.findViewById(R.id.fillPetrol_addbill);
        CardView savebtn=v.findViewById(R.id.fillPetrol_savebtn);
        addBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    public void end_booking(View view) {
        Toast.makeText(this, "Booking Ended", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CarStartedactivity.this,HomeScreen.class));
    }
}