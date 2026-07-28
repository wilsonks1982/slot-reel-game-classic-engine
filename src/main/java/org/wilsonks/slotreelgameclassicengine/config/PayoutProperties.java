package org.wilsonks.slotreelgameclassicengine.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Setter
@Getter
@Slf4j
@Component
@ConfigurationProperties(prefix = "payout")
public class PayoutProperties {
    private Map<String, Integer> wins;

    @PostConstruct
    public void init() {
        if (wins == null || wins.isEmpty()) {
            throw new IllegalStateException("Combination payouts configuration is missing or empty.");
        }
        wins.forEach((combination, payout) -> {
            if (payout < 0) {
                throw new IllegalStateException("Payout for combination " + combination + " cannot be negative.");
            }
            log.info("Loaded payout for combination {}: {}", combination, payout);
        });

    }
}
