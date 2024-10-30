package Unit0.Mountains.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import Unit0.Mountains.Mountains;

public class MountainsTest {
    @Test
    public void isValidTest() {
        Mountains mountains = new Mountains();
        assertTrue(mountains.isValid("Australia	Mountain	Mount Fitch	-12.9584737167229	130.956172943115	99"));
        assertFalse(mountains.isValid("Ecuador	Mountain	Genovesa	??????	??????	64 m"));
    }
    @Test
    public void testNumRecords() {
        Mountains mountains = new Mountains();
        mountains.isValid("Kosovo	Mountain	Đeravica	42.5314998	20.1394535	2656 m");
        assertEquals(1, mountains.getNumRecords());
        assertEquals(1, mountains.getCleanRecords());
        assertEquals(0, mountains.getCorruptRecords());
    }
    @Test
    public void testElevations() {
        Mountains mountains = new Mountains();
        mountains.isValid("Kosovo	Mountain	Đeravica	42.5314998	20.1394535	2656 m");
        mountains.isValid("Australia	Mountain	Mount Lookout	-16.6630818115759	128.013553619385	270");
        mountains.isValid("Australia	Mountain	Drayson Peak	-15.2385601789789	128.155517578125	233");
        assertEquals(2656, mountains.getTallestMountainElevation());
        assertEquals(233, mountains.getShortestMountainElevation());
    }
}
