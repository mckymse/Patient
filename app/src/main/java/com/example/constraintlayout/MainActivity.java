package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8,editText9;
    Button button1;
    DatePickerDialog.OnDateSetListener setListener;
    DatabaseHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DatabaseHelper(this);

        editText1=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        editText6=findViewById(R.id.editText6);
        editText7=findViewById(R.id.editText7);
        editText8=findViewById(R.id.editText8);
        editText9=findViewById(R.id.editText9);
        button1=findViewById(R.id.button);
        Calendar calendar=Calendar.getInstance();

        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);

        insertrecord();



        editText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String dob=day+"/"+month+"/"+year;
                        editText4.setText(dob);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });





    }


    public void insertrecord(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted=mydb.insertdata(editText1.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString(), editText5.getText().toString(),editText6.getText().toString(),editText7.getText().toString(),editText8.getText().toString(),editText9.getText().toString());
                if(isInserted)
                    Toast.makeText(MainActivity.this,"PATIENT RECORD INSERTED",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"INSERTION FAILURE",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,SecondPage.class);
                startActivity(intent);

            }
        });
    }


}
