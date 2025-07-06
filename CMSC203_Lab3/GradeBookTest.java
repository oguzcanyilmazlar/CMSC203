import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

    private GradeBook gradeBookOne;
    private GradeBook gradeBookTwo;

    @BeforeEach
    void setUp() throws Exception {
        gradeBookOne = new GradeBook(5);
        gradeBookOne.addScore(4.21);
        gradeBookOne.addScore(3.1415);
        gradeBookOne.addScore(100.0);
        gradeBookTwo = new GradeBook(5);
        gradeBookTwo.addScore(6.0);
        gradeBookTwo.addScore(98.0);
    }

    @AfterEach
    void tearDown() throws Exception {
        gradeBookOne = null;
        gradeBookTwo = null;
    }

    @Test
    void testAddScore() {
        assertTrue("4.21 3.1415 100.0".equals(gradeBookOne.toString()));
        assertEquals(3, gradeBookOne.getScoresSize());
        assertTrue("6.0 98.0".equals(gradeBookTwo.toString()));
        assertEquals(2, gradeBookTwo.getScoresSize());

    }

    @Test
    void testSum() {
        assertEquals(4.21 + 3.1415 + 100.0, gradeBookOne.sum(), 0.00001);
        assertEquals(6.0 + 98.0, gradeBookTwo.sum(), 0.00001);
    }

    @Test
    void minimum() {
        assertEquals(3.1415, gradeBookOne.minimum(), 0.00001);
        assertEquals(6.0, gradeBookTwo.minimum(), 0.00001);
    }

    @Test
    void finalScore() {
        assertEquals(4.21 + 100.0, gradeBookOne.finalScore(), 0.00001);
        assertEquals(98.0, gradeBookTwo.finalScore(), 0.00001);
    }
}
