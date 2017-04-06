package net.androidbootcamp.vetcalc;

/*
 * The Patient Class will pass a patient object between our activities
 * Method derived from Android Documentation by Google
 * Intents - We will build our object in each Activity;
 */
import java.io.Serializable;


public class Patient implements Serializable {
    // Declare the variables
    private double weight;
    private double kg;
    private double pounds;
    private String species;
    private String name;

    // Patient constructor
    public Patient() {
        weight = -1;
        kg = -1;
        pounds = -1;
        species = "";
        name = "";
    }

    // If you overload the constructor I assume it in kg
    public Patient(double weight){
        setWeight(weight, true);
    }

    // And one more
    public Patient(double weight, String species, String name){
        setWeight(weight, true);
        this.species = species;
        this.name = name;
    }




    /* Initialize patient weight and store it as kilograms.
     * Boolean kfOrPound controls radio input
     * true = kilograms : false = pounds
     */
    public void setWeight(double a, boolean kgOrPounds) {
        if (kgOrPounds) {
            weight = a;
            kg = a;
            pounds = a * 2.204;
        } else {
            weight = a / 2.204;
            pounds = a;
            kg = weight;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    // getWeight() returns Patient the double weight as kilograms
    public double getWeight() {
        return weight;
    }

    // getPounds() returns Patient double weight as pounds
    public double getPounds() {
        return pounds;
    }

    //getKilos() returns Patient double weight as kilogams
    public double getKilos() {
        return kg;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

}
