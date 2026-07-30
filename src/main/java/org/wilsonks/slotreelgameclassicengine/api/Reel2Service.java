package org.wilsonks.slotreelgameclassicengine.api;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wilsonks.slotreelgameclassicengine.config.Reel2Properties;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class Reel2Service {
    private final Reel2Properties reel2Properties;

    @PostConstruct
    public void init() {
        IntStream.range(0, reel2Properties.getStrip().size())
                .forEach(i -> {
                    String symbol = reel2Properties.getStrip().get(i);
                    List<Integer> spread = reel2Properties.getSpread().get(i);
                    log.info("Reel 2 - Symbol: {}, Spread: {}", symbol, spread);
                });
    }

    public int getReelStopVirtualPosition(SecureRandom secureRandom) {
        return secureRandom.nextInt(128);
    }
    public int getReelStopIndex(Integer betIndex, int virtualReelPos) {
        int actualReelPos = 0;
        for (int i = 0; i < reel2Properties.getSpread().size(); i++) {
            if(reel2Properties.getSpread().get(i).contains(virtualReelPos)) {
                actualReelPos = i;
                break;
            }
        }
        return actualReelPos;
    }

    public String getSymbolAtIndex(int index) {
        if (index < 0 || index >= reel2Properties.getStrip().size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for the reel strip.");
        }
        log.info("Reel 2 - Getting symbol at index {}: {}", index, reel2Properties.getStrip().get(index));
        return reel2Properties.getStrip().get(index);
    }

}
