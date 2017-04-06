/*  Vet Calc - Version .01
    By Schuyler Ankele

    Main Activity - More Documentation will be provided on the project README.md

    1) This Activity will be used to collect patient data.  Namely the patient's weight.
    2) We will also have the user select units.
    3) All units will be converted to the metric system because medication
    dosages are given in mgs per kg.  This is done in the Patient class.
    4) The user will confirm this weight and advance to the next screen.

 */


package net.androidbootcamp.vetcalc;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {
    public boolean defClicked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Will load a savedInstanceState if applicable(We may want to kill this so it starts empty)
        super.onCreate(savedInstanceState);
        // Set the view to the first input screen
        setContentView(R.layout.activity_main);

        // We have to create a new Patient object before we can dump data into it
        final Patient fido = new Patient();
        final AppLogic tools = new AppLogic();

        // Bind the objects in this layout to variables
        final EditText patWt = (EditText) findViewById(R.id.patientWt);
        final RadioButton lbSelect = (RadioButton) findViewById(R.id.lbRadBtn);
        final RadioButton kgSelect = (RadioButton) findViewById(R.id.kgRadBtn);
        final TextView lbsVal = ((TextView) findViewById(R.id.lbVal));
        final TextView kgsVal = (TextView) findViewById(R.id.kgVal);
        final Button wtBtn = (Button) findViewById(R.id.weightBtn);

        // Check our buttons and wait for an event
        lbSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                defClicked = false;
            }
        });
        kgSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will catch a user mistake in case they click back and forth on these buttons
                defClicked = true;
            }
        });


        // Implicit listeners are easier to create
        // In JS we call these arrow functions ->
        wtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                fido.setWeight(Double.parseDouble(patWt.getText().toString()), defClicked);
                tools.postWtVals(fido.getKilos(), fido.getPounds(),
                                 lbSelect, kgSelect, lbsVal, kgsVal);
                // lbsVal.setText(Double.toString(weight));
            }
        });
        // This is a lock button - It will disable editing on the patient weight and change view
        final Button wtLock = (Button) findViewById(R.id.wtConf);
        wtLock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                launchNewAct(view, fido);
                // setContentView(R.layout.activity_meds);
            }
        });




    } // End onCreate

    public void launchNewAct(View view, Object o){
        Intent i;
        i = new Intent(this, MedsActivity.class);
        i.putExtra("patientObj", (Serializable) o);
        startActivity(i);

    }

} // End MainActivity


