package net.androidbootcamp.vetcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
        setContentView(R.layout.activity_meds);
        // We're ready to rock :)








        TextView  emergencyMessage = (TextView) findViewById(R.id.globalTest);
        emergencyMessage.setText(Double.toString(fido.getKilos()));
    }
}
