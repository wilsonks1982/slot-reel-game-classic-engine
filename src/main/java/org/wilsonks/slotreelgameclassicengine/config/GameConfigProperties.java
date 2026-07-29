package org.wilsonks.slotreelgameclassicengine.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@Slf4j
@ConfigurationProperties(prefix = "gameconfig")
@Component
public class GameConfigProperties {
    private List<Integer> betsValues;
    private List<Integer> denomValues;
    private int defaultBetIndex;
    private int defaultDenomIndex;
    private List<List<Integer>> betValues;

    @PostConstruct
    public void validateConfig() {
        if (betsValues == null || betsValues.isEmpty()) {
            throw new IllegalArgumentException("Bets values cannot be null or empty");
        }
        if (denomValues == null || denomValues.isEmpty()) {
            throw new IllegalArgumentException("Denomination values cannot be null or empty");
        }
        if (defaultBetIndex < 0 || defaultBetIndex >= betsValues.size()) {
            throw new IllegalArgumentException("Default bet index is out of bounds");
        }
        if (defaultDenomIndex < 0 || defaultDenomIndex >= denomValues.size()) {
            throw new IllegalArgumentException("Default denomination index is out of bounds");
        }
        log.info("✅ GameConfigProperties initialized with betsValues: {}", betsValues);
        log.info("✅ GameConfigProperties initialized with denomValues: {}", denomValues);
        log.info("✅ GameConfigProperties initialized with defaultBetIndex: {}", defaultBetIndex);
        log.info("✅ GameConfigProperties initialized with defaultDenomIndex: {}", defaultDenomIndex);
        log.info("✅ GameConfigProperties initialized with betValues: {}", betValues);
    }
}
