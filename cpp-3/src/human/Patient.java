package human;

import disease.Angina;
import disease.Disease;
import disease.Flu;
import gui.Log;
import human.Doctor;
import human.Human;
import medicine.Medicine;

public class Patient extends Human {

    private Disease disease;
    private Doctor doctor;
    private Medicine medicine;
    private boolean lunghHealth = true;
    private boolean throatHealth = true;
    private boolean health = true;

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Medicine getMedicine() {
        return this.medicine;
    }

    public Patient() {
        super();
        this.disease = null;
        this.doctor = null;
    }

    public Patient(String name, int age, Doctor doctor) {
        super(name, age);
        this.doctor = doctor;
        this.disease = null;
    }

    public Patient(String name, int age) {
        super(name, age);
        this.doctor = null;
        this.disease = null;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        if(disease == null){
            Log.log("Disease not added");
            return;
        }
        Log.log("Disease added");
        if(disease instanceof Angina){
            throatHealth = false;
        }else if(disease instanceof Flu){
            lunghHealth = false;
        }
        health = false;
        this.disease = disease;
    }

    public void complain() {
        Log.log(this.name + " complain");
        if (this.doctor == null) {
            Log.log("No doctor!");
            return;
        }
        doctor.diagnose();
    }

    public void removeDisease() {
        Log.log("Disease removed");
        lunghHealth = throatHealth = health = true;
        this.disease = null;
    }

    public boolean isHealthy(){
        return this.health;
    }

    private void takeMedicine(){
        this.removeDisease();
    }

    public void checkMedicine(Disease disease){
        if(medicine.checkMedicine(disease)){
            Log.log("Medicine is good");
            this.takeMedicine();

        }else{
            Log.log("Medicine is bad");
            this.complain();
        }
    }

}
