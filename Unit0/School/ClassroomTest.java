package Unit0.School;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClassroomTest {
    private Classroom classroom;
    @BeforeEach
    public void setup() {
        this.classroom = new Classroom("Data Structures", 5, 5);
    }

    @Test
    public void testGetName() {
        assertEquals("Data Structures", this.classroom.getName());
    }
    @Test
    public void testAssignStudent() {
        Student s = new Student(12398, "Logan", 10);
        this.classroom.assignStudent(s, 0, 0);
        assertEquals(s, this.classroom.getStudent(0, 0));
        s = new Student(9781236, "Matthew", 11);
        this.classroom.assignStudent(s, 2, 4);
        assertEquals(s, this.classroom.getStudent(2, 4));
    }
    @Test
    public void testAddStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(12398, "Logan", 10));
        students.add(new Student(9781236, "Matthew", 11));
        students.add(new Student(892137, "Jack", 12));
        this.classroom.addStudents(students);
        assertEquals(3, classroom.getNumStudents());
        assertEquals(students.get(2), classroom.getStudent(4, 4));
        assertEquals(students.get(1), classroom.getStudent(4, 3));
        assertEquals(students.get(0), classroom.getStudent(4, 2));
    }
    @Test
    public void testGetStudents() {
        assertEquals(0, classroom.getNumStudents());
    }
    @Test
    public void testToString() {
        assertEquals("Name: Data Structures, Students: [[null, null, null, null, null], [null, null, null, null, null], [null, null, null, null, null], [null, null, null, null, null], [null, null, null, null, null]]", classroom.toString());
        List<Student> students = new ArrayList<>();
        students.add(new Student(12398, "Logan", 10));
        students.add(new Student(9781236, "Matthew", 11));
        students.add(new Student(892137, "Jack", 12));
        this.classroom.addStudents(students);
        assertEquals("Name: Data Structures, Students: [[null, null, null, null, null], [null, null, null, null, null], [null, null, null, null, null], [null, null, null, null, null], [null, null, id: 12398, name: Logan, grade: 10, id: 9781236, name: Matthew, grade: 11, id: 892137, name: Jack, grade: 12]]", classroom.toString());
    }
} 