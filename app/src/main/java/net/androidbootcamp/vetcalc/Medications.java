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

    /** Data structure for medications arrays
     NameOfDrug, Concentration in mg/ml, dosageRange(vals in mg/kg - min to max), IV, IM */






    protected final String[][] erMedications =
            {       {"Atipamazole (IV)",
                            "5" , "0.05", "0.1", "0.15", "0.2", "true", "false"},          // 0
                    {"Atropine (IV)",
                            "0.54" , "0.01", "0.0125", ".015", ".02", "true", "false" },            // 1
                    {"Dexamethasone SP (IV)",
                            "4","0.25","0.5", "1.0","2.0","true", "false"},        // 2
                    {"Diphenhydramine (IM, IV)",
                            "50", "1.0", "2.0", "3.0","4.0","true", "true"},     // 3
                    {"Epinephrine (IV)",
                            "1","0.01", "0.05", "0.1", "0.20", "true", "false"},             // 4
                    {"Flumazenil (IV)",
                            "0.1", "0.005", "0.01", "0.02", "0.04", "true", "false"},
                    {"Lidocaine (IV)",
                            "20" , "0.5","1.0", "1.5" ,"2.0","true","false"},   // 5 added value[3] 1.5
                    {"Nalbuphine (IV)",
                            "10" , "0.50","0.6",".8", "1.0","true","false"},//6
                    {"Naloxone (IV)",
                            "0.4" , "0.001","0.025", "0.005","0.01","true","false"}//7
            };


    protected final String [] [] genMedications = {
            {"Acepromazine (IM, SQ)","10.0","0.01", "0.02", "0.03", "0.04", "0.05", "0.10"},
            {"Atropine (IM, SQ)",	"0.54", "0.02", "0.024", "0.032", "0.036", "0.04"},
            {"Buprenorphine (IM, SQ, IV)", "0.6", "0.005", "0.01", "0.015", "0.02", "0.025","0.03"},
            {"Butorphanol (IM, SQ, IV)", "10.0", "0.10", "0.20", "0.25" , "0.30", "0.35",  "0.40"},
            {"Dexmedetomidine (IM, SQ)","0.5", "0.0025", "0.005", "0.01", "0.015", "0.02", "0.025"},
            {"Diazepam/Midazolam (SQ,IM, IV)", "5.0", "0.1", "0.125", "0.15", "0.175", "0.2"},
            {"Etomidate (IV)", "2.0", "0.33", "0.66", "1.0", "1.33", "1.66", "2.0"},
            {"Fentanyl (IV)", "0.05","0.005","0.006", "0.007", "0.008", "0.009", "0.01"},
            {"Glycopyrrolate (IM, SQ)",	"0.2",	"0.005","0.0075", "0.01","0.0125", "0.015", "0.02"},
            {"Hydromorphone (IM, SQ)","2.0", "0.01", "0.02", "0.05", "0.10", "0.15", "0.20"},
            {"Ketamine (IV)", "100", "2.0", "3.33" , "5.0", "6.67","7.5", "10.0"},
            {"Methadone (IM, SQ)",	"10", "0.10", "0.30", "0.5", "0.7", "0.85", "1.00"},
            {"Morphine (IM, SQ)","15","0.1","0.2", "0.3", "0.4", "0.5", "1.0"},
            {"Propofol (IV)", "10", "4.0", "5.0", "5.5", "6.0", "7.0","8.0"}

    };


    } // end of Medication Class





