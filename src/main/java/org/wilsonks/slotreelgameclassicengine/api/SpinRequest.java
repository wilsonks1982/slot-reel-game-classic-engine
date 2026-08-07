package org.wilsonks.slotreelgameclassicengine.api;

import java.math.BigDecimal;

public record SpinRequest(
        String spinId,
        String playerUid,
        String egmId,
        String gameId,
        BigDecimal betAmount,
        Integer coin,
        Integer denomination
) {
    public SpinRequest {
        if (spinId == null || spinId.isBlank()) {
            throw new IllegalArgumentException("spinId cannot be null or blank");
        }
        if (playerUid == null || playerUid.isBlank()) {
            throw new IllegalArgumentException("playerUid cannot be null or blank");
        }
        if (egmId == null || egmId.isBlank()) {
            throw new IllegalArgumentException("egmId cannot be null or blank");
        }
        if (gameId == null || gameId.isBlank()) {
            throw new IllegalArgumentException("gameId cannot be null or blank");
        }
        if (betAmount == null || betAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("betAmount must be a positive number");
        }
        if (coin == null || coin <= 0) {
            throw new IllegalArgumentException("coin must be a positive integer");
        }
        if (denomination == null || denomination <= 0) {
            throw new IllegalArgumentException("denomination must be a positive integer");
        }


    }
}
