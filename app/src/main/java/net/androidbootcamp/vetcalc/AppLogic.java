package net.androidbootcamp.vetcalc;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 *   AppLogic Class contains miscellaneous tools for the VetCalc App.
 */
public class AppLogic implements Serializable{
    public static DecimalFormat decimalFormat = new DecimalFormat("###,###.##");


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
        lbsLabel += decimalFormat.format(lb);
        kgsLabel += decimalFormat.format(kg);

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

    public static void fillMedList(String[][] in, String [] out){
        for(int i =0; i < in.length; i++){
            out[i] = in[i][0];
        }
    }
    /**
     *
     * @param in is an array of String arrays.  For this method we only need the name (position 0).
     * @param i is the position of the Medication indicated by the 'medSpinner'
     * @param out is the array we want to fill with a dosage range and concentration
     *
     */

    public static void getDoseRange(String[][] in, int i, double [] out){
        /** Our data in the Medication goes like this
         * Inputs:
         * 0 = Name
         * 1 = Concentration (out[0])
         * 2 = Min Range
         * 5 = Max Range
         *
         * Outputs:
         * 0 = Concentration
         * 1 = Min Dosage
         * 4 = Max Dosage
         * */

        out[0] = Double.parseDouble(in[i][2]); // Gets Min Dosage Med at position i
        out[1] = Double.parseDouble(in[i][3]); // Gets Dosage 2/4 of Med at position i
        out[2] = Double.parseDouble(in[i][4]); // Gets Dosage 3/4 of Med at position i
        out[3] = Double.parseDouble(in[i][5]); // Gets Max Dosage of Med at position i

    }
    public static void getDoseRangeLg(String[][] in, int i, double [] out){
        /** Our data in the Medication goes like this
         * Inputs:
         * 0 = Name
         * 1 = Concentration (out[0])
         * 2 = Min Range
         * 5 = Max Range
         *
         * Outputs:
         * 0 = Concentration
         * 1 = Min Dosage
         * 4 = Max Dosage
         * */

        out[0] = Double.parseDouble(in[i][2]); // Gets Min Dosage Med at position i
        out[1] = Double.parseDouble(in[i][3]);
        out[2] = Double.parseDouble(in[i][4]);
        out[3] = Double.parseDouble(in[i][5]); //
        out[4] = Double.parseDouble(in[i][6]);
        out[5] = Double.parseDouble(in[i][7]); // Gets Max Dosage of Med at position i

    }

    public static String getMedName(String [][] in, int i){
        return in[i][0];

    }

    public static void convertForList(double [] in, List<String> out){
        for(int i = 0; i < in.length; i++){
            out.set(i, Double.toString(in[i]));
        }

    }

    public String decFrom(double a){
        return decimalFormat.format(a);
    }


} // End of AppLogic Class
