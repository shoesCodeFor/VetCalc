package net.androidbootcamp.vetcalc;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *  Dose class is a single calculation of a medications.
 */

public class Dose implements Serializable {
    private String name = "";
    private double concentration = 0;
    private double [] range;
    private double doseStrength = 0;
    private double dosage = 0;
    private double amount = 0;
    private boolean admin = false; // means 'Administered'
    DecimalFormat decimalFormat = new DecimalFormat("###,###.##");



    public Dose () {
        name = "";
        concentration = 0;

    }

    /**
     *
     * @param name = is the name of the medication
     * @param concentration = is the concentration from the manufacturer
     * @param range = is the safe dosage range
     */
    public Dose(String name, double concentration, double[] range){
        this.name = name;
        this.concentration = concentration;
        this.range = range;
        this.doseStrength = 0;
    }

    public String getName(){
        return this.name;
    }

    public String getConcStr(){
        return  Double.toString(this.concentration);
    }

    public double getConc(){
        return this.concentration;
    }

    public void giveDose(){
        admin = true;
    }

    public void setRange(double [] range){
        this.range = range;
    }

    /**
     * Set the medication strength
     * @param position = ith place in the array or ranges
     */
    public void setSelectedStrength(int position){
        this.doseStrength = range[position];

    }

    public double getSelectedStrength(){
        return this.doseStrength;
    }


    public double [] getRange(){return this.range;}

    public String [] getRangeStr(){
        String [] rangeStr = new String[4];
        for(int i = 0; i < range.length; i ++){
            rangeStr[i] = Double.toString(range[i]);
        }
        return  rangeStr;
    }

    /**
     *
     * @param patientWeight = this will create the dose based on a selected strength and patient weight
     */
    public void setAmount(double patientWeight){
        this.dosage = patientWeight * doseStrength;
        this.amount = this.dosage / concentration;
    }

    /**
     * @return = The medication dosage formatted for the UI
     */
    public String getDosage(){
        return decimalFormat.format(this.dosage) + " mg";
    }

    /**
     * @return = The medication in ml formulated from the concentration (dosage/concentration)
     */
    public String getAmount(){
        return decimalFormat.format(this.amount) + " ml";
    }


}
