public class Main {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Doctor", 32, "therapy");
        Patient patient = new Patient("Patient", 21);
        Gui gui = new Gui();
        gui.build();
        gui.getComplainButton().addActionListener(ActionListener -> patient.complain());
        gui.getAddDiseaseButton().addActionListener(ActionListener -> patient.setDisease(new Disease(Disease.getRandomSymptoms(2))));
        patient.setLog(gui.getLog());
        doctor.setLog(gui.getLog());
        doctor.setPatient(patient);
        gui.setVisible(true);
    }
}
