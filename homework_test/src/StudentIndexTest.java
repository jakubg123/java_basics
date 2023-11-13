import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class StudentIndexTest {

    private StudentIndex student;

    @BeforeEach
    public void setUp() {
        student = new StudentIndex("Kowalski", 5);
    }

    @Test
    public void testInsertMarks() {
        String input = "3\n4\n5\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> insertedMarks = student.insertMarks(new Scanner(System.in));
        assertEquals(Arrays.asList(4, 5, 3), insertedMarks);
    }


    @Test
    public void testMaxMark() {
        student.insertMarks(new Scanner("3\n4\n5\n3\n"));
        assertEquals(5, student.maxMark());
    }

    @Test
    public void testAddGrades() throws StudentMarkException {
        List<Integer> gradesToAdd = Arrays.asList(4, 5, 3);
        student.addGrades(gradesToAdd);
        assertEquals(gradesToAdd, student.insertMarks(new Scanner("3\n4\n5\n3\n")));
    }

    @Test
    public void testCalculateAvg() {
        student.insertMarks(new Scanner("3\n4\n5\n3\n"));
        assertEquals(3.75, student.calculateAvg(), 0.01);
    }

}