package net.androidbootcamp.vetcalc;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *   AppLogic Class contains miscellaneous tools for the VetCalc App.
 */
public class AppLogic implements Serializable{
    public static DecimalFormat wtFormat = new DecimalFormat("###,###.##");


    /**
     *  This method will post our calculated weights
     *  onto the screen to check before calculating meds
     *  We can refactor this - it does too much
     * @param kg = the patient weight entered in KG
     * @param lb
     * @param a
     * @param b
     * @param one
     * @param two
     * @return
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

    /**
     *
     * @param nameOfScrContainer = This id is the name of your ScrollContainer
     * @param desiredPosition = The desired position is the id you would like to jump to
     */
    public static void smartScroll(final ScrollView nameOfScrContainer, final View desiredPosition) {
        //Write your logic here.
        final ScrollView scrollView = nameOfScrContainer;
        scrollView.postDelayed(new Runnable() {
            public void run() {
                scrollView.scrollTo(0, (int)desiredPosition.getY());
            }
        }, 100);

    }

    /**
     *
     * @param in is an array of String arrays.  For this method we only need the name (position 0).
     * @param out is the array we want to fill with names of medications
     */

    public static void fillList(String[][] in, String [] out){
        for(int i =0; i < in.length; i++){
            out[i] = in[i][0];
        }
    }




}
