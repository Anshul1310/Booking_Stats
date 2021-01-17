package com.anStudios.bookingstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class StartCarActivity extends AppCompatActivity {

    private EditText bookingName;
    private EditText bookingprice;
    private CircleImageView profile_photo;
    private TextView editImage_btn;
    private EditText bookingfrom;
    private EditText bookingto;
    private TextView startNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_car);
        bookingfrom = findViewById(R.id.booking_from);
        bookingName = findViewById(R.id.booking_customer_name);
        editImage_btn=findViewById(R.id.bookingeditimage_btn);
        profile_photo=findViewById(R.id.booking_cutomer_photo);
        bookingprice = findViewById(R.id.booking_price_charged);
        bookingto = findViewById(R.id.booking_to);
        startNow = findViewById(R.id.booking_start_now);
        startNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkTokens(bookingName.getText().toString(),
                        bookingfrom.getText().toString(),
                        bookingprice.getText().toString(),
                        bookingto.getText().toString())){
                    Intent intent=new Intent(StartCarActivity.this,CarStartedactivity.class);
                    intent.putExtra("customername",bookingName.getText().toString());
                    intent.putExtra("customerprice",bookingprice.getText().toString());
                    intent.putExtra("customerfrom",bookingfrom.getText().toString());
                    intent.putExtra("customerto",bookingto.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    public boolean checkTokens(String name, String price, String to, String from) {
        if (!name.equals("") && !price.equals("") && !to.equals("") && !from.equals("")) {
            return true;
        }else{
            return false;
        }
    }
}