package org.wilsonks.slotreelgameclassicengine.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Reel2ServiceTest {

    @Autowired
    private Reel2Service reel2Service;

    @Test
    void testReel2SymbolsForAllSpreadIndexes() {
        String[] strip = {
                "RU", "T2", "1B", "RS", "BE", "T3", "SS", "CH", "MA", "T4",
                "BS", "1B", "T5", "T1", "T2", "CH", "3B", "T3", "2B", "RU",
                "BE", "1B", "SS", "3B", "RS", "T1", "T4", "MA", "BS", "2B",
                "T5", "JD"
        };

        int[][] spread = {
                { 0, 1 },
                { 2, 3 },
                { 4, 5, 6, 7, 8, 9, 10 },
                { 11, 12, 13 },
                { 14, 15, 16, 17, 18 },
                { 19, 20 },
                { 21, 22, 23 },
                { 24, 25, 26 },
                { 27, 28 },
                { 29, 30, 31, 32, 33, 34, 35 },
                { 36, 37, 38, 39, 40 },
                { 41, 42, 43, 44, 45, 46, 47 },
                { 48, 49, 50, 51, 52, 53, 54, 55 },
                { 56 },
                { 57, 58 },
                { 59, 60, 61 },
                { 62, 63, 64, 65 },
                { 66, 67 },
                { 68, 69, 70, 71, 72 },
                { 73, 74 },
                { 75, 76, 77, 78, 79 },
                { 80, 81, 82, 83, 84, 85, 86, 87 },
                { 88, 89 },
                { 90, 91, 92, 93 },
                { 94, 95, 96 },
                { 97, 98 },
                { 99, 100, 101, 102, 103, 104 },
                { 105, 106, 107 },
                { 108, 109, 110, 111, 112 },
                { 113, 114, 115, 116, 117 },
                { 118, 119, 120, 121, 122, 123, 124, 125 },
                { 126, 127 }
        };

        for (int stopIndex = 0; stopIndex < spread.length; stopIndex++) {
            String expectedSymbol = strip[stopIndex];
            int[] inputIndexes = spread[stopIndex];

            for (int inputIndex : inputIndexes) {
                int actualStopIndex = reel2Service.getReelStopIndex(0, inputIndex);
                assertEquals(stopIndex, actualStopIndex,
                        String.format("Input index %d should map to stop index %d", inputIndex, stopIndex));

                String actualSymbol = reel2Service.getSymbolAtIndex(actualStopIndex);
                assertEquals(expectedSymbol, actualSymbol,
                        String.format("Stop index %d should display symbol %s", actualStopIndex, expectedSymbol));
            }
        }
    }
}
