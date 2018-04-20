package medicine;

import disease.Disease;
import gui.Log;

public class Medicine {
    private Disease disease = null;

    public Medicine(){
    }

    public Medicine(Disease disease){
        this.disease = disease;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public boolean checkMedicine(Disease disease){
        Log.log("Checking medicine...");
        return this.disease.equals(disease);
    }
}
