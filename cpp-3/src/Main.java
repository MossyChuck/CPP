import disease.Angina;
import disease.Disease;
import disease.Flu;
import gui.Gui;
import human.Doctor;
import human.Patient;
import medicine.Medicine;

public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Petr", 32, "therapy");
        Patient patient = new Patient("Vasiliy", 21);
        Flu flu = new Flu(Disease.getRandomSymptoms(2));
        Angina angina = new Angina(Disease.getRandomSymptoms(3));
        patient.setMedicine(new Medicine(flu));
        Gui gui = new Gui();
        gui.build();
        gui.getAddFluButton().addActionListener(ActionListener -> {
            patient.setDisease(flu);
            flu.makeCough(patient);
        });
        gui.getAddAnginaButton().addActionListener(ActionListener -> {
            patient.setDisease(angina);
            angina.makeThroatAche(patient);
        });
        doctor.setPatient(patient);
        gui.setVisible(true);
    }
}
