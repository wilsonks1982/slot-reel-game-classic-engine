package org.wilsonks.slotreelgameclassicengine.api;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wilsonks.slotreelgameclassicengine.config.Reel3Properties;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class Reel3Service {
    private final Reel3Properties reel3Properties;

    @PostConstruct
    public void init() {
        IntStream.range(0, reel3Properties.getStrip().size())
                .forEach(i -> {
                    String symbol = reel3Properties.getStrip().get(i);
                    List<Integer> spread = reel3Properties.getSpread().get(i);
                    log.info("Reel 3 - Symbol: {}, Spread: {}", symbol, spread);
                });
    }

    public int getReelStopIndex(Integer betIndex, int virtualReelPos) {
        int actualReelPos = 0;
        for (int i = 0; i < reel3Properties.getSpread().size(); i++) {
            if(reel3Properties.getSpread().get(i).contains(virtualReelPos)) {
                actualReelPos = i;
                break;
            }
        }
        return actualReelPos;
    }

    public String getSymbolAtIndex(int index) {
        if (index < 0 || index >= reel3Properties.getStrip().size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for the reel strip.");
        }
        log.info("Reel 3 - Getting symbol at index {}: {}", index, reel3Properties.getStrip().get(index));
        return reel3Properties.getStrip().get(index);
    }

}
