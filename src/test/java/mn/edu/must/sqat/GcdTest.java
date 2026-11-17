package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GcdTest {

    @Test
    @DisplayName("gcd(7, 0) covers 13->15F->20")
    void gcdWithZeroSecondArgument() {
        assertEquals(7, DataFlowTargets.gcd(7, 0));
    }

    @Test
    @DisplayName("gcd(12, 6) covers loop pairs with 16, 17, 18")
    void gcdWithOneIteration() {
        assertEquals(6, DataFlowTargets.gcd(12, 6));
    }

    @Test
    @DisplayName("gcd(12, 8) covers repeated loop pairs (18->15T)")
    void gcdWithTwoIterations() {
        assertEquals(4, DataFlowTargets.gcd(12, 8));
    }
}
