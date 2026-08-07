package org.wilsonks.slotreelgameclassicengine.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class SpinResponse {
    private String spinId;
    private String playerUid;
    private String gameId;
    private String egmId;
    private BigDecimal betAmount;
    private Integer coin;
    private Integer denomination;

    private String reelCombination;
    private String hitPattern;
    private List<Integer> reelIndexes;
    private List<String> reelSymbols;
    private BigDecimal winAmount;
    private BigDecimal bonusWinAmount;
    private BigDecimal totalWinAmount;
}
