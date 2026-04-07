import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    App app = new App();

    // ✅ Test Valid Patient
    @Test
    void testValidPatient() {
        Patient p = new Patient("1", "John Doe", 30, "Flu");
        assertTrue(app.addPatient(p));
    }

    // ❌ Missing Name
    @Test
    void testMissingName() {
        Patient p = new Patient("2", "", 25, "Cold");
        assertFalse(app.addPatient(p));
    }

    // ❌ Invalid Age
    @Test
    void testInvalidAge() {
        Patient p = new Patient("3", "Alice", -5, "Fever");
        assertFalse(app.addPatient(p));
    }

    // ❌ Missing Diagnosis
    @Test
    void testMissingDiagnosis() {
        Patient p = new Patient("4", "Bob", 40, "");
        assertFalse(app.addPatient(p));
    }

    // ✅ Retrieval Accuracy
    @Test
    void testRetrievePatient() {
        Patient p = new Patient("5", "Charlie", 28, "Cough");
        app.addPatient(p);

        Patient result = app.getPatient("5");

        assertNotNull(result);
        assertEquals("Charlie", result.getName());
        assertEquals(28, result.getAge());
    }

    // ❌ Retrieval Non-existing
    @Test
    void testRetrieveNonExisting() {
        Patient result = app.getPatient("999");
        assertNull(result);
    }
}