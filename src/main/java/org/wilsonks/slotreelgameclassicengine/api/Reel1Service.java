package org.wilsonks.slotreelgameclassicengine.api;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wilsonks.slotreelgameclassicengine.config.Reel1Properties;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class Reel1Service {
    private final Reel1Properties reel1Properties;

    @PostConstruct
    public void init() {
        IntStream.range(0, reel1Properties.getStrip().size())
                .forEach(i -> {
                    String symbol = reel1Properties.getStrip().get(i);
                    List<Integer> spread = reel1Properties.getSpread().get(i);
                    log.info("Reel 1 - Symbol: {}, Spread: {}", symbol, spread);
                });
    }

    public int getReelStopVirtualPosition(SecureRandom secureRandom) {
        return secureRandom.nextInt(128);
    }
    public int getReelStopIndex(Integer betIndex, int virtualReelPos) {
        int actualReelPos = 0;
        for (int i = 0; i < reel1Properties.getSpread().size();i++) {
            if(reel1Properties.getSpread().get(i).contains(virtualReelPos)) {
                actualReelPos = i;
                break;
            }
        }
        return actualReelPos;
    }

    public String getSymbolAtIndex(int index) {
        if (index < 0 || index >= reel1Properties.getStrip().size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for the reel strip.");
        }
        log.info("Reel 1 - Getting symbol at index {}: {}", index, reel1Properties.getStrip().get(index));
        return reel1Properties.getStrip().get(index);
    }

}
