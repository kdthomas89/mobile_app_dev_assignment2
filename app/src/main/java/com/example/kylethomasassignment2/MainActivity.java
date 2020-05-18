/*
* This program is a program that will prompt the user to enter a number between 1 and 10
* The user can then press the count up or count down buttons and the program will increment their input
* up to a maximum of 10 or decrement their input to a minimum of 1
* */
package com.example.kylethomasassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables for the countUp and countDown methods
    int numUp = 0;
    int numDown = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method that checks whether the input is between 1 and 10
    public boolean numberValidation (int x){
        if (x <= 10 && x >=1){
            return true;
        }
        else {
            return false;
        }
    }

    //Initializes the number variable to be the value that the user inputs, then returns that value.
    public int setNumber (){
        int number = 0;
        EditText numberInput = findViewById(R.id.numberInput);
        try{
            number = Integer.parseInt(numberInput.getText().toString());
        } catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
        return number;
    }

    /*
    * On button press, these 2 method checks the input # for validation, then displays the sum of the input # and the counting # and iterates the counting #
    * on every press until it reaches 10 or 0.
    */
    public void countUp(View v) {
        if (numberValidation(setNumber()) == true){
            if (setNumber() + numUp > 0 && setNumber() + numUp <= 10) {
                Toast.makeText(this, "" + (setNumber() + numUp), Toast.LENGTH_SHORT).show();
                numUp++;
            }
        }
        else {
            Toast.makeText(this, "Please enter a valid number between 1 and 10.", Toast.LENGTH_SHORT).show();
        }
    }

    public void countDown(View v){
        Log.i("Info", "User pressed countDown");
        if (numberValidation(setNumber()) == true){
            if (setNumber()+ numDown > 0 && setNumber()+ numDown <= 10) {
                Toast.makeText(this, "" + (setNumber() + numDown), Toast.LENGTH_SHORT).show();
                numDown--;
            }
        }
        else {
            Toast.makeText(this, "Please enter a valid number between 1 and 10.", Toast.LENGTH_SHORT).show();
        }
    }
}
