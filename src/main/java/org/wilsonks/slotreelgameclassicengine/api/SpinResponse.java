package org.wilsonks.slotreelgameclassicengine.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SpinResponse {
    private String referenceId;
    private String playerUid;
    private String gameId;
    private String egmId;
    private Integer betIndex;
    private Integer denomIndex;
    private Integer bet;
    private Integer denom;
    private Integer betAmount;
    private String reelCombination;

    @Builder.Default
    private String hitPattern = "NONE";
    @Builder.Default
    private List<Integer> reelIndexes = List.of(-1, -1, -1);
    @Builder.Default
    private List<String> reelSymbols = List.of("--", "--", "--");
    @Builder.Default
    private Long winAmount = 0L;
    @Builder.Default
    private Long bonusWinAmount = 0L;
    @Builder.Default
    private Long totalWinAmount = 0L;
}
