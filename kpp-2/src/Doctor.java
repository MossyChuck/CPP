import java.util.ArrayList;

public class Doctor extends Human {
    private String speciality;
    private Patient patient;
    private Log log;

    public void setLog(Log log) {
        this.log = log;
    }

    public void diagnose() {
        //System.out.println("Doctor " + this.name + " diagnose");
        log.log("Doctor " + this.name + " diagnose");
        if (patient.getDisease() == null) {
            log.log("No diseases, " + patient.getName() + " healthy");
            return;
        }

        log.log("Doctor diagnosed disease");
        heal();

    }

    public void heal() {
        log.log("Start healing");
        String symptoms = "";
        for (String symptom : patient.getDisease().getSymptoms()) {
            symptoms += symptom + " ";
        }
        if (!symptoms.equals("")) {
            log.log("Healed symptoms: " + symptoms);
        }
        patient.removeDisease();
        log.log("Patient healthy");
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
