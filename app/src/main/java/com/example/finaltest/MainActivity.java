package com.example.finaltest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    Button book, findTotal;
    ListView LV;
    ImageView flagImage;
    TextView totalAmount,capital, quantity;
    SeekBar seekBar;
    Spinner spinner;


    ArrayList<details> data = new ArrayList<>();
    String countries [] = {"Canada","USA","England"};

    ArrayList<details> tempData = new ArrayList<>();

    public static double price = 0;
    public static String placeName = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findTotal = findViewById(R.id.findtotal);
        spinner = findViewById(R.id.spinner);
        book = findViewById(R.id.book);
        LV = findViewById(R.id.LV);
        flagImage = findViewById(R.id.flagImage);
        totalAmount = findViewById(R.id.totalAmount);
        capital = findViewById(R.id.capital);
        quantity = findViewById(R.id.quantity);
        seekBar = findViewById(R.id.seekBar);

        fillData();

        int imgId = getResources().getIdentifier(getFlageImage(countries[0]),"mipmap",getPackageName());
        flagImage.setImageResource(imgId);


        capital.setText(data.get(0).getCapitalName());

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,countries);
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(this);

        LV.setOnItemClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                quantity.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        findTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (price == 0) {
                    Toast.makeText(MainActivity.this, "Please Select A place", Toast.LENGTH_SHORT).show();
                }else {
                    int qty = Integer.parseInt(quantity.getText().toString());
                    double t = qty * price;
                    double percentage = 0.05 * price;
                    if (qty < 15) {
                        totalAmount.setText(String.format("%.2f", t));
                    } else {
                        totalAmount.setText(String.format("%.2f", t - percentage));
                    }
                }
            }
        });
        book.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (totalAmount.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Find The Total Amount", Toast.LENGTH_SHORT).show();
                }else {
                    price = 0;
                    alertMethod("Yeah!!!!", "Enjoy Your Holidays in" + placeName + "\nTotal amount = $" + totalAmount.getText().toString(), "Thank You");
                    quantity.setText(String.valueOf(0));
                    totalAmount.setText(String.valueOf(0));

                }
            }
        });


    }

    private void alertMethod(String title,String message , String button){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void fillData(){
        data.add(new details(countries[0],"Ottawa","canada","Niagara Falls","niagra",100));
        data.add(new details(countries[0],"Ottawa","canada","CN Tower","cntower",30));
        data.add(new details(countries[0],"Ottawa","canada","The Butchart Garden","butcher",30));
        data.add(new details(countries[0],"Ottawa","canada","Notre-Dame Basilica","notredame",50));

        data.add(new details(countries[1],"Washington","usa","The Statue Of Liberty","liberty",90));
        data.add(new details(countries[1],"Washington","usa","The White House","whitehouse",60));
        data.add(new details(countries[1],"Washington","usa","Times Square","time",75));

        data.add(new details(countries[2],"London","england","The Big Ben","bigben",30));
        data.add(new details(countries[2],"London","england","Westminster Abbey","west",25));
        data.add(new details(countries[2],"London","england","Hyde Park","hydepark",15));
    }

    public String getCapital(String cat){
        for (int i = 0; i<data.size(); i++){
            if (data.get(i).getCountryName().equals(cat)){
                return data.get(i).getCapitalName();
            }
        }
        return null;
    }

    public  String getFlageImage (String cat){
        for (int i = 0; i<data.size(); i++){
            if (data.get(i).getCountryName().equals(cat)){
                return data.get(i).getFlagImage();
            }
        }
        return null;
    }

    public void fillTempData(String country){
        for (int i = 0;i<data.size();i++){
            if (data.get(i).getCountryName().equals(country)){
                tempData.add(data.get(i));
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        capital.setText(getCapital(countries[position])); // setting capital name

        int imgId = getResources().getIdentifier(getFlageImage(countries[position]),"mipmap",getPackageName());
        flagImage.setImageResource(imgId);

        tempData.clear();
        fillTempData(countries[position]);

        LV.setAdapter(new placeListRow(tempData,this));



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        price = tempData.get(position).getPrice();
        placeName = tempData.get(position).getPlace();
        Toast.makeText(this, ""+tempData.get(position).getPlace()+" Selected", Toast.LENGTH_SHORT).show();
    }
}