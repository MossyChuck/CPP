package disease;

import gui.Log;
import human.Patient;

public class Flu extends Disease {
    public Flu(){
        super();
    }

    public Flu(String[] symptoms){
        super(symptoms);
    }

    public void makeCough(Patient patient){
        Log.log("Making cough...");
        patient.checkMedicine(this);
    }
}
