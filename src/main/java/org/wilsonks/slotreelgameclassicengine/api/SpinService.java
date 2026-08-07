package org.wilsonks.slotreelgameclassicengine.api;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.wilsonks.slotreelgameclassicengine.config.GameConfigProperties;
import org.wilsonks.slotreelgameclassicengine.config.PayTableProperties;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpinService {
    public static final Integer VIRTUAL_REEL_STRIP_SIZE = 128;
    private final PayTableProperties payoutProperties;
    private final GameConfigProperties gameConfigProperties;
    private final SecureRandom secureRandom;
    private final Reel1Service reel1Service;
    private final Reel2Service reel2Service;
    private final Reel3Service reel3Service;

    private final List<PayRule> compiledRules = new ArrayList<>();

    @PostConstruct
    public void initPayTable() {
        // Taken rowPatterns from the configuration and compile them into regex patterns for matching
        payoutProperties.getWins().forEach((rawPattern, payout) -> {
            var regex = PayTableParser.convertToRegex(rawPattern);
            PayRule rule = new PayRule(rawPattern, regex, payout);
            compiledRules.add(rule);
            log.info("Compiled pay rule: {} with payout: {}", rule, payout);
        });
        Collections.sort(compiledRules); // Sort rules by payout in descending order
        log.info("Paytable compiled with {} rules.", compiledRules.size());
    }

    public PayTableProperties getPaylines() {
        return payoutProperties;
    }

    public GameConfigProperties getGameConfig() {
        return gameConfigProperties;
    }

    public SpinResponse spin(SpinRequest request) {

        int reel1Index = reel1Service.getReelStopIndex(request.coin(), secureRandom.nextInt(VIRTUAL_REEL_STRIP_SIZE));
        int reel2Index = reel2Service.getReelStopIndex(request.coin(), secureRandom.nextInt(VIRTUAL_REEL_STRIP_SIZE));
        int reel3Index = reel3Service.getReelStopIndex(request.coin(), secureRandom.nextInt(VIRTUAL_REEL_STRIP_SIZE));

        String reel1Symbol = reel1Service.getSymbolAtIndex(reel1Index);
        String reel2Symbol = reel2Service.getSymbolAtIndex(reel2Index);
        String reel3Symbol = reel3Service.getSymbolAtIndex(reel3Index);

        String reelCombination = String.join("-", reel1Symbol, reel2Symbol, reel3Symbol);

        BigDecimal winAmount = BigDecimal.ZERO;
        String matchingPattern = "NONE";

        for (PayRule rule : compiledRules) {
            if (rule.regexPattern().matcher(reelCombination).matches()) {
                winAmount = request.betAmount().multiply(BigDecimal.valueOf(rule.payout()));
                matchingPattern = rule.originalPattern();
                break;
            }
        }

        log.info("Spin Result: {} | Hit Pattern: {} | Total Win: {}", reelCombination, matchingPattern, winAmount);

        return SpinResponse.builder()
                .spinId(request.spinId())
                .egmId(request.egmId())
                .playerUid(request.playerUid())
                .gameId(request.gameId())
                .coin(request.coin())
                .denomination(request.denomination())
                .betAmount(request.betAmount())
                .reelCombination(reelCombination)
                .hitPattern(matchingPattern)
                .winAmount(winAmount)
                .reelIndexes(List.of(reel1Index, reel2Index, reel3Index))
                .reelSymbols(List.of(reel1Symbol, reel2Symbol, reel3Symbol))
                .bonusWinAmount(BigDecimal.ZERO) // Assuming no bonus logic for now
                .totalWinAmount(winAmount) // Assuming no bonus logic for now
                .build();

    }
}
