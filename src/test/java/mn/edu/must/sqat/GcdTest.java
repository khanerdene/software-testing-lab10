package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {

    @Test
    @DisplayName("gcd(7, 0) covers 13 to 15F and 20")
    void gcdWithZeroSecondArgument() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd(12, 6) covers loop pairs 13, 16, 17, 18")
    void gcdWithOneIteration() {
        assertEquals(12, DataFlowTargets.gcd(12, 8));
    }

    @Test
    @DisplayName("gcd(12, 8) covers repeated loop pairs")
    void gcdWithTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(30, 18));
    }
}
