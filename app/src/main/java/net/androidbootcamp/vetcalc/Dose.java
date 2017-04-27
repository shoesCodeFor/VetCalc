package net.androidbootcamp.vetcalc;

import java.io.Serializable;

/**
 * Created by Shoe on 4/27/17.
 */

public class Dose implements Serializable {
    private String name = "";
    private double concentration = 0;
    private double [] range;
    private boolean admin = false;




    public Dose () {
        name = "";
        concentration = 0;

    }

    public Dose(String name, double concentration, double[] range){
        this.name = name;
        this.concentration = concentration;
        this.range = range;
    }

    public void giveDose(){
        admin = true;
    }





}
