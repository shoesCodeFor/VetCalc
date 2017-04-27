package net.androidbootcamp.vetcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ERMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ermeds);

        Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        Medications meds = new Medications();

        AppLogic tools = new AppLogic();
        String [] medList = new String[meds.erMedications.length];
        tools.fillMedList(meds.erMedications, medList);

        /** This spinner controls the Medication selected
         *
         */
        Spinner medSpinner = (Spinner) findViewById(R.id.medSelector);
        List<String> medVals = new ArrayList<String>(Arrays.asList(medList));
        ArrayAdapter<String> med_adp;
        med_adp= new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, medVals);
        med_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);// This is a preset value
        medSpinner.setAdapter(med_adp);
        /**
         * Navigation spinner to go to other activities
         *
         */
        Spinner navSpinner = (Spinner) findViewById(R.id.navSpinnerER);

        /**
         * Dosage Spinner - this is an array stored with concentration
         *
         * On dosage selection we will create a new Dose object
         * 
         */
        Spinner doseSpinner = (Spinner) findViewById(R.id.doseSpinner);
        // List<String> doseVals = new ArrayList<String>(Arrays.asList(doseList));
    }
}
