package net.androidbootcamp.vetcalc;

import android.app.Application;

/**
    <h1>Medications Class - Medication Dosages will be derived from CSU Veterinary Teaching Hospital
    and the University of Cornell Veterinary Hospital.</h1><br><br>

    Storing this much sensitive data can be risky.  To prevent a DB attack most of our med dosages will
    be kept internally with this Class.  I will use a String Array of Arrays to store the data.
    We will then parse the data as needed.  (Doubles and Booleans)<br><br>

    Abbreviations of Note
    <ul>
         <li>
            IV - Intravenously  (Injection to the vein)
         </li>
         <li>
            IM - Intermuscular  (Injection to the muscle)
         </li>
         <li>
            SQ - Subcutaneous   (Injection between fat and muscle)
         </li>
         <li>
            PO - Per Os         (Medication given Orally)
         </li>




    </ul>


 */

public class Medications {

    /* This is the data arrangment for the multidimensional medications array
                    NameOfDrug, Concentration in mg/ml, dosageRange(vals in mg/kg - 4 cols 0s are blank), IV, IM */
    protected final String[][] erMedications =
            {       {"Atipamazole (IV)",
                            "5" , "0.05", "0.1", "0.15", "0.2", "true", "false"},          // 0
                    {"Atropine (IV)",
                            "0.54" , "0.01", "0.02", "", "", "true", "false" },               // 1
                    {"Dexamethasone SP (IV)",
                            "4","0.25","0.5", "1.0","2.0","true", "false"},        // 2
                    {"Diphenhydramine (IM, IV)",
                            "50", "1.0", "2.0", "3.0","4.0","true", "true"},     // 3
                    {"Epinephrine (IV)",
                            "1","0.01", "0.05", "0.1", "0.20", "true", "false"},             // 4
                    {"Flumazenil (IV)",
                            "0.1", "0.005", "0.01", "0.02", "0.04", "true", "false"},
                    {"Lidocaine (IV)",
                            "20" , "0.5","1.0","2.0", "","true","false"},// 5
                    {"Nalbuphine (IV)",
                            "10" , "0.50","0.75","1.0", "","true","false"},//6
                    {"Naloxone (IV)",
                            "0.4" , "0.001","0.005","0.01", "","true","false"}//7
            };


    } // end of Medication Class





