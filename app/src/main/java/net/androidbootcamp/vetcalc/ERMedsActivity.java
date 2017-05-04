package net.androidbootcamp.vetcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ERMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ermeds);

        final Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        final Medications meds = new Medications();

        final AppLogic tools = new AppLogic();
        final String [] medList = new String[meds.erMedications.length];
        final String [] doseRangeLbl = new String[4];
        Arrays.fill(doseRangeLbl, " ");
        doseRangeLbl[0] = "(Min-Max)";
        tools.fillMedList(meds.erMedications, medList);

        /**
         * Medication Dosage and Details
         *
         */
        final TextView medName = (TextView) findViewById(R.id.medName);
        final TextView medConc = (TextView) findViewById(R.id.medConc);
        final TextView medSum = (TextView) findViewById(R.id.dosageSum);
        final TextView dosageDet = (TextView) findViewById(R.id.dosageDet);
        /**
         * Dosage Spinner - this is an array stored with concentration
         *
         * On dosage selection we will create a new Dose object
         *
         */
        final Spinner doseSpinner = (Spinner) findViewById(R.id.doseSpinner);
        final List<String> doseVals = new ArrayList<String>(Arrays.asList(doseRangeLbl));
        ArrayAdapter<String> dose_adp;
        dose_adp = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, doseVals);
        dose_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        doseSpinner.setAdapter(dose_adp);

        /** This spinner controls the Medication selected
         *
         *
         */
        final Spinner medSpinner = (Spinner) findViewById(R.id.medSelector);
        final List<String> medVals = new ArrayList<String>(Arrays.asList(medList));
        ArrayAdapter<String> med_adp;
        med_adp= new ArrayAdapter<>(this, R.layout.simple_spinner_meds, medVals);
        // was simple_dropdown_item_1line
        // med_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);// This is a preset value
        medSpinner.setAdapter(med_adp);
        medSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                double [] tempRange = new double[4];
                tools.getDoseRange(meds.erMedications, position, tempRange);
                final Dose oneDose = new Dose(
                        medList[position],
                        Double.parseDouble(meds.erMedications[position][1]),
                        tempRange
                );
                System.out.println(position);
                medName.setText(oneDose.getName());
                medConc.setText(oneDose.getConcStr());
                doseSpinner.setSelection(0);
                tools.convertForList(oneDose.getRange(),doseVals);
                doseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oneDose.setSelectedStrength(position);
                        System.out.println(oneDose.getSelectedStrength());
                        String sumMessage = "Dosage strength selected(" + oneDose.getSelectedStrength() + "mg/kg) " +
                                            "\nPatient weight = " + fido.getWeight() + "kg" ;
                        String doseMessage = "Calculated dose is " + (fido.getWeight()* oneDose.getSelectedStrength()) + "mg\n"+
                                             "The dosage to administer is " + ((fido.getWeight()* oneDose.getSelectedStrength())/oneDose.getConc()) + "ml";
                        medSum.setText( sumMessage );
                        dosageDet.setText( doseMessage );
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Add some hints on the fields below


            }

        });
        /**
         * Navigation spinner to go to other activities
         *
         */
        Spinner navSpinner = (Spinner) findViewById(R.id.navSpinnerER);
        ArrayAdapter<String> nav_adp;
        nav_adp= new ArrayAdapter<>(this, R.layout.simple_spinner_nav, getResources().getStringArray(R.array.flow));
        // was simple_dropdown_item_1line
        // med_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);// This is a preset value
        navSpinner.setAdapter(nav_adp);
        navSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    }
}
