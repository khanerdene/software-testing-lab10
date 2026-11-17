package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusTest {

    @Test
    @DisplayName("empty attendance, covers 49 to 56")
    void emptyAttendanceDoesNotMeetPositiveThreshold() {
        assertEquals(0, DataFlowTargets.bonus(new int[0], 1));
    }

    @Test
    @DisplayName("absent then present, covers 46 to 41")
    void absenceResetsStreakBeforeAttendance() {
        assertEquals(5, DataFlowTargets.bonus(new int[]{0, 1}, 1));
    }

    @Test
    @DisplayName("5 in a row for bonus, covers 54 to 56")
    void fiveConsecutiveDaysEarnStreakReward() {
        assertEquals(3, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 6));
    }

    @Test
    @DisplayName("threshold of 0 covers empty array")
    void zeroThresholdRewardsEmptyAttendance() {
        assertEquals(5, DataFlowTargets.bonus(new int[0], 0));
    }//

    @Test
    @DisplayName("streak bonus and threshold bonus")
    void mixedAttendanceWithBothRewards() {
        assertEquals(8, DataFlowTargets.bonus(new int[]{1, 1, 1, 1, 1}, 5));
    }//

    @Test
    @DisplayName("breaking streak gives no reward")
    void shorterRunsDoNotEarnStreakReward() {
        assertEquals(0, DataFlowTargets.bonus(new int[]{1, 1, 0, 1, 1, 1}, 7));
    }//

    @Test
    @DisplayName("throws IAE on null attendance")
    void nullAttendanceIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(null, 0));
    }

    @Test
    @DisplayName("throws IAE on negative threshold")
    void negativeThresholdIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> DataFlowTargets.bonus(new int[0], -1));
    }
}
