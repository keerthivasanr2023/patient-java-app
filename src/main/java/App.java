import java.util.*;

class Patient {
    private String id;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String id, String name, int age, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
}

public class App {

    private Map<String, Patient> patientDB = new HashMap<>();

    // ✅ Add Patient with validation
    public boolean addPatient(Patient patient) {
        if (!validatePatient(patient)) {
            return false;
        }
        patientDB.put(patient.getId(), patient);
        return true;
    }

    // ✅ Validation Logic
    public boolean validatePatient(Patient patient) {
        if (patient == null) return false;

        if (patient.getId() == null || patient.getId().isEmpty())
            return false;

        if (patient.getName() == null || patient.getName().isEmpty())
            return false;

        if (patient.getAge() <= 0)
            return false;

        if (patient.getDiagnosis() == null || patient.getDiagnosis().isEmpty())
            return false;

        return true;
    }

    // ✅ Retrieve Patient
    public Patient getPatient(String id) {
        return patientDB.get(id);
    }

    // ✅ Get all patients
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patientDB.values());
    }
}