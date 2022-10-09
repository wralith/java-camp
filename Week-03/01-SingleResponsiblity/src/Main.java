import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Main {
    public static void main(String[] args) {
        PatientList patientList = new PatientList();
        PatientListManager patientListManager = new PatientListManager(patientList);

        Patient patient1 = new Patient(1, "Wra", "Flu");
        patientListManager.add(patient1);
        Patient patient2 = new Patient(2, "Josh", "Fever");
        patientListManager.add(patient2);

        System.out.println("List of patients and problems");
        patientListManager.printAllPatientNamesAndProblems();
    }
} 

class Patient {
    private int id;
    private String name;
    private String problem;

    public Patient(int id, String name, String problem) {
        this.id = id;
        this.name = name;
        this.problem = problem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }
}

// Dunno what i am doing, maybe replicating db in memory?
// TODO: Read about data structures: interfaces and implementations in Java
class PatientList {
    private List<Patient> patients = new ArrayList<>();

    public List<Patient> getPatients() {
        return patients;
    }

    public void add(Patient patient) {
        patients.add(patient);
    }

}

class PatientListManager {
    PatientList patientList;

    public PatientListManager(PatientList patientList) {
        this.patientList = patientList;
    }

    public void add(Patient patient) {
        System.out.printf("Patient with name: %s saved.%n", patient.getName());
        patientList.add(patient);
    }

    public void printAllPatientNamesAndProblems() {
        List<Patient> patients = patientList.getPatients();
        Iterator<Patient> iter = patients.iterator();
        while (iter.hasNext()) {
            Patient patient = iter.next();
            System.out.print("name: " + patient.getName());
            System.out.print(", ");
            System.out.print("problem: " + patient.getProblem());
            System.out.print("\n");
        }
    }
} 