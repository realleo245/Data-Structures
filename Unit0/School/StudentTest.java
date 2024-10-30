package Unit0.School;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void constructorTest() {
        Student s = new Student(37, "John", 11);
        
        assertEquals(37, s.getID());
        assertEquals("John", s.getName());
        assertEquals(11, s.getGrade());
    }
    @Test
    public void setNameTest() {
        Student s = new Student(37, "John", 11);

        assertEquals("John", s.getName());
        s.setName("Peter");
        assertEquals("Peter", s.getName());
    }
    @Test
    public void checkValidTest() {
        Student s = new Student(37, "John", 11);
        assertTrue(s.checkValid());
        s = new Student(-1, "Rio", 11);
        assertFalse(s.checkValid());
        s = new Student(23, null, 12);
        assertFalse(s.checkValid());
        s = new Student(20, "", 10);
        assertFalse(s.checkValid());
        s = new Student(11, "                ", 9);
        assertFalse(s.checkValid());
        s = new Student(11, "Hello", 8);
        assertFalse(s.checkValid());
        s = new Student(11, "Hello", 15);
        assertFalse(s.checkValid());
    }
    @Test
    public void testToString() {
        Student s = new Student(37, "John", 11);        
        assertEquals("id: 37, name: John, grade: 11", s.toString());
    }
}
