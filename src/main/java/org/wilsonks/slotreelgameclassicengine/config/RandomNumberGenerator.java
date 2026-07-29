package org.wilsonks.slotreelgameclassicengine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class RandomNumberGenerator {
    @Bean
    SecureRandom secureRandom() {
        return new SecureRandom();
    }
}
