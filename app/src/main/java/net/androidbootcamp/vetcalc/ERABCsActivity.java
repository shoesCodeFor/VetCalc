package net.androidbootcamp.vetcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;

public class ERABCsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We will change this to parsable if speed becomes an issue
        final Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        setContentView(R.layout.activity_er_abc);
        final AppLogic tools = new AppLogic();

        // Create variables for the elements within the view
        final TextView abcJump = (TextView) findViewById(R.id.abcJumper);
        final TextView advThree = (TextView) findViewById(R.id.adv3);
        final ScrollView erScroll = (ScrollView) findViewById(R.id.erContainer);
        abcJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tools.smartScroll(erScroll, advThree);

            }
        });

        Spinner navSpinner = (Spinner) findViewById(R.id.flowSelect);
        ArrayAdapter<String> nav_adp;
        nav_adp = new ArrayAdapter<>(this, R.layout.simple_spinner_nav, getResources().getStringArray(R.array.flow));
        // was simple_dropdown_item_1line
        // med_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);// This is a preset value
        navSpinner.setAdapter(nav_adp);
        navSpinner.setSelection(3);
        navSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 1) {
                    launchER(fido);
                }
                if (position == 0) {
                    goHome(fido);
                }
                if (position == 2) {
                    launchGen(fido);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void launchER(Object o){
        Intent i;
        i = new Intent(this, ERMedsActivity.class);
        i.putExtra("patientObj", (Serializable) o);
        startActivity(i);
    }
    public void launchGen(Object o){
        Intent i;
        i = new Intent(this, GenMedsActivity.class);
        i.putExtra("patientObj", (Serializable) o);
        startActivity(i);
    }
    public void goHome(Object o){
        Intent i;
        i = new Intent(this, MainActivity.class);
        i.putExtra("patientObj", (Serializable) o);
        startActivity(i);
    }

}
