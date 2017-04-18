package net.androidbootcamp.vetcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class ERABCsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We will change this to parsable if speed becomes an issue
        Patient fido = (Patient) getIntent().getSerializableExtra("patientObj");
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



        TextView  emergencyMessage = (TextView) findViewById(R.id.patientData);
        emergencyMessage.setText(Double.toString(fido.getKilos()));
    }
}
