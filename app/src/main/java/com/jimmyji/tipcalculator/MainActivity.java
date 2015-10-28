package com.jimmyji.tipcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    public final static String RESULT_BILL = "result bill";
    public final static String RESULT_SPLIT = "result split";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void evaluate(View view) {
        //get all the values from edit text input
        EditText totalBill = (EditText) findViewById(R.id.editText);
        EditText totalPercent = (EditText) findViewById(R.id.editText2);
        EditText totalPeople = (EditText) findViewById(R.id.editText3);

        //change them to doubles
        double billCalc = Double.parseDouble(totalBill.getText().toString());
        double percentCalc = (Double.parseDouble(totalPercent.getText().toString())/100)+ 1.0;
        double peopleCalc = Double.parseDouble(totalPeople.getText().toString());

        //calculate results
        double finalBill = billCalc*percentCalc;
        double finalSplit = finalBill/peopleCalc;

        //pass them to a new activity
        Intent intent = new Intent(this, Result.class);
        intent.getDoubleExtra(RESULT_BILL, finalBill);
        intent.getDoubleExtra(RESULT_SPLIT, finalSplit);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
