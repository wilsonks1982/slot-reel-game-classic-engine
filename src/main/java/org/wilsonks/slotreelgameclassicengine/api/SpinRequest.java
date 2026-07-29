package org.wilsonks.slotreelgameclassicengine.api;

public record SpinRequest(
        String referenceId,
        String playerUid,
        String egmId,
        String gameId,
        Integer betIndex,
        Integer denomIndex
) {
    public SpinRequest {
        if (referenceId == null || referenceId.isBlank()) {
            throw new IllegalArgumentException("referenceId cannot be null or blank");
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
        if (betIndex < 0) {
            throw new IllegalArgumentException("betIndex cannot be negative");
        }
        if (denomIndex < 0) {
            throw new IllegalArgumentException("denomIndex cannot be negative");
        }

    }
}
