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
                    NameOfDrug, mgPerKg, range, IV, Orally */
    final private String[][] erMedications =
            {{"Atipamazole (IV)", "0.00", "0.2", "true", "false"},          // 0
                    {"Atropine (IV)", "0.04"},               // 1
                    {"Dexamethasone SP (IV)"},        // 2
                    {"Diphenhydramine (IM, IV)"},     // 3
                    {"Epinephrine (IV)"},             // 4
                    {"Flumazenil (IV)"}               // 5
            };


    } // end of Medication Class





