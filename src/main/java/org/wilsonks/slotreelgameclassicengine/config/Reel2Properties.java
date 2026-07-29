package org.wilsonks.slotreelgameclassicengine.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@Slf4j
@Component
@ConfigurationProperties(prefix = "reel2")
public class Reel2Properties {
    private List<String> strip;
    private List<List<Integer>> spread;

    @PostConstruct
    public void validate() {
        if (strip == null || strip.isEmpty()) {
            throw new IllegalArgumentException("Reel2 strip configuration is missing or empty.");
        }
        if (spread == null || spread.isEmpty()) {
            throw new IllegalArgumentException("Reel2 coin1 configuration is missing or empty.");
        }
        log.info("Reel2Properties loaded successfully with strip size: {} and coin1-spread size: {}", strip.size(), spread.size());
    }
}
