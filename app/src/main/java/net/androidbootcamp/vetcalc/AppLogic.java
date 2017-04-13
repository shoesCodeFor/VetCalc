package net.androidbootcamp.vetcalc;

/**
 * Created by Shoe on 4/5/17.
 */
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DecimalFormat;

public class AppLogic implements Serializable{
    public static DecimalFormat wtFormat = new DecimalFormat("###,###.##");




    /*
     * @param postWtVals(double, double, RadioButton, RadioButton, TextView, TextView)
     *                   This method will post our calculated weights
     *                   onto the screen to check before calculating meds
     *  @
     */
    public static boolean postWtVals(double kg, double lb, RadioButton a, RadioButton b,
                                     TextView one, TextView two){
        /* Convert the value if necessary
           Weight will be set to kilograms
           Lbs/Kgs will be displayed for user confirmation
        */

        String lbsLabel = "Pounds: ";
        String kgsLabel = "Kilograms: ";
        lbsLabel += wtFormat.format(lb);
        kgsLabel += wtFormat.format(kg);

        // DecimalFormat wtFormat = new DecimalFormat("###,###.##");
        // In a basic context this will pass 0 or false
        if(a.isChecked()) {
            //  Pass false in our method for kilograms

            one.setText(lbsLabel);
            two.setText(kgsLabel);
        }
        // This will pass true
        else{
            // Leave the value as is, but post both values

            one.setText(lbsLabel);
            two.setText(kgsLabel);
        }

        return true;
    }
    public static void smartScroll(final ScrollView nameOfScrContainer, final View desiredPosition) {
        //Write your logic here.
        final ScrollView scrollView = nameOfScrContainer;
        scrollView.postDelayed(new Runnable() {
            public void run() {
                scrollView.scrollTo(0, (int)desiredPosition.getY());
            }
        }, 100);
    }



}
