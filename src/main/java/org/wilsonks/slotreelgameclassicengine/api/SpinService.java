package org.wilsonks.slotreelgameclassicengine.api;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wilsonks.slotreelgameclassicengine.config.GameConfigProperties;
import org.wilsonks.slotreelgameclassicengine.config.PayTableProperties;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpinService {
    private final PayTableProperties payoutProperties;
    private final GameConfigProperties gameConfigProperties;

    public PayTableProperties getPaylines() {
        return payoutProperties;
    }

    public GameConfigProperties getGameConfig() {
        return gameConfigProperties;
    }

    public SpinResponse spin(SpinRequest request) {
        Integer betAmount = gameConfigProperties.getBetValues()
                .get(request.betIndex())
                .get(request.denomIndex());

        return SpinResponse.builder()
                .referenceId(request.referenceId())
                .egmId(request.egmId())
                .playerUid(request.playerUid())
                .gameId(request.gameId())
                .betIndex(request.betIndex())
                .denomIndex(request.denomIndex())
                .betAmount(betAmount)
                .build();

    }
}
