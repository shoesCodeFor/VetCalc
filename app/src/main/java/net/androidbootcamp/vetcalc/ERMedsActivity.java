package net.androidbootcamp.vetcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ERMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_select);

        /**
         *  Create programming objects for this activity
         */
        final Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        final Medications meds = new Medications();
        final AppLogic tools = new AppLogic();

        /**
         *  Create some dummy variables to hold our medication attributes before creating
         *  them as a Dose object
         */
        final String [] medList = new String[meds.erMedications.length];
        final String [] doseRangeLbl = new String[4];
        Arrays.fill(doseRangeLbl, " ");
        doseRangeLbl[0] = "(Min-Max)";
        final double [] tempRange = new double[4];

        // Fill our Spinner with medications
        tools.fillMedList(meds.erMedications, medList);

        /**
         * Create variables for all our TextView elements in this activity
        */
        final TextView medConc = (TextView) findViewById(R.id.medConc);
        final TextView wtLabel = (TextView) findViewById(R.id.weightLbl);
        final TextView dosageStr = (TextView) findViewById(R.id.strValue);
        final TextView calcedDose = (TextView) findViewById(R.id.calcDoseVal);
        final TextView medSum = (TextView) findViewById(R.id.adminVal);

        /**
         * Dosage Spinner - this is an array stored with dosage strengths
         *
         * On medication selection we bind the associated dose range to this Spinner
         * On doseSpinner selection we initialize the value selected to the Dose object
         *
         */
        final Spinner doseSpinner = (Spinner) findViewById(R.id.doseSpinner);
        final List<String> doseVals = new ArrayList<String>(Arrays.asList(doseRangeLbl));
        final ArrayAdapter<String> dose_adp;
        dose_adp = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, doseVals);
        dose_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        doseSpinner.setAdapter(dose_adp);

        /** Medication Spinner -
         *  On itemSelected we will create a new Dose object and wait for the user to select a
         *  dosage strength (doseSpinner)
         *
         *  On medication change the position in the doseSpinner
         *  is applied to the new dosage strengths(same array position)
         */

        final Spinner medSpinner = (Spinner) findViewById(R.id.medSelector);
        final List<String> medVals = new ArrayList<String>(Arrays.asList(medList));
        ArrayAdapter<String> med_adp;
        // Bind the med values to the Spinner and force our layout
        med_adp= new ArrayAdapter<>(this, R.layout.simple_spinner_meds, medVals);
        medSpinner.setAdapter(med_adp);
        medSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the range and hold it
                tools.getDoseRange(meds.erMedications, position, tempRange);

                // Build a new Dose object and initialize (name, concentration and range)
                final Dose oneDose = new Dose(
                        medList[position],
                        Double.parseDouble(meds.erMedications[position][1]),
                        tempRange
                );
                // Default labels before strength selection
                dosageStr.setText( "NA" );
                calcedDose.setText( "NA" );
                medSum.setText( "NA" );
                medConc.setText(oneDose.getConcStr());

                // Bind medication range to the doseVals list
                tools.convertForList(oneDose.getRange(),doseVals);
                // Notify the adapter of changes
                dose_adp.notifyDataSetChanged();

                // Probably don't need this
                if(!doseSpinner.isSelected()){
                    doseSpinner.setSelection(0);
                }

                /**
                 *  doseSpinner Listener -
                 *  we wait for a value to be selected and the perform our calculations
                 */
                doseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        oneDose.setSelectedStrength(position);
                        oneDose.setAmount( fido.getWeight() );
                        wtLabel.setText(fido.getWeight() + " kg");
                        dosageStr.setText( oneDose.getSelectedStrength() + "mg/kg");
                        calcedDose.setText( oneDose.getDosage() );
                        medSum.setText( oneDose.getAmount() );

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
        Spinner navSpinner = (Spinner) findViewById(R.id.navSpinner);
        ArrayAdapter<String> nav_adp;
        nav_adp= new ArrayAdapter<>(this, R.layout.simple_spinner_nav, getResources().getStringArray(R.array.flow));
        // was simple_dropdown_item_1line
        // med_adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);// This is a preset value
        navSpinner.setAdapter(nav_adp);
        navSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position ==1 ){
                    launchNewAct(view, fido);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });






    } // End of onCreate

    public void launchNewAct(View view, Object o){
        Intent i;
        i = new Intent(this, GenMedsActivity.class);
        i.putExtra("patientObj", (Serializable) o);
        startActivity(i);

    }
}  // End of Class
