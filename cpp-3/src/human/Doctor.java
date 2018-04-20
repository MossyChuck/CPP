package human;

import gui.Log;
import java.util.ArrayList;

public class Doctor extends Human {
    private String speciality;
    private Patient patient;

    public void diagnose() {
        Log.log("Doctor " + this.name + " diagnose");
        if (patient.isHealthy()) {
            Log.log("No diseases, " + patient.getName() + " healthy");
            return;
        }

        Log.log("Doctor diagnosed disease");
        heal();
    }

    public void heal() {
        Log.log("Start healing");
        String symptoms = "";
        for (String symptom : patient.getDisease().getSymptoms()) {
            symptoms += symptom + " ";
        }
        if (!symptoms.equals("")) {
            Log.log("Healed symptoms: " + symptoms);
        }
        patient.removeDisease();
        Log.log("Patient healthy");
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Doctor() {
        super();
        this.speciality = "";
    }

    public Doctor(String name, int age, String speciality) {
        super(name, age);
        this.speciality = speciality;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public void setPatient(Patient patient) {
        patient.setDoctor(this);
        this.patient = patient;
    }
}
