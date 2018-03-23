import java.util.ArrayList;

public class Patient extends Human {

    private Disease disease;
    private Doctor doctor;
    private Log log;

    public void setLog(Log log) {
        this.log = log;
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
        log.log("Disease added");
        this.disease = disease;
    }

    public void complain() {
        log.log(this.name + " complain");
        if (this.doctor == null) {
            log.log("No doctor!");
            return;
        }
        doctor.diagnose();
    }

    public void removeDisease() {
        this.disease = null;
    }

}
