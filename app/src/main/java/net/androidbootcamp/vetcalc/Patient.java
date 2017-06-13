package net.androidbootcamp.vetcalc;

/**
 * The Patient Class will pass a patient object between our activities
 * Method derived from Android Documentation by Google
 * Intents - We will build our object in each Activity;
 */
import java.io.Serializable;

/**
 *   Patient Class is serializable so that we can pass it between Activities
 */
public class Patient implements Serializable {
    // Declare the variables
    private double weight;
    private double kg;
    private double pounds;
    private String species;
    private String name;

    /**
     *
     */
    public Patient() {
        weight = -1;
        kg = -1;
        pounds = -1;
        species = "";
        name = "";
    }

    /**
     *
     * @param weight = simple contructor when only weight in kg is specified
     */
    public Patient(double weight){
        setWeight(weight, true);
    }

    /**
     *
     * @param weight = patient weight in kilograms
     * @param species = Canine or Feline
     * @param name = Patient Name for the log file
     */
    public Patient(double weight, String species, String name){
        setWeight(weight, true);
        this.species = species;
        this.name = name;
    }


    /**
     *
     * @param a = weight in kilograms
     * @param kgOrPounds = the users weight units preference
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

    /**
     * @param name = Patient's name as a String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param species = Patient species (Feline or Canine only for now)
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     *
     * @return = Patient the double weight as kilograms
     */
    public double getWeight() {
        return weight;
    }

    /**
      * @return = Patient double weight as pounds
     */
    public double getPounds() {
        return pounds;
    }

    /**
     *
     * @return = Patient double weight as kilogams
     */
    public double getKilos() {
        return kg;
    }

    /**
     *
     * @return = Patient name as a string
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return = The patient species in a String
     */
    public String getSpecies() {
        return species;
    }

}
