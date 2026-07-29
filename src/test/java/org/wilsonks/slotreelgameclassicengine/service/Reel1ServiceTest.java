package org.wilsonks.slotreelgameclassicengine.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wilsonks.slotreelgameclassicengine.api.Reel1Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Reel1ServiceTest {

    @Autowired
    private Reel1Service reel1Service;

    @Test
    void testReel1StopIndexes() {
        // Test sample edge indices and boundaries based on spread configuration
        assertEquals(0, reel1Service.getReelStopIndex(0));

        assertEquals(1, reel1Service.getReelStopIndex(1));
        assertEquals(1, reel1Service.getReelStopIndex(6));

        assertEquals(2, reel1Service.getReelStopIndex(7));
        assertEquals(2, reel1Service.getReelStopIndex(9));

        assertEquals(3, reel1Service.getReelStopIndex(10));
        assertEquals(3, reel1Service.getReelStopIndex(13));

        assertEquals(4, reel1Service.getReelStopIndex(14));

        assertEquals(5, reel1Service.getReelStopIndex(15));
        assertEquals(5, reel1Service.getReelStopIndex(17));

        assertEquals(6, reel1Service.getReelStopIndex(18));
        assertEquals(6, reel1Service.getReelStopIndex(21));

        assertEquals(7, reel1Service.getReelStopIndex(22));
        assertEquals(7, reel1Service.getReelStopIndex(25));

        assertEquals(8, reel1Service.getReelStopIndex(26));

        assertEquals(9, reel1Service.getReelStopIndex(27));
        assertEquals(9, reel1Service.getReelStopIndex(29));

        assertEquals(10, reel1Service.getReelStopIndex(30));
        assertEquals(10, reel1Service.getReelStopIndex(39));

        assertEquals(11, reel1Service.getReelStopIndex(40));
        assertEquals(11, reel1Service.getReelStopIndex(49));

        assertEquals(12, reel1Service.getReelStopIndex(50));
        assertEquals(12, reel1Service.getReelStopIndex(53));

        assertEquals(13, reel1Service.getReelStopIndex(54));
        assertEquals(13, reel1Service.getReelStopIndex(57));

        assertEquals(14, reel1Service.getReelStopIndex(58));
        assertEquals(14, reel1Service.getReelStopIndex(61));

        assertEquals(15, reel1Service.getReelStopIndex(62));
        assertEquals(15, reel1Service.getReelStopIndex(63));

        assertEquals(16, reel1Service.getReelStopIndex(64));
        assertEquals(16, reel1Service.getReelStopIndex(66));

        assertEquals(17, reel1Service.getReelStopIndex(67));

        assertEquals(18, reel1Service.getReelStopIndex(68));
        assertEquals(18, reel1Service.getReelStopIndex(70));

        assertEquals(19, reel1Service.getReelStopIndex(71));
        assertEquals(19, reel1Service.getReelStopIndex(73));

        assertEquals(20, reel1Service.getReelStopIndex(74));
        assertEquals(20, reel1Service.getReelStopIndex(77));

        assertEquals(21, reel1Service.getReelStopIndex(78));

        assertEquals(22, reel1Service.getReelStopIndex(79));
        assertEquals(22, reel1Service.getReelStopIndex(82));

        assertEquals(23, reel1Service.getReelStopIndex(83));
        assertEquals(23, reel1Service.getReelStopIndex(84));

        assertEquals(24, reel1Service.getReelStopIndex(85));
        assertEquals(24, reel1Service.getReelStopIndex(90));

        assertEquals(25, reel1Service.getReelStopIndex(91));
        assertEquals(25, reel1Service.getReelStopIndex(96));

        assertEquals(26, reel1Service.getReelStopIndex(97));
        assertEquals(26, reel1Service.getReelStopIndex(100));

        assertEquals(27, reel1Service.getReelStopIndex(101));
        assertEquals(27, reel1Service.getReelStopIndex(110));

        assertEquals(28, reel1Service.getReelStopIndex(111));
        assertEquals(28, reel1Service.getReelStopIndex(120));

        assertEquals(29, reel1Service.getReelStopIndex(121));
        assertEquals(29, reel1Service.getReelStopIndex(122));

        assertEquals(30, reel1Service.getReelStopIndex(123));
        assertEquals(30, reel1Service.getReelStopIndex(125));

        assertEquals(31, reel1Service.getReelStopIndex(126));
        assertEquals(31, reel1Service.getReelStopIndex(127));

    }

    @Test
    void testGetSymbolAtIndex() {
        String[] strip = {
                "T1", "T4", "CH", "BS", "T2", "SS", "3B", "BE", "T3", "MA",
                "T5", "1B", "BS", "2B", "RU", "JD", "SS", "T1", "RS", "CH",
                "3B", "T2", "BE", "MA", "T4", "2B", "BS", "T5", "1B", "T3",
                "RS", "JD"
        };

        assertEquals(strip[0], reel1Service.getSymbolAtIndex(0));
        assertEquals(strip[1], reel1Service.getSymbolAtIndex(1));
        assertEquals(strip[2], reel1Service.getSymbolAtIndex(2));
        assertEquals(strip[3], reel1Service.getSymbolAtIndex(3));
        assertEquals(strip[4], reel1Service.getSymbolAtIndex(4));
        assertEquals(strip[5], reel1Service.getSymbolAtIndex(5));
        assertEquals(strip[6], reel1Service.getSymbolAtIndex(6));
        assertEquals(strip[7], reel1Service.getSymbolAtIndex(7));
        assertEquals(strip[8], reel1Service.getSymbolAtIndex(8));
        assertEquals(strip[9], reel1Service.getSymbolAtIndex(9));
        assertEquals(strip[10], reel1Service.getSymbolAtIndex(10));
        assertEquals(strip[11], reel1Service.getSymbolAtIndex(11));
        assertEquals(strip[12], reel1Service.getSymbolAtIndex(12));
        assertEquals(strip[13], reel1Service.getSymbolAtIndex(13));
        assertEquals(strip[14], reel1Service.getSymbolAtIndex(14));
        assertEquals(strip[15], reel1Service.getSymbolAtIndex(15));
        assertEquals(strip[16], reel1Service.getSymbolAtIndex(16));
        assertEquals(strip[17], reel1Service.getSymbolAtIndex(17));
        assertEquals(strip[18], reel1Service.getSymbolAtIndex(18));
        assertEquals(strip[19], reel1Service.getSymbolAtIndex(19));
        assertEquals(strip[20], reel1Service.getSymbolAtIndex(20));
        assertEquals(strip[21], reel1Service.getSymbolAtIndex(21));
        assertEquals(strip[22], reel1Service.getSymbolAtIndex(22));
        assertEquals(strip[23], reel1Service.getSymbolAtIndex(23));
        assertEquals(strip[24], reel1Service.getSymbolAtIndex(24));
        assertEquals(strip[25], reel1Service.getSymbolAtIndex(25));
        assertEquals(strip[26], reel1Service.getSymbolAtIndex(26));
        assertEquals(strip[27], reel1Service.getSymbolAtIndex(27));
        assertEquals(strip[28], reel1Service.getSymbolAtIndex(28));
        assertEquals(strip[29], reel1Service.getSymbolAtIndex(29));
        assertEquals(strip[30], reel1Service.getSymbolAtIndex(30));
        assertEquals(strip[31], reel1Service.getSymbolAtIndex(31));

    }
}
