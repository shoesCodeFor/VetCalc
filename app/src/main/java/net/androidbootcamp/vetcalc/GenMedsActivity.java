package net.androidbootcamp.vetcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class GenMedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_select);
        final Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        System.out.println(fido.getWeight());

        Spinner navSpinner = (Spinner) findViewById(R.id.navSpinner);
        navSpinner.setSelection(1);
    }
}
