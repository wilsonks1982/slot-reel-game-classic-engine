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
@ConfigurationProperties(prefix = "reel1")
public class Reel1Properties {
    private List<String> strip;
    private List<List<Integer>> coin1Spread;

    @PostConstruct
    public void validate() {
        if (strip == null || strip.isEmpty()) {
            throw new IllegalArgumentException("Reel1 strip configuration is missing or empty.");
        }
        if (coin1Spread == null || coin1Spread.isEmpty()) {
            throw new IllegalArgumentException("Reel1 coin1 configuration is missing or empty.");
        }

        log.info("Reel1Properties loaded successfully with strip size: {} and coin1-spread size: {}", strip.size(), coin1Spread.size());
    }
}
