package mini2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyStructureTest {
    static TechnicalLead CTO;
    static BusinessLead CFO;
    static Accountant actA;
    static SoftwareEngineer seA;
    static SoftwareEngineer seB;
    static  SoftwareEngineer seC;

    @BeforeAll
    static void setUp() {
        CTO = new TechnicalLead("Satya Nadella");
        seA = new SoftwareEngineer("Kasey");
        seB = new SoftwareEngineer("Breana");
        seC = new SoftwareEngineer("Eric");
        CTO.addReport(seA);
        CTO.addReport(seB);
        CTO.addReport(seC);

        CFO = new BusinessLead("Amy Hood");
        actA = new Accountant("Niky");
        CFO.addReport(actA, CTO);
    }

    @Test
    void testSoftwareEngineerCanCheckInCode() {
        seA.setCodeAccess(false);
        assertEquals(false, seA.getCodeAccess());

        seA.setCodeAccess(true);
        assertEquals(true, seA.getCodeAccess());
    }

    @Test
    void testAccountantCanApproveBonus() {
        assertFalse(actA.canApproveBonus(20000000));
        assertTrue(actA.canApproveBonus(1000));
    }


    @Test
    void testCanSoftwareEnginnerGetBonus() {
        assertEquals(false, CFO.approveBonus(seA, 2000000));
        assertEquals(true, CFO.approveBonus(seA, 1000));
    }

    @AfterAll
    static void tearDown() {
        CTO = null;
        seA = null;
        seB = null;
        seC =null;

        CFO = null;
        actA = new Accountant("Niky");
    }

}
