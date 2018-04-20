package disease;

import gui.Log;
import human.Patient;

public class Angina extends Disease {
    public Angina(){
        super();
    }

    public Angina(String[] symptoms){
        super(symptoms);
    }

    public void makeThroatAche(Patient patient){
        Log.log("Making throat ache...");
        patient.checkMedicine(this);
    }
}
