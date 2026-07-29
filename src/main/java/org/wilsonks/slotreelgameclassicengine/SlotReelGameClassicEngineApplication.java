package org.wilsonks.slotreelgameclassicengine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class SlotReelGameClassicEngineApplication {

    public static void main(String[] args) {

        log.info("Starting SlotReelGameClassicEngineApplication...");
        ConfigurableApplicationContext context = SpringApplication.run(SlotReelGameClassicEngineApplication.class, args);
        String appName = context.getEnvironment().getProperty("spring.application.name");
        String port = context.getEnvironment().getProperty("server.port");
        log.info("{} is running on port {}", appName, port);
    }

}
