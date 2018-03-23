import java.util.ArrayList;

public class Disease {
    private ArrayList<String> symptoms;

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<String> symptoms) {
        this.symptoms = symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        for (String symptom : symptoms) {
            this.symptoms.add(symptom);
        }
    }

    public Disease() {
        this.symptoms = new ArrayList<>();
    }

    public Disease(String[] symptoms) {
        this.symptoms = new ArrayList<>();
        for (String symptom : symptoms) {
            this.symptoms.add(symptom);
        }
    }

    public Disease(ArrayList<String> symptoms) {
        this.symptoms = symptoms;
    }

    public static String[] getRandomSymptoms(int number) {
        String[] symptoms = {"'headache'", "'stomach ache'", "'throat ache'", "'dizziness'", "'nausea'"};
        String[] result = new String[number];
        while (--number >= 0) {
            int index = (int) Math.floor((float) (Math.random() * symptoms.length));
            result[number] = symptoms[index];
        }

        return result;
    }
}
