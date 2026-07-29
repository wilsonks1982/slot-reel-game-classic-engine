package org.wilsonks.slotreelgameclassicengine.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private Integer betAmount;
    private Integer reel1Index = -1;
    private Integer reel2Index = -1;
    private Integer reel3Index = -1;
    private String reel1Symbol = "";
    private String reel2Symbol = "";
    private String reel3Symbol = "";
    private Long winAmount = 0L;
    private Long bonusAmount = 0L;
    private Long totalWinAmount = 0L;
}
