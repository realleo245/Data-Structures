package Unit0.Mountains.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import Unit0.Mountains.Mountain;

public class MountainTest {
    @Test
    public void constructorTest() {
        Mountain mountain = new Mountain("United States\tMountain\tMount Terror\t48.7714644260203\t-121.294813156128\t2484 m");
        assertEquals("United States", mountain.getCountry());
        assertEquals("Mountain", mountain.getType());
        assertEquals("Mount Terror", mountain.getName());
        assertEquals(48.7714644260203, mountain.getLatitude());
        assertEquals(-121.294813156128, mountain.getLongitude());
        assertEquals(2484, mountain.getElevation());
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            Mountain m = new Mountain("United States\tVolcano Glacier Peak\t48.1117294268656	-121.113023757935	3213 m");
        });
    }
}